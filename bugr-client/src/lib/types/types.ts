export enum NavLinks {
    Home = "home",
    Login = "login",
    Logout = "logout",
    Messages = "messages",
    Profile = "profile",
    Search = "search",
    About = "about",
    Rules = "rules"
  }

  export const navItems: {link: NavLinks, auth: boolean}[] = [
    { link: NavLinks.Home, auth: false },
    { link: NavLinks.Login, auth: false },
    { link: NavLinks.Logout, auth: true },
    { link: NavLinks.About, auth: false },
    { link: NavLinks.Rules, auth: false },
    { link: NavLinks.Messages, auth: true },
    { link: NavLinks.Profile, auth: true },
    { link: NavLinks.Search, auth: true },
  ]