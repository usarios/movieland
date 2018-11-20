package com.dmuzychuk.movieland.service;

import com.dmuzychuk.movieland.dao.MovieDao;
import com.dmuzychuk.movieland.entity.Movie;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultMovieServiceTest {

    @Test
    @DirtiesContext
    public void getAll() {
        MovieDao movieDao = mock(MovieDao.class);

        List<Movie> expectedMovieList = new ArrayList<>();

        Movie movie1 = new Movie();
        movie1.setId(1);
        movie1.setNameRussian("Укрощение строптивого");
        movie1.setNameNative("Il bisbetico domato");
        movie1.setYearOfRelease(1980);
        movie1.setRating(7.7);
        movie1.setPrice(120.00);
        movie1.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg");
        expectedMovieList.add(movie1);

        Movie movie2 = new Movie();
        movie2.setId(2);
        movie2.setNameRussian("Блеф");
        movie2.setNameNative("Bluff storia di truffe e di imbroglioni");
        movie2.setYearOfRelease(1976);
        movie2.setRating(7.6);
        movie2.setPrice(100.00);
        movie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg");
        expectedMovieList.add(movie2);

        DefaultMovieService movieService = new DefaultMovieService(movieDao);

        when(movieDao.getAll()).thenReturn(expectedMovieList);

        List<Movie> actualMovieList = movieService.getAll();

        assertEquals(2, actualMovieList.size());
        assertThat(actualMovieList, containsInAnyOrder(movie1, movie2));

    }
}
