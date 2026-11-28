package com.alexisdev.StarWarsFilms.obj;

import lombok.Data;

import java.util.List;

@Data
public class MovieList {
    private List<Movie> results;
}