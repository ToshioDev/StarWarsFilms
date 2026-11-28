package com.alexisdev.StarWarsFilms.controllers;

import com.alexisdev.StarWarsFilms.obj.Character;
import com.alexisdev.StarWarsFilms.obj.Movie;
import com.alexisdev.StarWarsFilms.services.StarWarsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private StarWarsApiService apiService;

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = apiService.getAllMovies();
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getFilm(@PathVariable int id) {
        Movie movieDetail = apiService.getMovieDetail(id);
        if (movieDetail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDetail);
    }

    @GetMapping("/{id}/characters")
    public ResponseEntity<List<Character>> getCharactersByFilm(@PathVariable int id) {
        List<Character> characters = apiService.getCharactersByFilm(id);
        if (characters == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(characters);
    }
}
