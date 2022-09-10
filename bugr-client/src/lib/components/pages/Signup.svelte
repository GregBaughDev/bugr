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
  <form>
    <div>
      <label for="username">Enter a username:</label>
      <input type="text" name="username" id="username" bind:value={newUserForm.username}>
    </div>
    <div>
      <label for="password">Enter a password:</label>
      <input type="password" name="password" id="password" bind:value={newUserForm.password}>
    </div>
    <div>
      <label for="email">Enter your email:</label>
      <input type="email" name="email" id="email" bind:value={newUserForm.email}>
    </div>
    <div>
      <label for="location">Enter your location:</label>
      <input type="text" name="location" id="location" bind:value={newUserForm.location}>
    </div>
    <div>
      <label for="state">Select your state:</label>
      <select name="state" id="state" bind:value={newUserForm.state}>
        {#each Object.values(States) as state}
          <option value={state}>{state}</option>
        {/each}
      </select>
    </div>
    <div>
      <label for="userType">User type:</label>
      <select name="userType" id="userType" required bind:value={newUserForm.userType}>
        {#each Object.entries(UserType) as [key, value]}
          <option value={key}>{value}</option>
        {/each}
      </select>
    </div>
    <div>
      <label for="about">About:</label>
      <textarea id="about" name="about" required bind:value={newUserForm.aboutBug}></textarea>
    </div>
    <div>
      <button type="button" on:click={handleSubmit}>Sign up!</button>
    </div>
  </form>
</div>