<script lang="ts">
  import { push } from 'svelte-spa-router'
  import { userLoggedIn, userMessages } from '../../state/globalStore'
  import { userDetails } from '../../state/userStore'

  $userDetails = null
  $userLoggedIn = false
  $userMessages = null
  push('/')
</script>