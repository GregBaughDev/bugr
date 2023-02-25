<script lang="ts">
  import { onDestroy, onMount } from "svelte"
  import { getUserMessages, sendUserMessage, updateMessageRead } from "../../../../api/messages"
  import { deleteChat } from "../../../../api/chats"
  import { userMessages } from "../../../state/globalStore"
  import { userDetails } from "../../../state/userStore"
  import { clsx } from 'clsx'
  import MessagesInformation from "./MessagesInformation.svelte";
  import MessagesController from "./MessagesController.svelte";

  onMount(async () => {
    await getUserMessages($userDetails.userId.toString())
  })

  const messageInterval = setInterval( async () => {
    await getUserMessages($userDetails.userId.toString())
  }, 60000)

  onDestroy(() => {
    clearInterval(messageInterval)
  })

  let openMessage: number
  let fromUser: number
  let replyAreaActive: boolean
  let replyMessage: string
  console.log({ fromUser })
  const currentMessage = (chatId: number | undefined): void => {
    openMessage = chatId
  }
  const toggleReplyArea = (): boolean => replyAreaActive = !replyAreaActive
  const handleReplySubmit = async (chatId: number): Promise<void> => {
    // There's an issue here where the touser and fromuser are the same
    await sendUserMessage({
      chatId: chatId.toString(),
      fromUser: $userDetails.userId.toString(),
      toUser: fromUser.toString(),
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
    if (window.confirm('Are you sure you wish to delete this chat')) {
      await deleteChat(chatId.toString())
      await getUserMessages($userDetails.userId.toString())
    }
  }

  const props = {
    userId: $userDetails.userId,
    openMessage: handleOpenMessage,
    currentMessage: currentMessage,
    handleMessageSwitchOrClose: handleMessageSwitchOrClose,
    toggleReplyArea: toggleReplyArea,
    handleAlertUser: handleAlertUser,
    fromUser: fromUser
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
    {#if $userMessages?.length > 0}
      {#each $userMessages as chat}
        <MessagesInformation chatProps={chat} {...props} />
        {#if openMessage !== undefined && openMessage === chat[0].chatId}
          {#if openMessage === chat[0].chatId}
            <!-- <div class="flex flex-row p-2 w-1/2 justify-between">
              <div class="w-1/3 hover:bg-[#e0e0e2] cursor-pointer font-bold text-left" on:click={() => {currentMessage(undefined); handleMessageSwitchOrClose()}}>Close</div>
              <div class="w-1/3 hover:bg-[#e0e0e2] cursor-pointer text-center font-bold" on:click={() => {toggleReplyArea(); fromUser = chat[0].toUser === $userDetails.userId ? chat[0].fromUser : chat[0].toUser}}>Reply</div>
              <div class="w-1/3 hover:bg-[#e0e0e2] cursor-pointer font-bold text-right" on:click={() => handleAlertUser(chat[0].chatId)}>Delete</div>
            </div> -->
            <!-- TO DO: messages are now being ordered by user -->
            <MessagesController chat={chat[0]} {...props} />
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
                <button class="border-[#240465] border-2 p-2 mt-1 font-bold" on:click={() => {handleReplySubmit(openMessage); handleMessageSwitchOrClose()}} disabled={replyMessage === undefined}>Send</button>
              </div>
            {/if}
          </div>
        {/if}
      {/each}
    {/if}
  </div>
</div>
