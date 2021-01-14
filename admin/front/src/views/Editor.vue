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
      <div class="title">
        <h3>타이틀</h3>
        <el-input
          class="m1"
          placeholder="Please Title"
          v-model="title"
        ></el-input>
      </div>

      <!-- sub title -->
      <div class="title">
        <h4>서브타이틀</h4>
        <el-input
          class="m1"
          placeholder="Please SubTitle"
          v-model="subtitle"
        ></el-input>
      </div>

      <!-- file upload -->
      <file-upload />

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
import "quill/dist/quill.core.css";
import "quill/dist/quill.snow.css";
import "quill/dist/quill.bubble.css";
import { quillEditor } from "vue-quill-editor";
import { mapMutations, mapActions } from 'vuex'

import Home from "./Home.vue";
import FileUpload from "../components/layout/FileUpload";

export default {
  name: "editor",
  components: {
    quillEditor,
    FileUpload,
    Home,
  },
  data() {
    return {
      title: "",
      subtitle: "",
      content: "",

      editorOption: {},
    };
  },
  mounted() {
    const { id, title, href, content, subtitle, banner, updated } = this.$route.params;
    this.id = id;
    this.href = href;
    this.title = title;
    this.content = content;
    this.subtitle = subtitle;
    this.banner = banner;
    this.updated = updated;
  },
  computed: {
    postId() {
      const { id } = this.$route.params;
      return id;
    },
  },
  methods: {
    ...mapActions(['InsertPost']),

    onEditorChange({ quill, html, text }) {
      console.log("editor change!", quill, html, text);
      this.content = html;
    },
    tapSave() {
      this.$alert(`${this.content}`, "Save Ok", {
        confirmButtonText: "OK",
        callback: (action) => {

          this.InsertPost({
            id: this.id,
            href: this.href,
            title: this.title,
            subtitle: this.subtitle,
            content: this.content,
          });

          this.$router.replace("/");
        },
      });
    },

  },
};
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
  .title {
    flex-direction: column;
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
