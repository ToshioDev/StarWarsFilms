package com.alexisdev.StarWarsFilms.services;

import com.alexisdev.StarWarsFilms.obj.Character;
import com.alexisdev.StarWarsFilms.obj.Movie;
import com.alexisdev.StarWarsFilms.obj.MovieListWrapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StarWarsApiService {

    private final RestTemplate restTemplate;

    public StarWarsApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Movie> getAllMovies() {
        String url = "https://swapi.dev/api/films/";
        MovieListWrapper wrapper = restTemplate.getForObject(url, MovieListWrapper.class);
        return wrapper.getResults();
    }

    public Movie getMovieDetail(int id) {
        String url = "https://swapi.dev/api/films/" + id + "/";
        return restTemplate.getForObject(url, Movie.class);
    }

    public List<Character> getCharactersByFilm(int filmId) {
        String filmUrl = "https://swapi.dev/api/films/" + filmId + "/";
        List<Character> characters = new ArrayList<>();
        Movie film = restTemplate.getForObject(filmUrl, Movie.class);
        if (film != null) {
            List<String> charactersUrls = film.getCharacters();
            for (String characterUrl : charactersUrls) {
                Character character = restTemplate.getForObject(characterUrl, Character.class);
                characters.add(character);
            }
        }
        return characters;
    }

    public Character getCharacterById(int id) {
        String url = "https://swapi.dev/api/people/" + id + "/";
        return restTemplate.getForObject(url, Character.class);
    }
}
