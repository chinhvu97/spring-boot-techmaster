<template>
  <div class="center-container">
    <table class="table" id="array-rendering">
      <thead>
      <tr>
        <th>No</th>
        <th>Title</th>
        <th>Director</th>
        <th>Year published</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(movie, index) in movies" :key="index">
        <td>{{ index + 1 }}</td>
        <td>{{ movie.title }}</td>
        <td>{{ movie.director }}</td>
        <td>{{ movie.year }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  props: {
    movies: {
      type: Array,
      required: true,
    },
  }
}
</script>

<style scoped>
.center-container {
  display: flex;
  justify-content: center;
}

a {
  color: #42b983;
}

table {
  border-collapse: collapse;
}

td, th {
  border: 1px solid #999;
  padding: 0.5rem;
  text-align: left;
}

</style>
