package com.dmuzychuk.movieland.dao.cache;

import com.dmuzychuk.movieland.dao.GenreDao;
import com.dmuzychuk.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class CachedGenreDao implements GenreDao {

    private volatile List<Genre> cachedGenreList;

    private GenreDao genreDao;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public CachedGenreDao(@Qualifier("defaultGenreDao") GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> getAll() {
        return new ArrayList<>(cachedGenreList);
    }

    @PostConstruct
    @Scheduled(initialDelayString = "${initial-delay-millis}", fixedDelayString = "${14400000}")
    public void initGenreCache() {
        cachedGenreList = genreDao.getAll();

        logger.info("Genre cache refreshed at: {}", LocalDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));
        logger.info("Number of records in Genre cache: {}", cachedGenreList.size());
    }
}
