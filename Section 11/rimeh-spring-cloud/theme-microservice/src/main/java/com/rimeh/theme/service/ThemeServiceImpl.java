package com.rimeh.theme.service;

import com.rimeh.theme.dto.ThemeDto;
import com.rimeh.theme.entities.Theme;
import com.rimeh.theme.repos.ThemeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ThemeServiceImpl implements ThemeService {

    private ThemeRepository themeRepository;

    @Override
    public ThemeDto getThemeByCode(String code) {
        Theme t = themeRepository.findByThemeCode(code);
        return new ThemeDto(t.getId(), t.getThemeName(), t.getThemeCode());
    }
}