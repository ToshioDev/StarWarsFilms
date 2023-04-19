package com.alexisdev.StarWarsFilms.obj;

import java.util.List;

public class MovieListWrapper {
    private List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        // Asignar un ID único a cada película
        for (int i = 0; i < results.size(); i++) {
            Movie movie = results.get(i);
            movie.setId(String.valueOf(i + 1));
        }
        this.results = results;
    }
}