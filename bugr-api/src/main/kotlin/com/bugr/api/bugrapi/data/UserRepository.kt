package com.bugr.api.bugrapi.data

import com.bugr.api.bugrapi.models.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<Users, Int> {

    @Query(
        value = "SELECT user_id, username, location, state, user_type, about_bug, is_confirmed, date_registered FROM users WHERE user_id = :id",
        nativeQuery = true
    )
    fun findUserById(id: Int): Optional<Users>
}