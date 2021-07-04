import { NuxtConfig } from '@nuxt/types'
const config: NuxtConfig = {
  srcDir: 'src/',
  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: 'job-offer-front',
    htmlAttrs: {
      lang: 'en',
    },
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '' },
    ],
    link: [{ rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }],
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,



  buildModules: [
    '@nuxt/typescript-build',
    '@nuxtjs/tailwindcss'
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    // https://go.nuxtjs.dev/axios
    '@nuxtjs/axios',
    '@nuxtjs/auth-next'
  ],

  // Axios module configuration: https://go.nuxtjs.dev/config-axios
  axios: {},

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {},

  auth: {
    strategies: {
      auth0: {
        domain: process.env.AUTH0_DOMAIN_NAME,
        clientId: process.env.AUTH0_CLIENT_ID,
        //audience: process.env.AUTH0_AUDIENCE,
        responseType: 'code',
        grantType: 'authorization_code',
        codeChallengeMethod: 'S256'
      }
    },
    redirect: {
      login: '/login',
      logout: '/logout',
      callback: '/callback',
      home: '/mypage'
    }
  }
}

export default config
