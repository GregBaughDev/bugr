<script lang="ts">
  import Router, { push } from 'svelte-spa-router'
  import { routes } from './routes'
  import './app.css'
  import Nav from './lib/components/Nav.svelte';  
</script>

<main class="bg-background h-screen w-screen">
  <div class="p-5">
    <h1 class="font-serif font-bold text-primary italic text-center text-6xl">bugr</h1>
    <div class="flex flex-row">
      <Nav />
      <Router {routes} />
    </div>
  </div>
</main>