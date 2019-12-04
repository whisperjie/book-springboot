package com.whisper.blog.controller;

import com.whisper.blog.entity.Catalog;
import com.whisper.blog.entity.Novel;
import com.whisper.blog.service.NovelService;
import com.whisper.blog.util.NovelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/novel")
public class NovelController {
    @Autowired
    NovelService novelMapper;
    @RequestMapping("id/{id}")
    public ModelAndView findById(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/novel/read");
        Novel novel=novelMapper.findById(id);
        modelAndView.addObject(novel);
        modelAndView.addObject("show",true);
        List<Catalog> catalogList= NovelUtil.getAllCatalog(novel.getTitle());
        if (catalogList.isEmpty()){
            modelAndView.addObject("show",false);
            Long lines =NovelUtil.getLines(novel.getTitle());
            int  index= (int) (lines/100);
            for (int i = 1; i<=index;i++) {
                Catalog catalog=new Catalog();
                catalog.setId((long) i);
                catalog.setName(String.valueOf(i*100));
                catalog.setStart((long) (i*100));
                catalogList.add(catalog);
            }
        }
        System.out.println(catalogList);
        modelAndView.addObject(catalogList);
        /*return "novel/show";*/
        //return "novel/show";
        return modelAndView;
    }
    @RequestMapping("{id}/read/{index}")
    public ModelAndView findById(@PathVariable("id") int id,@PathVariable("index") int index){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/novel/show");
        Novel novel=novelMapper.findById(id);
        modelAndView.addObject(novel);
        List<String> lines=null;
        List<Catalog> catalogList= NovelUtil.getAllCatalog(novel.getTitle());
        modelAndView.addObject(catalogList);
        modelAndView.addObject(index);
        Long offset=NovelUtil.getLines(novel.getTitle());
        if (catalogList.isEmpty()){

            int start=index*100;
            Long end=0L;
            if (index==offset/100){

                end=offset;
            }else{
                end= Long.valueOf(index*100+100-1);
            }
            lines = NovelUtil.getText(novel.getTitle(), (long)start, end);

        }else{
            if (index==0){
                lines=NovelUtil.getText(novel.getTitle(),0L,catalogList.get(index).getStart()-1);
            }else if(index==catalogList.size()){
                lines = NovelUtil.getText(novel.getTitle(), catalogList.get(index-1).getStart(), offset);
            }else{
                lines = NovelUtil.getText(novel.getTitle(), catalogList.get(index-1).getStart(), catalogList.get(index).getStart() - 1);
            }
        }
        modelAndView.addObject("lines",lines);
        return modelAndView;
    }
    @GetMapping("/")
    public ModelAndView findAll(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/novel/all");
        //return novelMapper.findAll();
        List<Novel> novels=novelMapper.findAll();
        modelAndView.addObject("novelList",novels);
        return modelAndView;
    }
    @RequestMapping("/name/{name}")
    public Novel findByName(@PathVariable("name") String name){
        return novelMapper.findByName(name);
    }
    @DeleteMapping("/id/{id}")
    public int delById(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("/novel/a");
        System.out.println("all");
        return novelMapper.delById(id);
    }
    @GetMapping("/add")
    public ModelAndView addNovel(ModelAndView modelAndView){
        modelAndView.setViewName("/novel/add");

        return modelAndView;
    }
    @PostMapping("/")
    public String addNovel( @RequestParam("name") String name, @RequestParam("author") String author, @RequestParam("intro") String intro, @RequestParam("book") MultipartFile file){
        Novel novel=new Novel();
        novel.setAuthor(author);
        novel.setIntro(intro);
        novel.setTitle(name);
        novel.setSize(String.valueOf(file.getSize()));
        novelMapper.addNovel(novel);
        if (file.isEmpty()){
            return "上传失败，请选择文件";
        }
        String dir="E:\\txt\\";
       // String fileName=file.getOriginalFilename();
        File dest=new File(dir+name+".txt");
        try{
            file.transferTo(dest);
            System.out.println("上传成功");
            return "上传成功";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "上传失败";
    }
}
