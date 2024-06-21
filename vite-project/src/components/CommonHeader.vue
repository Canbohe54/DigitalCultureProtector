<template>
  <div class="">
    <div class="flex flex-direction padding-lr-xl index-1 absolute-top"
         :tran="state.selectedKeys==='/home'?'four':''"
         :class="state.selectedKeys==='/home'?'bg-gray text-white ':'bg-white text-black'">
      <!--   1   -->
      <el-row :gutter="80" class="padding-tb-xs"
              :class="state.selectedKeys==='/home'?'border-bottom-three':'border-bottom-da'">
        <el-col :span="12">
          <div class="flex align-center justify-center">
            <div class="avatar-sm text-darkred iconfont icon-sj9 text-center text-xxxl"></div>
            <span class="margin-left ff text-overflow-sub text-bold">数字文化守护者 · 文化遗产数字博物馆</span>
          </div>
        </el-col>
        <el-col :span="12">
          <div class="flex align-center justify-center">
            <div class="padding-lr-xs text-bold-1 margin-top-sm cursor"><i class="iconfont icon-search_sousuo"></i>
            </div>
            <div class="padding-lr-xs text-bold-1 margin-top-sm cursor"><i class="iconfont icon-session_huihua"></i>
            </div>
            <div class="padding-lr-xs text-bold-1 margin-top-sm cursor">
              <el-tooltip content="点击登录" placement="bottom" :disabled="isLogin">
                <a href="/login"><i class="iconfont icon-mine_wode"></i></a>
              </el-tooltip></div>
            <div class="margin-top-sm margin-left-sm ff text-overflow-sub text-bold">
              {{ new Date().getFullYear() }}-{{ new Date().getMonth() + 1 }}-{{ new Date().getDate() }}
              {{ "星期" + "日一二三四五六".charAt(new Date().getDay()) }}
              农历{{ lunardate }}
            </div>
            <div class="padding-lr-xs text-bold-1 margin-top-sm cursor margin-left-sm"><i
                class="iconfont icon-knot"></i></div>
          </div>
        </el-col>
      </el-row>
      <!--   2   -->
      <div class="w-fill h-60px flex align-center justify-center">
        <div class="ff text-sm text-bold padding-lr-sm margin-lr-xs cursor text-overflow-sub"
             :class="router.currentRoute.value.fullPath===item.path?'border-bottom':'no-border bg-hover'"
             v-for="(item,index) in menu" @click="handleSelect(item.path)"
             @mouseenter="mouseenter(item,index)" @mouseleave="mouseleave(item,index)">
          {{ item.label }}
        </div>
      </div>
      <!--   3   -->

    </div>
  </div>
</template>

<script setup lang="ts">
import {computed, onMounted, reactive, ref} from 'vue'
import router from "@/router";
import {index} from "@/stores";
//@ts-ignore
import lunardate from "@/utils/solarlunar.js";

const menu = ref([
  {label: '首页', path: '/home'},
  // {label: '机构', path: '/institution'},
  {label: '政策', path: '/policy'},
  {label: '资讯', path: '/message'},
  {label: '清单', path: '/detailed'},
  // {label: '资源', path: '/assets'},
  {label: '体验', path: '/experience'},
  {label: '学术', path: '/science', children: [{label: "论坛", path: ""}, {label: "调研", path: ""}]},
  {label: '百科', path: '/encyclopedia', children: [{label: "申报指南", path: ""}, {label: "百叶窗", path: ""}]},
  {label: '我的', path: '/myself', children: [{label: "我的预约", path: ""}, {label: "我的收藏", path: ""}]},
])
//@ts-ignore
const noChildren = computed(() => menu.value.filter((item) => !item.children))
//@ts-ignore
const hasChildren = computed(() => menu.value.filter((item) => item.children))
const state = reactive({
  selectedKeys: computed(/* @ts-ignore */() => index().selectedKeys),
});
const isLogin = ref(localStorage.getItem('myself'))

onMounted(() => {
  activeIndex.value = router.currentRoute.value.fullPath;
  index().changeSelectedKeys(activeIndex.value);
})
const activeIndex = ref("/home");
const handleSelect = (key: string) => {
  router.push(key);
  index().changeSelectedKeys(key);
}
const mouse = ref("")
const transform = ref(0)

//@ts-ignore
const mouseenter = (item, index) => {
  mouse.value = item.label
  transform.value = 650 + (100 * (index + 1))
}
//@ts-ignore
const mouseleave = (item, index) => {
  setTimeout(mouse.value = "", 20000);
}

</script>

<style scoped>
.border-bottom {
  border-bottom: var(--border-h) solid darkred;
  line-height: var(--line-h);
}

.no-border {
  border-bottom: var(--border-h) solid transparent;
  line-height: var(--line-h);
}

.no-border:hover {
  border-bottom: var(--border-h) solid darkred;
}

</style>
