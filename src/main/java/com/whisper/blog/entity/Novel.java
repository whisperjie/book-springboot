package com.whisper.blog.entity;


import lombok.Data;

import java.util.Date;

@Data
public class Novel {
    Integer id;
    String author,title,intro,size;
}
