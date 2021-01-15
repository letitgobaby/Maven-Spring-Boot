import Vue from 'vue'
import Vuex from 'vuex'
import ls from 'store'

import { fileUpload, insertPost, updatePost } from '@/api/post'
import { reqLogin, reqUserInfo, reqLogout } from '@/api/user'

Vue.use(Vuex)

function initialState() {
  return {
    user: {
      name: '',
      token: '',
      roles: []
    },
    formData: null,
    postInfo: {
      id: 0,
      href: '',
      title: '',
      subtitle: '',
      content: '',
      updated: '',
      banner: ''
    }
  }
}

export default new Vuex.Store({
  state: initialState(),
  mutations: {
    SetUser(state, payload) {
      state.user = payload.data || {}
      ls.set('X-Token', state.user.token)
    },
    SetImgData(state, payload) {
      console.log("@@@@", 'SETIMGDATA')
      state.formData = payload.formData;
      state.postInfo.banner = payload.imgName;
    },
    SetPostData(state, payload) {
      state.postInfo.id = payload.id;
      state.postInfo.href = payload.href;
      state.postInfo.title = payload.title;
      state.postInfo.subtitle = payload.subtitle;
      state.postInfo.content = payload.content;
    },
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
    },

    // 이름 바꿔야됨
    async SavePost({ commit }, postInfo) {
      commit('SetPostData', postInfo);
    },

    // 이름 바꿔야됨
    async SaveImg() {
      if ( this.state.formData !== null ) {
        fileUpload(this.state.formData)
        .then(res => {
          if ( this.state.postInfo.id === undefined ) {
            insertPost(this.state.postInfo); 
          } else {
            updatePost(this.state.postInfo);
          }
        })
        .catch( err => console.log( err ) );
      } else {
        if ( this.state.postInfo.id === undefined ) {
          insertPost(this.state.postInfo); 
        } else {
          updatePost(this.state.postInfo);
        }
      }
    },

    // 이름 바꿔야됨
    async FetchPost({ dispatch }, postInfo) {
      await dispatch('SavePost', postInfo);
      await dispatch('SaveImg');
    }

  },

  getters: {
    userRoles: state => state.user.roles,
    username: state => state.user.name
  }
})
