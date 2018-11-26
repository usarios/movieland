package com.dmuzychuk.movieland.dao;

import com.dmuzychuk.movieland.entity.Movie;
import com.dmuzychuk.movieland.entity.SortingItem;

import java.util.List;

public interface MovieDao {

    List<Movie> getAll();

    List<Movie> getAll(List<SortingItem> sortingItems);

    List<Movie> getRandom();

    List<Movie> getByGenreId(int id);

    List<Movie> getByGenreId(int id, List<SortingItem> sortingItems);
}

