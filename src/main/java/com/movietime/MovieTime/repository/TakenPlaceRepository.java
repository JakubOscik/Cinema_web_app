package com.movietime.MovieTime.repository;

import com.movietime.MovieTime.entity.TakenPlace;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TakenPlaceRepository extends CrudRepository<TakenPlace, Integer> {

}
