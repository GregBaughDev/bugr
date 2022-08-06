<script lang="ts">
  import { currentPage } from '../state/globalStore'
  import { pageSelector } from '../utils/utils'
</script>

<div class="w-10/12 p-4">
    <svelte:component this={pageSelector($currentPage)} />
</div>