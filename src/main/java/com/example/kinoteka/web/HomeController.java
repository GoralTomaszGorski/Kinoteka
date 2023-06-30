package com.example.kinoteka.web;


import com.example.kinoteka.domain.film.FilmService;
import com.example.kinoteka.domain.film.dto.FilmDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final FilmService filmService;

    public HomeController(FilmService filmService) {
        this.filmService = filmService;
    }


    @GetMapping("/")
    public String home(Model model){
        List<FilmDto> promotedFilms = filmService.findAllPromotedFilms();
        model.addAttribute("heading", "Promowane filmy");
        model.addAttribute("description", "Filmy polecane przez Kinotekę");
        model.addAttribute("filmy", promotedFilms);
        return "movie-listing";

    }
}
