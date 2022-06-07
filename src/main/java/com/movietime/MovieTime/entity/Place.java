package com.movietime.MovieTime.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "placeId")
public @Getter @Setter
class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="placeId")
    private int placeId;

    @ManyToOne
    @JoinColumn(name = "hallId")
    @JsonIgnoreProperties({ "places" })
    private Hall hallId;

    @Column(name="taken", nullable = false)
    private boolean taken;

    @Column(name="height", nullable = false)
    private int height;

    @Column(name="width", nullable = false)
    private int width;

    @Column(name="x", nullable = false)
    private int x;

    @Column(name="y", nullable = false)
    private int y;

    public Place(Hall hallId, boolean taken, int height, int width, int x, int y) {
        this.hallId = hallId;
        this.taken = taken;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public Hall getHallFk() {
        return hallId;
    }

    public void setHallFk(Hall hallId) {
        this.hallId = hallId;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public Hall getHallId() {
        return hallId;
    }

    public void setHallId(Hall hallId) {
        this.hallId = hallId;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() { return y;}

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeId=" + placeId +
                ", taken=" + taken +
                '}';
    }
}
