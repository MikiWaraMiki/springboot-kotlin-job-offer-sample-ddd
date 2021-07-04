<template>
  <div>
    <h1>こんにちは、{{ this.$auth.$state.user.name }}さん</h1>
  </div>
</template>
<script>
export default {
  created() {
    console.log(this.$auth.$state.user)
  }
}
</script>
