package com.bugr.api.bugrapi.data

import com.bugr.api.bugrapi.models.Messages
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository : JpaRepository<Messages, Int> {

    @Query(
        value = "SELECT chats FROM users WHERE user_id = :userId",
        nativeQuery = true
    )
    fun getUserChats(userId: Int): Array<Int>

    @Query(
        value = "SELECT m.*, u.username FROM messages AS m INNER JOIN users as u ON m.from_user = u.user_id WHERE chat_id = :chatId ORDER BY message_date ASC",
        nativeQuery = true
    )
    fun getAllChatMessages(chatId: Int): List<Messages>

}