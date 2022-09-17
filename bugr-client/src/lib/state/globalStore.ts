import { writable } from 'svelte/store'
import type { Writable } from 'svelte/store'
// LOOK INTO JWTs
export const userLoggedIn: Writable<boolean> = writable(false)
