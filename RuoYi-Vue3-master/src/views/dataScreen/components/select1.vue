<template>
    <el-select v-model="value" class="m-2 select" placeholder="Select" size="small" @change="handlechange">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.lable"
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
   sessionStorage.setItem('goods', value.value);

  window.location.reload();
}
var options=[
{value:"黑麦",lable:"黑麦"},
{value:"铜",lable:"铜"},
{value:"铁矿石",lable:"铁矿石"},
{value:"铁矿",lable:"铁矿"},
{value:"钢材",lable:"钢材"},
{value:"茶叶",lable:"茶叶"},
{value:"稻谷",lable:"稻谷"},
{value:"砂石",lable:"砂石"},
{value:"猪腩",lable:"猪腩"},
{value:"燕麦",lable:"燕麦"},
{value:"活猪",lable:"活猪"},
{value:"活猪",lable:"活猪"},
{value:"水泥",lable:"水泥"},
{value:"木材",lable:"木材"},
{value:"小麦",lable:"小麦"},
{value:"小牛",lable:"小牛"},
{value:"天然橡胶",lable:"天然橡胶"},
{value:"大麦",lable:"大麦"},
{value:"大豆粉",lable:"大豆粉"},
{value:"大豆油",lable:"大豆油"},
{value:"大豆",lable:"大豆"},
{value:"原煤",lable:"原煤"},
{value:"原油",lable:"原油"},
{value:"单氟磷酸钠",lable:"单氟磷酸钠"},
{value:"三钙",lable:"三钙"}]

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