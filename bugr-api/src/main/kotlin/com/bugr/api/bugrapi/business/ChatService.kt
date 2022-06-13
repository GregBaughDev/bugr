package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.ChatRepository
import com.bugr.api.bugrapi.models.Chats
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class ChatService(private val chatRepository: ChatRepository) {

    fun getAllChatsForUser(id: Int): Optional<Chats> {
        // EXCEPTION TO DO -> Generic server error
        return chatRepository.getAllChatsForUser(id)
    }

}