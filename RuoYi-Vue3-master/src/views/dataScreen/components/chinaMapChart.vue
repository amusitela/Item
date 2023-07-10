<template>
  <!-- 中国地图 -->
  <div class="map-ball"></div>
  <div id="mapChart" class="echarts"></div>
</template>

<script setup lang="ts">
import { ECharts, EChartsOption, init } from "echarts";
import echarts from "../../../utils/echarts";
import mapJson from "../assets/port1.json";

let planePath: string =
  "path://M36 17L28 10V0H64V10L56 17H36ZM40 14H48V3H40V14ZM44 8H52V5H44V8Z";
const initChart = (data: any = []): ECharts => {
  const charEle = document.getElementById("mapChart") as HTMLElement;
  const charEch: ECharts = init(charEle);
  echarts.registerMap("port1", mapJson as any);
  const option: EChartsOption = {
    // 悬浮窗
    tooltip: {
      trigger: "item",
      formatter: function (params: any) {
        return `${params.name}: ${params.value || "-"}`;
      }
    },
    // echarts大小位置
    grid: {
      left: "10px",
      right: "0px",
      top: "10px",
      bottom: "10px"
    },
    geo: {
      map: "port1",
      zoom: 1.5,
      center: [118.848234, 31.12333],
      scaleLimit: {
        min: 0.8
      },
      label: {
        color: "#fff",
        show: true
      },
      
      emphasis: {
        label: {
          color: "#fff",
          show: true
        },
        itemStyle: {
          areaColor: {
            x: 0,
            y: 0,
            x2: 0,
            y2: 1,
            colorStops: [
              {
                offset: 0,
                color: "#073684" // 0% 处的颜色
              },
              {
                offset: 1,
                color: "#2B91B7" // 100% 处的颜色
              }
            ]
          }
        }
      },
      roam: false,
      itemStyle: {
        areaColor: {
          x: 0,
          y: 0,
          x2: 0,
          y2: 1,
          colorStops: [
            {
              offset: 0,
              color: "#073684" // 0% 处的颜色
            },
            {
              offset: 1,
              color: "#061E3D" // 100% 处的颜色
            }
          ]
        },
        borderColor: new echarts.graphic.LinearGradient(
          0,
          0,
          0,
          1,
          [
            {
              offset: 0,
              color: "#00F6FF"
            },
            {
              offset: 1,
              color: "#87ADCB"
            }
          ],
          false
        ),
        shadowColor: "rgba(10,76,139,1)",
        shadowOffsetY: 0,
        shadowBlur: 60,
        borderWidth: 1
      },
      tooltip: {
        show: false
      }
    },
    // 要显示的散点数据
    series: [
      {
        name: "",
        type: "lines",
        coordinateSystem: "geo",
        zlevel: 1,
        effect: {
          show: true,
          period: 6,
          trailLength: 0.7,
          color: "red", // arrow箭头的颜色
          symbolSize: 3
        },
        lineStyle: {
          color: "#fff",
          width: 0,
          curveness: 0.2
        },
        data
      },
      {
        name: "",
        type: "lines",
        coordinateSystem: "geo",
        zlevel: 2,
        symbol: ["none", "arrow"],
        symbolSize: 10,
        effect: {
          show: true,
          period: 6,
          trailLength: 0,
          symbol: planePath,
          symbolSize: 15
        },
        lineStyle: {
          color: "#fff",
          width: 1,
          opacity: 0.6,
          curveness: 0.2
        },
        data
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
.map-ball {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 900px;
  height: 900px;
  transform: translate(-50%, -50%);
  img {
    width: 500px;
    height: 500px;
  }
}
</style>
