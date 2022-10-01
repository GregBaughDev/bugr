import { ApiRoutes } from "./types"
import type { GetMessages } from "./types"

export const getUserMessages = async (userId): Promise<GetMessages[]> => {
  try {
    const getMessages = await fetch(`${ApiRoutes.BASE}${ApiRoutes.MESSAGES.GET_MESSAGES}${userId}`, { method: 'GET', headers: { 'Content-Type': 'application/json' }, mode: 'cors' })
    const result = await getMessages.json()
    console.log(result)
    return result
  } catch (e) {
    console.error(e)
  }
}