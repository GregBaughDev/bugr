import { getUserMessages } from "../../api/messages"

export class MessageWsClient {
  private websocket = new WebSocket("ws://localhost:8887")
  private userId: string

  constructor(userId: string) {
    this.userId = userId
  }

  startSocket() {
    this.websocket.addEventListener('open', () => {
      console.log('socket started')
      this.websocket.send(this.userId)
    })

    this.websocket.onmessage = async () => {
      console.log('message received')
      await getUserMessages(this.userId)
    }

    this.websocket.onerror = (e) => {
      console.error(e)
    }
  }

  closeSocket() {
    this.websocket.close()
  }
}