package com.rimeh.livre.restControllers;

import com.rimeh.livre.config.Configuration;
import com.rimeh.livre.dto.APIResponseDto;
import com.rimeh.livre.dto.LivreDto;
import com.rimeh.livre.service.LivreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/livres")
@AllArgsConstructor
public class LivreController {

    private LivreService livreService;

    @Autowired
    Configuration configuration;

    /*@GetMapping("{id}")
    public ResponseEntity<LivreDto> getLivreById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(livreService.getLivreById(id), HttpStatus.OK);
    }*/
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getLivreById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(livreService.getLivreById(id), HttpStatus.OK);
    }

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(configuration.getName() + " " + configuration.getEmail());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createLivre(@RequestBody LivreDto livreDto) {
        livreService.createLivre(livreDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Livre created successfully");
    }
}