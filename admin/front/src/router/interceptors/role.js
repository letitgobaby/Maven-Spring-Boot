import store from '@/store/'
import { Notification } from 'element-ui'

export default function checkRoles(to, from, next) {
  const { dispatch, getters } = store
  const { requiresRole } = to.meta

  if (!requiresRole) {
    next()
  } else {
    if (getters.userRoles.length === 0) {
      dispatch('GetUserInfo')
        .then(() => {
          checkAndNext(getters.userRoles, requiresRole, next, dispatch)
        })
        .catch(() => {
          Notification.error({
            message: '인증 오류',
            description: '사용자 정보가 확인되지 않았습니다'
          })
        })
    } else {
      checkAndNext(getters.userRoles, requiresRole, next, dispatch)
    }
  }
}

function checkAndNext(roles, requiresRole, next, dispatch) {
  if (roles.indexOf(requiresRole) > -1) {
    next()
  } else {
    dispatch('Logout')
    next('/403')
  }
}

