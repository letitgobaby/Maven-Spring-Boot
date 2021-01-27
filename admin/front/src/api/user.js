import request from '@/utils/request'

export function reqLogin (loginParam) {
  return request({
    // url: '/api/user/login',
    url: '/api/test/login',
    method: 'POST',
    data: loginParam
  })
}

export function reqUserInfo () {
  console.log("reqUserInfo");
  return request({
    url: '/api/user',
    method: 'GET'
  })
}

export function reqLogout () {
  return request({
    url: '/api/user/logout',
    method: 'POST'
  })
}
