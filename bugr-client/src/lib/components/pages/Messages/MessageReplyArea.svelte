<script lang="ts">
  let replyMessage: string
  export let handleReplySubmit: (chatId: number, replyMessage: string) => Promise<void>
  export let handleMessageSwitchOrClose: () => void
  export let openMessage: number
</script>

<div class="flex justify-between flex-col w-1/2">
  <textarea class="border-[#240465] border-2 resize-none p-2" placeholder="Enter your reply..." bind:value={replyMessage}></textarea>
  <button class="border-[#240465] border-2 p-2 mt-1 font-bold" on:click={() => {handleReplySubmit(openMessage, replyMessage); handleMessageSwitchOrClose(); replyMessage = ''}} disabled={replyMessage === undefined}>Send</button>
</div>