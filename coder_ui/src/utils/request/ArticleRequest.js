import axios from 'axios'
import {articleListURL} from "@/utils/BaseUtil";


export function articleRequest(config){
  const instance = axios.create({
    baseURL: articleListURL(),
    timeout:5000
  })
  return instance(config);
}