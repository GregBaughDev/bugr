<script lang="ts">
  import type { GetMessages } from "src/api/types"
  import clsx from 'clsx'

  export let message: GetMessages
  export let userId: number
</script>

<div class={clsx("flex flex-row justify-between w-1/2 py-1 h-10", message.fromUser === userId && 'bg-[#e0e0e2]')}>
  <div>{message.message}</div>
  <div>{message.username}</div>
</div>