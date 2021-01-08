<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>{{ count }}</h2>
    <button v-on:click="emitUpdate">COUNT</button>
    <button v-on:click="justMethod">NOTHING</button>
  </div>
</template>

<script>
export default {
  name: "TestVue",
  data() {
    return {
      msg: "It's Vue.js LifeCycle Test",
      count: 0,
      welcome: "~!!",
    };
  },
  beforeCreate() {
    try {
      this.messageBack("beforeCreate");
    } catch (err) {
      console.log("@@ beforeCreate - messageBack function is not defined yet");
    }
  },
  created() {
    try {
      this.messageBack("created");
    } catch (err) {
      console.log("@@ created - messageBack function is not defined yet");
    }
  },
  beforeMount() {
    try {
      this.messageBack("beforeMount");
    } catch (err) {
      console.log("@@ beforeMount - messageBack function is not defined yet");
    }
  },
  mounted() {
    try {
      this.messageBack("mounted");
    } catch (err) {
      console.log("@@ mounted - messageBack function is not defined yet");
    }
  },
  beforeUpdate() {
    try {
      this.messageBack("beforeUpdate");
    } catch (err) {
      console.log("@@ beforeUpdate - messageBack function is not defined yet");
    }
  },
  updated() {
    try {
      this.messageBack("updated");
    } catch (err) {
      console.log("@@ updated - messageBack function is not defined yet");
    }
  },
  beforDestroy() {
    try {
      this.messageBack("beforDestroy");
    } catch (err) {
      console.log("@@ beforDestroy - messageBack function is not defined yet");
    }
  },
  destroyed() {
    try {
      this.messageBack("destroyed");
    } catch (err) {
      console.log("@@ destroyed - messageBack function is not defined yet");
    }
  },
  methods: {
    messageBack: function(msg) {
      console.log("@@ " + msg + "  " + (this.welcome === undefined ? "- DATA is undefined !!" : this.welcome) );
    },
    emitUpdate: function() {
      this.count = this.count + 1;
      console.log('-- COUNT PLUS 1')
    },
    justMethod: function() {
      console.log("-- JUST METHOD. Nothing happened");
    },
  },
};
</script>



<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
