package com.dmuzychuk.movieland.dao.common;

import com.dmuzychuk.movieland.entity.common.MovieRequestParam;
import com.dmuzychuk.movieland.entity.common.SortingColumn;
import com.dmuzychuk.movieland.entity.common.SortingItem;
import com.dmuzychuk.movieland.entity.common.SortingOrder;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DaoSqlUtilsTest {

    @Test
    public void testgetSqlWithSortingClause() {
        String sqlPrefix = "Select id, name_rus, rating, price from movie";
        String sqlSuffix = "order by rating desc";

        String expectedSqlSorted = "select id, name_rus, rating, price from movie order by rating desc";
        String actualSqlSorted;

        SortingItem sortingItem = new SortingItem(SortingColumn.RATING, SortingOrder.DESC);
        MovieRequestParam movieRequestParam = new MovieRequestParam();
        movieRequestParam.setSortingItem(sortingItem);

        actualSqlSorted = DaoSqlUtils.getSqlWithSortingClause(sqlPrefix, movieRequestParam);

        assertEquals(expectedSqlSorted, actualSqlSorted);
    }
}
