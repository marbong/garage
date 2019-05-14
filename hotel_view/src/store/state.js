// https://vuex.vuejs.org/en/state.html

export default {
    authUser: {},
    isAuthenticated: false,
    jwt: localStorage.getItem('token'),
    endpoints: {
      // TODO: Remove hardcoding of dev endpoints
      obtainJWT: 'http://127.0.0.1:8000/api/auth/obtain_token/',
      refreshJWT: 'http://127.0.0.1:8000/api/auth/refresh_token/',
    }
}
