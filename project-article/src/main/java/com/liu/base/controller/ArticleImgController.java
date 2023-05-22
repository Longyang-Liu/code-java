package com.liu.base.controller;

import com.liu.base.domain.ArticleImg;
import com.liu.base.service.IArticleImgService;
import com.liu.base.utils.file.FileUpload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

import static com.liu.base.utils.serialNumber.SnowflakeUtils.snowflakeUtils;


@CrossOrigin
@RestController
@RequestMapping("/articleImg")
@Slf4j//控制台打印日志（lombok）
public class ArticleImgController {

    @Value("${kw.profile}")
    private String filePath;

    @Resource
    private IArticleImgService articleImgService;

    @PostMapping("/uploadImg")
    public String getContent(@RequestParam(value = "avatar") MultipartFile file) throws IOException {
        String fileName = FileUpload.uploadFile(file, filePath+"/img");
        ArticleImg articleImg = new ArticleImg();
        articleImg.setId(snowflakeUtils.nextId()+"");
        articleImg.setName(fileName);
        articleImg.setPath(filePath+"/img/"+fileName);
        articleImg.setUrl("/image/"+fileName);
        articleImg.setSize(file.getSize());
        articleImg.setUploadTime(new Date());
        articleImgService.insertImg(articleImg);
        return articleImg.getUrl();
    }
}
