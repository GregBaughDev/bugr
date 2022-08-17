import type { UserLogin } from "./types"
import { ApiRoutesUsers } from "./types"

export const userLogin = async (data): Promise<void> => {
  try {
    const loginCall = await fetch(ApiRoutesUsers.LOGIN, { method: 'POST', headers: { 'Content-Type': 'application/json' }, mode: 'cors', body: JSON.stringify(data) })
    const result = await loginCall.json()
    console.log({result})
    return result
  } catch (e) {
    console.log({ e })
  }
}