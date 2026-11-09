package com.rimeh.livre.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private LivreDto livreDto;
    private ThemeDto themeDto;
}