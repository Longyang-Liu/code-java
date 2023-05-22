import {articleRequest} from "@/utils/request/ArticleRequest";

// 查询所有数据
export function getInfoList(query) {
    return articleRequest({
        url: '/article/getInfoList',
        method: 'get',
        params: query
    })
}

// 通过ID查询数据
export function getDetailById(query) {
    return articleRequest({
        url: '/article/getDetail',
        method: 'get',
        params: query
    })
}

// 传入详细信息实体类，解析文章信息和内容
export function insertDetail(data) {
    return articleRequest({
        url: '/article/insertDetail',
        method: 'post',
        data: data
    })
}

// 插入文章信息
export function insertArticle(data) {
    return articleRequest({
        url: '/article/insertInfo',
        method: 'post',
        data: data
    })
}

// 修改文章数据信息
export function updateDetail(data) {
    return articleRequest({
        url: '/article/updateDetail',
        method: 'put',
        data: data
    })
}

// 修改文章数据信息
export function deleteDetail(data) {
    return articleRequest({
        url: '/article/deleteDetail',
        method: 'delete',
        data: data
    })
}