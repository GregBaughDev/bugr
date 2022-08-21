import { writable } from "svelte/store";
import type { Writable } from "svelte/store";
import type { User } from "../types/types";

export const userDetails: Writable<User> = writable()