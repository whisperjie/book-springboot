package com.whisper.blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class TestController {
@RequestMapping("/test")
    public String test(){
    return "test";
}
}
