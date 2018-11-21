package com.dmuzychuk.movieland.service;

import com.dmuzychuk.movieland.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAll();

    List<Movie> getRandom();
}
