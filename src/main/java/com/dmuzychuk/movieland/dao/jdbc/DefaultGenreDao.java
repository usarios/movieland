package com.dmuzychuk.movieland.dao.jdbc;

import com.dmuzychuk.movieland.dao.GenreDao;
import com.dmuzychuk.movieland.dao.jdbc.mapper.GenreRowMapper;
import com.dmuzychuk.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DefaultGenreDao implements GenreDao {

    private JdbcTemplate jdbcTemplate;

    static private final String SQL_GET_ALL_GENRES = "select id, name_rus from genre";

    static private final GenreRowMapper GENRE_ROW_MAPPER = new GenreRowMapper();

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Genre> getAll() {
        List<Genre> genres = new ArrayList<>(jdbcTemplate.query(SQL_GET_ALL_GENRES, GENRE_ROW_MAPPER));

        logger.info("getAll method returned: {} rows", genres.size());
        logger.debug("getAll method returned such genres: {}", genres);

        return genres;
    }
}
