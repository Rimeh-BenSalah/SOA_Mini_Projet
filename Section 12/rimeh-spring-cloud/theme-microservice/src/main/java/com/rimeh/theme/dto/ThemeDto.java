package com.rimeh.theme.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThemeDto {
    private Long id;
    private String themeName;
    private String themeCode;
}