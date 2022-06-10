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
        property = "takenPlaceId")
public @Getter @Setter
class TakenPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="takenPlaceId")
    private int takenPlaceId;

    @Column(name = "placeId")
    private int placeId;

    @Column(name = "screenId")
    private int screenId;

    public TakenPlace(int placeId, int screenId) {
        this.placeId = placeId;
        this.screenId = screenId;
    }

    public int getTakenPlaceId() {
        return takenPlaceId;
    }

    public void setTakenPlaceId(int takenPlaceId) {
        this.takenPlaceId = takenPlaceId;
    }

    public int getPlaceFk() {return placeId;}

    public void setPlaceFk(int placeId) {this.placeId = placeId;}

    public int getTicketFk() {return screenId;}

    public void setTicketFk(int screenId) {this.screenId = screenId;}
}
