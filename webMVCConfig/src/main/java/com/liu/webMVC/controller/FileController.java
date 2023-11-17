package com.liu.webMVC.controller;


import com.liu.webMVC.config.YnConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/fileList")
public class FileController {

    private static String defaultFilePath = YnConfig.getFilePath();

    @GetMapping(value = "/getFileInfo")
    public ResponseEntity<String> getFileInfo(String filePath) {
        StringBuilder stringBuilder = new StringBuilder(defaultFilePath);
        if (filePath != null) {
            stringBuilder.append(filePath);
        }
        File folder = new File(stringBuilder.toString());
        File[] listOfFiles = folder.listFiles();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < listOfFiles.length; i++) {
            File listOfFile = listOfFiles[i];
            StringBuilder stringBuilder1 = new StringBuilder();
            if (listOfFile.isFile()) {
                stringBuilder1.append("File: ").append(listOfFile.getName());
            } else if (listOfFile.isDirectory()) {
                stringBuilder1.append("Directory: ").append(listOfFile.getName());
            }
            result.append(stringBuilder1).append("<br>"); // 使用<br>标签表示换行
        }
        String string = result.toString();
        return ResponseEntity.ok(string);
    }

    @GetMapping(value = "/getFileInfo1")
    public String getFileInfo1(String filePath){
        System.out.println(filePath);
        StringBuilder stringBuilder = new StringBuilder(defaultFilePath);
        if(filePath != null){
            stringBuilder.append(filePath);
        }
        File folder = new File(stringBuilder.toString());//文件夹路径
        File[] listOfFiles = folder.listFiles();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < listOfFiles.length; i++) {
            File listOfFile = listOfFiles[i];
            result.append(listOfFile.toString()).append("\n");
            if (listOfFile.isFile()) {
                System.out.println("File: " + listOfFile.getName());
            } else if (listOfFile.isDirectory()) {
                System.out.println("Directory: " + listOfFile.getName());
            }
        }
        String string = result.toString();
        System.out.println("fsdfd");
        System.out.println(string);
        return string;
    }
}
