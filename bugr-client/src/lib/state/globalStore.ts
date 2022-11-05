import { writable } from 'svelte/store'
import type { Writable } from 'svelte/store'
import type { GetMessages } from 'src/api/types'
// LOOK INTO JWTs
export const userLoggedIn: Writable<boolean> = writable(false)

export const userMessages: Writable<GetMessages[][]> = writable([])