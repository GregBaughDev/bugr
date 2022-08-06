<script lang="ts">
  import { currentPage } from '../state/globalStore'
  import { navItems, NavLinks } from '../types/types'
  
  const handleClick = (link: NavLinks): void => {
    $currentPage = link
  }
</script>

<div class="flex flex-col w-2/12">
  {#each navItems as nav }
    <h3 on:click={() => handleClick(nav)}>{nav}</h3>
  {/each}
</div>