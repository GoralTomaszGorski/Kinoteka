package com.example.kinoteka.web;


import com.example.kinoteka.domain.film.FilmService;
import com.example.kinoteka.domain.film.dto.FilmDto;
import com.example.kinoteka.domain.type.TypeService;
import com.example.kinoteka.domain.type.dto.TypeDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class TypeController {
    private final TypeService typeService;
    private final FilmService filmService;

    public TypeController(TypeService typeService, FilmService filmService) {
        this.typeService = typeService;
        this.filmService = filmService;
    }

    @GetMapping("/gatunek/{name}")
    public String getType(@PathVariable String name, Model model){
        TypeDto type = typeService.findTypeByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<FilmDto> films = filmService.findMoviesByTypeName(name);
        model.addAttribute("heading", type.getName());
        model.addAttribute("description", type.getDescription());
        model.addAttribute("films", films);
        return "movie-listing";
    }

    @GetMapping("/gatunki-filmowe")
    public String getTypeList(Model model){
        List<TypeDto> types = typeService.findAllTypes();
        model.addAttribute("types", types);
        return "type-listing";
    }
}
