package com.dmuzychuk.movieland.dao.mapper;

import com.dmuzychuk.movieland.dao.jdbc.mapper.GenreRowMapper;
import com.dmuzychuk.movieland.entity.Genre;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GenreRowMapperTest {

    @Test
    @DirtiesContext
    public void testGenreRowMapper() throws SQLException {
        GenreRowMapper genreRowMapper = new GenreRowMapper();

        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("id")).thenReturn(7);
        when(resultSet.getString("name_rus")).thenReturn("комедия");

        Genre genre = genreRowMapper.mapRow(resultSet, 0);

        assertEquals(7, genre.getId());
        assertEquals("комедия", genre.getName());
    }
}
