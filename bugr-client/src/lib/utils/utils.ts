import { NavLinks } from '../types/types';
import Home from '../components/pages/Home.svelte';
import Login from '../components/pages/Login.svelte';
import Messages from '../components/pages/Messages.svelte';
import Profile from '../components/pages/Profile.svelte';
import Search from '../components/pages/Search.svelte';
import About from '../components/pages/About.svelte';
import Rules from '../components/pages/Rules.svelte';

export const pageSelector = (link: NavLinks) => {
  switch (link) {
    case NavLinks.Home:
      return Home
    case NavLinks.Login:
      return Login
    case NavLinks.Messages:
      return Messages
    case NavLinks.Profile:
      return Profile
    case NavLinks.Search:
      return Search
    case NavLinks.About:
      return About
    case NavLinks.Rules:
      return Rules
    }
  }