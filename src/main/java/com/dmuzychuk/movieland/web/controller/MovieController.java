package com.dmuzychuk.movieland.web.controller;

import com.dmuzychuk.movieland.entity.Movie;
import com.dmuzychuk.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(path = "/movie", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getAllMovies() {
        return movieService.getAll();
    }

    @GetMapping(path = "/movie/random", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getRandomMovies() {
        return movieService.getRandom();
    }

}
