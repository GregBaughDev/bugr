package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.UserRepository
import com.bugr.api.bugrapi.models.LoggedInUser
import com.bugr.api.bugrapi.models.Users
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun userLogin(username: String, password: String): LoggedInUser {
        // EXCEPTION TO DO -> Confirm body has content + generic server error
        return userRepository.userLogin(username, password)
    }

    fun newUser(newUser: Users): Users {
        // EXCEPTION TO DO -> Confirm body has content + generic server error
        // Regex for email
        // Regex for password
        // ENCRYPT PASSWORD
        return userRepository.save(newUser)
    }

}