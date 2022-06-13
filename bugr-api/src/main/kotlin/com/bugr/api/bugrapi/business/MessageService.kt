package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.MessageRepository
import com.bugr.api.bugrapi.models.Messages
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(private val messageRepository: MessageRepository) {

    fun getMessages(chatId: Int): Optional<List<Messages>> {
        // EXCEPTION TO DO -> Generic server error
        return messageRepository.getAllChatMessages(chatId)
    }

    fun postMessage(message: Messages): Messages {
        // EXCEPTION TO DO -> Message must have body + generic server issue
        return messageRepository.save(message)
    }

}