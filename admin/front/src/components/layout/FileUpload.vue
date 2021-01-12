<template>
  <div>
    <el-upload
      class="avatar-uploader"
      action=""
      :show-file-list="false"
      :on-success="handleAvatarSuccess"
      :before-upload="beforeAvatarUpload"
    >
      <img v-if="imageUrl" :src="imageUrl" class="avatar" />
      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
    {{ datas }}
  </div>
</template>


<script>
export default {
  data() {
    return {
      imageUrl: "",
      datas: {},
    };
  },
  methods: {
    handleAvatarSuccess(res, file) {
      alert("suc");
      this.imageUrl = URL.createObjectURL(file.raw);
      this.datas = file;
    },
    beforeAvatarUpload(file) {
      let w = true;
      let fileReader = new FileReader();
      fileReader.onloadend = async (e) => {
        alert(e);
        w = false;
      };
      fileReader.readAsText(file);
      return w;
    },
  },
};
</script>

<style lang="scss" scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>