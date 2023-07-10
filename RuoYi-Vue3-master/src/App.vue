<template>
  <router-view />
</template>

<script setup>
import useSettingsStore from '@/store/modules/settings'
import { handleThemeStyle } from '@/utils/theme'
import  useAppStore  from './store/modules/app'
import { getInfo } from "./api/system/datescreen"

const store = useAppStore();
onMounted(() => {
  nextTick(() => {
    // 初始化主题样式
    handleThemeStyle(useSettingsStore().theme)
  })
  store.quest.start=0;
    store.quest.end=Date.now();
    getInfo(store.quest).then(res=>{
      store.date=res
          console.log(res)

      console.log(store.date.总吞吐量)
    })

})
</script>
