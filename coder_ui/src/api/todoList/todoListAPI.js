import {todoListRequest} from "../../utils/request/TodoListRequest";

// 通过ID查询文化内容
export function getTestList(query) {
  return todoListRequest({
    url: '/todoList/test',
    method: 'get',
    params: query
  })
}