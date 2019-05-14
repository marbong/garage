// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import jwt_decode from 'jwt-decode'
import Vuex from 'vuex'
import VueSwal from 'vue-swal'

import './components'
import './plugins'

import { sync } from 'vuex-router-sync'

// Application imports
import App from './App'
import i18n from '@/i18n'
import router from '@/router'
import store from '@/store'
import 'babel-polyfill'

// Sync store with router
sync(store, router)

Vue.config.productionTip = false

Vue.use(Vuex);
Vue.use(VueAxios, axios);
Vue.use(VueSwal)

/* eslint-disable no-new */
new Vue({
  i18n,
  router,
  store,
  render: h => h(App)
}).$mount('#app')
