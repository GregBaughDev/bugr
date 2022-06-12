package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.MessageRepository
import com.bugr.api.bugrapi.models.Messages
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(private val messageRepository: MessageRepository) {

    fun getMessages(chatId: Int): Optional<List<Messages>> {
        return messageRepository.getAllChatMessages(chatId)
    }

    fun postMessage(message: Messages): Messages {
        return messageRepository.save(message)
    }

}