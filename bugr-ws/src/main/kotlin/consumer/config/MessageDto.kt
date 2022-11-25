package consumer.config

import com.fasterxml.jackson.annotation.JsonProperty

data class MessageDto(@JsonProperty("userId") val userId: String, @JsonProperty("chatId") val chatId: String)