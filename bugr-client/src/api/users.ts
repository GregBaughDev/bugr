import { push } from "svelte-spa-router"
import { ApiRoutesUsers } from "./types"
import { userDetails } from "../lib/state/userStore"
import { userLoggedIn } from "../lib/state/globalStore"

export const userLogin = async (data): Promise<void> => {
  try {
    const loginCall = await fetch(`${ApiRoutesUsers.BASE}${ApiRoutesUsers.LOGIN}`, { method: 'POST', headers: { 'Content-Type': 'application/json' }, mode: 'cors', body: JSON.stringify(data) })
    const result = await loginCall.json()
    if (result.status === 400) {
      console.log('incorrect credentials')
      // USE A VARIABLE IN THE STORE TO SET THE ERROR AND DISPLAY WHERE REQUIRED
    } else {
      userDetails.set(result)
      userLoggedIn.set(true)
      push('/profile')
    }
  } catch (e) {
    console.error({ e })
  }
}

export const newUser = async (data): Promise<void> => {
  try {
    const newUserCall = await fetch(`${ApiRoutesUsers.BASE}${ApiRoutesUsers.NEW_USER}`, { method: 'POST', headers: { 'Content-Type': 'application/json' }, mode: 'cors', body: JSON.stringify(data) })
    const result = await newUserCall.json()
    if (result.status === 400){
      console.log(result.message)
    } else {
      userDetails.set(result)
      userLoggedIn.set(true)
      push('/profile')
    }
  } catch (e) {
    console.error({ e })
  }
}