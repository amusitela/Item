<template>
  <!-- 男女比例 -->
  <div class="malefemaleRatio-main">
    <div id="MaleFemaleRatioChart" class="echarts"></div>
  </div>
</template>

<script setup lang="ts">
import { ECharts, EChartsOption, init } from "echarts";

interface ChartProp {
  xline:[],
  indata:[],
  outdata:[]
}
const initChart = (data: ChartProp): ECharts => {
  const charEle = document.getElementById("MaleFemaleRatioChart") as HTMLElement;
  const charEch: ECharts = init(charEle);
  const option: EChartsOption = {
    tooltip: {
      trigger: 'axis'
    },
    legend: {
      data: ['平均出库时间', '平均入库时间']
    },
    toolbox: {
      show: true,
      feature: {
        dataView: { show: true, readOnly: false },
        magicType: { show: true, type: ['line', 'bar'] },
      }
    },
    calculable: true,
    xAxis: [
      {
        type: 'category',
        // prettier-ignore
        data: data.xline
      }
    ],
    yAxis: [
      {
        type: 'value'
      }
    ],
    series: [
      {
        name: '平均出库时间',
        type: 'bar',
        data: data.outdata,
        markPoint: {
          data: [
            { type: 'max', name: 'Max' },
            { type: 'min', name: 'Min' }
          ]
        },
        markLine: {
          data: [{ type: 'average', name: 'Avg' }]
        }
      },
      {
        name: '平均入库时间',
        // color:"#233653",
        type: 'bar',
        data: data.indata,
        markPoint: {
          data: [
            { name: 'Max', value: 182.2, xAxis: 7, yAxis: 183 },
            { name: 'Min', value: 2.3, xAxis: 11, yAxis: 3 }
          ]
        },
        // markLine: {
        //   data: [{ type: 'average', name: 'Avg' }]
        // }
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
.malefemaleRatio-main {
  box-sizing: border-box;
  width: 100%;
  height: 100%;
  .malefemaleRatio-header {
    display: flex;
    justify-content: space-between;
    width: 100%;
    height: 115px;

    .man,
    .woman {
      display: flex;
      flex-direction: column;
      align-items: center;
      width: 110px;
      height: 115px;
      background: url("../images/man-bg.png") no-repeat;
      background-size: 100% 100%;

      img {
        width: 60px;
        height: 60px;
        margin-top: 20px;
      }

      span {
        margin-top: 2px;
        font-size: 13px;
        color: #ffffff;
      }
    }

    .woman {
      background: url("../images/woman-bg.png") no-repeat;
    }
  }

  .echarts {
    width: 100%;
    height: 100%;
  }
}</style>
