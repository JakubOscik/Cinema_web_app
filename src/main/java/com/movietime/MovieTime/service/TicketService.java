package com.movietime.MovieTime.service;

import com.movietime.MovieTime.entity.*;
import com.movietime.MovieTime.repository.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    ScreenRepository screenRepository;
    @Autowired
    UsersRepository usersRepository;


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

    public void add(Temp temp){
        Film films = filmRepository.findById(temp.getFilmId()).stream().toList().get(0);
        Screen screens = screenRepository.findById(temp.getScreenId()).stream().toList().get(0);
        Users users = usersRepository.findById(temp.getUserId()).stream().toList().get(0);
        Place places = placeRepository.findById(temp.getPlaceId()).stream().toList().get(0);
//        System.out.println(users);
        Ticket t = new Ticket(screens, films, users, places);
        System.out.println(t);
        ticketRepository.save(t);
    }

    public JSONArray getUserTickets(String userId){
        var user = usersRepository.findById(Integer.parseInt(userId)).stream().toList();
        Map<String, ArrayList<Integer>> data = new HashMap<>();
        Map<String, Integer> screen = new HashMap<>();
        var s = ticketRepository.findUserTickets(user.get(0));
        for (Map<String, Object> stringObjectMap : s) {
            ArrayList<Integer> places = new ArrayList<>();
            List<Object> single = stringObjectMap.values().stream().toList();
            Screen name = (Screen) single.get(0);
            Place place = (Place) single.get(1);
            int p = place.getPlaceId();
            String n = name.getFilmFk().getName();
            int screenId = name.getScreenId();
            places.add(p);
            if(!data.containsKey(n)){
                data.put(n, places);
                screen.put(n, screenId);
            }
            else {
                data.get(n).add(p);
                data.put(n, data.get(n));
            }
        }
        JSONArray array = new JSONArray();
        for(Object a: data.keySet()) {
            Object name = a;
            ArrayList<Integer> places = data.get(a);
            int id = screen.get(a);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", name);
            jsonObject.put("places", places);
            jsonObject.put("screen", id);
            array.add(jsonObject);
        }
        return array;
    }

}
