import { get } from 'svelte/store'
import { push } from 'svelte-spa-router'
import wrap from 'svelte-spa-router/wrap'
import Home from './lib/components/pages/Home.svelte'
import About from './lib/components/pages/About.svelte'
import Login from './lib/components/pages/Login.svelte'
import Logout from './lib/components/pages/Logout.svelte'
import Messages from './lib/components/pages/Messages.svelte'
import Profile from './lib/components/pages/Profile.svelte'
import Rules from './lib/components/pages/Rules.svelte'
import Search from './lib/components/pages/Search.svelte'
import Signup from './lib/components/pages/Signup.svelte'
import UserView from './lib/components/pages/UserView.svelte'
import Fallback from './lib/components/pages/Fallback.svelte'
import { userLoggedIn } from '../src/lib/state/globalStore'

const checkUserAuthOrRedirect = (loggedIn: boolean): boolean => {
    if (loggedIn) {
      return true
    } else {
      push('/login')
    }
  }

export const routes = {
    '/': Home,
    '/about': About,
    '/login': Login,
    '/logout': wrap({
      component: Logout,
      conditions: [
        () => checkUserAuthOrRedirect(get(userLoggedIn))
      ]
    }),
    '/messages': wrap({
      component: Messages,
      conditions: [
        () => checkUserAuthOrRedirect(get(userLoggedIn))
      ]
    }),
    '/profile': wrap({
      component: Profile,
      conditions: [
        () => checkUserAuthOrRedirect(get(userLoggedIn))
      ]
    }),
    '/rules': Rules,
    '/search': wrap({
      component: Search,
      conditions: [
        () => checkUserAuthOrRedirect(get(userLoggedIn))
      ]
    }),
    '/signup': Signup,
    '/userView/:id': wrap({
      component: UserView,
      conditions: [
        () => checkUserAuthOrRedirect(get(userLoggedIn))
      ]
    }),
    '*': Fallback
  }