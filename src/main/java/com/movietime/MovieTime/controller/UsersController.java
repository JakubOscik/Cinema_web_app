package com.movietime.MovieTime.controller;

import com.movietime.MovieTime.entity.Users;
import com.movietime.MovieTime.repository.UsersRepository;
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
    private final UsersRepository usersRepository;
    @Autowired
    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

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

//    @PostMapping("/login")
//    private boolean login(@RequestParam String username, @RequestParam String password){
//        Iterable<Users> allUsers = usersRepository.findAll();
//        boolean status = false;
//        for(Users user: allUsers) {
//            if(user.getEmail().equals(username) && user.getPassword().equals(password)){
//                status = true;
//            }
//        }
//        System.out.println(status + "AAAAAAAAAAAAAAAAAAAAAAAAAA");
//        return status;
//    }

    @PostMapping("/login")
    private boolean login(@RequestBody Users data){
        Iterable<Users> allUsers = usersRepository.findAll();
        boolean status = false;
        for(Users user: allUsers) {
            if(user.getEmail().equals(data.getEmail()) && user.getPassword().equals(data.getPassword())){
                status = true;
            }
        }
        return status;
    }

    @PostMapping("/register")
    private boolean register(@RequestBody Users data){
        Iterable<Users> allUsers = usersRepository.findAll();
        int id = 0;
        boolean status = true;
        for(Users user: allUsers) {
            if(user.getEmail().equals(data.getEmail())){
                status = false;
                return status;
            }
            id = user.getUserId() + 1;
        }
        data.setUserId(id);
        usersRepository.save(data);
        return status;
    }
}

