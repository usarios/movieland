package com.dmuzychuk.movieland.dao.jdbc;

import com.dmuzychuk.movieland.dao.MovieDao;
import com.dmuzychuk.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.dmuzychuk.movieland.entity.Movie;
import com.dmuzychuk.movieland.entity.common.MovieRequestParam;
import com.dmuzychuk.movieland.dao.common.DaoSqlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DefaultMovieDao implements MovieDao {

    private static final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();

    private static final String SQL_GET_ALL_MOVIES = "select id, name_rus, name_native, year, rating, price, " +
            "poster_url from movie";

    private static final String SQL_GET_N_RANDOM_MOVIES = "select id, name_rus, name_native, year, rating, price, " +
            "poster_url from movie order by random() limit 3";

    private static final String SQL_GET_MOVIES_BY_GENRE = "select distinct m.id, m.name_rus, m.name_native, m.year, " +
            "m.rating, m.price, m.poster_url from movie m " +
            "join movie_genre mg " +
            "on m.id = mg.movie_id " +
            "where mg.genre_id = ?";

    private JdbcTemplate jdbcTemplate;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = jdbcTemplate.query(SQL_GET_ALL_MOVIES, MOVIE_ROW_MAPPER);

        logger.info("getAll method returned: {} rows", movies.size());

        return movies;
    }

    @Override
    public List<Movie> getRandom() {
        List<Movie> movies = jdbcTemplate.query(SQL_GET_N_RANDOM_MOVIES, MOVIE_ROW_MAPPER);

        List<Integer> ids = new ArrayList<>();
        for (Movie movie : movies) {
            ids.add(movie.getId());
        }

        logger.info("getRandom method returned: {} rows", movies.size());
        logger.info("getRandom method returned such ids: {}", ids);

        return movies;
    }

    @Override
    public List<Movie> getByGenreId(int id) {
        List<Movie> movies = jdbcTemplate.query(SQL_GET_MOVIES_BY_GENRE, MOVIE_ROW_MAPPER, id);

        logger.info("getByGenreId method with genreId = " + id + " returned {} rows", movies.size());

        return movies;
    }

    @Override
    public List<Movie> getAll(MovieRequestParam movieRequestParam) {
        logger.info("SortingPart: {}", movieRequestParam);

        String actualSqlText = DaoSqlUtils.getSqlWithSortingClause(SQL_GET_ALL_MOVIES, movieRequestParam);

        List<Movie> movies = jdbcTemplate.query(actualSqlText, MOVIE_ROW_MAPPER);

        return movies;
    }

    @Override
    public List<Movie> getByGenreId(int id, MovieRequestParam movieRequestParam) {
        String actualSqlText = DaoSqlUtils.getSqlWithSortingClause(SQL_GET_MOVIES_BY_GENRE, movieRequestParam);
        List<Movie> movies = jdbcTemplate.query(actualSqlText, MOVIE_ROW_MAPPER, id);

        logger.info("getByGenreId method with genreId = " + id + " returned {} rows", movies.size());

        return movies;
    }

}
