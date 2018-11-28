package com.dmuzychuk.movieland.service;

import com.dmuzychuk.movieland.dao.MovieDao;
import com.dmuzychuk.movieland.entity.Movie;
import com.dmuzychuk.movieland.entity.common.MovieRequestParam;
import com.dmuzychuk.movieland.entity.common.SortingColumn;
import com.dmuzychuk.movieland.entity.common.SortingItem;
import com.dmuzychuk.movieland.entity.common.SortingOrder;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class DefaultMovieServiceTest {

    @Test
    public void testGetAll() {
        MovieDao movieDao = mock(MovieDao.class);

        List<Movie> expectedMovieList = new ArrayList<>();

        Movie movie1 = new Movie();
        movie1.setId(12);
        movie1.setNameRussian("Укрощение строптивого");
        movie1.setNameNative("Il bisbetico domato");
        movie1.setYearOfRelease(1980);
        movie1.setRating(7.7);
        movie1.setPrice(120.00);
        movie1.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg");
        expectedMovieList.add(movie1);

        Movie movie2 = new Movie();
        movie2.setId(7);
        movie2.setNameRussian("Блеф");
        movie2.setNameNative("Bluff storia di truffe e di imbroglioni");
        movie2.setYearOfRelease(1976);
        movie2.setRating(7.6);
        movie2.setPrice(100.00);
        movie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg");
        expectedMovieList.add(movie2);

        DefaultMovieService movieService = new DefaultMovieService(movieDao);

        when(movieService.getAll()).thenReturn(expectedMovieList);

        List<Movie> actualMovieList = movieService.getAll();

        assertEquals(2, actualMovieList.size());
        assertThat(actualMovieList, hasItems(movie1, movie2));
    }

    @Test
    public void testGetRandom() {
        MovieDao movieDao = mock(MovieDao.class);

        List<Movie> expectedMovieList = new ArrayList<>();

        Movie movie1 = new Movie();
        movie1.setId(12);
        movie1.setNameRussian("Укрощение строптивого");
        movie1.setNameNative("Il bisbetico domato");
        movie1.setYearOfRelease(1980);
        movie1.setRating(7.7);
        movie1.setPrice(120.00);
        movie1.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg");
        expectedMovieList.add(movie1);

        Movie movie2 = new Movie();
        movie2.setId(7);
        movie2.setNameRussian("Блеф");
        movie2.setNameNative("Bluff storia di truffe e di imbroglioni");
        movie2.setYearOfRelease(1976);
        movie2.setRating(7.6);
        movie2.setPrice(100.00);
        movie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg");
        expectedMovieList.add(movie2);

        DefaultMovieService movieService = new DefaultMovieService(movieDao);

        when(movieService.getRandom()).thenReturn(expectedMovieList);

        List<Movie> actualMovieList = movieService.getRandom();

        assertEquals(2, actualMovieList.size());
        assertThat(actualMovieList, hasItems(movie1, movie2));
    }

    @Test
    public void testGetByGenre() {
        MovieDao movieDao = mock(MovieDao.class);

        List<Movie> expectedMovieList = new ArrayList<>();

        Movie movie1 = new Movie();
        movie1.setId(12);
        movie1.setNameRussian("Укрощение строптивого");
        movie1.setNameNative("Il bisbetico domato");
        movie1.setYearOfRelease(1980);
        movie1.setRating(7.7);
        movie1.setPrice(120.00);
        movie1.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg");
        expectedMovieList.add(movie1);

        Movie movie2 = new Movie();
        movie2.setId(7);
        movie2.setNameRussian("Блеф");
        movie2.setNameNative("Bluff storia di truffe e di imbroglioni");
        movie2.setYearOfRelease(1976);
        movie2.setRating(7.6);
        movie2.setPrice(100.00);
        movie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg");
        expectedMovieList.add(movie2);

        Movie movie3 = new Movie();
        movie2.setId(21);
        movie2.setNameRussian("Хороший, плохой, злой");
        movie2.setNameNative("Il buono, il brutto, il cattivo");
        movie2.setYearOfRelease(1979);
        movie2.setRating(8.5);
        movie2.setPrice(130);
        movie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BOTQ5NDI3MTI4MF5BMl5BanBnXkFtZTgwNDQ4ODE5MDE@._V1._SX140_CR0,0,140,209_.jpg");

        DefaultMovieService movieService = new DefaultMovieService(movieDao);

        when(movieService.getByGenreId(7)).thenReturn(expectedMovieList);

        List<Movie> actualMovieList = movieService.getByGenreId(7);

        assertEquals(2, actualMovieList.size());
        assertThat(actualMovieList, hasItems(movie1, movie2));
        assertThat(actualMovieList, not(hasItems(movie3)));
    }

    @Test
    public void testGetAllSorted() {
        MovieDao movieDao = mock(MovieDao.class);

        List<Movie> expectedMovieList = new ArrayList<>();

        Movie movie1 = new Movie();
        movie1.setId(12);
        movie1.setNameRussian("Укрощение строптивого");
        movie1.setNameNative("Il bisbetico domato");
        movie1.setYearOfRelease(1980);
        movie1.setRating(7.7);
        movie1.setPrice(120.00);
        movie1.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg");
        expectedMovieList.add(movie1);

        Movie movie2 = new Movie();
        movie2.setId(7);
        movie2.setNameRussian("Блеф");
        movie2.setNameNative("Bluff storia di truffe e di imbroglioni");
        movie2.setYearOfRelease(1976);
        movie2.setRating(7.6);
        movie2.setPrice(100.00);
        movie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg");
        expectedMovieList.add(movie2);

        DefaultMovieService movieService = new DefaultMovieService(movieDao);

        SortingItem sortingItem = new SortingItem(SortingColumn.RATING, SortingOrder.DESC);
        MovieRequestParam movieRequestParam = new MovieRequestParam();
        movieRequestParam.setSortingItem(sortingItem);

        when(movieService.getAll(movieRequestParam)).thenReturn(expectedMovieList);

        List<Movie> actualMovieList = movieService.getAll(movieRequestParam);

        assertEquals(2, actualMovieList.size());
        assertThat(actualMovieList, hasItems(movie1, movie2));
        assertEquals("Il bisbetico domato", actualMovieList.get(0).getNameNative());
        assertEquals("Bluff storia di truffe e di imbroglioni", actualMovieList.get(1).getNameNative());
    }
}
