package com.dmuzychuk.movieland.dao;

import com.dmuzychuk.movieland.entity.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/root-context.xml", "file:src/main/webapp/WEB-INF/movieland-servlet.xml", "classpath:/spring/test-context.xml"})
public class DefaultMovieDaoTest {

    private MovieDao movieDao;

    @Autowired
    public void setMovieDao(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Test
    @DirtiesContext
    public void testGetAll() {

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
        movie2.setPrice(100.0);
        movie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg");
        expectedMovieList.add(movie2);

        List<Movie> actualMovieList = movieDao.getAll();

        assertEquals(2, actualMovieList.size());

        assertThat(actualMovieList, containsInAnyOrder(movie1, movie2));

    }
}

