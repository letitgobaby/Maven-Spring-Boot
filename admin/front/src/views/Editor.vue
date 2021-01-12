<template>
  <div class="editor-page">
    <div class="header">
      <h1>This is Editor {{ postId }}</h1>
      <div class="right">
        <el-button @click="$router.go(-1)">Cancel</el-button>
        <el-button @click="tapSave" type="success">Save</el-button>
      </div>
    </div>
    <div class="content">
      
      <!-- title -->
      <el-input
        class="m1"
        placeholder="Please Title"
        v-model="title"
      ></el-input>

      <!-- quill -->
      <!-- Or manually control the data synchronization -->
      <quill-editor
        class="editor m1"
        :content="content"
        :options="editorOption"
        @change="onEditorChange($event)"
      />
    </div>
  </div>
</template>

<script>
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'
import { quillEditor } from 'vue-quill-editor'

export default {
  name: 'editor',
  components: {
    quillEditor
  },
  data() {
    return {
      title: '',
      content: '',

      editorOption: {}
    }
  },
  mounted() {
    const { title, content } = this.$route.params
    this.title = title
    this.content = content
  },
  computed: {
    postId() {
      const { id } = this.$route.params
      return id
    }
  },
  methods: {
    onEditorChange({ quill, html, text }) {
      console.log('editor change!', quill, html, text)
      this.content = html
    },
    tapSave() {
      this.$alert(`${this.content}`, 'Save Ok', {
        confirmButtonText: 'OK',
        callback: action => {
          this.$router.replace('/')
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.editor-page {
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
    flex: 1;
    display: flex;
    flex-direction: column;
    margin-bottom: 50px;
    .m1 {
      margin: 1rem;
    }
    .editor {
      flex: 1;
      overflow: auto;
    }
  }
}
</style>
