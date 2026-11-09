package com.rimeh.livre.repos;

import com.rimeh.livre.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, Long> { }