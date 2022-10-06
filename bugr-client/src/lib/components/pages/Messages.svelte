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

  let openMessage: number
  console.log({openMessage})
  const currentMessage = (messageId: number | undefined): void => {
    console.log("You clicked " + messageId)
    openMessage = messageId
  }
</script>

<div class="w-10/12 p-4 h-full">
  <h2>Messages</h2>
  <div class="border-2 w-full h-full border-[#240465]">
    <div class="flex flex-row border-b-2 border-[#240465]">
      <div class="p-2 w-1/5">From</div>
      <div class="p-2 w-1/5">Date</div>
      <div class="p-2 w-3/5">Message</div>
    </div>
    {#each $userMessages as chat}
      <div class="w-full border-t-2 h-1/5 border-[#240465] flex flex-row cursor-pointer hover:bg-[#e0e0e2]" on:click={() => currentMessage(chat[0].chatId)}>
        <div class="p-2 w-1/5">{chat[0].fromUser === $userDetails.userId ? "You" : chat[0].fromUser}</div>
        <div class="p-2 w-1/5">{new Date(chat[0].messageDate.substring(0, 10)).toLocaleDateString('en-AU')}</div>
        <div class="p-2 w-1/5">{chat[0].message}</div>
      </div> 
      {#if openMessage !== undefined && openMessage === chat[0].chatId}
        <div class="p-2 w-full flex flex-col">
          {#if openMessage === chat[0].chatId}
            <div class="p-2 w-2/5" on:click={() => currentMessage(undefined)}>Close</div>
            <!-- STYLING ON HOVER FOR THE ABOVE AND MOVE -->
          {/if}
          {#each chat as message}
            <div class="flex flex-row">
              <div class="w-1/3 justify-end">{message.username}</div>
            </div>
            <div class="flex flex-col py-2">
              <h4>{message.message}</h4>
            </div>
          {/each}
        </div>
      {/if}
    {/each}
  </div>
</div>
