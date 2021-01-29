import request from '@/utils/request'

export function reqLogin (loginParam) {
  return request({
    // url: '/api/user/login',
    url: '/api/member/login',
    method: 'POST',
    data: loginParam
  })
}

export function reqUserInfo () {
  return request({
    // url: '/api/user',
    url: '/api/member',
    method: 'GET'
  })
}

export function reqLogout () {
  return request({
    // url: '/api/user/logout',
    url: '/api/member/logout',
    method: 'POST'
  })
}
