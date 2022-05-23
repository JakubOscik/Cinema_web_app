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

    public Place(Hall hallId, boolean taken) {
        this.hallId = hallId;
        this.taken = taken;
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
}

