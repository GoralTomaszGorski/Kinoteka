package com.example.kinoteka.domain.film;

import com.example.kinoteka.domain.film.dto.FilmDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<FilmDto> findAllPromotedFilms(){
        return filmRepository.findAllByPromotedIsTrue().stream()
                .map(FilmDtoMapper::map)
                .toList();
    }

    public Optional<FilmDto> findFilmById(long id){
        return filmRepository.findById(id).map(FilmDtoMapper::map);
    }

    public List<FilmDto> findMoviesByTypeName(String type){
        return filmRepository.findAllByType_Name(type).stream()
                .map(FilmDtoMapper::map)
                .toList();
    }

}
