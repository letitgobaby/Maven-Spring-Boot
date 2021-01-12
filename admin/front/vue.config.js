const { argv } = require('yargs')
const apiMocker = require('connect-api-mocker')

// vue.config
const vueConfig = {
  devServer: {
    // development server port 8000
    port: 8000,
    // mock serve
    before: (app, server, compiler) => {
      if (argv.MOCK) {
        app.use(apiMocker('/api', 'mock/api'))
      }
    },
    // If you want to turn on the proxy, please remove the mockjs /src/main.jsL11
    proxy: {
      '/api': {
        // backend url
        target: 'http://localhost:8090/api',
        ws: false,
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  }
}

module.exports = vueConfig
