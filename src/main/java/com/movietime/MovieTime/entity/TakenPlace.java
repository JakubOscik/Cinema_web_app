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

    @ManyToOne
    @JoinColumn(name = "placeId")
    private Place placeId;

    @ManyToOne
    @JoinColumn(name = "ticketId")
    private Ticket ticketId;

    public TakenPlace(Place placeId, Ticket ticketId) {
        this.placeId = placeId;
        this.ticketId = ticketId;
    }

    public int getTakenPlaceId() {
        return takenPlaceId;
    }

    public void setTakenPlaceId(int takenPlaceId) {
        this.takenPlaceId = takenPlaceId;
    }

    public Place getPlaceFk() {return placeId;}

    public void setPlaceFk(Place placeId) {this.placeId = placeId;}

    public Ticket getTicketFk() {return ticketId;}

    public void setTicketFk(Ticket ticketId) {this.ticketId = ticketId;}
}
