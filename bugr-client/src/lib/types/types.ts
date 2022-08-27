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

  export const navItems: {link: NavLinks, route: string}[] = [
    { link: NavLinks.Home, route: '/' },
    { link: NavLinks.Login, route: '/login' },
    { link: NavLinks.Logout, route: '/logout' },
    { link: NavLinks.About, route: '/about' },
    { link: NavLinks.Rules, route: '/rules' },
    { link: NavLinks.Messages, route: '/messages' },
    { link: NavLinks.Profile, route: '/profile' },
    { link: NavLinks.Search, route: '/search' },
  ]

  enum UserType {
    Seeking,
    Offering,
    Carer
  }
  
  export interface User {
    userId: string
    username: string
    email: string
    location: string
    state: string
    userType: UserType
    aboutBug: string
    confirmed: boolean
  }