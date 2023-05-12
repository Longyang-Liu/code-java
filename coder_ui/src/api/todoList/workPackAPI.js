import {todoListRequest} from "../../utils/request/TodoListRequest";

// 通过ID查询文化内容
export function getList(query) {
  return todoListRequest({
    url: '/workPack/getList',
    method: 'get',
    params: query
  })
}

export function getWorkPackInfo(id) {
  return todoListRequest({
    url: '/workPack/' + id,
    method: 'get'
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

// 修改
export function updateWorkPack(data) {
  return todoListRequest({
    url: '/workPack/updateWorkPack',
    method: 'put',
    data: data
  })
}

// 删除
export function delPackInfo(id) {
  return todoListRequest({
    url: '/workPack/' + id,
    method: 'delete'
  })
}