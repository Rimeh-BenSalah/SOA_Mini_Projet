package com.rimeh.theme.service;

import com.rimeh.theme.dto.ThemeDto;

public interface ThemeService {
    ThemeDto getThemeByCode(String code);
}