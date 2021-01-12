import ls from 'store'
import axios from 'axios'
import { Notification } from 'element-ui'
import store from '@/store/'

const request = axios.create({
  // baseURL: process.env.VUE_APP_API_BASE_URL,
  timeout: 6000 // 요청 시간 초과
})

const errorHandler = error => {
  if (error.response) {
    const resBody = error.response.data
    if (error.response.status === 403 || error.response.status === 401) {
      store.dispatch('Logout')
      Notification.error({
        message: '인증 오류',
        description: resBody.error.message
      })
    }
  }
  return Promise.reject(error)
}

request.interceptors.request.use(config => {
  const token = ls.get('X-Token')
  if (token) {
    config.headers['X-Token'] = token
  }
  return config
}, errorHandler)

request.interceptors.response.use(response => {
  console.log('response', response)
  return response.data
}, errorHandler)

export default request
