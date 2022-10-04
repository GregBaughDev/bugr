<script lang="ts">
  import { onMount } from "svelte"
  import { getUserMessages } from "../../../api/messages"
  import { userMessages } from "../../../lib/state/globalStore"
  import { userDetails } from "../../../lib/state/userStore"

  // Open websocket and grab all the messages
  // If opened -> post to db
  // Add opened field to messages table
  // Display ability to respond to message
  // 

  onMount(async () => {
    await getUserMessages($userDetails.userId)
  })
  console.log({$userMessages})
  // Not working - look into subscribe to the store
</script>

<div class="w-10/12 p-4 h-full">
  <h2>Messages</h2>
  <div class="border-t-2 w-full h-full border-[#240465]">
    <div class="flex flex-row border-b-2 border-[#240465]">
      <div class="p-2 w-1/5">From</div>
      <div class="p-2 w-1/5">Date</div>
      <div class="p-2 w-3/5">Message</div>
    </div>
    <!-- loop through the messages and display here -->
    <!-- <div class="w-full border-b-2 h-1/5 border-[#240465] flex flex-row cursor-pointer hover:bg-[#e0e0e2]" on:click={(e) => console.log(e)}>
      <div class="p-2 w-1/5">TestUser</div>
      <div class="p-2 w-1/5">23.09.21</div>
      <div class="p-2 w-3/5">Hi there! I'd love to look after your bug</div>
    </div>
    <div class="w-full border-b-2 h-1/5 border-[#240465] flex flex-row cursor-pointer hover:bg-[#e0e0e2]">
      <div class="p-2 w-1/5">TestUser</div>
      <div class="p-2 w-1/5">23.09.21</div>
      <div class="p-2 w-3/5">Hi there! I'd love to look after your bug</div>
    </div> -->
    {#each $userMessages as message}
      <div class="w-full border-b-2 h-1/5 border-[#240465] flex flex-row cursor-pointer hover:bg-[#e0e0e2]">
        <div class="p-2 w-1/5">{message[0].fromUser}</div>
        <div class="p-2 w-1/5">{message[0].messageDate}</div>
        <div class="p-2 w-1/5">{message[0].message}</div>
      </div>
    {/each}
  </div>
</div>
<!-- Display message box at the bottom and allow user to reply -->