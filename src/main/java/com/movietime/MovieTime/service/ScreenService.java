package com.movietime.MovieTime.service;

import com.movietime.MovieTime.entity.Screen;
import com.movietime.MovieTime.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
