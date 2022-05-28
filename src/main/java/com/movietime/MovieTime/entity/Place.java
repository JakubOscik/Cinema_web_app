package com.movietime.MovieTime.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
    private Hall hallId;

    @Column(name="taken", nullable = false)
    private boolean taken;

    @Column(name="placeRow", nullable = false)
    private int row;

    @Column(name="placeColumn", nullable = false)
    private int column;

    public Place(Hall hallId, boolean taken, int row, int column) {
        this.hallId = hallId;
        this.taken = taken;
        this.row = row;
        this.column = column;
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

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}

