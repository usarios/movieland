package com.dmuzychuk.movieland.entity;

public enum SortingColumn {


    RATING("RATING"), PRICE("PRICE");

    private String SortingColumn;

    SortingColumn(String SortingColumn) {

        this.SortingColumn = SortingColumn;
    }
}
