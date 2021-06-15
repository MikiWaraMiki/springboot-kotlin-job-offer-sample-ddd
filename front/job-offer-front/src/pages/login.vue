<template>
  <div>
    <button color="primary" @click="loginWithAuth0">
      ログイン
    </button>
  </div>
</template>
<script>
export default {
  methods: {
    loginWithAuth0() {
      try {
        this.$auth.loginWith('auth0')
      } catch(e) {
        console.error(e)
      }
    }
  }
}
</script>
