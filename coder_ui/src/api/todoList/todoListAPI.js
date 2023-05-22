import {todoListRequest} from "@/utils/request/TodoListRequest";

// 查询内容
export function getList(query) {
  return todoListRequest({
    url: '/todoList/getList',
    method: 'get',
    params: query
  })
}

// 通过 ID 查询
export function getTodoListInfo(id) {
  return todoListRequest({
    url: '/todoList/' + id,
    method: 'get'
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

// 删除
export function delTodoInfo(id) {
  return todoListRequest({
    url: '/todoList/' + id,
    method: 'delete'
  })
}