
const initialState = () => {
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

export default initialState;
