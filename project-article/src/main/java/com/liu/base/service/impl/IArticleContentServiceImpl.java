package com.liu.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.base.domain.ArticleContent;
import com.liu.base.domain.dto.ArticleDetailDTO;
import com.liu.base.mapper.ArticleContentMapper;
import com.liu.base.service.IArticleContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IArticleContentServiceImpl extends ServiceImpl<ArticleContentMapper, ArticleContent> implements IArticleContentService
{

    @Resource
    private ArticleContentMapper articleContentMapper;

    /***
    * @Description: 通过id查询文章内容
    * @Param: [id]
    * @return: com.liu.base.domain.ArticleContent
    * @Author: Liu
    * @Date: 2023/1/10 18:51
    */
    @Override
    public ArticleContent getArticleContentById(String id) {
        QueryWrapper<ArticleContent> wrapper =new QueryWrapper<>();
        wrapper.eq("article_id", id);
        return articleContentMapper.selectOne(wrapper);
    }

    /***
    * @Description: 插入文章内容
    * @Param: [articleContent]
    * @return: java.lang.Boolean
    * @Author: Liu
    * @Date: 2023/1/10 19:01
    */
    @Override
    public Boolean insertContent(ArticleContent articleContent) {
        articleContentMapper.insert(articleContent);
        return true;
    }

    /**
    * @Description: 更新文章内容
    * @Param: [articleDetailDTO]
    * @return: java.lang.Boolean
    * @Author: Liu
    * @Date: 2023/1/29 8:41
    */
    @Override
    public Boolean updateContent(ArticleDetailDTO articleDetailDTO) {
        LambdaUpdateWrapper<ArticleContent> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(ArticleContent::getArticleId, articleDetailDTO.getArticleId())
                .set(ArticleContent::getArticleContent, articleDetailDTO.getArticleContent());
        articleContentMapper.update(null, lambdaUpdateWrapper);
        return true;
    }

    /**
    * @Description: 通过id删除文章内容数据
    * @Param: [id]
    * @return: java.lang.Boolean
    * @Author: Liu
    * @Date: 2023/1/29 9:24
    */
    @Override
    public Boolean deleteContent(String id) {
        LambdaQueryWrapper<ArticleContent> wrapper = new LambdaQueryWrapper<ArticleContent>();
        wrapper.eq(ArticleContent::getArticleId,id);
        articleContentMapper.delete(wrapper);
        return true;
    }
}
