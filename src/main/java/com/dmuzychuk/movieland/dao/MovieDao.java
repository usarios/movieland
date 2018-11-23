package com.dmuzychuk.movieland.dao;

import com.dmuzychuk.movieland.entity.Movie;

import java.util.List;

public interface MovieDao {

    List<Movie> getAll();

    List<Movie> getRandom();

    List<Movie> getByGenreId(int id);
}
