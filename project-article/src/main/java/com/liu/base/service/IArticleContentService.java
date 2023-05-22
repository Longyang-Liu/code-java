package com.liu.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.base.domain.ArticleContent;
import com.liu.base.domain.dto.ArticleDetailDTO;

public interface IArticleContentService extends IService<ArticleContent>
{


    /***
    * @Description: 通过id查询文件内容
    * @Param: [id]
    * @return: com.liu.base.domain.ArticleContent
    * @Author: Liu
    * @Date: 2023/1/10 19:01
    */
    ArticleContent getArticleContentById(String id);

    /***
    * @Description: 插入文章内容
    * @Param: [articleContent]
    * @return: java.lang.Boolean
    * @Author: Liu
    * @Date: 2023/1/10 14:13
    */
    Boolean insertContent(ArticleContent articleContent);

    /**
    * @Description: 更新文章内容
    * @Param: [articleDetailDTO]
    * @return: java.lang.Boolean
    * @Author: Liu
    * @Date: 2023/1/29 8:39
    */
    Boolean updateContent(ArticleDetailDTO articleDetailDTO);
    
    /**
    * @Description: 删除文章内容
    * @Param: [id]
    * @return: java.lang.Boolean
    * @Author: Liu
    * @Date: 2023/1/29 14:16
    */
    Boolean deleteContent(String id);
}
