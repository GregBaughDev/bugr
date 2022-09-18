<script lang="ts">
  import { userLogin } from '../../../api/users'
  import { logInError, logInErrorMessage } from '../../state/formStore'

  let isSubmitDisabled: boolean = true
  const userInfo: {username: string, password: string} = {
    username: '',
    password: ''
  }
  
  $: if (userInfo.username.length > 0 && userInfo.password.length > 0) {
    isSubmitDisabled = false
  } else {
    isSubmitDisabled = true
  }

  const handleSubmit = (): void => {
    userLogin({ username: userInfo.username, password: userInfo.password})
  }
</script>

<div class="w-10/12 p-4">
  <h2>Login</h2>
  <div class='flex flex-col w-full items-center mt-8'>
    <div class="my-6 h-6">
      {#key $logInError}
        {#if $logInError}
          <h2>{$logInErrorMessage}</h2>
        {/if}
      {/key}
    </div>
    <form class='w-2/3'>
      <div class='mb-4 flex justify-between w-full items-center'>
        <label for='username'>Username</label>
        <input type='text' name='username' id='username' class='p-2 w-2/3 border-[#240465] border-2' bind:value={userInfo.username}>
      </div>
      <div class='mb-6 flex justify-between w-full items-center'>
        <label for='password'>Password</label>
        <input type='password' name='password' id='password' class='p-2 w-2/3 border-[#240465] border-2' bind:value={userInfo.password}>
      </div>
      <div class='flex items-center justify-center w-full'>
        <button type='button' class={'bg-slate-700 border-2 p-4 w-1/3 font-bold border-[#240465] text-[#240465]'} on:click={handleSubmit} disabled={isSubmitDisabled}>Log in<br/>Is the button active -> {!isSubmitDisabled}</button>
      </div>
    </form>
  </div>
  <div class="mt-6 text-center">
    <h3>New user? Sign up <a href="#/signup" class="underline">here</a></h3>
  </div>
</div>