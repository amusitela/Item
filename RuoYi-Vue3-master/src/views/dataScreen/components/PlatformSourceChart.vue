<template>
  <!-- 平台来源 -->
  <div id="PlatformSourceChart" class="echarts"></div>
</template>

<script setup lang="ts">
import { ECharts, EChartsOption, init } from "echarts";
interface ChartProp {
  name: string;
  value: number;
  percentage: string;
}
const customFormatter = (value: string) => {
  // 在这里编写您的自定义格式化逻辑
  if (Number(value) >= 10000) {
              value = Number(value) / 10000 + "w";
  }
            return value;
};

const initChart = (data: any = {}): ECharts => {
  const charEle = document.getElementById("PlatformSourceChart") as HTMLElement;
  const charEch: ECharts = init(charEle);
  const option: EChartsOption = {
    tooltip: {
      trigger: "axis",
      confine: true,
      formatter: (params: any) => {
        let tipData = params[0];
        let html = `<div class="lineChart-bg">
                        <span style="">${tipData.name} <i >${tipData.value}</i> 吨货运量</span>
                    </div>`;
          return html;
        
      },
      backgroundColor: "transparent", // 提示标签背景颜色
      borderColor: "transparent",
      axisPointer: {
        lineStyle: {
          type: "dashed"
        },
        snap: true
      },
      extraCssText: "box-shadow: none;padding:0"
    },
  xAxis: [
      {
        type: "category",
          axisLine: {
          // 坐标轴轴线相关设置。数学上的x轴
          show: true,
          symbol: ["none", "arrow"],
          symbolOffset: [0, 30],
          lineStyle: {
            color: "#233653",
            // shadowOffsetX: 20,
            shadowColor: "#233653"
          }
        },
        axisLabel: {
          // 坐标轴刻度标签的相关设置
          color: "#7ec7ff",
          padding: 0,
          fontSize: 10,
          formatter: function (data) {
            return data;
          }
        },
        splitLine: {
          show: false,
          lineStyle: {
            color: "#192a44"
          }
        },
        axisTick: {
          show: false
        },
        data: data.goodsname
      }
    ], 
  yAxis: {
    type: 'value',
    name: "(吞吐量)",
    axisLabel: {
          show: true,
          color: "#7ec7ff",
          padding: 0,
          formatter: customFormatter
        },
  },
  series: [
    {
      data: data.data.map((val: number, index: number) => {
          return {
            value: val,
            itemStyle: {
              shadowBlur: 20,
              color: data.colors[index],
            }
          };
        }),
      color:data.color,
      type: 'bar'
    }
  ]
  };
  charEch.setOption(option, true);
  return charEch;
};
defineExpose({
  initChart
});
</script>
<style lang="scss" scoped>
.echarts {
  width: 100%;
  height: 100%;
  :deep(.lineChart-bg) {
    box-sizing: border-box;
    display: flex;
    align-items: center;
    width: 180px;
    height: 60px;
    padding-left: 20px;
    background: url("../images/line-bg.png") no-repeat;
    background-size: 100% 100%;
    span {
      font-size: 12px;
      color: rgb(255 255 255 / 80%);
      i {
        font-style: normal;
        color: #f5b348;
      }
    }
  }
}
</style>
