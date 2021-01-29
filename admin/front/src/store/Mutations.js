import ls from 'store'

export default {
  SetUser(state, payload) {
    state.user = payload.data || {}
    ls.set('X-Token', state.user.token)
  },

  SetImgData(state, payload) {
    state.formData = payload.formData;
    state.postInfo.banner = payload.imgName;
  },

  SetPostData(state, payload) {
    state.postInfo.id = payload.id;
    state.postInfo.href = payload.href;
    state.postInfo.title = payload.title;
    state.postInfo.subtitle = payload.subtitle;
    state.postInfo.content = payload.content;
    // state.postInfo.banner = payload.banner;
  },

}