package com.movietime.MovieTime.controller;

import com.movietime.MovieTime.entity.Screen;
import com.movietime.MovieTime.entity.Ticket;
import com.movietime.MovieTime.service.TicketService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping("/tickets")
    private List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/ticket/{id}")
    private Ticket getTicket(@PathVariable("id") int id) {
        return ticketService.getTicketById(id);
    }

    @DeleteMapping("/ticket/{id}")
    private void deleteTicket(@PathVariable("id") int id) {
        ticketService.delete(id);
    }

    @PostMapping("/ticket")
    private int saveTicket(@RequestBody Ticket ticket) {
        ticketService.saveOrUpdate(ticket);
        return ticket.getTicketId();
    }

    @GetMapping("/taken")
    private List<Integer> getTakenPlaces() {
        return ticketService.getPlacesFromTickets();
    }

    @GetMapping("/getTickets")
    private void screen(@RequestParam Screen screen) {
        ticketService.getAllTickets(screen);
    }
}
