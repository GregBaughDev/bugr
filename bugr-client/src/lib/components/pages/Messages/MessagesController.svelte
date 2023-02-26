<script lang="ts">
  import type { GetMessages } from "src/api/types";

  export let userId: number
  export let chat: GetMessages
  export let currentMessage: (chatId: number | undefined) => void
  export let handleMessageSwitchOrClose: () => void
  export let toggleReplyArea: () => boolean
  export let setFromUser: (fromUser: number) => void
  export let handleAlertUser: (chatId: number) => Promise<void>
</script>

<div class="flex flex-row p-2 w-1/2 justify-between">
  <div class="w-1/3 hover:bg-[#e0e0e2] cursor-pointer font-bold text-left" on:click={() => {currentMessage(undefined); handleMessageSwitchOrClose()}}>Close</div>
  <div class="w-1/3 hover:bg-[#e0e0e2] cursor-pointer text-center font-bold" on:click={() => {toggleReplyArea(); setFromUser(chat.toUser === userId ? chat.fromUser : chat.toUser)}}>Reply</div>
  <div class="w-1/3 hover:bg-[#e0e0e2] cursor-pointer font-bold text-right" on:click={() => handleAlertUser(chat.chatId)}>Delete</div>
</div>
