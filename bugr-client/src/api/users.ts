import type { UserLogin } from "./types"
import { ApiRoutesUsers } from "./types"

export const userLogin = async (data: UserLogin): Promise<void> => {
  const loginCall = await fetch(ApiRoutesUsers.LOGIN, { method: 'POST', body: JSON.stringify(data) })
  const result = await loginCall.json()
  return result
}