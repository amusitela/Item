<template>
    <div class="user-info-head" style="width: 800px;">
      <el-upload  drag action="#" :http-request="requestUpload" :before-upload="beforeUpload">
            <el-icon class="el-icon--upload"><upload-filled /></el-icon>
            <div class="el-upload__text">
                Drop file here or <em>click to upload</em>
            </div>
            <template #tip>
                <div class="el-upload__tip">
                    jpg/png files with a size less than 500kb
                </div>
            </template>
        </el-upload>
        <el-button type="primary" @click="uploadImg()">提 交</el-button>
        
    </div>
        
</template>
  
<script setup>
const { proxy } = getCurrentInstance();


let fileObj

/** 覆盖默认上传行为 */
function requestUpload() {
    
}

/** 上传预处理 */
function beforeUpload(file) {
    const allowedTypes = ['application/vnd.ms-excel', 'text/csv', 'text/plain', 'image/png'];
    const fileType = file.type;
    if (allowedTypes.includes(fileType)) {
        fileObj = file;
       
    } else {
        proxy.$modal.msgError("文件格式错误，请上传xls,csv,txt类型。");
    }
}
/** 上传图片 */
function uploadImg() {
const fd = new FileReader()
console.log(fileObj);
    fd.readAsDataURL(fileObj)
    // 将文件转化为base64格式传入后端
    console.log(fd);
    fd.onload = () => {
      //传给后端 fd.result
      console.log(fd.result);
      proxy.$modal.msgSuccess("提交成功");
    }
}

</script>
  
<style lang='scss' scoped>
.user-info-head {
    position: relative;
    display: inline-block;
    height: 120px;
    margin: 0 auto;
}
</style>