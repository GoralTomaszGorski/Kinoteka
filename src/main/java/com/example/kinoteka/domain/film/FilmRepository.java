package com.example.kinoteka.domain.film;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Long> {
    List<Film> findAllByPromotedIsTrue();
    List<Film> findAllByType_Name(String type);
}
