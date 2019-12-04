package com.whisper.blog.mapper;


import com.whisper.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
public interface UserMapper {
    User findById(int id);
    List<User> findAll();
    User findByName(String name);
    int delById(int id);
    int addUser(User user);
    int updateUser(User user);
    int findUserCount();
}
