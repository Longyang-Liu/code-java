import {todoListRequest} from "../../utils/request/TodoListRequest";

// 通过ID查询文化内容
export function getList(query) {
  return todoListRequest({
    url: '/workPack/getList',
    method: 'get',
    params: query
  })
}

// 新增
export function addWorkPack(data) {
  return todoListRequest({
    url: '/workPack/addWorkPack',
    method: 'post',
    data: data
  })
}