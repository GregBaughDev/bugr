package com.bugr.api.bugrapi.data

import com.bugr.api.bugrapi.models.Messages
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface MessageRepository : JpaRepository<Messages, Int> {

    @Query(
        value = "SELECT * FROM messages WHERE chat_id = :chatId ORDER BY message_date DESC",
        nativeQuery = true
    )
    fun getAllChatMessages(chatId: Int): Optional<List<Messages>>

}