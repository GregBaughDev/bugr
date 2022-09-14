<script lang="ts">
  import { States, UserType } from '../../types/types'
  import type { User } from '../../types/types'
  import { newUser } from '../../../api/users'
  
  const newUserForm: User = {
    username: '',
    password: '',
    email: '',
    location: '',
    state: undefined,
    userType: undefined,
    aboutBug: ''
  }

  const handleSubmit = (): void => {
    newUser({ ...newUserForm })
  }
</script>
<!-- TODO: ADD REQUIRED FIELDS CHECKS -->
<div class="w-10/12 p-4">
  <h2>Sign up</h2>
  <form class="flex flex-col w-full items-center mt-8">
    <div class="mt-4 flex justify-between w-full items-center">
      <label for="username">Enter a username:</label>
      <input type="text" name="username" id="username" class="w-2/3 p-2 border-[#240465] border-2" bind:value={newUserForm.username}>
    </div>
    <div class="mt-2 flex justify-between w-full items-center">
      <label for="password">Enter a password:</label>
      <input type="password" name="password" id="password" class="w-2/3 p-2 border-[#240465] border-2" bind:value={newUserForm.password}>
    </div>
    <div class="mt-2 flex justify-between w-full items-center">
      <label for="email">Enter your email:</label>
      <input type="email" name="email" id="email" class="w-2/3 p-2 border-[#240465] border-2" bind:value={newUserForm.email}>
    </div>
    <div class="mt-2 flex justify-between w-full items-center">
      <label for="location">Enter your location:</label>
      <input type="text" name="location" id="location" class="w-2/3 p-2 border-[#240465] border-2" bind:value={newUserForm.location}>
    </div>
    <div class="mt-2 flex justify-between w-full items-center">
      <label for="state">Select your state:</label>
      <select name="state" id="state" class="w-2/3 p-2 border-[#240465] border-2" bind:value={newUserForm.state}>
        {#each Object.values(States) as state}
          <option value={state}>{state}</option>
        {/each}
      </select>
    </div>
    <div class="mt-2 flex justify-between w-full items-center">
      <label for="userType">User type:</label>
      <select name="userType" id="userType"class="w-2/3 p-2 border-[#240465] border-2" bind:value={newUserForm.userType}>
        {#each Object.entries(UserType) as [key, value]}
          <option value={key}>{value}</option>
        {/each}
      </select>
    </div>
    <div class="mt-2 flex justify-between w-full items-center">
      <label for="about">About:</label>
      <textarea id="about" name="about" class="w-2/3 resize-none p-2 border-[#240465] border-2" bind:value={newUserForm.aboutBug}></textarea>
    </div>
    <div class="mt-4 flex items-center justify-center w-full">
      <button type="button" class="border-2 p-4 rounded-xl w-1/3 font-bold border-[#240465] text-[#240465]" on:click={handleSubmit}>Sign up!</button>
    </div>
  </form>
</div>