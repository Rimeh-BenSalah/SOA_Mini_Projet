package com.rimeh.theme.repos;

import com.rimeh.theme.entities.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
    Theme findByThemeCode(String code);
}