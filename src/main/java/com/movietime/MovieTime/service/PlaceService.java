package com.movietime.MovieTime.service;

import com.movietime.MovieTime.entity.Place;
import com.movietime.MovieTime.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceService
{
    @Autowired
    PlaceRepository placeRepository;

    public List<Place> getAllPlaces()
    {
        List<Place> places = new ArrayList<Place>();
        placeRepository.findAll().forEach(places::add);
        return places;
    }

    public Place getPlaceById(int id)
    {
        return placeRepository.findById(id).get();
    }
    public void saveOrUpdate(Place place)
    {
        placeRepository.save(place);
    }

    public void delete(int id)
    {
        placeRepository.deleteById(id);
    }
}
