package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.MessageRepository
import com.bugr.api.bugrapi.models.Chat
import com.bugr.api.bugrapi.models.Message
import com.bugr.api.bugrapi.models.exceptions.InvalidInputException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class MessageService(private val messageRepository: MessageRepository) {
    @Autowired
    lateinit var chatService: ChatService

    fun getMessages(userId: Int): MutableList<List<Message>> {
        val userMessages: MutableList<List<Message>> = mutableListOf()
        val userChats: Optional<List<Chat>> = chatService.getAllChatsForUser(userId)

        if (userChats.get().isNotEmpty()) {
            userChats.get().forEach {
                userMessages.add(messageRepository.getAllChatMessages(it.chatId))
            }
        }
        return userMessages
    }

    fun postMessage(message: Message) {
        // LOOK INTO THE BELOW - Exception not being thrown
        if (message.message.isEmpty()) throw InvalidInputException()
        // TO DO: Look into issue where opened is always stored as true
        if (message.chatId?.toString().isNullOrBlank()) {
            val chatId: Optional<Int> = chatService.getChatForUserAndRecipient(message.toUser, message.fromUser)
            if (chatId.isPresent) {
                message.chatId = chatId.get()
            } else {
                val newChatId = chatService.createNewChatForUserAndRecipient(message.toUser, message.fromUser)
                message.chatId = newChatId
            }
        }
        return messageRepository.saveUserMessage(message.chatId as Int, message.fromUser, message.toUser, message.message)
    }

    fun updateMessageOpened(messageId: Int) {
        return messageRepository.updateMessageOpened(messageId)
    }
        // ADD LOGGING TO THIS APP
}