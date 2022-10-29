package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.MessageRepository
import com.bugr.api.bugrapi.models.Messages
import com.bugr.api.bugrapi.models.exceptions.InvalidInputException
import org.springframework.stereotype.Service

@Service
class MessageService(private val messageRepository: MessageRepository) {

    fun getMessages(userId: Int): MutableList<List<Messages>> {
        val userChats: MutableList<List<Messages>> = arrayListOf()
        val userChatsString: String = messageRepository.getUserChats(userId)
        val userChatsArray: List<String> = userChatsString.split(',')
        if (userChatsArray[0].isNotEmpty()) {
            userChatsArray.forEach() { userChats.add(messageRepository.getAllChatMessages(it.toInt())) }
        }
        return userChats
    }

    fun postMessage(message: Messages): Unit {
        if (message.message.isEmpty()) throw InvalidInputException()
        return messageRepository.saveUserMessage(message.chatId, message.fromUser, message.toUser, message.message)
    }
}