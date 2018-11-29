package com.dmuzychuk.movieland.entity.common;

public enum SortingOrder {

    ASC("asc"), DESC("desc");

    private String sortingOrder;

    SortingOrder(String SortingOrder) {
        this.sortingOrder = SortingOrder;
    }

    public String getSortingOrder() {
        return sortingOrder;
    }

    public static SortingOrder getByName(String name) {
        for (SortingOrder sortingOrder : values()) {
            if (name.equalsIgnoreCase(sortingOrder.getSortingOrder())) {
                return sortingOrder;
            }
        }
        throw new IllegalArgumentException("Invalid sorting order: " + name);
    }
}
