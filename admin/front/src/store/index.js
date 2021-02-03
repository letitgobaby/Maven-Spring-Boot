import Vue from 'vue'
import Vuex from 'vuex'

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
