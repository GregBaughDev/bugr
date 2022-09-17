import { writable } from "svelte/store"
import type { Writable } from "svelte/store"

export const logInError: Writable<boolean> = writable(false)
export const logInErrorMessage: Writable<string> = writable('')

export const signUpError: Writable<boolean> = writable(false)
export const signUpErrorMessage: Writable<object> = writable({
    username: '',
    password: '',
    email: '',
    location: '',
    about: ''
})