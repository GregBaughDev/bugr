import type { User } from "src/lib/types/types"

export const ApiRoutesUsers = {
  BASE: 'http://localhost:8080/api/v1',
  LOGIN: '/users',
  NEW_USER: '/users/new'
} as const

export interface UserLogin {
  body: {
    username: string
    password: string
  }
}

export interface NewUser {
  body: {
    newUser: User
  }
}