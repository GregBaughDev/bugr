<script lang="ts">
  import { userDetails } from '../../state/userStore'
  import { States, UserType } from '../../types/types'
  
  const { email, location, username, aboutBug, state, userType, userId } = $userDetails
  
  let isEdit = false
  let isSubmittable = false

  const profileValues = {
    profileEmail: email,
    profileLocation: location,
    profileState: state,
    profileUserType: userType,
    profileAboutBug: aboutBug
  }

  const onSubmit = (): void => {
    console.log({ profileValues })
  }

  $: Object.values(profileValues).some((item) => item === '') ? isSubmittable = false : isSubmittable = true
</script>

<div class="w-10/12 p-4">
  <h2>Profile</h2>
  <h3>Username: {username}</h3>
  <!--CLIENT SIDE VALIDATION-->
  {#if isEdit}
    <form class="flex flex-col">
      <div class="mb-1">
        <label for="email">Email:</label>
        <input type="email" name="email" class="bg-[#e0e0e2] p-2" required bind:value={profileValues.profileEmail}>
      </div>
      <div class="mb-1">
        <label for="location">Location:</label>
        <input type="text" name="location" class="bg-[#e0e0e2] p-2" required bind:value={profileValues.profileLocation}>
      </div>
      <div class="mb-1">
        <label for="state">State:</label>
        <select name="state" class="bg-[#e0e0e2] p-2 text-[#240465]" bind:value={profileValues.profileState}>
          {#each Object.values(States) as state}
            <option value={state}>{state}</option>
          {/each}
        </select>
      </div>
      <div class="mb-1">
        <label for="userType">User type:</label>
        <select name="userType" class="bg-[#e0e0e2] p-2 text-[#240465]" bind:value={profileValues.profileUserType}>
          {#each Object.entries(UserType) as [key, value]}
            <option value={key}>{value}</option>
          {/each}
        </select>
      </div>
      <div class="mb-1 flex flex-col w-1/2">
        <label for="aboutBug">About:</label>
        <textarea class="resize-none bg-[#e0e0e2] p-2 text-[#240465]" bind:value={profileValues.profileAboutBug}></textarea>
      </div>
    </form>
    {#if !isSubmittable}
      <h3>All fields must be complete</h3>
    {/if}
    <button type="submit" class="border-2 p-3 border-[#240465] mt-3 w-1/2" on:click={onSubmit} disabled={!isSubmittable}>Submit</button>
    <button type="submit" class="border-2 p-3 border-[#240465] mt-3" on:click={() => window.alert("Change password: TO DO")}>Change password</button>
  {:else}
    <h3>Email: {email}</h3>
    <h3>Location: {location}</h3>
    <h3>State: {state}</h3>
    <h3>User type: {userType}</h3>
    <h3>About: {aboutBug}</h3>
  {/if}
  <!--BELOW - RESET VALUES IF NOT SUBMITTED AND CLICKED-->
  <button type="submit" class="border-2 p-3 border-[#240465] mt-3" on:click={() => isEdit = !isEdit}>{isEdit ? "Cancel" : "Edit"}</button>
</div>

