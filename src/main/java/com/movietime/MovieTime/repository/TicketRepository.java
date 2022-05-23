package com.movietime.MovieTime.repository;


import com.movietime.MovieTime.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Integer>
{
}