
Vue.component('post-list', {
  props: ['post'],
  template: 
  "<div class='post-preview'>" +
    "<a href='/post'>" +
      "<h2 class='post-title'>" +
        "{{ post.title }}" +
      "</h2>" +
      "<h3 class='post-subtitle'>" +
        "{{ post.subtitle }}" +
      "</h3>" +
    "</a>" +
    "<p class='post-meta'>Posted by" +
    "<a href='#'>Start Bootstrap</a>" +
    "on {{ post.updated }}" +
    "</p>" +
  "</div> <hr>" +
  "<hr style='width:50%;text-align:left;margin-left:0'>"
});


var app = new Vue({
  el: '#vueComponent',
  data: {
      itemList: null,
      page: 0,
      size: 10
  },
  mounted() {
    axios.get('/api/v1/postPaging', {
      params: { page: this.page, size: this.size }
    })
      .then( response => {
        this.itemList = response.data.data;
        this.page = response.data.page;
        this.size = response.data.size + 10;
      });

  },
  methods: {
    paging: function () {
      axios.get('/api/v1/postPaging', {
        params: { page: this.page, size: this.size }
      })
        .then( response => {
          this.itemList = response.data.data;
          this.page = response.data.page;
          this.size = response.data.size + 10;
        });
    }

  }
});
