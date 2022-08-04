<script lang="ts">
  import { NavLinks } from '../types/types'
  
  const navItems: String[] = [
    NavLinks.Home,
    NavLinks.Login,
    NavLinks.Messages,
    NavLinks.Profile,
    NavLinks.Search,
    NavLinks.About  
  ]

  const handleClick = (link: String): void => {
    console.log(`clicked ${link}`)
    // Set main display element to the requested link
  }
</script>

<div class="flex flex-col">
  {#each navItems as nav }
    <h2 on:click={() => handleClick(nav)}>{nav}</h2>
  {/each}
</div>