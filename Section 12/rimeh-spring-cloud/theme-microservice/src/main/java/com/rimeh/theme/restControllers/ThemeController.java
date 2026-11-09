package com.rimeh.theme.restControllers;

import com.rimeh.theme.config.Configuration;
import com.rimeh.theme.dto.ThemeDto;
import com.rimeh.theme.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("/api/themes")
@RequiredArgsConstructor
public class ThemeController {

    private final ThemeService themeService;

//    @Autowired
//    Configuration configuration;

//    @GetMapping("/author")
//    public ResponseEntity<String> retrieveAuthorInfo() {
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(configuration.getName() + " " + configuration.getEmail());
//    }


//    @Value("${build.version}")
//    private String buildVersion;

//    @GetMapping("/version")
//    public ResponseEntity<String> version() {
//        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
//    }

    @GetMapping("{code}")
    public ResponseEntity<ThemeDto> getThemeByCode(@PathVariable("code") String code) {
        return new ResponseEntity<>(themeService.getThemeByCode(code), HttpStatus.OK);
    }
}