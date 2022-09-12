<script lang="ts">
  import { userLogin } from '../../../api/users'

  const userInfo: {username: string, password: string} = {
    username: undefined,
    password: undefined
  }

  const handleSubmit = (): void => {
    userLogin({ username: userInfo.username, password: userInfo.password})
  }
</script>
<!-- TODO: INCORRECT CREDENTIALS DISPLAY -->
<!-- TODO: ADD REQUIRED FIELDS CHECKS -->
<!-- CHECK IF DATA NEEDS TO SANITISED -->
<!-- validate the form inputs -->
<div class="w-10/12 p-4">
  <h2>Login</h2>
  <div class='flex flex-col w-full items-center mt-8'>
    <form class='w-2/3'>
      <div class='mb-4 flex justify-between w-full items-center'>
        <label for='username'>Username</label>
        <input type='text' name='username' id='username' class='p-2 w-2/3' bind:value={userInfo.username}>
      </div>
      <div class='mb-6 flex justify-between w-full items-center'>
        <label for='password'>Password</label>
        <input type='password' name='password' id='password' class='p-2 w-2/3' bind:value={userInfo.password}>
      </div>
      <div class='flex items-center justify-center w-full'>
        <button type='button' class='border-white border-2 p-4 rounded-xl w-1/3 font-bold' on:click={handleSubmit}>Log in</button>
      </div>
    </form>
  </div>
  <div class="mt-6 text-center">
    <h3>New user? Sign up <a href="#/signup" class="underline">here</a></h3>
  </div>
</div>