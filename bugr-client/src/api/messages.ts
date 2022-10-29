import { ApiRoutes, type PostMessage } from "./types"
import type { GetMessages } from "./types"
import { userMessages } from "../lib/state/globalStore"

export const getUserMessages = async (userId: string): Promise<void> => {
  try {
    const getMessages = await fetch(
      `${ApiRoutes.BASE}${ApiRoutes.MESSAGES.GET_MESSAGES}${userId}`, 
      { 
        method: 'GET', 
        headers: { 
          'Content-Type': 'application/json' 
        }, 
        mode: 'cors' 
      }
    )
    const result: GetMessages[] = await getMessages.json()
    return userMessages.set(result)
  } catch (e) {
    console.error(e)
  }
}

export const sendUserMessage = async (data: PostMessage): Promise<void> => {
  try {
    const postMessage = await fetch(
      `${ApiRoutes.BASE}${ApiRoutes.MESSAGES.POST_MESSAGE}`, 
      { 
        method: 'POST', 
        headers: { 
          'Content-Type': 'application/json' 
        }, 
        mode: 'cors', 
        body: JSON.stringify(data) 
      }
    )
    if (postMessage.status === 201) {
      // Set a global to alert user
    }
  } catch (e) {
    console.error({e})
  }
}