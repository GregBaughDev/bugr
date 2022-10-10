import { push } from "svelte-spa-router"
import { ApiRoutes } from "./types"
import { userDetails } from "../lib/state/userStore"
import { userLoggedIn } from "../lib/state/globalStore"
import { logInError, logInErrorMessage } from "../lib/state/formStore"

export const userLogin = async (data): Promise<void> => {
  logInError.set(false)
  logInErrorMessage.set('')
  try {
    const loginCall = await fetch(
      `${ApiRoutes.BASE}${ApiRoutes.USERS.LOGIN}`, 
      { 
        method: 'POST', 
        headers: { 
          'Content-Type': 'application/json' 
        }, 
        mode: 'cors', 
        body: JSON.stringify(data) 
      }
    )
    const result = await loginCall.json()
    if (result.status === 400) {
      logInError.set(true)
      logInErrorMessage.set(result.message)
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
    const newUserCall = await fetch(
      `${ApiRoutes.BASE}${ApiRoutes.USERS.NEW_USER}`, 
      { 
        method: 'POST', 
        headers: { 
          'Content-Type': 'application/json' 
        }, 
        mode: 'cors', 
        body: JSON.stringify(data) 
      }
    )
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