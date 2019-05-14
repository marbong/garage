<template>
  <div>
    <v-toolbar flat color="white">
      <v-toolbar-title>Amenity Management</v-toolbar-title>
      <v-divider
        class="mx-2"
        inset
        vertical
      ></v-divider>
      <v-spacer></v-spacer>
      <v-dialog v-model="dialog" max-width="500px">
        <template v-slot:activator="{ on }">
          <v-btn color="primary" dark class="mb-2" v-on="on">New Item</v-btn>
        </template>
        <v-card>
          <v-card-title>
            <span class="headline">{{ formTitle }}</span>
          </v-card-title>

          <v-card-text>
            <v-container grid-list-md>
              <v-layout wrap>
                </v-flex>
                <v-flex xs12 sm6 md4>
                  <v-text-field v-model="editedItem.name" label="Amenity name"></v-text-field>
                </v-flex>
                <v-flex xs12 sm6 md4>
                  <v-text-field v-model="editedItem.available_count" label="Count (ea)"></v-text-field>
                </v-flex>
              </v-layout>
            </v-container>
          </v-card-text>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" flat @click="close">Cancel</v-btn>
            <v-btn color="blue darken-1" flat @click="save">Save</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-toolbar>
    <v-data-table
      :headers="headers"
      :items="data"
      class="elevation-1"
    >
      <template v-slot:items="props">
        <td class="text-xs-center">{{ props.item.name }}</td>
        <td class="text-xs-left">{{ props.item.available_count }}</td>
        <td class="text-xs-center justify-center layout px-0">
          <v-icon
            small
            class="mr-2"
            @click="editItem(props.item)"
          >
            edit
          </v-icon>
          <v-icon
            small
            @click="deleteItem(props.item)"
          >
            delete
          </v-icon>
        </td>
      </template>
      <template v-slot:no-data>
        <v-btn color="primary" @click="initialize">Reset</v-btn>
      </template>
    </v-data-table>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data: () => ({  
    drawer: false,
    dialog: false,
    snack: false,
    snackColor: '',
    snackText: '',    
    file_name: '',
    fileUrl: '',
    fileFile: '',      
    search: '',
    pagination: {
      sortBy: 'id',
      rowsPerPage: 10
    },
    selected: [],
    headers: [
      { text: 'NAME', value: 'name', class: "text-xs-center subheading font-weight-bold"},
      { text: 'COUNT', value: 'available_count', class: "text-xs-center subheading font-weight-bold"},
      { text: 'ACTION', value: 'action', class: "text-xs-center subheading font-weight-bold"}
    ],
    data: [],
    editedIndex: -1,
    editedItem: {
      name: '',
      available_count: 0
    },
    defaultItem: {
      name: '',
      available_count: 0
    }

  }),
  created: function () {
    // aib2b-management-service
    axios.get('http://169.56.70.69:32244/api/management-svc/amenity/list')
      .then(response => this.data = response.data)
  },
  computed: {
    formTitle () {
      return this.editedIndex === -1 ? 'Insert' : 'Update'
    },
   pages: function () {
      if (this.pagination.rowsPerPage == null ||
        this.pagination.totalItems == null
      ) return 0
      return Math.ceil(this.pagination.totalItems / this.pagination.rowsPerPage)
    }  
  },

  methods: {
    editItem (item) {
      this.editedIndex = this.data.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialog = true
    },
    deleteItem (item) {
      const index = this.data.indexOf(item)
      confirm('Delete?') && this.data.splice(index, 1)
      
      axios({ 
              method: 'post',
              url: 'http://169.56.70.69:32244/api/management-svc/amenity/amenityItem/delete',
              data: item,
              config: { headers: {'Content-Type': 'multipart/form-data' }}
            })
            .then(function (response) {
                      alert("삭제완료");
                })
            .catch(function (error) {
                      alert("삭제에 실패하였습니다.");
              console.log(error);
            });


    },
    close () {
      this.dialog = false
      setTimeout(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      }, 300)
    },
    save () {

      axios({
              method: 'post',
              url: 'http://169.56.70.69:32244/api/management-svc/amenity/amenityItem',
              data: this.editedItem,
              config: { headers: {'Content-Type': 'multipart/form-data' }}
            })
            .then(function (response) {
                      alert("저장완료");
                })
            .catch(function (error) {
                      alert("저장에 실패하였습니다.");
              console.log(error);
            });


      if (this.editedIndex > -1) {
        Object.assign(this.data[this.editedIndex], this.editedItem)
      } else {
        this.data.push(this.editedItem)
      }
      this.close()
    },
    toggleAll () {
      if (this.selected.length) this.selected = []
      else this.selected = this.data.slice()
    },
    change_sort: function (column) {
      if (this.pagination.sortBy === column) {
        this.pagination.descending = !this.pagination.descending
      } else {
        this.pagination.sortBy = column
        this.pagination.descending = false
      }
    },

    upload_file: function () {
    },

    get_data : function(){
      axios.get('http://169.56.70.69:32244/api/management-svc/amenity/list')
        .then(response => this.data = response.data)
        console.log(this.data);   
    }, 

  }
}
</script>
