package com.dmuzychuk.movieland.dao;


import com.dmuzychuk.movieland.entity.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/root-context.xml", "file:src/main/webapp/WEB-INF/movieland-servlet.xml", "classpath:/spring/test-context.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class DefaultGenreDaoTest {

    private GenreDao genreDao;

    @Autowired
    public void setGenreDao(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Test
    public void getAll() {

        Genre genre1 = new Genre(5, "мелодрама");
        Genre genre2 = new Genre(6, "биография");
        Genre genre3 = new Genre(7, "комедия");

        List<Genre> genres = new ArrayList<>();
        genres.add(genre1);
        genres.add(genre2);
        genres.add(genre3);

        List<Genre> actualGenresList = genreDao.getAll();

        assertEquals(15, actualGenresList.size());

        assertThat(actualGenresList, hasItems(genre1, genre2, genre3));
    }
}
