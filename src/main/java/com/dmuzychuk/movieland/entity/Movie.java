package com.dmuzychuk.movieland.entity;

import java.util.Objects;

public class Movie {

    private int id;
    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private double rating;
    private double price;
    private String picturePath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRussian() {
        return nameRussian;
    }

    public void setNameRussian(String nameRussian) {
        this.nameRussian = nameRussian;
    }

    public String getNameNative() {
        return nameNative;
    }

    public void setNameNative(String nameNative) {
        this.nameNative = nameNative;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", nameRussian='" + nameRussian + '\'' +
                ", nameNative='" + nameNative + '\'' +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", picturePath='" + picturePath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return getId() == movie.getId() &&
                getYearOfRelease() == movie.getYearOfRelease() &&
                Double.compare(movie.getRating(), getRating()) == 0 &&
                Double.compare(movie.getPrice(), getPrice()) == 0 &&
                Objects.equals(getNameRussian(), movie.getNameRussian()) &&
                Objects.equals(getNameNative(), movie.getNameNative()) &&
                Objects.equals(getPicturePath(), movie.getPicturePath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNameRussian(), getNameNative(), getYearOfRelease(), getRating(), getPrice(), getPicturePath());
    }
}
