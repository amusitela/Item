<template>
  <!-- 年度使用 -->
  <div id="AnnualUseChart" class="echarts"></div>
</template>

<script setup lang="ts">
import { ECharts, EChartsOption, init } from "echarts";
const colors = ["#54C8AC", "#F0BD40", "#5780E3"];
const initChart = (data: any = {}): ECharts => {
  const charEle = document.getElementById("AnnualUseChart") as HTMLElement;
  const gradientColors = ["rgba(254, 219, 101,0.1)", "rgba(0, 122, 254,0.1)", "rgba(255, 75, 122, 0.1)"];
  const charEch: ECharts = init(charEle);
  const option: EChartsOption = {
  color: colors,
  tooltip: {
    trigger: 'axis',
    axisPointer: {
      type: 'cross'
    }
  },
  grid: {
    right: '20%'
  },
  legend: {
    data: ['同比', '环比', '吞吐量']
  },
  xAxis: [
    {
      type: 'category',
      axisTick: {
        alignWithLabel: true
      },
      // prettier-ignore
      data: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
    }
  ],
  yAxis: [
    {
      type: 'value',
      name: '环比%',
      position: 'right',
      alignTicks: true,
      axisLine: {
        show: true,
        lineStyle: {
          color: colors[0]
        }
      },
      axisLabel: {
        formatter: '{value}'
      }
    },
    {
      type: 'value',
      name: '同比%',
      position: 'right',
      alignTicks: true,
      offset: 40,
      axisLine: {
        show: true,
        lineStyle: {
          color: colors[1]
        }
      },
      axisLabel: {
        formatter: '{value}'
      }
    },
    {
      type: 'value',
      name: '吞吐量（吨）',
      position: 'left',
      alignTicks: true,
      axisLine: {
        show: true,
        lineStyle: {
          color: colors[2]
        }
      },
      axisLabel: {
        formatter: '{value}'
      }
    }
  ],
  series: [
    {
      name: '同比',
      type: 'line',
      data: data.value
    },
    {
      name: '环比',
      type: 'line',
      yAxisIndex: 1,
      data: data.value1
    },
    {
      name: '吞吐量',
      type: 'bar',
      yAxisIndex: 2,
      data: data.value2
    }
  ]
};
  charEch.setOption(option);
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
}
:deep(.annual-tooTip) {
  box-sizing: border-box;
  width: 206px;
  height: 103px;
  padding: 5px 20px;
  background: url("../images/contrast-bg.png") no-repeat;
  background-size: 100% 100%;
  .annual-month {
    display: inline-block;
    margin-bottom: 2px;
    font-size: 10px;
    color: #03b8e2;
    transform: scale(0.9);
  }
  .annual-list {
    display: flex;
    flex-direction: column;
    width: 100%;
    .year-item {
      display: flex;
      align-items: center;
      width: 100%;
      height: 22px;
      .year-dot {
        width: 5px;
        height: 5px;
        margin: 0 2px;
        border-radius: 50%;
      }
      .year-name,
      .year-value {
        font-size: 10px;
        color: #03b8e2;
        transform: scale(0.8);
      }
      .year-name {
        margin: 0 2px;
      }
      .year-value {
        display: inline-block;
        width: 25%;
      }
    }
  }
}
</style>
