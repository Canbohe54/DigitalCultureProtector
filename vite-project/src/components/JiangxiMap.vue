<template>
  <div class="w-100vw h-100vh"
       style="background:url(https://www.ihchina.cn/Uploads/Picture/2019/10/11/s5da048b1840e2.jpg) no-repeat center/100% 100%;">
    <!--  1  -->

    <!--  2  -->
    <div class="h-10vh">
      <div class="flex align-center justify-center line-h-10vh">
        <div class="iconfont icon-knot text-bold text-white padding-lr-xs"></div>
        <div class="ff text-bold text-white text-center text-df text-overflow-sub">非物质文化遗产地图</div>
        <div class="iconfont icon-knot text-bold text-white padding-lr-xs"></div>
      </div>
    </div>

    <!--  3  -->
    <div class="h-90vh flex align-center justify-center">
      <div ref="chartContainer" class="w-50vw h-90vh"></div>
      <div class="padding-sm w-25vw h-65vh text-white bg-black text-center">
        <div class="text-xs margin-top-xxxs text-overflow-sub">【 {{city}} 】</div>
        <div class="flex align-center justify-center border-bottom-da padding-xs margin-top-xs text-xxxs cursor">
          <div class="text-brown text-overflow-sub padding-lr-xs">国家级代表性项目</div>
          <div class="text-overflow-sub padding-lr-xs">国家级代表性传承人</div>
        </div>
        <div class="margin-top-xxs">
          <!--     3-1     -->
          <div class="">
            <div class="bg-tran w-33 fl padding-xxxs" v-for="(item,index) in list">
              <div class="bg-brown h-fill padding-lr-sm h-80 padding-tb-xs"
                   :class="index===8||index===9?'flex align-center justify-around h-fill-t':''">
                <div class="text-lg text-bold ff-impact" :class="index===8||index===9?'text-small':''">
                  {{ item.count }}
                </div>
                <div class="text-xxxxs margin-top-xxxs text-overflow-twice"  :class="index===8||index===9?'text-overflow-sub':''">
                  {{ item.label }}
                </div>
              </div>
            </div>
          </div>

          <div class="text-xxxs margin-top-sm fl line-h-20 text-overflow-twice">
            说明：数据来自国务院及国家文化和旅游行政主管部门公开信息，台湾省暂无数据，数据统计截至2021年06月30日。
          </div>

          <div class="fl w-fill flex align-center justify-center margin-top-xs">
            <div class="iconfont icon-clound text-xl"></div>
            <div class="text-xxs padding-lr-xs">总计: <span class="text-sm ff-impact text-bold-2">88</span> 项</div>
            <div class="iconfont icon-clound text-xl"></div>
          </div>

        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import {onBeforeUnmount, onMounted, ref} from "vue";
import * as echarts from "echarts";
import guangzhou from "@/assets/guangdong.json";

const city=ref("广东省")
const list = ref([
  {
    label: '民间文学',
    count: 1
  }, {
    label: '传统音乐',
    count: 7
  }, {
    label: '传统舞蹈',
    count: 11
  }, {
    label: '传统戏剧',
    count: 17
  }, {
    label: '曲艺',
    count: 6
  }, {
    label: '传统体育、游艺与杂艺',
    count: 1
  }, {
    label: '传统美术',
    count: 11
  }, {
    label: '传统技艺',
    count: 21
  }, {
    label: '传统医药',
    count: 1
  }, {
    label: '民俗',
    count: 12
  },
])

const mapData: any = guangzhou;
const points = ref([
  // // 散点图数据
  // {
  //   name: "江西师范大学",
  //   value: [115.923027, 28.677068],
  //   itemStyle: {color: "white"},
  // }, // 江西师范大学
  // {
  //   name: "安义",
  //   value: [115.555441, 28.850794],
  //   itemStyle: {color: "#fff"},
  // }, // 安义
  // {
  //   name: "兴国",
  //   value: [115.36319, 26.337937],
  //   itemStyle: {color: "white"},
  // }, // 兴国
]);
const linesData = ref([]);
const planePath = // 飞机svg
    "path://M1705.06,1318.313v-89.254l-319.9-221.799l0.073-208.063c0.521-84.662-26.629-121.796-63.961-121.491c-37.332-0.305-64.482,36.829-63.961,121.491l0.073,208.063l-319.9,221.799v89.254l330.343-157.288l12.238,241.308l-134.449,92.931l0.531,42.034l175.125-42.917l175.125,42.917l0.531-42.034l-134.449-92.931l12.238-241.308L1705.06,1318.313z";

const chartContainer = ref<HTMLElement | null>(null);
//@ts-ignore
let chart: echarts.ECharts | null = null;

onMounted(() => {
  chart = echarts.init(chartContainer.value!);
  initChart();
  addHoverEventListener();
});

onBeforeUnmount(() => {
  if (chart) {
    //@ts-ignore
    chart.dispose();
    chart = null;
  }
});

function initChart() {
  //@ts-ignore
  echarts.registerMap("guangdong", mapData);
  const option = {
    backgroundColor: "transparent", // 背景颜色
    geo: {
      // 地图配置
      map: "guangdong",
      label: {
        // 图形上的文本标签
        normal: {
          // 通常状态下的样式
          show: true,
          textStyle: {
            color: "#000",
          },
        },
        emphasis: {
          // 鼠标放上去高亮的样式
          textStyle: {
            color: "#000",
          },
        },
      },
      itemStyle: {
        // 地图区域的样式设置
        normal: {
          // 通常状态下的样式
          borderColor: "#fff",
          borderWidth: 1,
          areaColor: {
            //地图区域的颜色
            type: "radial", // 径向渐变
            x: 0.5, // 圆心
            y: 0.5, // 圆心
            r: 0.8, // 半径
            colorStops: [
              {
                // 0% 处的颜色
                offset: 0,
                color: "rgba(255,255,255,0.5)",
              },
              {
                // 100% 处的颜色
                offset: 1,
                color: "rgba(255,255,255,0.5)",
              },
            ],
          },
        },
        // 鼠标放上去高亮的样式
        emphasis: {
          areaColor: "rgba(255,255,255,0.6)",
          borderWidth: 1,
        },
      },
    },
    tooltip: {
      trigger: "item",
      formatter: (params: any) => {
        // const { name, center, centroid } = params;
        return `地区名称: ${params.name}<br/>ID: ${params.dataIndex}`;
      },
    },
    series: [
      {
        // 散点系列数据
        type: "effectScatter", // 带有涟漪特效动画的散点（气泡）图
        coordinateSystem: "geo", //该系列使用的坐标系:地理坐标系
        // 特效类型,目前只支持涟漪特效'ripple'，意为“涟漪”
        effectType: "ripple",
        // 配置何时显示特效。可选'render'和'emphasis' 。
        showEffectOn: "render",
        rippleEffect: {
          // 涟漪特效相关配置。
          period: 2, // 动画的周期，秒数。
          scale: 8, // 动画中波纹的最大缩放比例。
          // 波纹的绘制方式，可选 'stroke' 和 'fill'。
          brushType: "stroke",
        },
        zlevel: 0.5, // 所有图形的 zlevel 值。
        data: points.value,
      },
      {
        // 线条系列数据
        type: "lines",
        zlevel: 2,
        symbol: ["none", "arrow"], // 标记的图形: 箭头
        symbolSize: 10, // 标记的大小
        effect: {
          // 线条特效的配置
          show: true,
          period: 6, // 特效动画的时间，单位s
          trailLength: 0, // 特效尾迹的长度。取值[0,1]值越大，尾迹越重
          symbol: planePath, // 特效图形的标记 可选'circle'等
          symbolSize: 15, // 特效标记的大小
        },
        lineStyle: {
          // 线条样式
          color: "#fff",
          width: 2.5, // 线条宽度
          opacity: 0.6, // 尾迹线条透明度
          curveness: 0.2, // 尾迹线条曲直度
        },
        data: linesData.value,
      },
    ],
  };

  if (chart) {
    //@ts-ignore
    chart.setOption(option);
  }
}
import api from "@/api";
function addHoverEventListener() {
  if (chart) {
    //@ts-ignore
    chart.on("click", (params: any) => {
      if (params.name) {
        city.value = params.name;
        api.home.mapCulture(params.name).then((res:any)=>{
          list.value=res.data
        })
      }
    });
  }
}
</script>

<style scoped>
.bg-brown {
  background-color: #b3a087;
}

.bg-black {
  background-color: #9e8c73;
}

.text-brown {
  color: #ffedcf;
}

.h-fill {
  min-height: 84px
}

.h-fill-t {
  min-height: 32px !important;
}

.text-small {
  font-weight: normal;
  transform: translateY(2px);
  font-size: 16px !important;
}

.text-overflow-sub{
  display: -webkit-box;
  -webkit-box-orient: vertical !important;
  -webkit-line-clamp: 1 !important;
  overflow: hidden;
}
</style>
