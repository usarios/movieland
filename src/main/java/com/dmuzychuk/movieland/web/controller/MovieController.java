package com.dmuzychuk.movieland.web.controller;

import com.dmuzychuk.movieland.entity.Movie;
import com.dmuzychuk.movieland.entity.SortingColumn;
import com.dmuzychuk.movieland.entity.SortingItem;
import com.dmuzychuk.movieland.entity.SortingOrder;
import com.dmuzychuk.movieland.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    private MovieService movieService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(path = "/movie", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getAllMoviesSorted(@RequestParam(name = "rating", required = false) String ratingOrder,
                                          @RequestParam(name = "price", required = false) String priceOrder) {
        if (ratingOrder == null && priceOrder == null) {
            return movieService.getAll();
        }

        List<SortingItem> sortingItems = new ArrayList<>();

        if (ratingOrder != null) sortingItems.add(new SortingItem(SortingColumn.RATING,
                SortingOrder.valueOf(ratingOrder.toUpperCase())));

        if (priceOrder != null) sortingItems.add(new SortingItem(SortingColumn.PRICE,
                SortingOrder.valueOf(priceOrder.toUpperCase())));

        logger.info("Sorting items list: {}", sortingItems);

        return movieService.getAll(sortingItems);
    }

    @GetMapping(path = "/movie/random", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getRandomMovies() {
        return movieService.getRandom();
    }

    @GetMapping(path = "/movie/genre/{genreId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getMoviesByGenreSorted(@PathVariable int genreId,
                                              @RequestParam(name = "rating", required = false) String ratingOrder,
                                              @RequestParam(name = "price", required = false) String priceOrder
                                              ) {
        if (ratingOrder == null && priceOrder == null) {
            return movieService.getByGenreId(genreId);
        }

        List<SortingItem> sortingItems = new ArrayList<>();

        if (ratingOrder != null) sortingItems.add(new SortingItem(SortingColumn.RATING,
                SortingOrder.valueOf(ratingOrder.toUpperCase())));

        if (priceOrder != null) sortingItems.add(new SortingItem(SortingColumn.PRICE,
                SortingOrder.valueOf(priceOrder.toUpperCase())));

        logger.info("Sorting items list: {}", sortingItems);

        return movieService.getByGenreId(genreId, sortingItems);
    }
}
