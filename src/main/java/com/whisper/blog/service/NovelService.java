package com.whisper.blog.service;


import com.whisper.blog.entity.Novel;
import com.whisper.blog.entity.User;
import com.whisper.blog.mapper.NovelMapper;
import com.whisper.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NovelService {
    @Autowired
    NovelMapper novelMapper;
    public Novel findById(int id){
        return novelMapper.findById(id);
    }
    public Novel findByName(String name){
        return novelMapper.findByName(name);
    }
    public List<Novel> findAll(){
        return novelMapper.findAll();
    }

    public int delById(int id) {
        return novelMapper.delById(id);
    }
    public int addNovel(Novel novel){
        return novelMapper.addNovel(novel);
    }
}
