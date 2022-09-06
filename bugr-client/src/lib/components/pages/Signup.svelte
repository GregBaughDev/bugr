<script lang="ts">
  import { States, UserType } from '../../types/types'
  import type { StatesValues } from '../../types/types'
  
  const newUser = {
    username: undefined,
    password: undefined,
    email: undefined,
    location: undefined,
    state: undefined,
    userType: undefined,
    about: undefined
  }
</script>

<div class="w-10/12 p-4">
  <h2>Sign up</h2>
  <form>
    <div>
      <label for="username">Enter a username:</label>
      <input type="text" name="username" id="username" required>
    </div>
    <div>
      <label for="password">Enter a password:</label>
      <input type="password" name="password" id="password" required>
    </div>
    <div>
      <label for="email">Enter your email:</label>
      <input type="email" name="email" id="email">
    </div>
    <div>
      <label for="location">Enter your location:</label>
      <input type="text" name="location" id="location" required>
    </div>
    <div>
      <label for="state">Select your state:</label>
      <select name="state" id="state">
        {#each Object.values(States) as state}
          <option value={state}>{state}</option>
        {/each}
      </select>
    </div>
    <div>
      <label for="userType">User type:</label>
      <select name="userType" id="userType">
        {#each Object.entries(UserType) as [key, value]}
          <option value={key}>{value}</option>
        {/each}
      </select>
    </div>
    <div>
      <label for="about">About:</label>
      <textarea id="about" name="about" required></textarea>
    </div>
    <div>
      <button type="button">Sign up!</button>
    </div>
  </form>
</div>