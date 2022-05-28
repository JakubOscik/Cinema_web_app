package com.movietime.MovieTime.service;

import com.movietime.MovieTime.entity.Screen;
import com.movietime.MovieTime.repository.ScreenRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScreenService
{
    @Autowired
    ScreenRepository screenRepository;

    public List<Screen> getAllScreens()
    {
        List<Screen> screens = new ArrayList<Screen>();
        screenRepository.findAll().forEach(screens::add);
        return screens;
    }

    public Screen getScreenById(int id)
    {
        return screenRepository.findById(id).get();
    }
    public void saveOrUpdate(Screen screen)
    {
        screenRepository.save(screen);
    }

    public void delete(int id)
    {
        screenRepository.deleteById(id);
    }

    public JSONArray printScreen(String day) {
        Map<Object,ArrayList<Object>> filmsData = new HashMap<>();
        var s = screenRepository.findAllFilmsByDay(day);
        for (Map<String, Object> stringObjectMap : s) {
            var single = stringObjectMap.values().stream().toList();
            Object name = single.get(2);
            Object hour = single.get(1);
            if (!filmsData.containsKey(name)) {
                ArrayList<Object> hours = new ArrayList<>();
                hours.add(hour);
                filmsData.put(name, hours);
            } else {
                filmsData.get(name).add(hour);
                filmsData.put(name,  filmsData.get(name));
            }

        }
        JSONArray array = new JSONArray();

        for(var a: filmsData.keySet()) {
            var name = a;
            var hours = filmsData.get(a);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("data", name);
            jsonObject.put("hours", hours);
            array.add(jsonObject);
        }
        return array;
    }
}
