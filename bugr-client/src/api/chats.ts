import { ApiRoutes } from "./types"

export const deleteChat = async (chatId: string): Promise<void> => {
  try {
    const deleteChat = await fetch(
      `${ApiRoutes.BASE}${ApiRoutes.CHATS.DELETE_CHATS}${chatId}`,
      {
        method: 'DELETE',
        mode: 'cors'
      }
    )
    console.log({ deleteChat })
  } catch (e) {
    console.error(e)
  }
}