package com.rimeh.livre.service;

import com.rimeh.livre.dto.APIResponseDto;
import com.rimeh.livre.dto.LivreDto;

public interface LivreService {
    APIResponseDto getLivreById(Long id);
}