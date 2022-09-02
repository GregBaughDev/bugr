<script lang="ts">
  import { push } from 'svelte-spa-router'
  import { userLoggedIn } from '../../state/globalStore'

  $userLoggedIn = false
  push('/')
</script>