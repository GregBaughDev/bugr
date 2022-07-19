package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.UserRepository
import com.bugr.api.bugrapi.models.LoggedInUser
import com.bugr.api.bugrapi.models.Users
import com.bugr.api.bugrapi.models.exceptions.InvalidInputException
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    private val emailRegex: Regex = "\\b[\\w.-]+@[\\w.-]+\\.\\w{2,4}\\b".toRegex()

    fun userLogin(username: String, password: String): LoggedInUser {
        if(username.isEmpty() || password.isEmpty()) throw InvalidInputException()
        return userRepository.userLogin(username, password)
    }

    fun newUser(newUser: Users): Users {
        if (!emailRegex.matches(newUser.email)) throw InvalidInputException()
        // ENCRYPT PASSWORD
        // CHECK IF USER EXISTS
        return userRepository.save(newUser)
    }
}