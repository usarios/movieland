package com.dmuzychuk.movieland.dao.cache;

import com.dmuzychuk.movieland.dao.GenreDao;
import com.dmuzychuk.movieland.entity.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/root-context.xml", "file:src/main/webapp/WEB-INF/movieland-servlet.xml", "classpath:/spring/test-context.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class CachedGenreDaoTest {

    @Autowired
    private GenreDao cachedGenreDao;

    @Test
    public void testGetAll() {
        List<Genre> actualGenreList = cachedGenreDao.getAll();

        assertEquals(15, actualGenreList.size());

        assertEquals(7, actualGenreList.get(6).getId());
        actualGenreList.set(6, new Genre(88,"ABC"));

        actualGenreList = cachedGenreDao.getAll();
        assertTrue(actualGenreList.contains(new Genre(7, "комедия")));
    }
}
