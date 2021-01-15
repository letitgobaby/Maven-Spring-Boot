<template>
  <div>
    <el-upload
      action="#" 
      accept="image/*" 
      list-type="picture-card" 
      :limit="1" 
      :file-list="fileList"
      :auto-upload="false" 
      :on-change="onSuccess" >

      <i slot="default" class="el-icon-plus"></i>

      <div slot="file" slot-scope="{ file }">
        <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" ref="img" />
        
        <span class="el-upload-list__item-actions">
          <span
            class="el-upload-list__item-preview"
            @click="handlePictureCardPreview(file)">
            <i class="el-icon-zoom-in"></i>
          </span>
          <span
            v-if="!disabled"
            class="el-upload-list__item-delete"
            @click="handleRemove(file)">
            <i class="el-icon-delete"></i>
          </span>
        </span>
      </div>

    </el-upload>

    <el-dialog :visible.sync="dialogVisible">
      <img width="100%" :src="dialogImageUrl" alt="" />
    </el-dialog>
  
  </div>
</template>


<script>
import { mapMutations } from 'vuex'
import { getImage } from '@/api/post'

export default {
  props: ['banner'],

  data() {
    return {
      imgName: "",
      dialogImageUrl: '',
      dialogVisible: false,
      fileList: [],
      disabled: false,
    };
  },

  mounted() {
    if (this.banner !== undefined) this.fileList = [ getImage(this.banner) ];
  },

  methods: {
    ...mapMutations(['SetImgData']),

    handleRemove(file) {
      this.fileList.splice(ele => {
        if ( ele.name === file.name ) return true;
      })

    },

    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },

    onSuccess(file) {
      this.imgName = file.raw.name
      const formData = new FormData(this.$refs.file)
      formData.append('file', file.raw)

      this.SetImgData({ formData, imgName: file.raw.name });
    },

  }
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