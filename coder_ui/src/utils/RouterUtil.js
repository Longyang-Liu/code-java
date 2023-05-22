import Router from '@/router/index'


/**
 * @Description: 路由跳转
 * @param null
 * @return: 
 * @Author: Liu
 * @Date: 2023/5/22 14:49
*/
export function goDocumentByObj(name, obj){
  Router.push({
    name: name,
    params: obj
  });
}