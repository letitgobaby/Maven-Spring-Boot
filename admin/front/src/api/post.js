import request from '@/utils/request'

export function fileUpload(formData) {
  return request({
    url: '/api/post/image',
    method: 'post',
    data: formData
  })
}