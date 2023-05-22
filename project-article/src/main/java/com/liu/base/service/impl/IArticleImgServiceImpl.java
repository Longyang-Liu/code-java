package com.liu.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.base.domain.ArticleImg;
import com.liu.base.mapper.ArticleImgMapper;
import com.liu.base.service.IArticleImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IArticleImgServiceImpl extends ServiceImpl<ArticleImgMapper, ArticleImg> implements IArticleImgService
{

    @Resource
    private ArticleImgMapper articleImgMapper;

    @Override
    public ArticleImg insertImg(ArticleImg articleImg) {
        articleImgMapper.insert(articleImg);
        return articleImg;
    }
}
