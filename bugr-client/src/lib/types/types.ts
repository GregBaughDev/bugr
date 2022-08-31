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

  export interface NavItem {
    link: NavLinks
    route: string
    auth: boolean
  }

  export const navItems: NavItem[] = [
    { link: NavLinks.Home, route: '/', auth: false },
    { link: NavLinks.Login, route: '/login', auth: false },
    { link: NavLinks.Logout, route: '/logout', auth: true },
    { link: NavLinks.About, route: '/about', auth: false },
    { link: NavLinks.Rules, route: '/rules', auth: false },
    { link: NavLinks.Messages, route: '/messages', auth: true },
    { link: NavLinks.Profile, route: '/profile', auth: true },
    { link: NavLinks.Search, route: '/search', auth: true },
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