import {todoListRequest} from "../../utils/request/TodoListRequest";

// 通过ID查询文化内容
export function getList(query) {
  return todoListRequest({
    url: '/todoList/getList',
    method: 'get',
    params: query
  })
}

// 新增
export function addTodo(data) {
  return todoListRequest({
    url: '/todoList/addTodo',
    method: 'post',
    data: data
  })
}

// 修改
export function updateTodo(data) {
  return todoListRequest({
    url: '/todoList/updateTodo',
    method: 'put',
    data: data
  })
}