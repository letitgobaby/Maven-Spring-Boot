import { fileUpload, insertPost, updatePost } from '@/api/post'
import { reqLogin, reqUserInfo, reqLogout } from '@/api/user'
import ls from 'store'
import store from '@/store/'

export default {
  Login({ commit }, loginInfo) {
    return new Promise((resolve, reject) => {
      reqLogin(loginInfo)
        .then((body) => {
          commit('SetUser', { data: body });
          resolve()
        })
        .catch(error => {
          reject(error)
        })
    })
  },

  async GetUserInfo({ commit }) {
    const body = await reqUserInfo();
    console.log('^^^^^^^', body );
    commit('SetUser', { data: body });
  },

  async Logout({ commit }) {
    await reqLogout();
    ls.set('X-Token', ''); // ls.clearAll();
    const { user } = initialState();
    commit('SetUser', { data: user });
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
      }).catch( err => console.log( err ) );

    } else {
      if ( this.state.postInfo.id === undefined ) {
        insertPost(this.state.postInfo); 
      } else {
        updatePost(this.state.postInfo);
      }
    }
  },

  // 이름 바꿔야됨
  FetchPost({ dispatch }, postInfo) {
    return new Promise( async (resolve, reject) => {
      await dispatch('SavePost', postInfo);
      await dispatch('SaveImg');
      resolve();
    });
  }

}