<script lang='ts'>
  import { findUsersByState } from "../../../api/users";
  import { States, type StatesValues } from "../../types/types";
  import type { User } from "../../types/types";
  import { link } from "svelte-spa-router";

  let searchState: string;
  let currentState: string;
  // Better type for the below
  let userSearch: User[] = []

  const handleSearch = async (): Promise<void> => {
    userSearch = await findUsersByState(searchState as StatesValues)
    currentState = searchState
  }
</script>

<div class="w-10/12 p-4">
  <h2>Search</h2>
  <h3>Find users by state</h3>
  <div class="mt-2 flex justify-center flex-col">
    <div>
      <select name="location" id="location-search" class="border-2  border-[#240465] p-3 w-full" bind:value={searchState}>
        <option value="">Please select a state from the dropdown:</option>
        {#each Object.values(States) as state}
          <option value={state}>{state}</option>
        {/each}
      </select>
    </div>
    <button type="submit" class="border-2 p-3 border-[#240465] mt-3" on:click={handleSearch} disabled={!searchState}>Search</button>
  </div>
  <div class="mt-2">
    {#if userSearch.length > 0}
      <h2 class="text-center">All users in {currentState}</h2>
      {#each userSearch as user}
        <!-- svelte-ignore a11y-missing-attribute -->
        <a use:link={{ href:`/UserView/${user.userId}?${currentState}` }}>
          <div class="border-2 p-3 mt-3 border-[#240465]">
            <p>User: {user.username}</p>
            <p>Type: {user.userType.toLowerCase()}</p>
            <p>Location: {user.location}</p>
            <p>About: {user.aboutBug}</p>
          </div>
        </a>
      {/each}
    {:else if userSearch.length === 0 && currentState !== undefined}
      <h2 class="text-center">No results</h2>
    {/if}
  </div>
</div>