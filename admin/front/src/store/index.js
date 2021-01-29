import Vue from 'vue'
import Vuex from 'vuex'
// import ls from 'store'

// import { fileUpload, insertPost, updatePost } from '@/api/post'
// import { reqLogin, reqUserInfo, reqLogout } from '@/api/user'

import Mutations from './Mutations'
import Actions from './Actions'
import Getters from './Getters'
import initialState from './etc/initialState'

Vue.use(Vuex)

export default new Vuex.Store({
  state: initialState(),
  mutations: Mutations,
  actions: Actions,
  getters: Getters
})
