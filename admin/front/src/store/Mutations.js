import ls from 'store'

export default {
  SetUser(state, payload) {
    console.log('~ SETUSER ~')
    state.user = payload.data || {}
    ls.set('X-Token', state.user.token)
    // ls.set('X-Token', payload.data);
  },

  SetToken(state, payload) {
    ls.set('X-AUTH-TOKEN', payload.data);
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