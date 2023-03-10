<script lang="ts">
  import { onDestroy, onMount } from "svelte"
  import { getUserMessages, sendUserMessage, updateMessageRead } from "../../../../api/messages"
  import { deleteChat } from "../../../../api/chats"
  import { userMessages } from "../../../state/globalStore"
  import { userDetails } from "../../../state/userStore"
  import MessagesInformation from "./MessagesInformation.svelte";
  import MessagesController from "./MessagesController.svelte";
  import Message from "./Message.svelte";
  import MessageReplyArea from "./MessageReplyArea.svelte";

  onMount(async () => {
    await getUserMessages($userDetails.userId.toString())
  })

  const messageInterval = setInterval( async () => {
    await getUserMessages($userDetails.userId.toString())
  }, 60000)

  onDestroy(() => {
    clearInterval(messageInterval)
  })

  let fromUser: number
  const setFromUser = (from: number) => fromUser = from
  
  let openMessage: number
  let replyAreaActive: boolean
  
  const currentMessage = (chatId: number | undefined): void => {
    openMessage = chatId
  }
  
  const toggleReplyArea = (): boolean => replyAreaActive = !replyAreaActive
  
  const handleReplySubmit = async (chatId: number, replyMessage: string): Promise<void> => {
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
  }
  const handleAlertUser = async (chatId: number): Promise<void> => {
    if (window.confirm('Are you sure you wish to delete this chat')) {
      await deleteChat(chatId.toString())
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
    {#if $userMessages?.length > 0}
      {#each $userMessages as chat}
      <!--Need to update UI when props change-->
        <MessagesInformation chats={chat} openMessage={handleOpenMessage} />
        {#if openMessage !== undefined && openMessage === chat[0].chatId}
          {#if openMessage === chat[0].chatId}
            <MessagesController 
              chat={chat[0]}
              userId={$userDetails.userId}
              currentMessage={currentMessage}
              handleMessageSwitchOrClose={handleMessageSwitchOrClose}
              toggleReplyArea={toggleReplyArea}
              setFromUser={setFromUser}
              handleAlertUser={handleAlertUser}
            />
          {/if}
          <div class="w-full flex flex-col p-2 max-h-[400px] overflow-scroll">
            {#each chat as message}
              <Message message={message} userId={$userDetails.userId} />
            {/each}
            {#if replyAreaActive}
              <MessageReplyArea handleReplySubmit={handleReplySubmit} handleMessageSwitchOrClose={handleMessageSwitchOrClose} openMessage={openMessage} />
            {/if}
          </div>
        {/if}
      {/each}
    {/if}
  </div>
</div>
