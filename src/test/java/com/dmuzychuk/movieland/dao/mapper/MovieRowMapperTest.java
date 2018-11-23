package com.dmuzychuk.movieland.dao.mapper;

import com.dmuzychuk.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.dmuzychuk.movieland.entity.Movie;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieRowMapperTest {

    @Test
    @DirtiesContext
    public void testMovieRowMapper() throws SQLException {
        MovieRowMapper movieRowMapper = new MovieRowMapper();
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name_rus")).thenReturn("Укрощение строптивого");
        when(resultSet.getString("name_native")).thenReturn("Il bisbetico domato");
        when(resultSet.getInt("year")).thenReturn(1980);
        when(resultSet.getDouble("rating")).thenReturn(7.7);
        when(resultSet.getDouble("price")).thenReturn(120.00);
        when(resultSet.getString("poster_url")).thenReturn("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg");

        Movie actualMovie = movieRowMapper.mapRow(resultSet,0);

        assertEquals(1, actualMovie.getId());
        assertEquals("Укрощение строптивого", actualMovie.getNameRussian());
        assertEquals("Il bisbetico domato", actualMovie.getNameNative());
        assertEquals(1980, actualMovie.getYearOfRelease());
        assertEquals(7.7, actualMovie.getRating(), 0);
        assertEquals(120.00, actualMovie.getPrice(), 0);
        assertEquals("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg", actualMovie.getPicturePath());
    }
}