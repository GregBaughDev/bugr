package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.ChatRepository
import com.bugr.api.bugrapi.models.Chats
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class ChatService(val chatRepository: ChatRepository) {

    fun getAllChatsForUser(id: Int): Optional<Chats> {
        return chatRepository.getAllChatsForUser(id)
    }

}