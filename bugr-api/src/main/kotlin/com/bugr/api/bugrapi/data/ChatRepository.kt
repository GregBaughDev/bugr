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

}