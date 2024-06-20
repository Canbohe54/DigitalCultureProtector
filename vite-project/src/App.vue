<template>
  <RouterView/>
</template>

<script setup lang="ts">
import {RouterView} from "vue-router";</script>

<style>
:root {
  --line-h: 56px;
  --border-h: 4px;
}

.html,
.body {
  width: 100vw;
  height: 100vh;
  font-family: "Droid Sans Mono Slashed", serif;
}

.main {
  width: calc(100vw - 0px);
  /*height: calc(100vh - 460px);*/
  height: auto;
  min-height: calc(100vh - 460px);
  padding: 0 5vw;
  background-color: #eee;
  overflow: hidden;
}

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}

img {
  width: 100%;
  height: 100%;
}

a {
  text-decoration: none;
}
</style>
