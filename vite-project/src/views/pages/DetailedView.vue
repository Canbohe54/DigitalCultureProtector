<template>
  <div class="main">
    <!--    1    -->
    <div class="w-fill text-center text-df text-black ff text-bold">国家级非物质文化遗产代表性项目名录</div>

    <div class="text-black margin-top-xl line-h-25 text-xxs">
      &emsp; &emsp;建立非物质文化遗产代表性项目名录，对保护对象予以确认，以便集中有限资源，对体现中华民族优秀传统文化，具有历史、文学、艺术、科学价值的非物质文化遗产项目进行重点保护，是非物质文化遗产保护的重要基础性工作之一。联合国教科文组织《保护非物质文化遗产公约》（以下简称《公约》）要求“各缔约国应根据自己的国情”拟订非物质文化遗产清单。建立国家级非物质文化遗产名录，是我国履行《公约》缔约国义务的必要举措。《中华人民共和国非物质文化遗产法》明确规定：“国家对非物质文化遗产采取认定、记录、建档等措施予以保存，对体现中华民族优秀传统文化，具有历史、文学、艺术、科学价值的非物质文化遗产采取传承、传播等措施予以保护。”“国务院建立国家级非物质文化遗产代表性项目名录，将体现中华民族优秀传统文化，具有重大历史、文学、艺术、科学价值的非物质文化遗产项目列入名录予以保护。”<br/>
      &emsp; &emsp;国务院先后于2006年、2008年、2011年、2014年和2021公布了五批国家级项目名录（前三批名录名称为“国家级非物质文化遗产名录”，《中华人民共和国非物质文化遗产法》实施后，第四批名录名称改为“国家级非物质文化遗产代表性项目名录”），共计1557个国家级非物质文化遗产代表性项目（以下简称“国家级项目”），按照申报地区或单位进行逐一统计，共计3610个子项。为了对传承于不同区域或不同社区、群体持有的同一项非物质文化遗产项目进行确认和保护，从第二批国家级项目名录开始，设立了扩展项目名录。扩展项目与此前已列入国家级非物质文化遗产名录的同名项目共用一个项目编号，但项目特征、传承状况存在差异，保护单位也不同。<br/>
      &emsp; &emsp;国家级名录将非物质文化遗产分为十大门类，其中五个门类的名称在2008年有所调整，并沿用至今。十大门类分别为：民间文学，传统音乐，传统舞蹈，传统戏剧，曲艺，传统体育、游艺与杂技，传统美术，传统技艺，传统医药，民俗。每个代表性项目都有一个专属的项目编号。编号中的罗马数字代表所属门类，如传统音乐类国家级项目“侗族大歌”的项目编号为“Ⅱ-28”。<br/>
    </div>

    <div class="flex align-center justify-center margin-top-xl">
      <div class="iconfont icon-knot cursor"></div>
      <div class="text-center text-black ff text-bold padding-lr-xs cursor text-red-hover">查看申报指南</div>
      <div class="iconfont icon-knot cursor"></div>
    </div>

    <!--    2     -->
    <el-row class="margin-top-xxl">
      <el-col :span="6">
        <div class="w-fill text-center text-xs text-black">
          <div class="ff-impact text-black text-bold text-xxl">5</div>
          <div class="text-black margin-top-xs">批次</div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="w-fill text-center text-xs text-black">
          <div class="ff-impact text-black text-bold text-xxl">10</div>
          <div class="text-black margin-top-xs">类别</div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="w-fill text-center text-xs text-black">
          <div class="ff-impact text-black text-bold text-xxl">88</div>
          <div class="text-black margin-top-xs">项目</div>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="w-fill text-center text-xs text-black">
          <div class="ff-impact text-black text-bold text-xxl">- -</div>
          <div class="text-black margin-top-xs">子项</div>
        </div>
      </el-col>
    </el-row>

    <!--    3     -->
    <table class="w-fill margin-top-xxl" align="center" cellpadding="10" cellspacing="0">
      <tr class="bg-red h-60px">
        <th>序号	</th>
        <th>项目序号	</th>
        <th>编号	</th>
        <th>名称	</th>
        <th>类别	</th>
        <th>公布时间	</th>
        <th>类型	</th>
        <th>申报地区或单位</th>
        <th>保护单位</th>
      </tr>
      <tr class="text-center h-80px text-black text-xs" v-for="item in 2">
        <td>Cell</td>
        <td>Cell</td>
        <td>Cell</td>
        <td>Cell</td>
        <td>Cell</td>
        <td>Cell</td>
        <td>Cell</td>
        <td>Cell</td>
        <td>Cell</td>
      </tr>
    </table>

    <!--    4      -->
    <div class="w-fill h-125px flex align-center justify-center text-center text-xxs line-h-30 text-black border-bottom-da">
      <div class="avatar-xxs cursor margin-lr-xxs bg-hover-red bg-hover bg-red">1</div>
      <div class="avatar-xxs cursor margin-lr-xxs bg-hover-red bg-hover">2</div>
      <div class="avatar-xxs cursor margin-lr-xxs bg-hover-red bg-hover">3</div>
      <div class="avatar-xxs cursor margin-lr-xxs bg-hover-red bg-hover">4</div>
      <div class="avatar-xxs cursor margin-lr-xxs bg-hover-red bg-hover">5</div>
      <div class="avatar-xxs cursor margin-lr-xxs bg-hover-red bg-hover">...</div>
      <div class="avatar-xxs cursor margin-lr-xxs bg-hover-red bg-hover">361</div>
      <div class="avatar-xxs cursor margin-lr-xxs bg-hover-red bg-hover iconfont icon-wenlvlogo text-sm"></div>
      <div class="cursor margin-lr-xxs text-xxs">跳转至</div>
      <div class="cursor margin-lr-xxs bg-hover">
        <input class="padding-lr-xs h-30px line-h-30" type="text"
               id="input" placeholder="">
      </div>
      <div class="cursor margin-lr-xxs text-xxs">页</div>
      <div class="cursor margin-lr-xs text-xxs bg-hover-red bg-hover padding-lr-xs radius-xs">确定</div>
    </div>

    <!--    5     -->

  </div>
</template>

<script setup lang="ts"></script>

<style scoped>
.text-xxl {
  font-size: 100px !important;
}

.bg-red{
  background-color: #962a2b;
}

#input {
  border: none;
}

input[type=text]:focus {
  outline: none;
}
</style>
