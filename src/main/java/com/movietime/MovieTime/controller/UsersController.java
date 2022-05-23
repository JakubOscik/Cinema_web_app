package com.movietime.MovieTime.controller;

import com.movietime.MovieTime.entity.Users;
import com.movietime.MovieTime.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UsersController
{
    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    private List<Users> getAllUsers()
    {
        return usersService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    private Users getUser(@PathVariable("id") int id)
    {
        return usersService.getUserById(id);
    }

    @DeleteMapping("/user/{id}")
    private void deleteUsers(@PathVariable("id") int id)
    {
        usersService.delete(id);
    }

    @PostMapping("/user")
    private int saveUser(@RequestBody Users users)
    {
        usersService.saveOrUpdate(users);
        return users.getUserId();
    }
}
