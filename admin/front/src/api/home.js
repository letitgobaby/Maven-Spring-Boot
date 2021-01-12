import request from '@/utils/request'

export function reqHomeList ({ page, size }) {
  return request({
    url: '/api/posts?page='+page+'&size='+size,
    method: 'GET'
  })
}

export function getCountAll() {
  return request({
    url: '/api/counts',
    method: 'GET'
  })
}