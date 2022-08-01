<script lang="ts">
  import Counter from './lib/Counter.svelte'
  import './app.css'
</script>

<main class="bg-background h-screen w-screen">
  <div class="p-5">
    <h1 class="font-serif text-primary italic text-center text-6xl">bugr</h1>
    <div class="card">
      <Counter />
    </div>
  </div>
</main>