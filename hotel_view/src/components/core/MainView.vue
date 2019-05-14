<template>
  <v-content>
    <div id="core-view">

      <v-fade-transition mode="out-in">
        <router-view />
      </v-fade-transition>
    </div>
  </v-content>
</template>

<script>
export default {
  metaInfo () {
    return {
      title: 'Awesome AI Hotel'
    }
  }
}
</script>

<style>
#core-view {
  padding-top: 60px;
}
</style>