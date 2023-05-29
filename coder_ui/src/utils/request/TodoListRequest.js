import axios from 'axios'

export function todoListRequest(config){
  const instance = axios.create({
    baseURL: "/task",
    timeout:5000
  })
  return instance(config);
}