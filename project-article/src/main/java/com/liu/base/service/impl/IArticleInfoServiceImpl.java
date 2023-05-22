package com.liu.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.base.domain.ArticleInfo;
import com.liu.base.domain.dto.ArticleDetailDTO;
import com.liu.base.mapper.ArticleInfoMapper;
import com.liu.base.service.IArticleInfoService;
import com.liu.base.utils.page.PageDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

import static com.liu.base.utils.page.PageDomain.setNewPage;

@Service
public class IArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements IArticleInfoService
{

    @Resource
    private ArticleInfoMapper articleInfoMapper;

    /***
    * @Description: 查询所有文章数据
    * @Param: [articleInfo]
    * @return: java.util.List<com.liu.base.domain.ArticleInfo>
    * @Author: Liu
    * @Date: 2023/1/10 18:51
    */
    @Override
    public Page<ArticleInfo> getInfoList(ArticleInfo articleInfo) {
        PageDomain pageDomain = setNewPage();
        Page<ArticleInfo> page = new Page<> (pageDomain.getPageNum(), pageDomain.getPageSize());
        QueryWrapper<ArticleInfo> wrapper =new QueryWrapper<>();
        if(articleInfo.getArticleTitle() != null && articleInfo.getArticleTitle() != ""){
            // wrapper.like("article_title", articleInfo.getArticleTitle());
            wrapper.like("article_title", articleInfo.getArticleTitle()).or().like("article_description", articleInfo.getArticleTitle());
        }
        wrapper.select().orderByDesc("article_id");
        return articleInfoMapper.selectPage(page, wrapper);
    }

    /**
    * @Description: 通过id查询文章信息
    * @Param: [id]
    * @return: com.liu.base.domain.ArticleInfo
    * @Author: Liu
    * @Date: 2023/1/28 18:15
    */
    @Override
    public ArticleInfo getArticleInfoById(String id) {
        QueryWrapper<ArticleInfo> wrapper =new QueryWrapper<>();
        wrapper.eq("article_id", id);
        return articleInfoMapper.selectOne(wrapper);
    }

    /***
    * @Description: 插入文件信息
    * @Param: [articleInfo]
    * @return: java.lang.Boolean
    * @Author: Liu
    * @Date: 2023/1/10 19:01
    */
    @Override
    public Boolean insertInfo(ArticleInfo articleInfo) {
        articleInfo.setCreationTime(new Date());
        articleInfoMapper.insert(articleInfo);
        return true;
    }

    /**
    * @Description: 更新文章信息
    * @Param: [articleDetailDTO]
    * @return: java.lang.Boolean
    * @Author: Liu
    * @Date: 2023/1/29 8:38
    */
    @Override
    public Boolean updateInfo(ArticleDetailDTO articleDetailDTO) {
        LambdaUpdateWrapper<ArticleInfo> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(ArticleInfo::getArticleId, articleDetailDTO.getArticleId())
                .set(ArticleInfo::getArticleTitle, articleDetailDTO.getArticleTitle())
                .set(ArticleInfo::getArticleDescription, articleDetailDTO.getArticleDescription());
        articleInfoMapper.update(null, lambdaUpdateWrapper);
        return true;
    }

    /**
    * @Description: 删除文章信息数据
    * @Param: [id]
    * @return: java.lang.Boolean
    * @Author: Liu
    * @Date: 2023/1/29 9:23
    */
    @Override
    public Boolean deleteInfo(String id) {
        LambdaQueryWrapper<ArticleInfo> wrapper = new LambdaQueryWrapper<ArticleInfo>();
        wrapper.eq(ArticleInfo::getArticleId,id);
        articleInfoMapper.delete(wrapper);
        return true;
    }
}
