<script lang="ts">
  import { currentPage } from '../state/globalStore'
  import { NavLinks } from '../types/types'
  
  const navItems: NavLinks[] = [
    NavLinks.Home,
    NavLinks.Login,
    NavLinks.Messages,
    NavLinks.Profile,
    NavLinks.Search,
    NavLinks.About  
  ]

  const handleClick = (link: NavLinks): void => {
    $currentPage = link
  }
</script>

<div class="flex flex-col">
  {#each navItems as nav }
    <h2 on:click={() => handleClick(nav)}>{nav}</h2>
  {/each}
</div>