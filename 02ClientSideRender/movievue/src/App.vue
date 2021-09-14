<template>
  <h1>Movie List</h1>
  <MovieList :movies="movies"  books=""/>
</template>

<script>
import axios from "axios"
import MovieList from "./components/MovieList.vue";
export default {
  components: {
    MovieList,
  },
  data() {
    return {
      movies: [],
      loading: false,
      error: null,
    }
  },
  methods: {    
    async fetchMovies() {
      try {
        this.error = null
        this.loading = true
        const url = `http://localhost:8080/movies`
        const response = await axios.get(url)       
        this.movies = response.data
      } catch (err) {       
        console.log(err)
      }
      this.loading = false
    },
  },
  mounted() {
    this.fetchMovies()
  },

}
</script>

<style>
#app {
  font-family: "SF Mono", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 50px;

}
</style>
