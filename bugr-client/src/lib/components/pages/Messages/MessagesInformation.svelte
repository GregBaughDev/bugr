<script lang="ts">
  import clsx from "clsx";
  import type { GetMessages } from "../../../../api/types";

  export let chatProps: GetMessages[]
  export let userId: number
  export let openMessage: (chatId: number, messageId: number, opened: boolean) => Promise<void>
</script>

<div class={clsx("w-full border-t-2 h-1/5 border-[#240465] flex flex-row cursor-pointer hover:bg-[#e0e0e2]", !chatProps[chatProps.length - 1].opened && 'bg-[#e0e0e2] font-bold')} on:click={() => {openMessage(chatProps[0].chatId, chatProps[chatProps.length - 1].messageId, chatProps[chatProps.length - 1].opened)}}>
  <div class="p-2 w-1/5">{chatProps[chatProps.length - 1].fromUser === userId ? "You" : chatProps[chatProps.length - 1].username}</div>
  <div class="p-2 w-1/5">{new Date(chatProps[chatProps.length - 1].messageDate.substring(0, 10)).toLocaleDateString('en-AU')}</div>
  <div class="p-2 w-1/5">{chatProps[chatProps.length - 1].message}</div>
</div> 