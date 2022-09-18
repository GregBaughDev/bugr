<script lang="ts">
  import Router, { push } from 'svelte-spa-router'
  import { routes } from './routes'
  import './app.css'
  import Nav from './lib/components/Nav.svelte'
</script>

<main class="h-screen w-screen cursor-vertical-text">
  <div class="p-5">
    <div class="flex flex-row justify-between items-center">
      <h1 class="font-bold text-primary italic text-[100px]">bugr</h1>
      <Nav />
    </div>
    <div class="flex justify-center">
      <Router {routes} />
    </div>
  </div>
</main>