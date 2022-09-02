<script lang="ts">
  import Router, { push } from 'svelte-spa-router'
  import wrap from 'svelte-spa-router/wrap'
  import './app.css'
  import Nav from './lib/components/Nav.svelte';
  import Home from './lib/components/pages/Home.svelte'
  import About from './lib/components/pages/About.svelte'
  import Login from './lib/components/pages/Login.svelte'
  import Logout from './lib/components/pages/Logout.svelte'
  import Messages from './lib/components/pages/Messages.svelte'
  import Profile from './lib/components/pages/Profile.svelte'
  import Rules from './lib/components/pages/Rules.svelte'
  import Search from './lib/components/pages/Search.svelte'
  import Fallback from './lib/components/pages/Fallback.svelte';
  import { userLoggedIn } from '../src/lib/state/globalStore'

  const checkUserAuthOrRedirect = (loggedIn: boolean): boolean => {
    if ($userLoggedIn) {
      return true
    } else {
      push('/login')
    }
  }

  const routes = {
    '/': Home,
    '/about': About,
    '/login': Login,
    '/logout': wrap({
      component: Logout,
      conditions: [
        () => checkUserAuthOrRedirect($userLoggedIn)
      ]
    }),
    '/messages': wrap({
      component: Messages,
      conditions: [
        () => checkUserAuthOrRedirect($userLoggedIn)
      ]
    }),
    '/profile': wrap({
      component: Profile,
      conditions: [
        () => checkUserAuthOrRedirect($userLoggedIn)
      ]
    }),
    '/rules': Rules,
    '/search': wrap({
      component: Search,
      conditions: [
        () => checkUserAuthOrRedirect($userLoggedIn)
      ]
    }),
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