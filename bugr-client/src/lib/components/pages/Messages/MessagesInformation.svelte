<script lang="ts">
  import clsx from "clsx";
  import type { GetMessages } from "../../../../api/types"
  import { userDetails } from "../../../state/userStore"

  export let chats: GetMessages[]
  export let openMessage: (chatId: number, messageId: number, opened: boolean) => Promise<void>

  const lastChat = chats.length - 1
  const isFromUser = chats[lastChat].fromUser === $userDetails.userId
</script>
<!--ADD CHECK BELOW FOR OPENED AND ALSO IS THE USERID THE SAME??-->
<div class={clsx("w-full border-t-2 h-1/5 border-[#240465] flex flex-row cursor-pointer hover:bg-[#e0e0e2]", !chats[lastChat].opened && !isFromUser && 'bg-[#e0e0e2] font-bold')} on:click={() => {openMessage(chats[0].chatId, chats[lastChat].messageId, chats[lastChat].opened)}}>
  <div class="p-2 w-1/5">{isFromUser ? "You" : chats[lastChat].username}</div>
  <div class="p-2 w-1/5">{new Date(chats[lastChat].messageDate.substring(0, 10)).toLocaleDateString('en-AU')}</div>
  <div class="p-2 w-1/5">{chats[lastChat].message}</div>
</div> 