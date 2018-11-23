package com.dmuzychuk.movieland.dao.jdbc;

import com.dmuzychuk.movieland.dao.MovieDao;
import com.dmuzychuk.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.dmuzychuk.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DefaultMovieDao implements MovieDao {

    private JdbcTemplate jdbcTemplate;

    static private final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();

    private static final String SQL_GET_ALL_MOVIES = "select id, name_rus, name_native, year, rating, price, " +
            "poster_url from movie order by id";

    private static final String SQL_GET_N_RANDOM_MOVIES = "select id, name_rus, name_native, year, rating, price, " +
            "poster_url from movie order by random() limit 3";

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = new ArrayList<>(jdbcTemplate.query(SQL_GET_ALL_MOVIES, MOVIE_ROW_MAPPER));

        logger.debug("getAll method returned: {} rows", movies.size());

        return movies;
    }

    @Override
    public List<Movie> getRandom() {
        List<Movie> movies = new ArrayList<>(jdbcTemplate.query(SQL_GET_N_RANDOM_MOVIES, MOVIE_ROW_MAPPER));

        logger.debug("getRandom method returned: {} rows", movies.size());

        return movies;
    }

}
