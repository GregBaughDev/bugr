<script lang="ts">
  import { onMount } from "svelte"
  import { getUserMessages } from "../../../api/messages"
  import { userMessages } from "../../../lib/state/globalStore"
  import { userDetails } from "../../../lib/state/userStore"

  // Open websocket and grab all the messages
  // If opened and new message -> post to db -> need value to check if it has been opened and display NEW next to the message
  // Add opened field to messages table
  // Display ability to respond to message
  // Refresh on send
  // Cache the messages
  onMount(async () => {
    if ($userMessages.length == 0) {
      await getUserMessages($userDetails.userId)
    }
  })

  let openMessage: number
  let replyAreaActive: boolean
  let replyMessage: string

  const currentMessage = (messageId: number | undefined): void => {
    openMessage = messageId
  }
  const toggleReplyArea = (): boolean => replyAreaActive = !replyAreaActive
  const handleReplySubmit = (messageId: number): void => {
    console.log(messageId + "-> response for message")
    console.log({ replyMessage })
    // Submit to DB
    // Refetch messages
  }
  const handleMessageSwitchOrClose = (): void => {
    replyAreaActive = false
    replyMessage = undefined
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
      <div class="w-full border-t-2 h-1/5 border-[#240465] flex flex-row cursor-pointer hover:bg-[#e0e0e2]" on:click={() => {currentMessage(chat[0].chatId); handleMessageSwitchOrClose()}}>
        <div class="p-2 w-1/5">{chat[0].fromUser === $userDetails.userId ? "You" : chat[0].fromUser}</div>
        <div class="p-2 w-1/5">{new Date(chat[0].messageDate.substring(0, 10)).toLocaleDateString('en-AU')}</div>
        <!-- display latest message below -->
        <div class="p-2 w-1/5">{chat[chat.length - 1].message}</div>
      </div> 
      {#if openMessage !== undefined && openMessage === chat[0].chatId}
        <div class="w-full flex flex-col p-2 justify-center">
          {#if openMessage === chat[0].chatId}
            <div class="flex flex-row w-1/2 justify-between">
              <div class="w-2/5 hover:bg-[#e0e0e2] cursor-pointer font-bold" on:click={() => {currentMessage(undefined); handleMessageSwitchOrClose()}}>Close</div>
              <div class="w-2/5 hover:bg-[#e0e0e2] cursor-pointer text-right font-bold" on:click={() => toggleReplyArea()}>Reply</div>
            </div>
          {/if}
          {#each chat as message}
            <div class="flex flex-row justify-between w-1/2 h-10">
              <div>{message.message}</div>
              <div>{message.username}</div>
            </div>
          {/each}
          {#if replyAreaActive}
            <div class="flex justify-between flex-col w-1/2">
              <textarea class="border-[#240465] border-2 resize-none p-2" placeholder="Enter your reply..." bind:value={replyMessage}></textarea>
              <button class="border-[#240465] border-2 p-2 mt-1 font-bold" on:click={() => {handleReplySubmit(openMessage); handleMessageSwitchOrClose()}} disabled={replyMessage == undefined}>Send</button>
            </div>
          {/if}
        </div>
      {/if}
    {/each}
  </div>
</div>
