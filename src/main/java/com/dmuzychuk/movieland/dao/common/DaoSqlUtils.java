package com.dmuzychuk.movieland.dao.common;

import com.dmuzychuk.movieland.entity.common.MovieRequestParam;

public class DaoSqlUtils {

    public static String getSqlWithSortingClause(String SqlPrefix, MovieRequestParam movieRequestParam) {
        String fullSqlTextWithOrderBy;
        String orderByClause = "order by";
        String sortingColumn = "";
        String sortingOrder = "";

        if (movieRequestParam.getSortingItem() != null && movieRequestParam.getSortingItem().getSortingColumn() != null) {
            sortingColumn = movieRequestParam.getSortingItem().getSortingColumn().name();
        }
        if (movieRequestParam.getSortingItem() != null && movieRequestParam.getSortingItem().getSortingOrder() != null) {
            sortingOrder = movieRequestParam.getSortingItem().getSortingOrder().name();
        }

        String orderByList = movieRequestParam.getSortingItem().getSortingColumn() + " "
                + movieRequestParam.getSortingItem().getSortingOrder();

        fullSqlTextWithOrderBy = SqlPrefix + " " + orderByClause + " " + sortingColumn + " " + sortingOrder;

        return fullSqlTextWithOrderBy.toLowerCase();
    }
}
