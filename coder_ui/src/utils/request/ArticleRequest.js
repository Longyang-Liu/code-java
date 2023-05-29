import axios from 'axios'

export function articleRequest(config){
  const instance = axios.create({
    baseURL: '/article',
    timeout:5000
  })
  return instance(config);
}