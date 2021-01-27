import Vue from 'vue'
import Router from 'vue-router'
import AppLayout from '@/components/layout/AppLayout.vue'
import BlankLayout from '@/components/layout/BlankLayout.vue'
import { Forbidden, NotFound, InternalServerError } from '@/components/errors'

import UserInterceptor from './interceptors/user'
import RoleInterceptor from './interceptors/role'

import Home from '@/views/Home.vue'
import Login from '@/views/Login.vue'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/login',
      component: BlankLayout,
      children: [{ path: '', name: 'login', component: Login }]
    },
    {
      path: '/',
      component: AppLayout,
      children: [
        {
          path: '',
          name: 'home',
          meta: {
            requiresUser: true,
            breadcrumb: ['home']
          },
          component: Home
        },

        {
          path: '/editor',
          name: 'editor',
          meta: {
            requiresUser: true,
            breadcrumb: [{ name: 'home', path: '/' }, { name: 'editor' }]
          },
          component: () =>
            import(/* webpackChunkName: "editor" */ '@/views/Editor.vue')
        },
        {
          path: '/member',
          name: 'member',
          meta: {
            requiresUser: true,
            requiresRole: 'ADMIN'
          },
          component: () =>
            import(/* webpackChunkName: "member" */ '@/views/Member.vue')
        },

        { path: '/403', component: Forbidden },
        { path: '/404', component: NotFound },
        { path: '/500', component: InternalServerError },
        { path: '*', component: NotFound }
      ]
    }
  ]
})

router.beforeEach(UserInterceptor)
// router.beforeEach(RoleInterceptor)

export default router
