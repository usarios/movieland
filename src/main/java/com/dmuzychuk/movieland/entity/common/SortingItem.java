package com.dmuzychuk.movieland.entity.common;

import java.util.Objects;

public class SortingItem {

    private SortingColumn sortingColumn;
    private SortingOrder sortingOrder;

    public SortingItem() {
    }

    public SortingItem(SortingColumn sortingColumn, SortingOrder sortingOrder) {
        this.sortingColumn = sortingColumn;
        this.sortingOrder = sortingOrder;
    }

    public SortingColumn getSortingColumn() {
        return sortingColumn;
    }

    public void setSortingColumn(SortingColumn sortingColumn) {
        this.sortingColumn = sortingColumn;
    }

    public SortingOrder getSortingOrder() {
        return sortingOrder;
    }

    public void setSortingOrder(SortingOrder sortingOrder) {
        this.sortingOrder = sortingOrder;
    }

    @Override
    public String toString() {
        return "SortingItem{" +
                "sortingColumn=" + sortingColumn +
                ", sortingOrder=" + sortingOrder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SortingItem)) return false;
        SortingItem that = (SortingItem) o;
        return getSortingColumn() == that.getSortingColumn() &&
                getSortingOrder() == that.getSortingOrder();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSortingColumn(), getSortingOrder());
    }
}
