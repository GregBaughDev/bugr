<script lang='ts'>
  import { findUsers } from "../../../api/users";
  import { States, type StatesValues } from "../../types/types";
  import type { User } from "../../types/types";

  // be able to click on a user page and display their user page show dates and reviews
  let state: string;
  let userSearch: User[] = []

  const handleSearch = async (): Promise<void> => {
    userSearch = await findUsers(state as StatesValues)
  }
</script>

<div class="w-10/12 p-4">
  <h2>Search</h2>
  <h3>Find users by state</h3>
  <div class="mt-2 flex justify-center flex-col">
    <div>
      <select name="location" id="location-search" class="border-2  border-[#240465] p-3 w-full" bind:value={state}>
        <option value="">Please select a state from the dropdown:</option>
        {#each Object.values(States) as state}
          <option value={state}>{state}</option>
        {/each}
      </select>
    </div>
    <button type="submit" class="border-2 p-3 border-[#240465] mt-3" on:click={handleSearch} disabled={!state}>Search</button>
  </div>
  {#if userSearch.length > 0}
    <h2 class="text-center">All users in {state}</h2>
    {#each userSearch as user}
      <div class="border-2 p-3 mt-3 border-[#240465]">
        <p>User: {user.username}</p>
        <p>Type: {user.userType.toLowerCase()}</p>
        <p>Location: {user.location}</p>
        <p>About: {user.aboutBug}</p>
      </div>
    {/each}
  {:else if state !== ''}
    <p2>No results</p2>
  {/if}
</div>