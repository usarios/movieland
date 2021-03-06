package com.dmuzychuk.movieland.service;

import com.dmuzychuk.movieland.dao.MovieDao;
import com.dmuzychuk.movieland.entity.Movie;
import com.dmuzychuk.movieland.entity.common.MovieRequestParam;
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
    public List<Movie> getByGenreId(int id, MovieRequestParam movieRequestParam) {
        return movieDao.getByGenreId(id, movieRequestParam);
    }

    @Override
    public List<Movie> getAll(MovieRequestParam movieRequestParam) {
        return movieDao.getAll(movieRequestParam);
    }
}