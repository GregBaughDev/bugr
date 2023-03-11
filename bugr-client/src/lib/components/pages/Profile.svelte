<script lang="ts">
  import { userDetails } from '../../state/userStore'
  import { States, UserType } from '../../types/types'
  
  const { email, location, username, aboutBug, state, userType, userId } = $userDetails

  const updatedUserDetails: {
    updatedEmail: string,
    updatedLocation: string,
    updatedAboutBug: string,
    updatedState: typeof States,
    updatedUserType: string,
  } = {
    updatedEmail: "" ?? email,
    updatedLocation: "" ?? location,
    updatedAboutBug: "" ?? aboutBug,
    updatedState: state,
    updatedUserType: "" ?? userType,
  }
  
  let isEdit = false
</script>

<div class="w-10/12 p-4">
  <h2>Profile</h2>
  <h3>Username: {username}</h3>
  {#if isEdit}
    <form class="flex flex-col">
      <div class="mb-1">
        <label for="email">Email:</label>
        <input type="email" name="email" class="bg-[#e0e0e2] p-2" value={email} required on:change={e => updatedUserDetails.updatedEmail = (e.target as HTMLInputElement).value}>
      </div>
      <div class="mb-1">
        <label for="location">Location:</label>
        <input type="text" name="location" class="bg-[#e0e0e2] p-2" value={location} required on:change={e => updatedUserDetails.updatedLocation = e.target.value}>
      </div>
      <div class="mb-1">
        <label for="state">State:</label>
        <select name="state" class="bg-[#e0e0e2] p-2 text-[#240465]" >
          {#each Object.values(States) as state}
            <option value={state} on:change={e => updatedUserDetails.updatedState = e.target.value}>{state}</option>
          {/each}
        </select>
      </div>
      <div class="mb-1">
        <label for="userType">User type:</label>
        <select name="userType" class="bg-[#e0e0e2] p-2 text-[#240465]">
          {#each Object.entries(UserType) as [key, value]}
            <option value={key} on:change={e => updatedUserDetails.updatedUserType = e.target.value}>{value}</option>
          {/each}
        </select>
      </div>
      <div class="mb-1 flex flex-col w-1/2">
        <label for="aboutBug">About:</label>
        <textarea class="resize-none bg-[#e0e0e2] p-2 text-[#240465]" value={aboutBug} on:change={e => updatedUserDetails.updatedAboutBug = e.target.value}></textarea>
      </div>
    </form>
    <button type="submit" class="border-2 p-3 border-[#240465] mt-3" on:click={() => console.log({ updatedUserDetails })}>Submit</button>
    <button type="submit" class="border-2 p-3 border-[#240465] mt-3" on:click={() => window.alert("Change password: TO DO")}>Change password</button>
  {:else}
    <h3>Email: {email}</h3>
    <h3>Location: {location}</h3>
    <h3>State: {state}</h3>
    <h3>User type: {userType}</h3>
    <h3>About: {aboutBug}</h3>
  {/if}
  <button type="submit" class="border-2 p-3 border-[#240465] mt-3" on:click={() => isEdit = !isEdit}>{isEdit ? "Cancel" : "Edit"}</button>
</div>

