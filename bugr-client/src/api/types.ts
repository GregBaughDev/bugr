import type { User } from "src/lib/types/types"

export const ApiRoutes = {
  BASE: 'http://localhost:8080/api/v1',
  USERS: {
    LOGIN: '/users',
    NEW_USER: '/users/new',
  },
  MESSAGES: {
    GET_MESSAGES: '/messages?userId='
  }
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

export interface GetMessages {
  messageId: number
  chatId: number
  fromUser: number
  toUser: number
  message: string
  messageDate: string
  username: string
}