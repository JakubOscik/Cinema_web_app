package com.movietime.MovieTime.model;

import com.movietime.MovieTime.entity.Place;
import com.movietime.MovieTime.entity.TakenPlace;
import com.movietime.MovieTime.entity.Ticket;

public class Reservation {
    private Ticket ticket;
    private Place takenPlaces;

    public Reservation(Ticket ticket, Place takenPlaces) {
        this.ticket = ticket;
        this.takenPlaces = takenPlaces;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Place getTakenPlaces() {
        return takenPlaces;
    }

    public void setTakenPlaces(Place takenPlaces) {
        this.takenPlaces = takenPlaces;
    }
}
