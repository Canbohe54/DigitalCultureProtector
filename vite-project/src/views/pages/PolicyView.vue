<template>
  <div class="main">
    <!--  1  -->
    <div class="padding-lr-xxsl">
      <el-row :gutter="200">
        <el-col :span="8">
          <div class="w-100 h-50 text-center line-h-50 cursor text-overflow-sub"
               :class="activeIndex===1?' bg-red':'bg-white'" @click="activeIndex=1">
            国内法规文件
          </div>
        </el-col>
        <el-col :span="8">
          <div class="w-100 h-50 text-center line-h-50 cursor text-overflow-sub"
               :class="activeIndex===2?' bg-red':'bg-white'" @click="activeIndex=2">
            联合国教科文组织文件
          </div>
        </el-col>
        <el-col :span="8">
          <div class="w-100 h-50 text-center line-h-50 cursor text-overflow-sub"
               :class="activeIndex===3?' bg-red':'bg-white'" @click="activeIndex=3">
            主要论述
          </div>
        </el-col>
      </el-row>
    </div>
    <!--  2  -->
    <div class="margin-top-lg padding-bottom-xl">
      <!--      Domestic regulatory document    -->
      <div
          class="w-100 h-60px text-xxs bg-white margin-top-xs line-h-65 text-center flex align-center justify-between padding-lr-xl"
          v-for="item in Domestic" v-if="activeIndex===1">
        <div class="">{{ item.label }}</div>
        <div class="">{{ item.date }}</div>
      </div>
      <div class="text-center" v-if="activeIndex===1&&Domestic.length===0">暂无数据</div>

      <!--      UNESCO document       -->
      <div
          class="w-100 h-60px text-xxs bg-white margin-top-xs line-h-65 text-center flex align-center justify-between padding-lr-xl"
          v-for="item in UNESCO" v-if="activeIndex===2">
        <div class="">{{ item.label }}</div>
        <div class="">{{ item.date }}</div>
      </div>
      <div class="text-center" v-if="activeIndex===2&&UNESCO.length===0">暂无数据</div>
      <!--      Main exposition       -->
      <div
          class="w-100 h-60px text-xxs bg-white margin-top-xs line-h-65 text-center flex align-center justify-between padding-lr-xl"
          v-for="item in Main" v-if="activeIndex===3">
        <div class="">{{ item.label }}</div>
        <div class="">{{ item.date }}</div>
      </div>
      <div class="text-center" v-if="activeIndex===3&&Main.length===0">暂无数据</div>

    </div>
  </div>
</template>

<script setup lang="ts">
import {ref} from "vue";

const activeIndex = ref(1);
const Domestic = ref([{
  label: '中华人民共和国非物质文化遗产法（中华人民共和国主席令第四十二号）',
  date: '2011'
}]);
const UNESCO = ref([]);
const Main = ref([]);

</script>

<style scoped>
.bg-red {
  background-color: darkred;
}

.bg-white {
  cursor: pointer;
  transition: all .2s linear;
}

.bg-white:hover {
  background-color: darkred;
  color: white;
}
</style>
