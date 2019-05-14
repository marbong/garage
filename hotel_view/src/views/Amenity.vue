<template>
  <v-container fill-height fluid grid-list-xl text-xs-center>
    <v-layout justify-center wrap>

      <v-flex xs12 md8>
        <v-card >
          <v-flex d-flex>
            <v-select v-model="amenity" :items="amenities" menu-props="auto" prepend-icon="domain" 
            label="Select Amenity" @change="change_amenities"></v-select>
            <v-select v-model="count" :items="counts"  menu-props="auto" prepend-icon="domain" 
            label="Select count" @change="change_counts"></v-select>   
            <v-select v-model="room" :items="rooms"  menu-props="auto" prepend-icon="domain" 
            label="Select room" @change="change_rooms"></v-select>
          </v-flex>      
        </v-card>
      </v-flex>
      
      <v-flex xs12 md8>
        <v-btn block dark large color="info" class="subheading" 
          @click="order_amenity" >Order Amenity
        </v-btn>          
      </v-flex>

      <v-flex xs12 md8 v-for="trans in trans_datas" :key="trans.text">
        <v-divider></v-divider>  
        <h1 class="display-1 text-xs-center font-weight-light light-blue--text">
          {{ trans.text }}
        </h1>
      </v-flex>  

    </v-layout>
  </v-container>
</template>

<script>
import axios from 'axios'
axios.defaults.xsrfCookieName = 'csrftoken'
axios.defaults.xsrfHeaderName = "X-CSRFTOKEN"

export default {
  data: () => ({
    drawer: false,
    dialog: false,
    learned: false,   
    amenity: 'Towel', 
    amenities: ['Towel', 'Toothbrush', 'Shampoo', 'BodyCleanser', 'Shaver', 'Soap', 'Water', 'GreenTea', 'Coffee'],
    count: 4, 
    counts: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20],
    room: 401,
    rooms: ['401','402','403','404','405','406','407','408','409','410'],
    trans_datas: [] 
  }),

  methods: {
    order_amenity: function ()  {
      let self = this
      self.trans_datas = []
      var form_data = new FormData();
      form_data.append('Amenity', self.amenity); 
      form_data.set('count', self.count);
      form_data.set('room', self.room);

      axios({
        method: 'post',
        url: 'http://169.56.70.69:32244/api/front-svc/amenityOrder/',
        data: form_data,
        config: { headers: {'Content-Type': 'multipart/form-data' }}
      })
      .then(function (response) {
          alert("정상적으로 요청되었습니다.");
    })
      .catch(function (error) {
          alert("요청에 실패하였습니다. 다시 시도해주세요.");
          console.log(error);
      }); 
    },
    change_trans_modes(data) {
      this.trans_mode = data;
    },
    change_pure_modes(data) {
      this.pure_mode = data;
    },
    change_counts(data) {
      this.count = data;
    },
    change_rooms(data) {
       this.room = data;
    },
    reset: function ()  {
      this.sentence = '';
      this.trans_datas = [];
    }
  }
}
</script>
