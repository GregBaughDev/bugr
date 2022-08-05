<script lang="ts">
  import Nav from './lib/components/Nav.svelte';
  import MainDisplay from './lib/components/MainDisplay.svelte';
  import './app.css'
</script>

<main class="bg-background h-screen w-screen">
  <div class="p-5">
    <h1 class="font-serif font-bold text-primary italic text-center text-6xl">bugr</h1>
    <div class="flex flex-row">
      <Nav />
      <MainDisplay />
    </div>
  </div>
</main>