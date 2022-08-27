import { writable } from 'svelte/store'
import type { Writable } from 'svelte/store';

export const userLoggedIn: Writable<boolean> = writable(false)
