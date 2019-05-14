<template>
  <v-container fill-height fluid grid-list-xl>
    <v-layout justify-center wrap>
      <v-flex xs12 md8>      
        <v-card>
          <v-card-title class="subheading font-weight-bold">지니뮤직 음악데이터
            <v-spacer></v-spacer>
            <v-text-field v-model="search" append-icon="search" label="검색" single-line hide-details></v-text-field>
          </v-card-title>
          <v-data-table :headers="headers" :items="data" :search="search"
           class="elevation-1" :pagination.sync="pagination" rows-per-page-text="20">
            <template v-slot:items="props">
              <td>{{ props.item.id }}</td>
              <td class="text-xs-left">{{ props.item.song_name }}</td>
              <td class="text-xs-left">{{ props.item.song_tts }}</td>
              <td class="text-xs-left">{{ props.item.song_tr }}</td>
              <td class="text-xs-left">{{ props.item.artist_name }}</td>
              <td class="text-xs-left">{{ props.item.artist_tts }}</td>
              <td class="text-xs-left">{{ props.item.artist_tr }}</td>
              <td class="text-xs-left">{{ props.item.popularity }}</td>
              <td class="text-xs-left">{{ props.item.genre }}</td>
              <td class="text-xs-left">{{ props.item.release_date }}</td>
              <td class="text-xs-left">{{ props.item.ranking }}</td>
            </template>
            <v-alert v-slot:no-results :value="true" color="error" icon="warning">
              "{{ search }}" 검색결과가 없습니다.
            </v-alert>
          </v-data-table>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import axios from 'axios'

export default {
  data: () => ({  
    search: '',
    pagination: {
      sortBy: 'song_name',
      rowsPerPage: 10
    },
    headers: [
      { text: 'SONG ID', value: 'song_id', class: "subheading font-weight-bold"},
      { text: '곡명', value: 'song_name', class: "subheading font-weight-bold"},
      { text: '곡명TTS', value: 'song_tts', class: "subheading font-weight-bold"},
      { text: '곡명독음', value: 'song_tr', class: "subheading  font-weight-bold"},
      { text: '가수명', value: 'artist_name', class: "subheading font-weight-bold"},
      { text: '가수명TTS', value: 'artist_tts', class: "subheading font-weight-bold"},
      { text: '가수명독음', value: 'artist_tr', class: "subheading  font-weight-bold"},
      { text: '인기', value: 'popularity', class: "subheading  font-weight-bold"},
      { text: '장르', value: 'genre', class: "subheading  font-weight-bold"},
      { text: '출시', value: 'release_date', class: "subheading  font-weight-bold"},
      { text: '순위', value: 'ranking', class: "subheading  font-weight-bold"},
    ],
    data: []
  }),
  created: function () {
    axios.get('http://169.56.70.78:30782/api/music/')
      .then(result => this.data = result.data)
  },
  computed: {
   pages: function () {
      if (this.pagination.rowsPerPage == null ||
        this.pagination.totalItems == null
      ) return 0
      return Math.ceil(this.pagination.totalItems / this.pagination.rowsPerPage)
    }  
  },

  methods: {
    change_sort: function (column) {
      if (this.pagination.sortBy === column) {
        this.pagination.descending = !this.pagination.descending
      } else {
        this.pagination.sortBy = column
        this.pagination.descending = false
      }
    } 
  }
}
</script>