package com.whisper.blog.service;


import com.whisper.blog.entity.User;
import com.whisper.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User findById(int id){
        return userMapper.findById(id);
    }
    public User findByName(String name){
        return userMapper.findByName(name);
    }
    public List<User> findAll(){
        return userMapper.findAll();
    }

    public int delById(int id) {
        return userMapper.delById(id);
    }
    public int addUser(User user){
        return userMapper.addUser(user);
    }
    public int update(User user){
        return userMapper.updateUser(user);
    }
}
