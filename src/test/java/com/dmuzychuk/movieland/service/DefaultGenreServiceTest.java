package com.dmuzychuk.movieland.service;

import com.dmuzychuk.movieland.dao.GenreDao;
import com.dmuzychuk.movieland.entity.Genre;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultGenreServiceTest {

    @Test
    @DirtiesContext
    public void testGetAll() {
        GenreDao genreDao = mock(GenreDao.class);

        Genre genre1 = new Genre(5, "мелодрама");
        Genre genre2 = new Genre(6, "биография");
        Genre genre3 = new Genre(7, "комедия");

        List<Genre> expectedGenreList = new ArrayList<>();
        expectedGenreList.add(genre1);
        expectedGenreList.add(genre2);
        expectedGenreList.add(genre3);

        DefaultGenreService genreService = new DefaultGenreService(genreDao);

        when(genreService.getAll()).thenReturn(expectedGenreList);

        List<Genre> actualGenreList = genreService.getAll();

        assertEquals(3, actualGenreList.size());
        assertThat(actualGenreList, hasItems(genre1, genre2, genre3));
    }
}
