package com.whisper.blog.mapper;

import com.whisper.blog.entity.User;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
class UserMapperTest {
@Autowired
    UserMapper userMapper;
    int id=2;
    @Test
    void findById() {
        System.out.println(userMapper.findById(id));
    }

    @Test
    void findAll() {
        System.out.println(userMapper.findAll());
    }

    @Test
    void findByName() {
        System.out.println(userMapper.findByName("whisper"));
    }

    @Test
    void delById() {
        System.out.println(userMapper.delById(2));
    }

    @Test
    void addUser() {
        User user=new User();
        user.setPassword("aaa");
        user.setName("sadw ");
        System.out.println(userMapper.addUser(user));
    }

    @Test
    void updateUser() {
        User user=new User();
        user.setId(28);
        user.setName("aaa");
        user.setName("sadw ");
        System.out.println(userMapper.updateUser(user));
    }

    @Test
    void findUserCount() {

        System.out.println(userMapper.findUserCount());
    }
}