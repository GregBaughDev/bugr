package com.bugr.api.bugrapi.data

import com.bugr.api.bugrapi.models.LoggedInUser
import com.bugr.api.bugrapi.models.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<Users, Int> {

    @Query(
        value = "SELECT user_id as userId, username, email, location, state, user_type as userType, about_bug as aboutBug, is_confirmed as isConfirmed FROM users WHERE username = :username AND user_password = :password",
        nativeQuery = true
    )
    fun userLogin(username: String, password: String): LoggedInUser
}