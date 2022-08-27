<script lang="ts">
  import { navItems } from '../types/types'
</script>

<div class="mr-10">
  <nav class="flex flex-col w-2/12">
    {#each navItems as nav }
      <a href={`/#${nav.route}`}>{nav.link}</a>
    {/each}
  </nav>
</div>