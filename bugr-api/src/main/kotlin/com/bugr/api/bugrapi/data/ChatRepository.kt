package com.bugr.api.bugrapi.data

import com.bugr.api.bugrapi.models.Chat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ChatRepository : JpaRepository<Chat, Int> {

    @Query(
        value = "SELECT * FROM chats WHERE to_user = :id OR from_user = :id",
        nativeQuery = true
    )
    fun getAllChatsForUser(id: Int): Optional<List<Chat>>


    @Query(
        value = "SELECT chat_id FROM chats WHERE (to_user = :to AND from_user = :from) OR (to_user = :from AND from_user = :to)",
        nativeQuery = true
    )
    fun getChatForUserAndRecipient(to: Int, from: Int): Optional<Int>

    @Query(
        value = "INSERT INTO chats (to_user, from_user) VALUES (:to, :from) RETURNING chat_id",
        nativeQuery = true
    )
    fun createNewChatForUserAndRecipient(to: Int, from: Int): Int
}