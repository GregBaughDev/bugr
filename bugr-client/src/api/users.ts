import { push } from "svelte-spa-router"
import { ApiRoutesUsers } from "./types"
import { userDetails } from "../lib/state/userStore"
import { userLoggedIn } from "../lib/state/globalStore"

export const userLogin = async (data): Promise<void> => {
  try {
    const loginCall = await fetch(ApiRoutesUsers.LOGIN, { method: 'POST', headers: { 'Content-Type': 'application/json' }, mode: 'cors', body: JSON.stringify(data) })
    const result = await loginCall.json()
    if (result.status === 400) {
      console.log('incorrect credentials')
    } else {
      userDetails.set(result)
      userLoggedIn.set(true)
      push('/profile')
    }
  } catch (e) {
    console.error({ e })
  }
}