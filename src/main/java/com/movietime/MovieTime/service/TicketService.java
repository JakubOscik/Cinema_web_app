package com.movietime.MovieTime.service;

import com.movietime.MovieTime.entity.Place;
import com.movietime.MovieTime.entity.Screen;
import com.movietime.MovieTime.entity.TakenPlace;
import com.movietime.MovieTime.entity.Ticket;
import com.movietime.MovieTime.repository.PlaceRepository;
import com.movietime.MovieTime.repository.TakenPlaceRepository;
import com.movietime.MovieTime.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TicketService
{
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TakenPlaceRepository takenPlaceRepository;
    @Autowired
    PlaceRepository placeRepository;

    public List<Ticket> getAllTickets()
    {
        List<Ticket> tickets = new ArrayList<>();
        ticketRepository.findAll().forEach(tickets::add);
        return tickets;
    }

    public Ticket getTicketById(int id)
    {
        return ticketRepository.findById(id).get();
    }

    public void save(Ticket ticket)
    {
        ticketRepository.save(ticket);
    }

    public void delete(int id)
    {
        ticketRepository.deleteById(id);
    }

}
