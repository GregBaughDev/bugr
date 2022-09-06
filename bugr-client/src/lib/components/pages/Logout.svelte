<script lang="ts">
  import { push } from 'svelte-spa-router'
  import { userLoggedIn } from '../../state/globalStore'
  import { userDetails } from '../../state/userStore'

  $userDetails = null
  $userLoggedIn = false
  push('/')
</script>