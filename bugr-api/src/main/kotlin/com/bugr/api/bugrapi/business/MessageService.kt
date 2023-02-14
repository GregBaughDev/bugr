package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.MessageRepository
import com.bugr.api.bugrapi.models.Chat
import com.bugr.api.bugrapi.models.Messages
import com.bugr.api.bugrapi.models.exceptions.InvalidInputException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class MessageService(private val messageRepository: MessageRepository) {
    @Autowired
    lateinit var chatService: ChatService

    fun getMessages(userId: Int): MutableList<List<Messages>> {
        val userMessages: MutableList<List<Messages>> = mutableListOf();
        val userChats: Optional<List<Chat>> = chatService.getAllChatsForUser(userId);

        if (userChats.get().isNotEmpty()) {
            userChats.get().forEach {
                userMessages.add(messageRepository.getAllChatMessages(it.chatId))
            }
        }
        return userMessages
    }

    fun postMessage(message: Messages) {
        if (message.message.isEmpty()) throw InvalidInputException()
        return messageRepository.saveUserMessage(message.chatId, message.fromUser, message.toUser, message.message)
    }

    fun updateMessageOpened(messageId: Int) {
        return messageRepository.updateMessageOpened(messageId)
    }
        // ADD LOGGING TO THIS APP
}