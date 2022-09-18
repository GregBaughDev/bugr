package com.bugr.api.bugrapi.data

import com.bugr.api.bugrapi.models.LoggedInUser
import com.bugr.api.bugrapi.models.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface UserRepository : JpaRepository<Users, Int> {

    @Query(
        value = "SELECT user_id as userId, username, email, location, state, user_type as userType, about_bug as aboutBug, is_confirmed as confirmed FROM users WHERE username = :username",
        nativeQuery = true
    )
    fun userLogin(username: String): LoggedInUser?

    @Query(
        value = "SELECT user_password FROM users WHERE username = :username",
        nativeQuery = true
    )
    fun checkPassword(username: String): String?

    @Query(
        value = "SELECT COUNT(users) FROM users WHERE username = :username",
        nativeQuery = true
    )
    fun checkUsernameExists(username: String): Int

    @Query(
        value = "SELECT COUNT(users) FROM users WHERE email = :email",
        nativeQuery = true
    )
    fun checkEmailExists(email: String): Int

    @Transactional
    @Modifying
    @Query(
        value = "UPDATE users SET is_confirmed = true WHERE user_id = :id",
        nativeQuery = true
    )
    fun confirmUser(id: Int): Int
}