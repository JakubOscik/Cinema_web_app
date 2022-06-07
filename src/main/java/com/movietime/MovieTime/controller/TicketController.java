package com.movietime.MovieTime.controller;

import com.movietime.MovieTime.entity.Place;
import com.movietime.MovieTime.entity.Screen;
import com.movietime.MovieTime.entity.Ticket;
import com.movietime.MovieTime.model.Reservation;
import com.movietime.MovieTime.service.TicketService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping("/tickets")
    private List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/reservations")
    private Reservation getAllReservations() {
        return ticketService.getAllReservations();
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
    private int saveTicket(@RequestBody Reservation reservation) {
        ticketService.saveOrUpdate(reservation);
        return reservation.getTicket().getTicketId();
    }

    //@GetMapping("/getTickets")
    //private List<Integer> screen(@RequestParam Screen screen) {
    //    return ticketService.getAllTickets(screen);
    //}
}
