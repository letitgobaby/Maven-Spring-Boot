import request from '@/utils/request'

export function fileUpload(formData) {
  console.log(formData)
  return request({
    url: '/api/posts/image',
    method: 'POST',
    data: formData
  })
}

export function insertPost(postInfo) {
  return request({
    url: '/api/posts',
    method: 'PUT',
    data: postInfo
  })
}