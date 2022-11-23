package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.MessageRepository
import com.bugr.api.bugrapi.models.Messages
import com.bugr.api.bugrapi.models.exceptions.InvalidInputException
import com.bugr.api.bugrapi.producer.MessageDto
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class MessageService(private val messageRepository: MessageRepository, private val kafkaTemplate: KafkaTemplate<String, MessageDto>) {

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
        messageRepository.saveUserMessage(message.chatId, message.fromUser, message.toUser, message.message)
        kafkaTemplate.send("bugr", MessageDto(message.toUser.toString(), message.chatId.toString()))
        return
    }

    fun updateMessageOpened(messageId: Int): Unit {
        return messageRepository.updateMessageOpened(messageId)
    }

    fun deleteChat(chatId: String?, userId: String?): Unit {
        if (chatId != null && userId != null) {
            val chatIdInt = chatId.toInt()
            val userIdInt = userId.toInt()
            messageRepository.deleteAllChats(chatIdInt)
            messageRepository.deleteChatFromUser(chatIdInt, userIdInt)
        } else {
            throw InvalidInputException()
        }
    }
}