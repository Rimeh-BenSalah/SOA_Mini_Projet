package com.rimeh.livre.service;

import com.rimeh.livre.dto.APIResponseDto;
import com.rimeh.livre.dto.LivreDto;
import com.rimeh.livre.dto.ThemeDto;
import com.rimeh.livre.entities.Livre;
import com.rimeh.livre.repos.LivreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class LivreServiceImpl implements LivreService {

    private LivreRepository livreRepository;
    //private WebClient webClient;
    private APIClient apiClient;

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
                tname
        );

        APIResponseDto response = new APIResponseDto();
        response.setLivreDto(livreDto);
        response.setThemeDto(themeDto);
        return response;
    }
}