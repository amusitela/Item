<template>
    <el-select v-model="value" class="m-2 select" placeholder="Select" size="small" @change="handlechange">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value"
      class="option"
    />
</el-select>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
import  useAppStore  from '../../../store/modules/app'
import { getInfo } from "../../../api/system/datescreen"
const value = ref('')
const store = useAppStore();
const handlechange=()=>{
  
   sessionStorage.setItem('port', value.value);
    window.location.reload();
}
const options = [
  {
    value: '杭州港',
    label: '杭州港',
  },
  {
    value: '苏州港',
    label: '苏州港',
  },
  {
    value: '太仓港',
    label: '太仓港',
  },
  {
    value: '马鞍山港',
    label: '马鞍山港',
  },
  {
    value: '镇江港',
    label: '镇江港',
  },
  {
    value:"芜湖港",
    label:"芜湖港"
  },
  {
    value:"铜陵港",
    label:"铜陵港"
  },
  {
    value:"南通港",
    label:"南通港"
  },
  {
    value:"泰州港",
    label:"泰州港"
  },

]
</script>
<style scoped>
.select{
    background-color: rgb(17, 20, 78);
    color: #29fcff;
}
.option{
    background-color: rgb(17, 20, 78);
    color: #29fcff;
}
</style>