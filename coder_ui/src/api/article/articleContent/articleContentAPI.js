import {articleRequest} from "@/utils/request/ArticleRequest";


// 通过ID查询文化内容
export function getContentById(query) {
    return articleRequest({
        url: '/articleContent/getContentById',
        method: 'get',
        params: query
    })
}