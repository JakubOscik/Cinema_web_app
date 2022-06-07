package com.movietime.MovieTime.service;

import com.movietime.MovieTime.entity.Screen;
import com.movietime.MovieTime.entity.Ticket;
import com.movietime.MovieTime.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService
{
    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> getAllTickets()
    {
        List<Ticket> tickets = new ArrayList<Ticket>();
        ticketRepository.findAll().forEach(tickets::add);
        return tickets;
    }

    public List<Integer> getPlacesFromTickets(){
        List<Integer> takenPlaces = new ArrayList<Integer>();
        var s = ticketRepository.findAll();
        for(Ticket t: s){
            takenPlaces.add(t.getPlaceId().getPlaceId());
        }
        return takenPlaces;
    }

    public Ticket getTicketById(int id)
    {
        return ticketRepository.findById(id).get();
    }
    public void saveOrUpdate(Ticket ticket)
    {
        ticketRepository.save(ticket);
    }
    public void delete(int id)
    {
        ticketRepository.deleteById(id);
    }
    public void getAllTickets(Screen screen){
        var places =ticketRepository.findAllTicketsByScreen(screen);
        System.out.println(screen);
        System.out.println(places);
    }
}
