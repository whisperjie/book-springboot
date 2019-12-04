package com.whisper.blog.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("/song")
public class SongController {
    //搜索歌曲
    String url="https://c.y.qq.com/soso/fcgi-bin/client_search_cp?aggr=1&cr=1&flag_qc=0&p={0}&n={1}&w={2}";
    //获取top100
    String topsong="https://c.y.qq.com/soso/fcgi-bin/client_search_cp?aggr=1&cr=1&flag_qc=0&p={0}&n={1}&w={2}";
    //随机推荐
    String randomcommend="https://c.y.qq.com/soso/fcgi-bin/client_search_cp?aggr=1&cr=1&flag_qc=0&p={0}&n={1}&w={2}";
    String yokenurl="https://c.y.qq.com/base/fcgi-bin/fcg_music_express_mobile3.fcg?format=json205361747&platform=yqq&cid=205361747&songmid=003lghpv0jfFXG&filename=C400003lghpv0jfFXG.m4a&guid=126548448";
    @RequestMapping("/serch")
    public String getTenSong(@Param("keyword") String keyword) throws IOException {
       String songUrl=String.format("https://c.y.qq.com/soso/fcgi-bin/client_search_cp?aggr=1&cr=1&flag_qc=0&p="+1+"&n="+1+"&w="+"竹林中");
       // HttpURLConnection connection=url.openConnection();
        InputStreamReader in=new InputStreamReader(new URL(songUrl).openStream(),"utf8");
        StringBuilder input=new StringBuilder();
        int ch;
        while((ch=in.read())!=-1)input.append((char)ch);
        //System.out.println("----"+input);
        return input.toString();

    }
}
