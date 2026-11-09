package com.rimeh.livre.service;

import com.rimeh.livre.dto.ThemeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8083", value = "THEME")
@FeignClient(name = "THEME")
//@FeignClient(value = "THEME",fallback = TheFallback.class)
public interface APIClient {

    @GetMapping("api/themes/{theme-code}")
    ThemeDto getThemeByCode(@PathVariable("theme-code") String themeCode);
}