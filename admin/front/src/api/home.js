import request from '@/utils/request'

export function reqHomeList ({ page, size }) {
  return request({
    url: '/api/posts?page='+page+'&size='+size,
    method: 'GET'
  })
}
