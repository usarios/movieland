package com.dmuzychuk.movieland.web.controller;

import com.dmuzychuk.movieland.dao.MovieDao;
import com.dmuzychuk.movieland.entity.Movie;
import com.dmuzychuk.movieland.entity.SortingColumn;
import com.dmuzychuk.movieland.entity.SortingItem;
import com.dmuzychuk.movieland.entity.SortingOrder;
import com.dmuzychuk.movieland.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/root-context.xml", "file:src/main/webapp/WEB-INF/movieland-servlet.xml", "classpath:/spring/test-context.xml"})
@WebAppConfiguration
public class MovieControllerTest extends AbstractJUnit4SpringContextTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    @InjectMocks
    MovieService movieService;

    @Mock
    MovieDao movieDao;

    @Before
    @DirtiesContext
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.webApplicationContext);
        this.mockMvc = builder.build();
    }

    @Test
    @DirtiesContext
    public void testGetAll() throws Exception {
        Movie movie = new Movie();
        movie.setId(12);
        movie.setNameRussian("Укрощение строптивого");
        movie.setNameNative("Il bisbetico domato");
        movie.setYearOfRelease(1980);
        movie.setRating(7.7);
        movie.setPrice(120.00);
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg");

        when(movieService.getAll()).thenReturn(Collections.singletonList(movie));

        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(12)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Укрощение строптивого")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Il bisbetico domato")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(1980)))
                .andExpect(jsonPath("$[0].rating", equalTo(7.7)))
                .andExpect(jsonPath("$[0].price", equalTo(120.00)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg")));
    }

    @Test
    @DirtiesContext
    public void testGetRandomMovies() throws Exception {
        Movie movie = new Movie();

        movie.setId(13);
        movie.setNameRussian("Ходячий замок");
        movie.setNameNative("Hauru no ugoku shiro");
        movie.setYearOfRelease(2004);
        movie.setRating(8.2);
        movie.setPrice(130.5);
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BZTRhY2QwM2UtNWRlNy00ZWQwLTg3MjktZThmNjQ3NTdjN2IxXkEyXkFqcGdeQXVyMzg2MzE2OTE@._V1._SY209_CR5,0,140,209_.jpg");

        when(movieService.getRandom()).thenReturn(Collections.singletonList(movie));

        mockMvc.perform(get("/movie/random"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(13)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Ходячий замок")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Hauru no ugoku shiro")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(2004)))
                .andExpect(jsonPath("$[0].rating", equalTo(8.2)))
                .andExpect(jsonPath("$[0].price", equalTo(130.5)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BZTRhY2QwM2UtNWRlNy00ZWQwLTg3MjktZThmNjQ3NTdjN2IxXkEyXkFqcGdeQXVyMzg2MzE2OTE@._V1._SY209_CR5,0,140,209_.jpg")));
    }

    @Test
    @DirtiesContext
    public void testGetMoviesByGenreId() throws Exception {
        Movie movie = new Movie();
        movie.setId(12);
        movie.setNameRussian("Блеф");
        movie.setNameNative("Bluff storia di truffe e di imbroglioni");
        movie.setYearOfRelease(1976);
        movie.setRating(7.6);
        movie.setPrice(100.00);
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg");

        when(movieService.getByGenreId(7)).thenReturn(Collections.singletonList(movie));

        mockMvc.perform(get("/movie/genre/7"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(12)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Блеф")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Bluff storia di truffe e di imbroglioni")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(1976)))
                .andExpect(jsonPath("$[0].rating", equalTo(7.6)))
                .andExpect(jsonPath("$[0].price", equalTo(100.00)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg")));
    }

    @Test
    @DirtiesContext
    public void testGetAllMoviesSorted() throws Exception {
        Movie movie = new Movie();
        movie.setId(20);
        movie.setNameRussian("Побег из Шоушенка");
        movie.setNameNative("The Shawshank Redemption");
        movie.setYearOfRelease(1994);
        movie.setRating(8.9);
        movie.setPrice(123.45);
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg");

        List<SortingItem> sortingItems = new ArrayList<>();
        sortingItems.add(new SortingItem(SortingColumn.RATING, SortingOrder.DESC));
        sortingItems.add(new SortingItem(SortingColumn.PRICE, SortingOrder.ASC));

        when(movieService.getAll(sortingItems)).thenReturn(Collections.singletonList(movie));

        mockMvc.perform(get("/movie?rating=desc&price=asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(20)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Побег из Шоушенка")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("The Shawshank Redemption")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(1994)))
                .andExpect(jsonPath("$[0].rating", equalTo(8.9)))
                .andExpect(jsonPath("$[0].price", equalTo(123.45)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg")));
    }

    @Test
    @DirtiesContext
    public void testGetMoviesByGenreSorted() throws Exception {
        Movie movie = new Movie();
        movie.setId(25);
        movie.setNameRussian("Большой куш");
        movie.setNameNative("Snatch");
        movie.setYearOfRelease(2000);
        movie.setRating(8.5);
        movie.setPrice(160.00);
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTA2NDYxOGYtYjU1Mi00Y2QzLTgxMTQtMWI1MGI0ZGQ5MmU4XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1._SY209_CR1,0,140,209_.jpg");

        List<SortingItem> sortingItems = new ArrayList<>();
        sortingItems.add(new SortingItem(SortingColumn.RATING, SortingOrder.DESC));
        sortingItems.add(new SortingItem(SortingColumn.PRICE, SortingOrder.ASC));

        when(movieService.getByGenreId(7, sortingItems)).thenReturn(Collections.singletonList(movie));

        mockMvc.perform(get("/movie/genre/7?rating=desc&price=asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(25)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Большой куш")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Snatch")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(2000)))
                .andExpect(jsonPath("$[0].rating", equalTo(8.5)))
                .andExpect(jsonPath("$[0].price", equalTo(160.00)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTA2NDYxOGYtYjU1Mi00Y2QzLTgxMTQtMWI1MGI0ZGQ5MmU4XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1._SY209_CR1,0,140,209_.jpg")));
    }
}
