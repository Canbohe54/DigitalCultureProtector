<template>
  <div class="index-9 flex text-sm fixed-top-right padding-tb-xs border margin-top-sm margin-lr-lg"
       :class="notifyType?'bg-white':'bg-red'">
    <div class="padding-lr-xl">{{ msg }}</div>
    <div class="padding-lr-sm cursor hover" @click="closeNotify">×</div>
  </div>
</template>

<script setup lang="ts">
import {defineProps} from 'vue';

interface Props {
  msg?: string;
  notifyType?: boolean;
  closeNotify?: Function;
}

defineProps<Props>();
</script>

<style scoped>

</style>