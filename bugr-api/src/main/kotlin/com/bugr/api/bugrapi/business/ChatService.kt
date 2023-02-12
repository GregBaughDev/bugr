package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.ChatRepository
import com.bugr.api.bugrapi.models.Chat
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class ChatService(private val chatRepository: ChatRepository) {

    fun getAllChatsForUser(id: Int): Optional<List<Chat>> {
        return chatRepository.getAllChatsForUser(id)
    }

}