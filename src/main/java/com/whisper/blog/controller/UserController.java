package com.whisper.blog.controller;


import com.whisper.blog.entity.User;
import com.whisper.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("id/{id}")
    public User findById(@PathVariable("id") int id){
        return userService.findById(id);
    }
    @GetMapping("/")
    public List<User> findAll(){
        return userService.findAll();
    }
    @RequestMapping("/name/{name}")
    public User findByName(@PathVariable("name") String name){
        return userService.findByName(name);
    }
    @PutMapping("/")
    public int updateUser( User user){
        return userService.update(user);
    }
    @DeleteMapping("/id/{id}")
    public int delById(@PathVariable("id") int id){
        System.out.println("all");
        return userService.delById(id);
    }
    @PostMapping("/")
    public int addUser( User user){
        return userService.addUser(user);
    }

}
