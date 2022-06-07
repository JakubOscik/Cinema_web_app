package com.movietime.MovieTime.repository;

import com.movietime.MovieTime.entity.Screen;
import com.movietime.MovieTime.entity.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TicketRepository extends CrudRepository<Ticket, Integer>
{
    @Query("SELECT t.placeId FROM Ticket t WHERE t.screenId=1")
    List<Map<String, Object>> findAllTicketsByScreen(@Param("screen") Screen screen);
}