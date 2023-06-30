package com.example.kinoteka.web;

import com.example.kinoteka.domain.film.FilmService;
import com.example.kinoteka.domain.film.dto.FilmDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/film/{id}")
    public String getFilm(@PathVariable long id, Model model){
        FilmDto filmDto = filmService.findFilmById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("film", filmDto);
        return "film";

    }
}
