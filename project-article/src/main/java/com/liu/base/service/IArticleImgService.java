package com.liu.base.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.base.domain.ArticleImg;

public interface IArticleImgService extends IService<ArticleImg> {

    ArticleImg insertImg(ArticleImg articleImg);
}
