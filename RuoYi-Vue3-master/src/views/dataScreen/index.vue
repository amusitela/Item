<template>
  <div class="dataScreen-container">
    <div ref="dataScreenRef" class="dataScreen">
      <div class="dataScreen-header">
        <div class="header-lf">
          <span class="header-time">当前时间：{{ time }}</span>
          <span class="header-screening" ><router-link to="/">首页</router-link></span>
        </div>
        <div class="header-ct">
          <div class="header-ct-title">
            <span>物流可视化大数据展示平台</span>
            <div class="header-ct-warning"></div>
          </div>
        </div>
        <div class="header-rg">
          <span class="header-download" ><span @click="handleopen1">选择港口</span><Select v-show="show1" @change="reload" ></Select></span>
          <span class="header-download1" ><span @click="handleopen">选择货物</span><Select1 v-show="show" @change="reload"></Select1></span>
          <span class="header-download2" ><span @click="handleopen2">选择时间</span><Datapicker v-show="show2" @change="reload"></Datapicker></span>
        </div>
      </div>
      <div class="dataScreen-main">
        <div class="dataScreen-lf">
          <div class="dataScreen-top">
            <div class="dataScreen-main-title">
              <span>装货次数统计</span>
              <img src="./images/dataScreen-title.png" alt="" />
            </div>
            <!-- chart区域 -->
            <div class="dataScreen-main-chart">
              <RealTimeAccessChart ref="RealTimeAccessRef" />
            </div>
          </div>
          <div class="dataScreen-center">
            <div class="dataScreen-main-title">
              <span>集装箱尺寸比例</span>
              <img src="./images/dataScreen-title.png" alt="" />
            </div>
            <!-- chart区域 -->
            <div class="dataScreen-main-chart">
              <MaleFemaleRatioChart ref="MaleFemaleRatioRef" />
            </div>
          </div>
          <div class="dataScreen-bottom">
            <div class="dataScreen-main-title">
              <span>货重比例</span>
              <img src="./images/dataScreen-title.png" alt="" />
            </div>
            <!-- chart区域 -->
            <div class="dataScreen-main-chart">
              <AgeRatioChart ref="AgeRatioRef" />
            </div>
          </div>
        </div>
        <div class="dataScreen-ct">
          <div class="dataScreen-map">
            <div class="dataScreen-map-title">港口实时流量</div>
            <!-- <vue3-seamless-scroll
							:list="alarmData"
							class="dataScreen-alarm"
							:step="0.5"
							:hover="true"
							:limitScrollNum="3"
						>
							<div class="dataScreen-alarm">
								<div class="map-item" v-for="item in alarmData" :key="item.id">
									<img src="./images/dataScreen-alarm.png" alt="" />
									<span class="map-alarm sle">{{ item.label }} 预警：{{ item.warnMsg }}</span>
								</div>
							</div>
						</vue3-seamless-scroll> -->
            <mapChart ref="MapChartRef" />
          </div>
          <div class="dataScreen-cb">
            <div class="dataScreen-main-title text">
              <span>
                未来30天{{store.quest.port}}{{store.quest.goods}}趋势预测图
              </span>
              <img src="./images/dataScreen-title.png" alt="" />
            </div>
            <!-- chart区域 -->
            <div class="dataScreen-main-chart">
              <OverNext30Chart ref="OverNext30Ref" />
            </div>
          </div>
        </div>
        <div class="dataScreen-rg">
          <div class="dataScreen-top">
            <div class="dataScreen-main-title">
              <span>港口吞吐量排行</span>
              <img src="./images/dataScreen-title.png" alt="" />
            </div>
            <!-- chart区域 -->
            <div class="dataScreen-main-chart">
              <HotPlateChart ref="HotPlateRef" />
            </div>
          </div>
          <div class="dataScreen-center">
            <div class="dataScreen-main-title">
              <span>{{store.quest.port}}{{store.quest.goods}}</span>
              <img src="./images/dataScreen-title.png" alt="" />
            </div>
            <!-- chart区域 -->
            <div class="dataScreen-main-chart">
              <AnnualUseChart ref="AnnualUseRef" />
            </div>
          </div>
          <div class="dataScreen-bottom">
            <div class="dataScreen-main-title">
              <span>货物类别数据统计</span>
              <img src="./images/dataScreen-title.png" alt="" />
            </div>
            <!-- chart区域 -->
            <div class="dataScreen-main-chart">
              <PlatformSourceChart ref="PlatformSourceRef" />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts" name="dataScreen">
import { ref, Ref, onMounted, onBeforeUnmount, reactive } from "vue";
import { useRouter } from "vue-router";
import { useTime } from "../../hooks/useTime";
import { ECharts } from "echarts";
import mapChart from "./components/chinaMapChart.vue";
import AgeRatioChart from "./components/AgeRatioChart.vue";
import AnnualUseChart from "./components/AnnualUseChart.vue";
import HotPlateChart from "./components/HotPlateChart.vue";
import MaleFemaleRatioChart from "./components/MaleFemaleRatioChart.vue";
import OverNext30Chart from "./components/OverNext30Chart.vue";
import PlatformSourceChart from "./components/PlatformSourceChart.vue";
import RealTimeAccessChart from "./components/RealTimeAccessChart.vue";
import Select from "./components/select.vue";
import Select1 from "./components/select1.vue";
import Datapicker from "./components/Datapicker.vue";
import  useAppStore  from '../../store/modules/app'
import { getInfo } from "../../api/system/datescreen"

const store = useAppStore();
const router = useRouter();
const dataScreenRef = ref<HTMLElement | null>(null);

onMounted(() => {
    store.quest.port= sessionStorage.getItem('port');
    store.quest.goods= sessionStorage.getItem('goods');
    store.quest.start= sessionStorage.getItem('start');
    store.quest.end= sessionStorage.getItem('end');
    if(store.quest.start==null){
    store.quest.start=0;
    }
    if(store.quest.end==null){
    store.quest.end=Date.now();
    }
  getInfo(store.quest).then(res=>{
    store.date=res
        console.log(res)
    console.log(store.date)
    chuli();
     // 初始化 echarts
       initCharts();
  })
    console.log(store.quest.port)
    console.log(store.quest.goods)



  // 初始化时为外层盒子加上缩放属性，防止刷新界面时就已经缩放
  if (dataScreenRef.value) {
    dataScreenRef.value.style.transform = `scale(${getScale()}) translate(-50%, -50%)`;
    dataScreenRef.value.style.width = `1920px`;
    dataScreenRef.value.style.height = `1080px`;
  }



  // 为浏览器绑定事件
  window.addEventListener("resize", resize);
});

// 根据浏览器大小推断缩放比例
const getScale = (width = 1920, height = 1080) => {
  let ww = window.innerWidth / width;
  let wh = window.innerHeight / height;
  return ww < wh ? ww : wh;
};

// 监听浏览器 resize 事件
const resize = () => {
  if (dataScreenRef.value) {
    dataScreenRef.value.style.transform = `scale(${getScale()}) translate(-50%, -50%)`;
  }
  // 使用了 scale 的echarts其实不需要需要重新计算缩放比例
  Object.values(dataScreen).forEach(chart => {
    chart && chart.resize();
  });
};

// 声明echarts实例
interface ChartProps {
  [key: string]: ECharts | null;
}
const dataScreen: ChartProps = {
  chart1: null,
  chart2: null,
  chart3: null,
  chart4: null,
  chart5: null,
  chart6: null,
  chart7: null,
  mapChart: null
};
// 获取当前时间
const { nowTime } = useTime();
let timer: NodeJS.Timer | null = null;
let time: Ref<string> = ref(nowTime.value);
timer = setInterval(() => {
  time.value = useTime().nowTime.value;
}, 1000);
// 获取子组件的ref
interface ChartExpose {
  initChart: (params: any) => ECharts;
}
const RealTimeAccessRef = ref<ChartExpose>();
const AgeRatioRef = ref<ChartExpose>();
const AnnualUseRef = ref<ChartExpose>();
const HotPlateRef = ref<ChartExpose>();
const MaleFemaleRatioRef = ref<ChartExpose>();
const OverNext30Ref = ref<ChartExpose>();
const PlatformSourceRef = ref<ChartExpose>();
const MapChartRef = ref<ChartExpose>();

// 初始化 charts参数
let ageData = [{}];
let hotData = reactive([] as any[]);
let platFromData = reactive([] as any[]);
let goodsname=reactive([] as any[])
let indata=reactive([] as any[])

let outdata=reactive([] as any[])
let xline=reactive([] as any[])

let temp=reactive([] as any[])
let data=new Array(30).fill(0);
let value=reactive([] as any[])
let value1=reactive([] as any[])
let value2=reactive([] as any[])

let mapData = reactive([] as any[])
const chuli=()=>{
console.log("begin")
  //处理同比环比数据

  store.date.同比环比.map((item)=>{
    value.push(item.tb)
    value1.push(item.hb)
    value2.push(item.zz)

   })
  console.log(value)

// 处理排行榜数据

store.date.港口货物吞吐量.map((item)=>{
  item.name=item.作业港口;
  delete item.作业港口;
  item.value=item.总重;
  delete item.总重
  item.maxValue=5000000;
  item.percentage=""
})

//排序
store.date.港口货物吞吐量.sort((a,b)=>{
  return b.value - a.value;
})

hotData=store.date.港口货物吞吐量.slice(0,5)
console.log(hotData)
// 处理趋势数据
var currentDate = new Date();
var month = currentDate.getMonth() + 1; // 月份是从 0 开始计数的，所以要加上 1
var day = currentDate.getDate();
store.date.不同货物的日趋势.map((item)=>{
  temp=item.now.split("-")
  if(temp[1]==month&&temp[2]>day){

  if(data[temp[2]-day-1]==0){
    data[temp[2]-day-1]=item.总重
  }else{
    data[temp[2]-day-1]=(item.总重+data[temp[2]-day-1])/2
  }
}
})
var arr
//处理吞吐笔数据
store.date.货物类型吞吐量.map((item)=>{
  arr=item.split(":")

  arr=arr.concat(arr[1].split(","));
  var num = parseFloat(arr[2]);
  ageData.push({value:num,name:arr[3],percentage:""})
  goodsname.push(arr[3])
  platFromData.push(arr[2])

})
ageData=ageData.slice(1,7)

//处理地图数据
store.date.不同货物的流向.map((item)=>{
  let singlemap={
  fromName:"",
  toName:"",
  coords:[[0],[0]]

}
  if (item.start === "苏州港") {
  singlemap.fromName = item.start;
  singlemap.coords[0] = [120.63132, 31.30227];
} else if (item.start === "太仓港") {
  singlemap.fromName = item.start;
  singlemap.coords[0] = [121.1147184375, 31.7038819620574];
} else if (item.start === "马鞍山港") {
  singlemap.fromName = item.start;
  singlemap.coords[0] = [118.469902, 31.732599];
} else if (item.start === "镇江港") {
  singlemap.fromName = item.start;
  singlemap.coords[0] = [119.388367, 32.214024];
} else if (item.start === "铜陵港") {
  singlemap.fromName = item.start;
  singlemap.coords[0] = [117.764656, 30.91478];
} else if (item.start === "芜湖港") {
  singlemap.fromName = item.start;
  singlemap.coords[0] = [118.356392, 31.34333];
} else if (item.start === "南通港") {
  singlemap.fromName = item.start;
  singlemap.coords[0] = [120.820282, 32.007179];
} else if (item.start === "泰州港") {
  singlemap.fromName = item.start;
  singlemap.coords[0] = [119.898323, 32.236931];
} else if (item.start === "杭州港") {
  singlemap.fromName = item.start;
  singlemap.coords[0] = [120.141388, 30.332582];
}
if (item.end === "苏州港") {
  singlemap.fromName = item.end;
  singlemap.coords[1] = [120.63132, 31.30227];
} else if (item.end === "太仓港") {
  singlemap.fromName = item.end;
  singlemap.coords[1] = [121.1147184375, 31.7038819620574];
} else if (item.end === "马鞍山港") {
  singlemap.fromName = item.end;
  singlemap.coords[1] = [118.469902, 31.732599];
} else if (item.end === "镇江港") {
  singlemap.fromName = item.end;
  singlemap.coords[1] = [119.388367, 32.214024];
} else if (item.end === "铜陵港") {
  singlemap.fromName = item.end;
  singlemap.coords[1] = [117.764656, 30.91478];
} else if (item.end === "芜湖港") {
  singlemap.fromName = item.end;
  singlemap.coords[1] = [118.356392, 31.34333];
} else if (item.end === "南通港") {
  singlemap.fromName = item.end;
  singlemap.coords[1] = [120.820282, 32.007179];
} else if (item.end === "泰州港") {
  singlemap.fromName = item.end;
  singlemap.coords[1] = [119.898323, 32.236931];
} else if (item.end === "杭州港") {
  singlemap.fromName = item.end;
  singlemap.coords[1] = [120.141388, 30.332582];
}
        mapData.push(singlemap);
})

store.date.货物入库周期分析.map((item)=>{
  indata.push(Math.round(item.平均入库堆存时间/60));
  xline.push(item.货物名称)
})
store.date.货物出库周期分析.map((item)=>{
  outdata.push(Math.round(item.平均出库堆存时间/60));
})
}

let annualData = [
  {
    label: 2021 + "年",
    value: value
  },
  {
    label: 2022+ "年",
    value: value1
  },
  {
    label: 2020+ "年",
    value: value2
  }
];


// 初始化 echarts
const initCharts = (): void => {
  dataScreen.chart1 = RealTimeAccessRef.value?.initChart(store.date.总吞吐量) as ECharts;
  dataScreen.chart2 = AgeRatioRef.value?.initChart(ageData) as ECharts;
  dataScreen.chart3 = AnnualUseRef.value?.initChart({
    value,
        value1,
        value2
  }) as ECharts;
  dataScreen.chart4 = HotPlateRef.value?.initChart({
    data: hotData,
    colors: ["#1089E7", "#F57474", "#56D0E3", "#F8B448", "#8B78F6"]
  }) as ECharts;
  dataScreen.chart5 = MaleFemaleRatioRef.value?.initChart({
    xline,
    indata,
    outdata
  }) as ECharts;
  dataScreen.chart6 = OverNext30Ref.value?.initChart({
    unit: ["吨"],
    data: data
  }) as ECharts;
  dataScreen.chart7 = PlatformSourceRef.value?.initChart({
    data: platFromData,
    goodsname,
    colors: ["#078dbc", "#6ad40b", "#6172fc", "#1786ff", "#ffbe2f", "#4dc89d", "#b797df"]
  }) as ECharts;
  dataScreen.mapChart = MapChartRef.value?.initChart(mapData) as ECharts;
};
//时间选择组件的显示与否
let show = ref(false)
const handleopen=()=>{
  show.value=! show.value;
}
let show1 = ref(false)
const handleopen1=()=>{
  show1.value=! show1.value;
}
let show2 = ref(false)
const handleopen2=()=>{
  show2.value=! show2.value;
}

const reload = () =>{
chuli();
}
// 销毁时触发
onBeforeUnmount(() => {
  window.removeEventListener("resize", resize);
  clearInterval(timer!);
  Object.values(dataScreen).forEach(val => val?.dispose());
});

</script>
<style lang="scss" scoped>
@import "./index.scss";
input{
  background-color: rgb(41, 49, 188);
    color: #29fcff;
}
</style>
