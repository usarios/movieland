package com.dmuzychuk.movieland.entity;

import java.util.Objects;

public class SortingItem {

    private SortingColumn column;
    private SortingOrder order;

    public SortingItem(SortingColumn column, SortingOrder order) {
        this.column = column;
        this.order = order;
    }

    public SortingItem() {}

    public SortingColumn getColumn() {
        return column;
    }

    public void setColumn(SortingColumn column) {
        this.column = column;
    }

    public SortingOrder getOrder() {
        return order;
    }

    public void setOrder(SortingOrder order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return column + " " + order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SortingItem)) return false;
        SortingItem that = (SortingItem) o;
        return getColumn() == that.getColumn() &&
                getOrder() == that.getOrder();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getColumn(), getOrder());
    }
}
