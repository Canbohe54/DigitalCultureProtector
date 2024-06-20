<template>
  <div class="main">
    <!--    1     -->
    <el-row>
      <el-col :span="6">
        <div class="w-fill text-center">
          <input class="w-fill padding-lr-sm margin-left-xl h-40px line-h-40" type="text"
                 id="input" placeholder="关键词"></div>
      </el-col>
      <el-col :span="6">
        <div class="w-fill padding-lr-xxl">
          <div class="bg-red h-40px text-xxs line-h-40 text-center text-overflow-sub">搜索</div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="w-fill padding-lr-xxl">
          <div class="bg-red h-40px text-xxs line-h-40 text-center text-overflow-sub">我的预约</div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="w-fill padding-lr-xxl">
          <div class="bg-red h-40px text-xxs line-h-40 text-center text-overflow-sub">我的收藏</div>
        </div>
      </el-col>
    </el-row>
    <!--    2     -->
    <div class="flex align-center justify-center margin-top-xl text-df">
      <div class="iconfont icon-knot cursor"></div>
      <div class="text-center text-black ff text-bold padding-lr-xs cursor">为你推荐</div>
      <div class="iconfont icon-knot cursor"></div>
    </div>
    <!--    Recommend for you     -->
    <div class="margin-top-xl">
      <div class="fl w-33 padding-xxs" v-for="item in recommend">
        <div class="w-fill h-400px hidden">
          <div class="h-225px hidden cursor">
            <div class="w-fill h-fill bg-img bg-red">
              <img class="w-fill h-fill" :src="item.pic" :alt="item.pic">
            </div>
          </div>
          <div class="w-fill h-200px bg-white">
            <div class="ff text-bold line-h-40 margin-top-xxxs text-xs text-center w-fill text-overflow-sub">
              {{ item.title }}
            </div>
            <div class="text-xxs padding-lr line-h-20 text-overflow-twice">{{ item.intro }}</div>
            <div class="text-xxxs padding-lr line-h-25 text-overflow-twice margin-top-xxs">地址：{{ item.address }}</div>
            <div class="text-xxxs padding-lr line-h-25 text-overflow-twice">时间：{{ item.date }}</div>
            <div class="text-xxxs padding-lr line-h-25 text-overflow-twice">联系电话：{{ item.phone }}</div>
          </div>
        </div>
      </div>
    </div>
    <!--    4     -->
    <div class="fl w-fill flex align-center justify-center margin-top-xl text-xxs">
      <div class="iconfont icon-gufengwujianzhongguofengzhongguojie_huaban_huaban cursor"></div>
      <div class="text-center text-black ff text-bold padding-lr-xs cursor">查看更多</div>
      <div class="iconfont icon-gufengwujianzhongguofengzhongguojie_huaban_huaban cursor"></div>
    </div>

  </div>
</template>

<script setup lang="ts">
import {ref} from "vue"

const recommend = ref([{
  id: '',
  pic: 'https://www.ihchina.cn/Uploads/Picture/2020/05/12/s5eba77d79fe28_634_354_37_0.jpg',
  title: '非遗知识课堂丨重读非遗法规文件',
  intro: '非遗知识课堂丨重读非遗法规文件：《关于实施中华优秀传统文化传承发展工程的意见》',
  detail: '',
  address: '',
  date: '',
  phone: ''
}]);
</script>

<style scoped>
.bg-red {
  cursor: pointer;
  background-color: darkred;
}

#input {
  border: none;
}

input[type=text]:focus {
  outline: none;
}

.bg-img {
  transition: all .4s ease-in-out;
}

.bg-img:hover {
  transform: scale(1.1);
}

.h-100px:hover {
  cursor: pointer;
  color: darkred !important;
}
</style>
