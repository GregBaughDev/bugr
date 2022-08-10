<script lang="ts">
  import { currentPage, userLoggedIn } from '../state/globalStore'
  import { navItems, NavLinks } from '../types/types'

  const handleClick = (link: NavLinks): void => {
    $currentPage = link
  }

  const filterNavItems = (navItems: {link: NavLinks, auth: boolean}[]): {link: NavLinks, auth: boolean}[] => {
    return navItems.filter((item) => item.auth === $userLoggedIn || [NavLinks.Home, NavLinks.About, NavLinks.Rules].includes(item.link))
  }
</script>

<div class="flex flex-col w-2/12">
  {#each filterNavItems(navItems) as nav }
    <h3 on:click={() => handleClick(nav.link)}>{nav.link}</h3>
  {/each}
</div>