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

  export const UserType = {
    SEEKING: "Seeking bug",
    OFFERING: "Offering bug",
    CARER: "Carer of bug"
  } as const

  type UserTypeProps = typeof UserType
  type UserTypeValues = UserTypeProps[keyof UserTypeProps]

  export const States = {
    VIC: "VIC",
    NSW: "NSW",
    QLD: "QLD",
    SA: "SA",
    WA: "WA",
    NT: "NT",
    ACT: "ACT",
    TAS: "TAS"
  } as const

  type StatesProps = typeof States
  export type StatesValues = StatesProps[keyof StatesProps]

  export interface User {
    userId?: string
    password?: string
    username: string
    email: string
    location: string
    state: StatesProps
    userType: UserTypeValues
    aboutBug: string
    confirmed?: boolean
  }