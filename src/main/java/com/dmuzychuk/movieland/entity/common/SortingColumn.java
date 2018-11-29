package com.dmuzychuk.movieland.entity.common;

public enum SortingColumn {


    RATING("rating"), PRICE("price");

    private String sortingColumn;

    SortingColumn(String sortingColumn) {
        this.sortingColumn = sortingColumn;
    }

    public String getSortingColumn() {
        return sortingColumn;
    }

    public static SortingColumn getByName(String name) {
        for (SortingColumn sortingColumn : values()) {
            if (name.equalsIgnoreCase(sortingColumn.getSortingColumn())) {
                return sortingColumn;
            }
        }
        throw new IllegalArgumentException("Invalid sorting column: " + name);
    }
}
