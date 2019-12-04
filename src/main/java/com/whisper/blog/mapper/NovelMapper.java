package com.whisper.blog.mapper;

import com.whisper.blog.entity.Novel;
import com.whisper.blog.entity.User;

import java.util.List;

public interface NovelMapper {
    Novel findById(int id);
    List<Novel> findAll();
    Novel findByName(String name);
    int delById(int id);
    int addNovel(Novel novel);
}
