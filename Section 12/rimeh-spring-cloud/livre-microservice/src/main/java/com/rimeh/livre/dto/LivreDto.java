package com.rimeh.livre.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivreDto {
    private Long id;
    private String titre;
    private String auteur;

    private String themeCode;
    private String themeName;
}