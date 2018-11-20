package com.lxft.dmuzychuk.dao.jdbc;

import com.lxft.dmuzychuk.dao.MovieDao;
import com.lxft.dmuzychuk.dao.jdbc.mapper.MovieRowMapper;
import com.lxft.dmuzychuk.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DefaultMovieDao implements MovieDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    private static final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();

    private static final String SQL_GET_ALL_MOVIES = "select m.id, m.name_rus, m.name_native, m.year, m.rating, m.price, " +
            "m.poster_url \n" +
            "from movie m\n" +
            "order by m.id";

    @Override
    public List<Movie> getAll() {

        return jdbcTemplate.query(SQL_GET_ALL_MOVIES, MOVIE_ROW_MAPPER);
    }

}
