package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.UserRepository
import com.bugr.api.bugrapi.models.LoggedInUser
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun userLogin(username: String, password: String): LoggedInUser {
        return userRepository.userLogin(username, password)
    }

}