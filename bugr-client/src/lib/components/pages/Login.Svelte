<script lang="ts">
  import { userLogin } from '../../../api/users'
  // BIND VARIABLES TO THE FORM AND SUBMIT
</script>
<!-- LOGIN FUNCTION -->
<!-- CHECK IF DATA NEEDS TO SANITISED -->
<h2>Login</h2>

<div class='flex flex-col w-full items-center mt-8'>
  <form method='post' class='w-2/3'>
    <div class='mb-4 flex justify-between w-full items-center'>
      <label for='username'>Username</label>
      <input type='text' name='username' id='username' class='p-2 w-2/3' required>
    </div>
    <div class='mb-6 flex justify-between w-full items-center'>
      <label for='password'>Password</label>
      <input type='password' name='password' id='password' class='p-2 w-2/3' required>
    </div>
    <div class='flex items-center justify-center w-full'>
      <button type='submit' class='border-white border-2 p-4 rounded-xl w-1/3 font-bold'>Log in</button>
    </div>
  </form>
  <!-- SIGN UP FLOW -->
</div>