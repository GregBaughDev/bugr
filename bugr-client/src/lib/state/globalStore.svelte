<script lang="ts">
  import { writable } from 'svelte/store'
  import type { Writable } from 'svelte/store';
  import { NavLinks } from '../types/types'

  export const currentPage = writable(NavLinks.Home)
  
</script>