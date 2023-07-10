<template>
    <div class="content">
        <div class="main">
        <p v-if="show">将MySQL中的表录入到达梦数据库</p>
        <p v-if="show1">将hdfs中的文件录入到达梦数据库</p>
        <p v-if="show2">将MinIO中的文件录入到达梦数据库</p>

    <el-radio-group v-model="shuujuyuan" label="数据源选择" @change="handlechange">
      <el-radio-button label="mysql">mysql</el-radio-button>
      <el-radio-button label="hdfs">hdfs</el-radio-button>
      <el-radio-button label="minio">minio</el-radio-button>
    </el-radio-group>
    <div style="margin: 20px" />
    <el-form
      label-width="100px"
      :model="formLabelAlign"
      style="max-width: 460px"
      v-if="show"
    >
      <el-form-item label="URL">
        <el-input v-model="formLabelAlign.url" />
      </el-form-item>
      <el-form-item label="用户名">
        <el-input v-model="formLabelAlign.username" />
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="formLabelAlign.password" />
      </el-form-item>
      <el-form-item label="源表名">
        <el-input v-model="formLabelAlign.source_table" />
      </el-form-item>
      <el-form-item label="目标表名">
        <el-input v-model="formLabelAlign.target_table" />
      </el-form-item>
      <el-form-item>
      <el-button type="primary" @click="onSubmit">提交</el-button>
    </el-form-item>
    </el-form>
    <el-form
      label-width="100px"
      :model="formLabelAlign1"
      style="max-width: 460px"
      v-if="show1"
    >
      <el-form-item label="源文件路径">
        <el-input v-model="formLabelAlign1.hdfsInputFile" />
      </el-form-item>
      <el-form-item label="目标文件路径">
        <el-input v-model="formLabelAlign1.localOutputFile" />
      </el-form-item>
      <el-form-item label="URI">
        <el-input v-model="formLabelAlign1.uri" />
      </el-form-item>
      <el-form-item>
      <el-button type="primary" @click="onSubmit">提交</el-button>
    </el-form-item>
    </el-form>
    <el-form
      label-width="100px"
      :model="formLabelAlign2"
      style="max-width: 460px"
      v-if="show2"
    >
      <el-form-item label="URL">
        <el-input v-model="formLabelAlign2.endpoint" />
      </el-form-item>
      <el-form-item label="访问密钥">
        <el-input v-model="formLabelAlign2.access_key" />
      </el-form-item>
      <el-form-item label="秘密密钥">
        <el-input v-model="formLabelAlign2.secret_key" />
      </el-form-item>
      <el-form-item label="存储桶名称">
        <el-input v-model="formLabelAlign2.bucket_name" />
      </el-form-item>
      <el-form-item label="源文件路径">
        <el-input v-model="formLabelAlign2.object_name" />
      </el-form-item>
	   <el-form-item label="本地保存路径">
        <el-input v-model="formLabelAlign2.filepath" />
      </el-form-item>
      <el-form-item>
      <el-button type="primary" @click="onSubmit">提价</el-button>
    </el-form-item>
    </el-form>
</div>
</div>
</template>
  
  <script lang="ts" setup>
  import { reactive, ref } from 'vue'
  import { mysqlrequest, hdfsrequest, miniorequest} from "@/api/system/source"   
  const shuujuyuan = ref('mysql')
  const show = ref(true)
  const show1 = ref(false)
  const show2 = ref(false)


  const handlechange = () =>{
    if(shuujuyuan.value=='mysql'){
        show.value=true
        show1.value=false
        show2.value=false

    }else if(shuujuyuan.value=='hdfs'){
      show1.value=true
        show.value=false
        show2.value=false    }
        else{
      show1.value=false
        show.value=false
        show2.value=true    }
  }
  
  const formLabelAlign = reactive({
    url: '',
    username: '',
    password: '',
    source_table:'',
    target_table:''
  })
  const formLabelAlign1 = reactive({
    hdfsInputFile: '',
    localOutputFile: '',
    uri: '',
    
  })
  const formLabelAlign2 = reactive({
    endpoint: '',
    access_key: '',
    secret_key: '',
    bucket_name:'',
    object_name:'',
	filepath:''
  })
  const onSubmit = ()=>{
     if(show.value){
        // 
        mysqlrequest(formLabelAlign)
        
     }else if(show1.value){
        //
        hdfsrequest(formLabelAlign1)
        
     }else{
      miniorequest(formLabelAlign2)
     }
  }
  </script>
  <style>
.content{
    display: flex;
    justify-content: center;
    align-items: center;
}
.main{
    width: 600px;
    height: 800px;
    padding: 20px;
    padding-top: 100px;
    border: 0.1px solid #f0f0f0;
    border-radius: 5px;
}
p{
    margin: 30px auto;
    font-size: 30px;
}
</style>