<script lang="ts">
  import './app.css'
  import Nav from './lib/components/Nav.svelte';
  import Router from 'svelte-spa-router'
  import Home from './lib/components/pages/Home.svelte'
  import About from './lib/components/pages/About.svelte'
  import Login from './lib/components/pages/Login.svelte'
  import Messages from './lib/components/pages/Messages.svelte'
  import Profile from './lib/components/pages/Profile.svelte'
  import Rules from './lib/components/pages/Rules.svelte'
  import Search from './lib/components/pages/Search.svelte'
  import Fallback from './lib/components/pages/Fallback.svelte';

  const routes = {
    '/': Home,
    '/about': About,
    '/login': Login,
    '/messages': Messages,
    '/profile': Profile,
    '/rules': Rules,
    '/search': Search,
    '*': Fallback
  }
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