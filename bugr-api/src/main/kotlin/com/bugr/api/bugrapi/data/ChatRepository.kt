package com.bugr.api.bugrapi.data

import com.bugr.api.bugrapi.models.Chats
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ChatRepository : JpaRepository<Chats, Int> {

    @Query(
        value = "SELECT chats.*, users.username FROM chats INNER JOIN users ON chats.from_user = users.user_id WHERE to_user = :id",
        nativeQuery = true
    )
    fun getAllChatsForUser(id: Int): Optional<Chats>

}