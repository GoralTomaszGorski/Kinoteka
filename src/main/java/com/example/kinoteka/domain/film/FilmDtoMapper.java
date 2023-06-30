package com.example.kinoteka.domain.film;

import com.example.kinoteka.domain.film.dto.FilmDto;

public class FilmDtoMapper {
    static FilmDto map(Film film){
        return new FilmDto(
                film.getId(),
                film.getTitle(),
                film.getEnglish_title(),
                film.getShortDescription(),
                film.getDescription(),
                film.getYoutubeTrailerId(),
                film.getRelease_year(),
                film.isPromoted(),
                film.getType().getName()

        );
    }
}
