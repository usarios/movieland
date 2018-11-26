package com.dmuzychuk.movieland.service;

import com.dmuzychuk.movieland.dao.MovieDao;
import com.dmuzychuk.movieland.entity.Movie;
import com.dmuzychuk.movieland.entity.SortingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService implements MovieService {

    private MovieDao movieDao;

    @Autowired
    public DefaultMovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    @Override
    public List<Movie> getRandom() {
        return movieDao.getRandom();
    }

    @Override
    public List<Movie> getByGenreId(int id) {
        return movieDao.getByGenreId(id);
    }

    @Override
    public List<Movie> getByGenreId(int id, List<SortingItem> sortingItems) {
        return movieDao.getByGenreId(id, sortingItems);
    }

    @Override
    public List<Movie> getAll(List<SortingItem> sortingItems) {
        return movieDao.getAll(sortingItems);
    }
}