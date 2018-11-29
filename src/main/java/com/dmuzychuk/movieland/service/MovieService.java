package com.dmuzychuk.movieland.service;

import com.dmuzychuk.movieland.entity.Movie;
import com.dmuzychuk.movieland.entity.common.MovieRequestParam;

import java.util.List;

public interface MovieService {

    List<Movie> getAll();

    List<Movie> getAll(MovieRequestParam movieRequestParam);

    List<Movie> getRandom();

    List<Movie> getByGenreId(int id);

    List<Movie> getByGenreId(int id, MovieRequestParam movieRequestParam);
}
