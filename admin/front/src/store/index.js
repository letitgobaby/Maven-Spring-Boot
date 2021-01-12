import Vue from 'vue'
import Vuex from 'vuex'
import ls from 'store'

import { reqLogin, reqUserInfo, reqLogout } from '@/api/user'

Vue.use(Vuex)

function initialState() {
  return {
    user: {
      name: '',
      token: '',
      roles: []
    }
  }
}

export default new Vuex.Store({
  state: initialState(),
  mutations: {
    SetUser(state, payload) {
      state.user = payload.data || {}
      ls.set('X-Token', state.user.token)
    }
  },
  actions: {
    Login({ commit }, loginInfo) {
      return new Promise((resolve, reject) => {
        reqLogin(loginInfo)
          .then((body) => {
            commit('SetUser', { data: body })
            resolve()
          })
          .catch(error => {
            reject(error)
          })
      })
    },

    async GetUserInfo({ commit }) {
      console.log('GetUserInfo')
      const body = await reqUserInfo()
      commit('SetUser', { data: body })
    },

    async Logout({ commit }) {
      await reqLogout()
      const { user } = initialState()
      commit({
        type: 'SetUser',
        data: user
      })
    }
  },

  getters: {
    userRoles: state => state.user.roles,
    username: state => state.user.name
  }
})
