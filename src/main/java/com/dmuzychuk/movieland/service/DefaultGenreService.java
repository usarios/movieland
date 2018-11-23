package com.dmuzychuk.movieland.service;

import com.dmuzychuk.movieland.dao.GenreDao;
import com.dmuzychuk.movieland.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultGenreService implements GenreService {

    private GenreDao genreDao;

    @Autowired
    public DefaultGenreService(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }
}
