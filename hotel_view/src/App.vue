<template>
  <v-app>
    <Toolbar/>

    <MainView/>

    <Footer/>
  </v-app>
</template>

<script>
  export default {
    name: 'App',
    components: {
      Toolbar: () => import('@/components/core/Toolbar'),
      MainView: () => import('@/components/core/MainView'),
      Footer: () => import('@/components/core/Footer'),
    },
    data () {
      return {
        //
      }
    },
    methods: {
      home () {
        alert('You clicked home!')
      }
    }  
  }
</script>
