package com.bugr.api.bugrapi.data

import com.bugr.api.bugrapi.models.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface MessageRepository : JpaRepository<Message, Int> {

    @Query(
        value = "SELECT m.*, u.username FROM messages AS m INNER JOIN users as u ON m.from_user = u.user_id WHERE chat_id = :chatId ORDER BY message_date ASC",
        nativeQuery = true
    )
    fun getAllChatMessages(chatId: Int): List<Message>

    @Transactional
    @Modifying
    @Query(
        value = "INSERT INTO messages (chat_id, from_user, to_user, message) VALUES (:chatId, :fromUser, :toUser, :message)",
        nativeQuery = true
    )
    fun saveUserMessage(chatId: Int, fromUser: Int, toUser: Int, message: String)

    @Transactional
    @Modifying
    @Query(
        value = "UPDATE messages SET opened = TRUE WHERE message_id = :messageId",
        nativeQuery = true
    )
    fun updateMessageOpened(messageId: Int)
}