import axios from 'axios'
import {todoListURL} from "@/utils/BaseUtil";


export function todoListRequest(config){
  const instance = axios.create({
    baseURL: todoListURL(),
    timeout:5000
  })
  return instance(config);
}