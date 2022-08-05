import { writable } from 'svelte/store'
import type { Writable } from 'svelte/store';
import { NavLinks } from '../types/types'

export const currentPage: Writable<NavLinks> = writable(NavLinks.Home)
