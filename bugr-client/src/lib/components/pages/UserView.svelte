<script lang='ts'>
  import type { User } from "../../types/types";
  import { pop, querystring, location } from "svelte-spa-router";
  import { onMount } from "svelte";
  import { findUserById } from "../../../api/users";
  // Find user details and display in the page
  // Grab the userId from the url and search by api
  // Add a back button to UserView and find out how we access the back functionality from the router
  export let params = { id: undefined}
  // Better type for the below
  let userView: Promise<User> = findUserById(params.id)

  onMount(() => {
    userView = findUserById(params.id)
  })
  console.log({ $querystring, $location, params })
  console.log({ userView })
</script>

<div class="w-10/12 p-4">
  <h3 on:click={() => pop()}>Back</h3>
  {#await userView}
    <h2>Loading</h2>
  {:then userData} 
    <h2>User data is loaded</h2>
    <h3>{userData.username}</h3>
  {/await}
</div>