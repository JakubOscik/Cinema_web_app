package com.movietime.MovieTime.service;

import com.movietime.MovieTime.entity.Place;
import com.movietime.MovieTime.entity.Screen;
import com.movietime.MovieTime.entity.Ticket;
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
    public void saveOrUpdate(Ticket ticket)
    {
        ticketRepository.save(ticket);
    }
    public void delete(int id)
    {
        ticketRepository.deleteById(id);
    }

    //public List<Integer> getAllTickets(Screen screen)
    //{
    //    var places = ticketRepository.findAllTicketsByScreen(screen);
    //    List<Integer> takenPlaces = new ArrayList<>();
    //    for (Map<String, Object> stringObjectMap : places) {
    //        List<Object> single = stringObjectMap.values().stream().toList();
    //        Place s = (Place) single.get(0);
    //        if(s.isTaken()) takenPlaces.add(s.getPlaceId());
    //    }
    //    return takenPlaces;
    //}
}
