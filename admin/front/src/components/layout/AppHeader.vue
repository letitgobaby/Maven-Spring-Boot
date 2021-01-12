<template>
  <div class="header">
    <el-menu
      class="header-nav-menu"
      :default-active="path"
      :router="true"
      background-color="#f7f7f7"
      mode="horizontal"
    >
      <el-menu-item index="/">Home</el-menu-item>
      <el-menu-item index="/member">Member</el-menu-item>
    </el-menu>

    <div class="header-user-menu" v-if="user.token">
      <el-dropdown class="header-user-menu__item" @command="handleUserCommand">
        <span class="el-dropdown-link">
          {{ user.name || "Unkown User" }}
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="logout">Logout</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.header {
  display: flex;
  background-color: #f7f7f7;

  .header-nav-menu {
    flex-grow: 1;
  }

  .header-user-menu {
    height: 60px;
    line-height: 60px;
    border-bottom: solid 1px #e6e6e6;

    .header-user-menu__item {
      padding: 0 20px;
    }
  }
}
</style>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  name: 'AppHeader',

  computed: {
    ...mapState({
      path: state => {
        const { route } = state
        return route.from ? route.path : null
      },

      user: 'user'
    })
  },

  methods: {
    ...mapActions(['resetUser']),

    handleUserCommand(cmd) {
      if (cmd === 'logout') {
        this.$router.push('/login')
        this.resetUser()
      }
    }
  }
}
</script>
