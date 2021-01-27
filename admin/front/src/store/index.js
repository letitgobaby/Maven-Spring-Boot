import Vue from 'vue'
import Vuex from 'vuex'
import ls from 'store'

import { fileUpload, insertPost, updatePost } from '@/api/post'
import { reqLogin, reqUserInfo, reqLogout } from '@/api/user'

import Mutations from './Mutations'
import Actions from './Actions'
import Getters from './Getters'

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

  mutations: Mutations,

  actions: Actions,

  getters: Getters

  // mutations: {
  //   SetUser(state, payload) {
  //     state.user = payload.data || {}
  //     ls.set('X-Token', state.user.token)
  //     ls.set('X-Token', payload.data);
  //   },
  //   SetImgData(state, payload) {
  //     state.formData = payload.formData;
  //     state.postInfo.banner = payload.imgName;
  //   },
  //   SetPostData(state, payload) {
  //     state.postInfo.id = payload.id;
  //     state.postInfo.href = payload.href;
  //     state.postInfo.title = payload.title;
  //     state.postInfo.subtitle = payload.subtitle;
  //     state.postInfo.content = payload.content;
  //     // state.postInfo.banner = payload.banner;
  //   },
  // },

  // actions: {
  //   Login({ commit }, loginInfo) {
  //     return new Promise((resolve, reject) => {
  //       reqLogin(loginInfo)
  //         .then((body) => {
  //           commit('SetUser', { data: body })
  //           resolve()
  //         })
  //         .catch(error => {
  //           reject(error)
  //         })
  //     })
  //   },

  //   async GetUserInfo({ commit }) {
  //     const body = await reqUserInfo()
  //     commit('SetUser', { data: body })
  //   },

  //   async Logout({ commit }) {
  //     await reqLogout()
  //     const { user } = initialState()
  //     commit({
  //       type: 'SetUser',
  //       data: user
  //     })
  //   },

  //   // 이름 바꿔야됨
  //   async SavePost({ commit }, postInfo) {
  //     commit('SetPostData', postInfo);
  //   },

  //   // 이름 바꿔야됨
  //   async SaveImg() {
  //     if ( this.state.formData !== null ) {
  //       fileUpload(this.state.formData)
  //       .then(res => {
  //         if ( this.state.postInfo.id === undefined ) {
  //           insertPost(this.state.postInfo); 
  //         } else {
  //           updatePost(this.state.postInfo);
  //         }
  //       }).catch( err => console.log( err ) );

  //     } else {
  //       if ( this.state.postInfo.id === undefined ) {
  //         insertPost(this.state.postInfo); 
  //       } else {
  //         updatePost(this.state.postInfo);
  //       }
  //     }
  //   },

  //   // 이름 바꿔야됨
  //   FetchPost({ dispatch }, postInfo) {
  //     return new Promise( async (resolve, reject) => {
  //       await dispatch('SavePost', postInfo);
  //       await dispatch('SaveImg');
  //       resolve();
  //     });
  //   }

  // },

  // getters: {
  //   userRoles: state => state.user.roles,
  //   username: state => state.user.name
  // }
})
