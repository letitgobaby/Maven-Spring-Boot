import { fileUpload, insertPost, updatePost } from '@/api/post'
import { reqLogin, reqUserInfo, reqLogout } from '@/api/user'

export default {

  Login({ commit }, loginInfo) {
    return new Promise((resolve, reject) => {
      reqLogin(loginInfo)
        .then((body) => {

          console.log('# login #');
          commit('SetUser', { data: body });
          // commit('SetToken', { data: body });

          resolve()
        })
        .catch(error => {
          reject(error)
        })
    })
  },

  async GetUserInfo({ commit }) {
    console.log('~ GetUserInfo ~');
    const body = await reqUserInfo();
    commit('SetUser', { data: body });
  },

  async Logout({ commit }) {
    await reqLogout();
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