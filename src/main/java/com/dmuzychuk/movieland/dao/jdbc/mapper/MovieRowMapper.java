package com.dmuzychuk.movieland.dao.jdbc.mapper;

import com.dmuzychuk.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {

        Movie movie = new Movie();

        movie.setId(resultSet.getInt("id"));
        movie.setNameRussian(resultSet.getString("name_rus"));
        movie.setNameNative(resultSet.getString("name_native"));
        movie.setYearOfRelease(resultSet.getInt("year"));
        movie.setRating(resultSet.getDouble("rating"));
        movie.setPrice(resultSet.getDouble("price"));
        movie.setPicturePath(resultSet.getString("poster_url"));

        return movie;
    }
}
