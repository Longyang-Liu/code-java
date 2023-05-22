package com.liu.base.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.base.domain.ArticleContent;
import com.liu.base.domain.ArticleInfo;
import com.liu.base.domain.dto.ArticleDetailDTO;
import com.liu.base.service.IArticleContentService;
import com.liu.base.service.IArticleInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.liu.base.utils.serialNumber.SnowflakeUtils.snowflakeUtils;


@CrossOrigin
@RestController
@RequestMapping("/article")
@Slf4j//控制台打印日志（lombok）
public class ArticleInfoController {

    @Resource
    private IArticleInfoService articleInfoService;
    @Resource
    private IArticleContentService articleContentService;

    /***
    * @Description: 查询所有文件信息
    * @Param: [articleInfo]
    * @return: java.util.List<com.liu.base.domain.ArticleInfo>
    * @Author: Liu
    * @Date: 2023/1/10 18:48
    */
    @GetMapping("/getInfoList")
    public Page<ArticleInfo>  getList(ArticleInfo articleInfo){
        Page<ArticleInfo>  infoList = articleInfoService.getInfoList(articleInfo);
        return infoList;
    }

    /**
    * @Description: 通过id查询文章信息
    * @Param: [id]
    * @return: com.liu.base.domain.ArticleContent
    * @Author: Liu
    * @Date: 2023/1/28 18:12
    */
    @GetMapping("/getInfoById")
    public ArticleInfo getInfo(String id){
        ArticleInfo articleinfo = articleInfoService.getArticleInfoById(id);
        return articleinfo;
    }

    /**
    * @Description: 通过id查询文章的详细数据信息
    * @Param: [id]
    * @return: com.liu.base.domain.dto.ArticleDetailDTO
    * @Author: Liu
    * @Date: 2023/1/28 18:26
    */
    @GetMapping("/getDetail")
    public ArticleDetailDTO getDetail(String id){
        ArticleContent articleContent = articleContentService.getArticleContentById(id);
        ArticleInfo articleinfo = articleInfoService.getArticleInfoById(id);
        ArticleDetailDTO articleDetailDTO = new ArticleDetailDTO();
        articleDetailDTO.setArticleId(articleContent.getArticleId());
        articleDetailDTO.setArticleTitle(articleinfo.getArticleTitle());
        articleDetailDTO.setArticleDescription(articleinfo.getArticleDescription());
        articleDetailDTO.setArticleContent(articleContent.getArticleContent());
        return articleDetailDTO;
    }

    /***
    * @Description: 插入文件信息
    * @Param: [articleInfo]
    * @return: java.lang.String
    * @Author: Liu
    * @Date: 2023/1/10 18:48
    */
    @PostMapping("/insertInfo")
    public String insertInfo(@RequestBody ArticleInfo articleInfo){
        Boolean aBoolean = articleInfoService.insertInfo(articleInfo);
        return aBoolean.toString();
    }

    /***
    * @Description: 插入文件信息和文件内容
    * @Param: [articleDetailDTO]
    * @return: java.lang.Boolean
    * @Author: Liu
    * @Date: 2023/1/10 18:48
    */
    @PostMapping("/insertDetail")
    public String insertDetail(@RequestBody ArticleDetailDTO articleDetailDTO){
        String id = snowflakeUtils.nextId()+"";
        articleDetailDTO.setArticleId(id);
        ArticleInfo articleInfo = new ArticleInfo();
        org.springframework.beans.BeanUtils.copyProperties(articleDetailDTO, articleInfo);
        ArticleContent articleContent = new ArticleContent();
        org.springframework.beans.BeanUtils.copyProperties(articleDetailDTO, articleContent);
        articleInfoService.insertInfo(articleInfo);
        articleContentService.insertContent(articleContent);
        return id;
    }

    /**
    * @Description: 修改文章信息以及文章内容
    * @Param: [articleDetailDTO]
    * @return: java.lang.Boolean
    * @Author: Liu
    * @Date: 2023/1/29 8:42
    */
    @PutMapping("/updateDetail")
    public Boolean updateDetail(@RequestBody ArticleDetailDTO articleDetailDTO){
        System.out.println("fsbnkajgbwrkjgfwe");
        System.out.println(articleDetailDTO);
        articleInfoService.updateInfo(articleDetailDTO);
        articleContentService.updateContent(articleDetailDTO);
        return true;
    }

    /**
    * @Description: 通过id删除文章信息以及文章内容
    * @Param: [id]
    * @return: java.lang.Boolean
    * @Author: Liu
    * @Date: 2023/1/29 9:19
    */
    @DeleteMapping("/deleteDetail")
    public Boolean deleteDetail(@RequestBody String id){
        System.out.println(id);
        articleInfoService.deleteInfo(id);
        articleContentService.deleteContent(id);
        return true;
    }

}
