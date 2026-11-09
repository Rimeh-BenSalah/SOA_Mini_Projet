package com.rimeh.livre.service;

import com.rimeh.livre.dto.APIResponseDto;
import com.rimeh.livre.dto.LivreDto;
import com.rimeh.livre.dto.LivreMessageDto;
import com.rimeh.livre.dto.ThemeDto;
import com.rimeh.livre.entities.Livre;
import com.rimeh.livre.exceptions.ResourceNotFoundException;
import com.rimeh.livre.repos.LivreRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class LivreServiceImpl implements LivreService {

    private LivreRepository livreRepository;
    //private WebClient webClient;
    private APIClient apiClient;

    private static final Logger log = LoggerFactory.getLogger(LivreServiceImpl.class);
    private final StreamBridge streamBridge;

    @Override
    public APIResponseDto getLivreById(Long id) {

        Livre livre = livreRepository.findById(id).get();

        /*ThemeDto themeDto = webClient.get()
                .uri("http://localhost:8083/api/themes/" + livre.getThemeCode())
                .retrieve()
                .bodyToMono(ThemeDto.class)
                .block();*/
        ThemeDto themeDto = apiClient.getThemeByCode(livre.getThemeCode());

        String tname;
        if (themeDto == null)
            tname="NOT AVAILABLE";
        else
            tname = themeDto.getThemeName();


        LivreDto livreDto = new LivreDto(
                livre.getId(),
                livre.getTitre(),
                livre.getAuteur(),
                livre.getThemeCode(),
                //themeDto.getThemeName(),
                tname,
                livre.getEmail(),
                livre.getMobileNumber()
        );

        APIResponseDto response = new APIResponseDto();
        response.setLivreDto(livreDto);
        response.setThemeDto(themeDto);
        return response;
    }

    @Override
    public void createLivre(LivreDto livreDto) {
        Livre savedLivre = livreRepository.save(Livre.builder()
                .titre(livreDto.getTitre())
                .auteur(livreDto.getAuteur())
                .themeCode(livreDto.getThemeCode())
                //.themeName(livreDto.getThemeName())
                .email(livreDto.getEmail())
                .mobileNumber(livreDto.getMobileNumber())
                .build());

        sendCommunication(savedLivre);
    }

    @Override
    public boolean updateCommunicationStatus(Long livreId) {
        boolean isUpdated = false;

        if (livreId != null) {
            Livre livre = livreRepository.findById(livreId).orElseThrow(
                    () -> new ResourceNotFoundException(
                            "Livre", "LivreId", livreId.toString()
                    )
            );

            livre.setCommunicationDone(true);
            livreRepository.save(livre);
            isUpdated = true;
        }

        return isUpdated;
    }


    private void sendCommunication(Livre livre) {
        var livreMsgDto = new LivreMessageDto(
                livre.getId(),
                livre.getEmail(),
                livre.getMobileNumber()
        );

        log.info("Sending Communication request for the details: {}", livreMsgDto);

        var result = streamBridge.send("sendCommunication-out-0", livreMsgDto);

        log.info("Is the Communication request successfully triggered? : {}", result);
    }



}