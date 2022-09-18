<script lang="ts">
  import { navItems, NavLinks } from '../types/types'
  import type { NavItem } from '../types/types';
  import { userLoggedIn } from '../state/globalStore'

  const filterNavItems = (navItems: NavItem[]): NavItem[] => {
    return navItems.filter((item) => item.auth === $userLoggedIn || [NavLinks.Home, NavLinks.About, NavLinks.Rules].includes(item.link))
  }
</script>
<!-- LOOK INTO PREVENT DEFAULT ON REFRESH -->
<div class="my-10">
  <nav class="flex flex-row w-2/12">
    {#key $userLoggedIn}
      {#each filterNavItems(navItems) as nav }
        <a class='-rotate-90' href={`/#${nav.route}`}>{nav.link}</a>
      {/each}
    {/key}
  </nav>
</div>