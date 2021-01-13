import request from '@/utils/request'

export function fileUpload(formData) {
  console.log(formData)
  return request({
    url: '/api/posts/image',
    method: 'post',
    data: formData
  })
}