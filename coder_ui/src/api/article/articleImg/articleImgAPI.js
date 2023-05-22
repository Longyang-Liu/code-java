import {articleRequest} from "@/utils/request/ArticleRequest";

// 通过ID查询文化内容
export function uploadImg(data) {
    return articleRequest({
        url: '/articleImg/uploadImg',
        method: 'post',
        data: data
    })
}