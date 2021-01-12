<template>
  <div class="home-page">
    <div class="header">
      <h1>저장된 포스트 리스트</h1>
      <el-button class="right" @click="goEditor">새글</el-button>
    </div>
    <el-table :data="tableData" @row-click="onClick">
      <el-table-column prop="id" label="번호" width="100"></el-table-column>
      <el-table-column prop="title" label="제목"></el-table-column>
      <el-table-column prop="subtitle" label="부제"></el-table-column>
      <el-table-column prop="content" label="내용"></el-table-column>
      <el-table-column prop="banner" label="배너"></el-table-column>
      <el-table-column prop="updated" label="수정날짜"></el-table-column>
    </el-table>
  </div>
</template>

<style lang="scss" scoped>
.home-page {
  margin-right: 3rem;
  display: flex;
  flex-direction: column;
  height: 100%;

  .header {
    display: flex;
    align-items: baseline;
    .right {
      margin-left: auto;
    }
  }
  .content {
  }
}
</style>

<script>
import { reqHomeList } from '@/api/home'

export default {
  name: 'posts',
  mounted() {
    this.fetch()
  },
  data() {
    return {
      tableData: []
    }
  },
  methods: {
    fetch() {
      reqHomeList({ page: 1, size: 20 })
      .then(body => {
        console.log( body.data );
        this.tableData = body.data
      })
    },
    onClick(row, column, event) {
      this.goEditor({ ...row })
    },
    goEditor(params) {
      this.$router.push({ name: 'editor', params })
    }
  }
}
</script>
