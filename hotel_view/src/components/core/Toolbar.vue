<template>
  <v-toolbar fixed clipped-left dark id="core-toolbar" 
  color="light-blue lighten-2" >
    <v-toolbar-title class="headline text-uppercase" to="home">
      <v-btn flat to="home">
        <v-icon left dark>dialpad</v-icon>
        <span>Awesome AI Hotel</span>
        <span class="font-weight-light"></span>
      </v-btn>
    </v-toolbar-title>

    <v-toolbar-items>
      <v-menu offset-y>
        <v-btn slot="activator" flat>ABOUT</v-btn>
        <v-list>
          <v-list-tile v-for="(link, i) in aboutMenus" :key="i">
            <v-btn flat :to="link.to">{{ link.text }}</v-btn>  
          </v-list-tile>
        </v-list>
      </v-menu>  
      
      <v-menu offset-y>
        <v-btn slot="activator" flat>ROOM SERVICE</v-btn>
        <v-list>
          <v-list-tile v-for="(link, i) in roomServiceMenus" :key="i">
            <v-btn flat :to="link.to">{{ link.text }}</v-btn>  
          </v-list-tile>
        </v-list>
      </v-menu>  

      <v-menu offset-y>
        <v-btn slot="activator" flat>INFORMATION</v-btn>
        <v-list>
          <v-list-tile v-for="(link, i) in infoServiceMenus" :key="i">
            <v-btn flat :to="link.to">{{ link.text }}</v-btn>  
          </v-list-tile>
        </v-list>
      </v-menu>  

      <v-spacer></v-spacer>

      <v-menu offset-y>
        <v-btn slot="activator" flat>Management</v-btn>
        <v-list>
          <v-list-tile v-for="(link, i) in managementMenus" :key="i">
            <v-btn flat :to="link.to">{{ link.text }}</v-btn>  
          </v-list-tile>
        </v-list>
      </v-menu>  



    </v-toolbar-items>      
  </v-toolbar>
</template>



<script>

  export default {
    data: () => ({
      aboutMenus: [
        {
          text: 'ABOUT',
          to: '/about/'
        },
        {
          text: 'HISTORY',
          to: '/history/'
        }       
      ],
      roomServiceMenus: [
        {
          text: 'AMENITY',
          to: '/amenity/'
        },
        {
          text: 'ROOM CLEANING',
          to: '/tv-upcoming/'
        },
        {
          text: 'RESERVATION',
          to: '/tv-unschedule/'
        }
      ],
      infoServiceMenus: [
        {
          text: 'ROOM',
          to: '/room/'
        },
        {
          text: 'DINING',
          to: '/giga-genie-utterance/'
        }      
      ],
      managementMenus: [
        {
          text: 'AMENITY',
          to: '/management/amenity/'
        },
        {
          text: 'ROOM',
          to: '/management/amenity/'
        },
        {
          text: 'FACILITY',
          to: '/management/amenity/'
        },                
        {
          text: 'INFORMATION',
          to: '/management/amenity/'
        }      
      ]      
    }),
  watch: {
    '$route' (val) {
      this.title = val.name
    }
  },    
  methods: {
    home () {
      this.$emit('home')
    }
  } 
}

</script>

<style>
  #core-toolbar a {
    text-decoration: none;
  }
</style>
