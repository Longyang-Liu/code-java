package com.liu.base.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.base.domain.ArticleInfo;
import com.liu.base.domain.dto.ArticleDetailDTO;

public interface IArticleInfoService extends IService<ArticleInfo> {

    /***
    * @Description: 查询文章数据列表
    * @Param: [articleInfo]
    * @return: java.util.List<com.liu.base.domain.ArticleInfo>
    * @Author: Liu
    * @Date: 2023/1/10 11:27
    */
    Page<ArticleInfo> getInfoList(ArticleInfo articleInfo);

    /***
    * @Description: 通过id查询文章信息
    * @Param: [id]
    * @return: com.liu.base.domain.ArticleInfo
    * @Author: Liu
    * @Date: 2023/1/29 8:34
    */
    ArticleInfo getArticleInfoById(String id);
    
    /***
    * @Description: 插入数据
    * @Param: [articleInfo]
    * @return: java.lang.Boolean
    * @Author: Liu
    * @Date: 2023/1/10 11:30
    */
    Boolean insertInfo(ArticleInfo articleInfo);

    /**
    * @Description: 更新文章信息数据
    * @Param: [articleDetailDTO]
    * @return: java.lang.Boolean
    * @Author: Liu
    * @Date: 2023/1/29 8:38
    */
    Boolean updateInfo(ArticleDetailDTO articleDetailDTO);

    /**
    * @Description: 删除文章信息数据
    * @Param: [id]
    * @return: java.lang.Boolean
    * @Author: Liu
    * @Date: 2023/1/29 14:16
    */
    Boolean deleteInfo(String id);
}
