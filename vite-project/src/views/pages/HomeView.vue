<template>
  <div class="absolute-top">
    <el-carousel height="100vh">
      <el-carousel-item v-for="item in carousel" :key="item">
        <img :src="item.src" :alt="item.src">
      </el-carousel-item>
    </el-carousel>
    <jiangxi-map />
  </div>
</template>

<script setup lang="ts">
import {ref} from "vue";
import JiangxiMap from "@/components/JiangxiMap.vue";

const carousel = ref([
  {
    src: "https://console.dasibuluo.com/Upload/File/2021/10/26/134354501286.jpg"
  }, {
    src: "https://img-xhpfm.zhongguowangshi.com/News/201908/20190807193958_0515.jpg"
  }, {
    src: "https://photo.tuchong.com/2968823/f/698748322.jpg"
  }, {
    src: "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fss2.meipian.me%2Fusers%2F1212521%2F087158b596924acaa8e494d731672211.jpg%3Fmeipian-raw%2Fbucket%2Fivwen%2Fkey%2FdXNlcnMvMTIxMjUyMS8wODcxNThiNTk2OTI0YWNhYThlNDk0ZDczMTY3MjIxMS5qcGc%3D%2Fsign%2F0905efee7465d6168e6769e08c7003fa.jpg&refer=http%3A%2F%2Fss2.meipian.me&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1705996007&t=fbcbea44ede8e39397ebf055901aed2a"
  },
])

</script>

<style scoped></style>
