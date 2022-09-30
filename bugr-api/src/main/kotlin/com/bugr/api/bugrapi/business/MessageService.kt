package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.MessageRepository
import com.bugr.api.bugrapi.models.Messages
import com.bugr.api.bugrapi.models.UserChats
import com.bugr.api.bugrapi.models.exceptions.InvalidInputException
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(private val messageRepository: MessageRepository) {

    fun getMessages(userId: Int): List<UserChats> {
        // UPDATE USERS TABLE TO INCLUDE CHATS ARRAY
        // GRAB ALL CHATS AND FOR EACH ONE GRAB THE CHATS FROM CHAT ID
        // RESHAPE INTO NEW FORMAT
        var userChats: List<Messages> = emptyList()
        var userMessages: List<UserChats> = emptyList()
        val userChatsString: String = messageRepository.getUserChats(userId)
        val userChatsArray: List<String> = userChatsString.split(',')
        // REMOVE CUSTOM TYPES AS NOT REQUIRED // SHRUG
        // SORT OUT THE SHAPE OF THE OBJECT
        if (userChatsArray.isNotEmpty()) {
            for (chat in userChatsArray) {
                userChats = messageRepository.getAllChatMessages(chat.toInt())
            }
            userMessages = userChats.map { mapToChats(it) }
        }
        return userMessages
    }

    fun postMessage(message: Messages): Messages {
        if (message.message.isEmpty()) throw InvalidInputException()

        return messageRepository.save(message)
    }

    private fun mapToChats(messages: Messages): UserChats {
        return UserChats(messages.username, messages.chatId, messages)
    }

}