<template>
  <div class="home-page">
    <div class="header">
      <h1>저장된 포스트 리스트</h1>
      <el-button class="right" @click="goEditor">새글</el-button>
    </div>
    <div class="content">
      <el-table :data="tableData" @row-click="onClick">
        <el-table-column prop="id" label="번호" width="100"></el-table-column>
        <el-table-column prop="title" label="제목"></el-table-column>
        <el-table-column prop="subtitle" label="부제"></el-table-column>
        <el-table-column prop="content" label="내용"></el-table-column>
        <el-table-column prop="banner" label="배너"></el-table-column>
        <el-table-column prop="updated" label="수정날짜"></el-table-column>
      </el-table>
    </div>
    <div class="pagination">
      <el-pagination background layout="prev, pager, next" :total="totalCount" @current-change="handleCurrentChange"></el-pagination>
    </div>
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
    margin: 2rem;
  }

  .pagination {
    margin-top: 3rem;
    display: flex;
    align-items: center;
    justify-content: center;
  }

}
</style>

<script>
import { reqHomeList, getCountAll } from '@/api/home'

export default {
  name: 'posts',
  mounted() {
    this.fetch(1)
    this.getCount()
  },
  data() {
    return {
      totalCount: 0,
      tableData: [],
      currentPage: 0
    }
  },
  methods: {
    fetch(page) {
      reqHomeList({ page: page, size: 10 })
      .then(body => {
        this.tableData = body.data
      })
    },
    getCount() {
      getCountAll().then(count => this.totalCount = count )
    },
    onClick(row, column, event) {
      this.goEditor({ ...row })
    },
    goEditor(params) {
      this.$router.push({ name: 'editor', params })
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.fetch(val);
      console.log(`current page: ${val}`);
    }

  }
}
</script>
