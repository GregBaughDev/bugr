import { ApiRoutes } from "./types"
import type { GetMessages } from "./types"
import { userMessages } from "../lib/state/globalStore"

export const getUserMessages = async (userId): Promise<void> => {
  try {
    const getMessages = await fetch(`${ApiRoutes.BASE}${ApiRoutes.MESSAGES.GET_MESSAGES}${userId}`, { method: 'GET', headers: { 'Content-Type': 'application/json' }, mode: 'cors' })
    const result: GetMessages[] = await getMessages.json()
    return userMessages.set(result)
  } catch (e) {
    console.error(e)
  }
}