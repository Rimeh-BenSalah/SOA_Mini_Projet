package com.rimeh.livre.service;


import com.rimeh.livre.dto.ThemeDto;
import org.springframework.stereotype.Component;

@Component
public class TheFallback implements APIClient {

    @Override
    public ThemeDto getThemeByCode(String themeCode) { return null; }
}
