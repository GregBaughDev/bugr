<script lang='ts'>
  import type { User } from "../../types/types";
  import { querystring, link } from "svelte-spa-router";
  import { onMount } from "svelte";
  import { findUserById } from "../../../api/users";
  import { sentenceCase } from "../../utils/stringUtils";
  import { userDetails } from "../../state/userStore";
  import { sendUserMessage } from "../../../api/messages";

  export let params = { id: undefined }
  // Better type for the below
  let userView: Promise<User> = findUserById(params.id)
  let userMessage: string

  onMount(() => {
    userView = findUserById(params.id)
  })

  const handleSendMessage = () => {
    sendUserMessage({
      fromUser: $userDetails.userId.toString(),
      toUser: params.id,
      message: userMessage
    })
  }

</script>

<div class="w-10/12 p-4">
  <!-- svelte-ignore a11y-missing-attribute -->
  <a use:link={{ href: `/search?${$querystring}` }}>Back</a>
  {#await userView}
    <h2>Loading</h2>
  {:then userData} 
    <h2>User: {userData.username}</h2>
    <h3>{userData.state}: {userData.location}</h3>
    <h3>Usertype: {sentenceCase(userData.userType)}</h3>
    <p>About: {userData.aboutBug}</p>
    <hr>
    <div class="flex justify-between flex-col w-full">
      <h3 class="text-center p-3 mt-3">Message user</h3>
      <textarea class="border-[#240465] border-2 resize-none p-2" placeholder="Enter your message" bind:value={userMessage}></textarea>
      <button type="submit" class="border-[#240465] border-2 p-2 mt-1 font-bold" on:click={handleSendMessage}>Send</button>
    </div>
  {/await}
</div>