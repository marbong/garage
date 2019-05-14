<template>
  <v-layout text-center wrap>
    <v-flex xs12>
      <v-parallax :src="require('@/assets/hotel02.jpeg')" contain height="1000">
        <v-layout column align-center justify-center class="white--text">
          <img :src="require('@/assets/logo.png')" height="200"> 
          <h1 class="white--text mb-2 display-3 text-xs-center">Welcome to Awesome AI HOTEL</h1>
          <v-layout justify-center>
            <v-btn dark large
              v-for="(link, i) in homeMenus"
              :key="i"
              :to="link.to"
              class="indigo lighten-1 mt-5" 
            >
              {{ link.text }}
            </v-btn>
          </v-layout>
        </v-layout>
      </v-parallax>
    </v-flex>

    <v-flex xs12>
      <v-container grid-list-xl>
        <v-layout row wrap justify-center class="my-5">
          <v-flex xs12 md4
            v-for="(info, i) in platformInfo"
            :key="i"
          >    
            <v-card class="elevation-0 transparent">
              <v-card-text class="text-xs-center">
                <v-icon x-large class="blue--text text--lighten-2">{{ info.icon }}</v-icon>
              </v-card-text>
              <v-card-title primary-title class="layout justify-center">
                <div class="headline text-xs-center">{{ info.title }}</div>
              </v-card-title>
              <v-card-text>
                {{ info.desc }}
              </v-card-text>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-flex>


    <v-flex xs12>
      <v-parallax :src="require('@/assets/section.jpg')" contain height="380">
        <v-layout column align-center justify-center>
          <h1 class="font-weight-thin font-italic white--text mb-2 text-xs-center">There's a reason why this Awesom AI hotel in downtown Seoul City is a popular favorite.  Stylish, innovative and forward thinking, Awesom AI hotel is one of the largest hospitality companies in the world, offering business and leisure travelers the finest in accommodations, service, amenities, and value.</h1>
        </v-layout>
      </v-parallax>
    </v-flex>
  </v-layout>
</template>

<script>
  export default {
    data: () => ({
      platformInfo: [
        {
          title: 'A First-Class Experience',
          icon: 'filter_1',
          desc: 'The Awesome AI hotel is one of the best hotels in Seoul City for the business traveler. The Awesome AI hotel business center provides a highly efficient and effective work environment with a variety of services, office equipment, and high-speed Internet access. '
        },
        {
          title: 'Meetings And Events',
          icon: 'find_in_page',
          desc: 'The Awesome AI hotel is the go-to venue for business people, event hosts, and party-goers alike. With spectacular ballrooms and lavish boardrooms, the Awesome AI hotel’s meeting and event space is ideal for just about any affair. '
        },
        {
          title: 'An Incredible Experience',
          icon: 'beenhere',
          desc: 'Our goal is to make your experience comfortable, relaxing and, most of all, memorable regardless of the reason behind your stay at the Awesome AI hotel.  Experience one of the finest downtown hotels'
        },      
      ],
      homeMenus: [
        {
          text: 'AMENITY SERVICE',
          to: '/amenity/'
        },
        {
          text: 'ROOMS CLEANING',
          to: '/amenity/'
        },
        {
          text: 'MESSAGE',
          to: '/amenity/'
        },
        {
          text: 'RESERVATION',
          to: '/amenity/'
        }    
      ]
    })
  }
</script>

<style>

</style>
