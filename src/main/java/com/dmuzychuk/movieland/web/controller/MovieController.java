package com.dmuzychuk.movieland.web.controller;

import com.dmuzychuk.movieland.entity.Movie;
import com.dmuzychuk.movieland.entity.common.*;
import com.dmuzychuk.movieland.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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
    public List<Movie> getAllMoviesSorted(@RequestParam(name = "rating", required = false) SortingOrder ratingOrder,
                                          @RequestParam(name = "price", required = false) SortingOrder priceOrder) {
        logger.info("Request ratingOrder: {}", ratingOrder);
        logger.info("Request priceOrder: {}", priceOrder);

        if (ratingOrder != null || priceOrder != null) {
            MovieRequestParam movieRequestParam = new MovieRequestParam();
            movieRequestParam.setSortingItem(getValidatedSortingItem(ratingOrder, priceOrder));

            return movieService.getAll(movieRequestParam);

        } else {
            return movieService.getAll();
        }
    }

    @GetMapping(path = "/movie/random", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getRandomMovies() {
        return movieService.getRandom();
    }

    @GetMapping(path = "/movie/genre/{genreId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getMoviesByGenreSorted(@PathVariable int genreId,
                                              @RequestParam(name = "rating", required = false) SortingOrder ratingOrder,
                                              @RequestParam(name = "price", required = false) SortingOrder priceOrder
    ) {

        logger.info("Request ratingOrder: {}", ratingOrder);
        logger.info("Request priceOrder: {}", priceOrder);

        if (ratingOrder != null || priceOrder != null) {
            MovieRequestParam movieRequestParam = new MovieRequestParam();

            movieRequestParam.setSortingItem(getValidatedSortingItem(ratingOrder, priceOrder));

            return movieService.getByGenreId(genreId, movieRequestParam);

        } else {
            return movieService.getByGenreId(genreId);
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(SortingOrder.class, new SortingOrderConverter());
        dataBinder.registerCustomEditor(SortingColumn.class, new SortingColumnConverter());
    }

    SortingItem getValidatedSortingItem(SortingOrder ratingOrder, SortingOrder priceOrder) {

        SortingItem sortingItem = new SortingItem();

        if (ratingOrder != null) {
            sortingItem.setSortingColumn(SortingColumn.getByName("RATING"));
            sortingItem.setSortingOrder(ratingOrder);
        } else {
            sortingItem.setSortingColumn(SortingColumn.getByName("PRICE"));
            sortingItem.setSortingOrder(priceOrder);
        }

        if (ratingOrder != null && priceOrder != null) {
            throw new IllegalArgumentException("Only one column should be specified for sorting");
        }

        if (ratingOrder != null && !ratingOrder.equals(SortingOrder.getByName("DESC"))) {
            throw new IllegalArgumentException("Sorting order for Rating column may be only Descending");
        }

        return sortingItem;
    }

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    void handleBadRequests(Exception e) {
        logger.error("Exception:{}", e);
    }
}
