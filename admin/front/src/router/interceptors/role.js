import store from '@/store/'
import { Notification } from 'element-ui'

export default function checkRoles(to, from, next) {
  const { dispatch, getters } = store
  const { requiresRole } = to.meta


  if (!requiresRole) {
    console.log( 'no requiresRole', requiresRole);
    next()
  } else {
    if (getters.userRoles.length === 0) {
      console.log( 'yes requiresRole', requiresRole, getters.userRoles);
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
  console.log('checkAndNext', roles, requiresRole);
  if (roles.indexOf(requiresRole) > -1) {
    next()
  } else {
    // dispatch('Logout')
    next('/403')
  }
}

