package com.whisper.blog.util;

import com.whisper.blog.entity.Catalog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NovelUtil {
    static String dir="E:\\txt\\";
    public static List<Catalog> getAllCatalog(String fileName){
        String filePath=dir+fileName+".txt";
        //System.out.println(filePath);
        String encoding="utf-8";
        List<Catalog> catalogs=new ArrayList<Catalog>();
        try {
            File file = new File(filePath);

            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(filePath), encoding);
                BufferedReader reader=new BufferedReader(read);
                String lineText=null;
                Long offset=0L;
                Long count= 1L;
                while ((lineText=reader.readLine())!=null){
                    Catalog catalog = new Catalog();
                   // System.out.println(lineText);
                    offset++;
                    Pattern p=Pattern.compile("(^\\s*第)(.{1,9})[章节卷集部篇回](\\s{1})(.*)($\\s*)");
                    Matcher matcher=p.matcher(lineText);
                    while (matcher.find()){

                        //System.out.println(lineText);
                        catalog.setId(count);
                        catalog.setName(lineText.trim());
                        catalog.setStart(offset);

                        catalogs.add(catalog);
                        count++;
                    }
                }
               /*while ((lineText=reader.readLine())!=null){
                   System.out.println(lineText);
               }*/
               reader.close();
            }else {
                System.out.println("找不到文件");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return catalogs;
    }
    public static Long getLines(String fileName){
        String filePath=dir+fileName+".txt";
        //System.out.println(filePath);
        String encoding="utf-8";
        Long offset=0L;
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(filePath), encoding);
                BufferedReader reader=new BufferedReader(read);
                String lineText=null;
                while ((lineText=reader.readLine())!=null){
                    offset++;
                }
                reader.close();
            }else {
                System.out.println("找不到文件");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return offset;
    }

    public static List<String> getText(String fileName, Long start, long end) {
        System.out.println(start+">>>>>>>>>>>>>"+end);
        String filePath=dir+fileName+".txt";
        System.out.println(filePath);
        String encoding="utf-8";
        List<String> lines=new ArrayList<String>();
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(filePath), encoding);
                BufferedReader reader=new BufferedReader(read);
                String lineText=null;
                Long offset=0L;
                Long count= 1L;
                while ((lineText=reader.readLine())!=null){
                    offset++;
                    if (offset >= start){
                       // System.out.println(lineText);
                       lines.add(lineText);
                    }
                    if (offset >= end){
                        break;
                    }

                }
               /*while ((lineText=reader.readLine())!=null){
                   System.out.println(lineText);
               }*/
                reader.close();
            }else {
                System.out.println("找不到文件");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    return lines;
    }


}
