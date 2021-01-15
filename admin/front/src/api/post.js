import request from '@/utils/request'

export function fileUpload(formData) {
  if (formData === null) return;
  return request({
    url: '/api/posts/image',
    method: 'POST',
    data: formData
  })
}

export function insertPost(postInfo) {
  console.log('@@@@@ INSERT  ', postInfo)
  return request({
    url: '/api/posts',
    method: 'POST',
    data: postInfo
  })
}

export function updatePost(postInfo) {
  console.log('@@@@@ UPDATE   ', postInfo)
  return request({
    url: '/api/posts',
    method: 'PUT',
    data: postInfo
  })
}

export function getImage(name) {
  return {
    name: name,
    url:  'http://localhost:8090/api/posts/images/' + name
  }

  // return request({
  //   url: '/api/posts/' + name,
  //   method: 'GET'
  // })
}