package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.ChatRepository
import com.bugr.api.bugrapi.models.Chat
import org.springframework.stereotype.Service
import java.util.Optional
import javax.annotation.PostConstruct

@Service
class ChatService(private val chatRepository: ChatRepository) {

    fun getAllChatsForUser(id: Int): Optional<List<Chat>> {
        return chatRepository.getAllChatsForUser(id)
    }

    fun deleteUserChat(id: Int) {
        return chatRepository.deleteById(id)
    }

}