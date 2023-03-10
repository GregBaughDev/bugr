<script lang="ts">
  import { userDetails } from '../../state/userStore'
  import { States, UserType } from '../../types/types'

  let isEdit = false
</script>

<div class="w-10/12 p-4">
  <h2>Profile</h2>
  <h3>Username: {$userDetails.username}</h3>
  {#if isEdit}
    <form class="flex flex-col">
      <div class="mb-1">
        <label for="email">Email:</label>
        <input type="email" name="email" value={$userDetails.email} class="bg-[#e0e0e2] p-2" required>
      </div>
      <div class="mb-1">
        <label for="location">Location:</label>
        <input type="text" name="location" value={$userDetails.location} class="bg-[#e0e0e2] p-2" required>
      </div>
      <div class="mb-1">
        <label for="state">State:</label>
        <select name="state" class="bg-[#e0e0e2] p-2 text-[#240465]">
          {#each Object.values(States) as state}
            <option value={state}>{state}</option>
          {/each}
        </select>
      </div>
      <div class="mb-1">
        <label for="userType">User type:</label>
        <select name="userType" class="bg-[#e0e0e2] p-2 text-[#240465]">
          {#each Object.entries(UserType) as [key, value]}
            <option value={key}>{value}</option>
          {/each}
        </select>
      </div>
      <div class="mb-1 flex flex-col w-1/2">
        <label for="aboutBug">About:</label>
        <textarea value={$userDetails.aboutBug} class="resize-none bg-[#e0e0e2] p-2 text-[#240465]"></textarea>
      </div>
    </form>
    <button type="submit" class="border-2 p-3 border-[#240465] mt-3">Submit</button>
  {:else}
    <h3>Email: {$userDetails.email}</h3>
    <h3>Location: {$userDetails.location}</h3>
    <h3>State: {$userDetails.state}</h3>
    <h3>User type: {$userDetails.userType}</h3>
    <h3>About: {$userDetails.aboutBug}</h3>
  {/if}
  <button type="submit" class="border-2 p-3 border-[#240465] mt-3" on:click={() => isEdit = !isEdit}>{isEdit ? "Cancel" : "Edit"}</button>
</div>

