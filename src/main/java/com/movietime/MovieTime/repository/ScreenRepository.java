package com.movietime.MovieTime.repository;

import com.movietime.MovieTime.entity.Screen;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ScreenRepository extends CrudRepository<Screen, Integer>
{
//    @Query("SELECT s.SCREEN_DAY, s.SCREEN_HOUR, f.NAME FROM Screen s INNER JOIN Film f ON s.FILM_ID = f.FILM_ID GROUP BY f.NAME " +
//            "WHERE s.SCREEN_DAY like %?1")
//    List<Screen> findAllFilmsByDay(String day);
    @Query("SELECT s.screenDay, s.screenHour, s.filmId FROM Screen s WHERE s.screenDay=:day")
    List<Map<String, Object>> findAllFilmsByDay(@Param("day") String day);
}
