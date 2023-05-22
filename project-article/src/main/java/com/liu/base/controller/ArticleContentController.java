package com.liu.base.controller;

import com.liu.base.domain.ArticleContent;
import com.liu.base.service.IArticleContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/articleContent")
@Slf4j//控制台打印日志（lombok）
public class ArticleContentController
{

    @Resource
    private IArticleContentService articleContentService;

    /***
    * @Description: 通过文章ID查询文章内容
    * @Param: [id]
    * @return: com.liu.base.domain.ArticleContent
    * @Author: Liu
    * @Date: 2023/1/10 18:47
    */
    @GetMapping("/getContentById")
    public ArticleContent getContent(String id){
        ArticleContent articleContent = articleContentService.getArticleContentById(id);
        return articleContent;
    }
}
