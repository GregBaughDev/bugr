<script lang="ts">
  import { onMount } from "svelte"
  import { deleteChat, getUserMessages, sendUserMessage, updateMessageRead } from "../../../api/messages"
  import { userMessages } from "../../../lib/state/globalStore"
  import { userDetails } from "../../../lib/state/userStore"
  import { clsx } from 'clsx' 

  // Open websocket to check for new messages
  // Cache the messages
  onMount(async () => {
    await getUserMessages($userDetails.userId.toString())
  })

  let openMessage: number
  let toUser: number
  let replyAreaActive: boolean
  let replyMessage: string

  const currentMessage = (chatId: number | undefined): void => {
    openMessage = chatId
  }
  const toggleReplyArea = (): boolean => replyAreaActive = !replyAreaActive
  const handleReplySubmit = async (chatId: number): Promise<void> => {
    await sendUserMessage({
      // @ts-ignore
      chatId: chatId.toString(),
      fromUser: $userDetails.userId.toString(),
      toUser: toUser.toString(),
      message: replyMessage
    })
    await getUserMessages($userDetails.userId.toString())
  }
  const handleOpenMessage = async (chatId: number, messageId: number, opened: boolean): Promise<void> => {
    currentMessage(chatId)
    handleMessageSwitchOrClose()
    if (!opened) {
      await updateMessageRead(messageId.toString())
      await getUserMessages($userDetails.userId.toString())
    }
  }
  const handleMessageSwitchOrClose = (): void => {
    replyAreaActive = false
    replyMessage = undefined
  }
  const handleAlertUser = async (chatId: number): Promise<void> => {
    if (window.confirm('Are you sure you wish to delete this message')) {
      await deleteChat(chatId.toString(), $userDetails.userId.toString())
      await getUserMessages($userDetails.userId.toString())
    }
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
      <div class={clsx("w-full border-t-2 h-1/5 border-[#240465] flex flex-row cursor-pointer hover:bg-[#e0e0e2]", !chat[chat.length - 1].opened && 'bg-[#e0e0e2] font-bold')} on:click={() => {handleOpenMessage(chat[0].chatId, chat[chat.length - 1].messageId, chat[chat.length - 1].opened)}}>
        <div class="p-2 w-1/5">{chat[chat.length - 1].fromUser === $userDetails.userId ? "You" : chat[chat.length - 1].username}</div>
        <div class="p-2 w-1/5">{new Date(chat[chat.length - 1].messageDate.substring(0, 10)).toLocaleDateString('en-AU')}</div>
        <div class="p-2 w-1/5">{chat[chat.length - 1].message}</div>
      </div> 
      {#if openMessage !== undefined && openMessage === chat[0].chatId}
        {#if openMessage === chat[0].chatId}
          <div class="flex flex-row p-2 w-1/2 justify-between">
            <div class="w-1/3 hover:bg-[#e0e0e2] cursor-pointer font-bold text-left" on:click={() => {currentMessage(undefined); handleMessageSwitchOrClose()}}>Close</div>
            <div class="w-1/3 hover:bg-[#e0e0e2] cursor-pointer text-center font-bold" on:click={() => {toggleReplyArea(); toUser = chat[0].toUser}}>Reply</div>
            <div class="w-1/3 hover:bg-[#e0e0e2] cursor-pointer font-bold text-right" on:click={() => handleAlertUser(chat[0].chatId)}>Delete</div>
          </div>
        {/if}
        <div class="w-full flex flex-col p-2 max-h-[400px] overflow-scroll">
          {#each chat as message}
            <div class={clsx("flex flex-row justify-between w-1/2 py-1 h-10", message.fromUser === $userDetails.userId && 'bg-[#e0e0e2]')}>
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
