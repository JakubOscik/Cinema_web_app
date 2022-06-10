package com.movietime.MovieTime.entity;

public class Temp {
    int screenId;
    int filmId;
    int placeId;
    int userId;

    public Temp(int screenId, int filmId, int placeId, int userId) {
        this.screenId = screenId;
        this.filmId = filmId;
        this.placeId = placeId;
        this.userId = userId;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
