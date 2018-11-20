package com.dmuzychuk.movieland.dao.jdbc;

import com.dmuzychuk.movieland.dao.MovieDao;
import com.dmuzychuk.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.dmuzychuk.movieland.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DefaultMovieDao implements MovieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    static private final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();

    private static final String SQL_GET_ALL_MOVIES = "select id, name_rus, name_native, year, rating, price, " +
            "poster_url from movie order by id";

    @Override
    public List<Movie> getAll() {

        return jdbcTemplate.query(SQL_GET_ALL_MOVIES, MOVIE_ROW_MAPPER);
    }

}
