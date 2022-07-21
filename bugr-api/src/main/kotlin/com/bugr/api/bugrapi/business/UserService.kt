package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.UserRepository
import com.bugr.api.bugrapi.models.LoggedInUser
import com.bugr.api.bugrapi.models.Users
import com.bugr.api.bugrapi.models.exceptions.InvalidInputException
import com.bugr.api.bugrapi.models.exceptions.UserException
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    private val emailRegex: Regex = "\\b[\\w.-]+@[\\w.-]+\\.\\w{2,4}\\b".toRegex()

    fun checkUsernameExists(username: String): Boolean {
        return userRepository.checkUsernameExists(username) == 1
    }

    fun checkEmailExists(email: String): Boolean {
        return userRepository.checkEmailExists(email) == 1
    }
    // REFACTOR ABOVE INTO ONE FUNCTION WHICH ACCEPTS AN OBJECT WITH SEARCH FOR AND EXCEPTION MESSAGE
    fun userLogin(username: String, password: String): LoggedInUser {
        if(username.isEmpty() || password.isEmpty()) throw InvalidInputException()
        return userRepository.userLogin(username, password)
    }

    fun newUser(newUser: Users): Users {
        if (!emailRegex.matches(newUser.email)) throw InvalidInputException()
        if (checkUsernameExists(newUser.username)) throw UserException()
        // LOOK INTO PASSING A CUSTOM MESSAGE INTO THE ABOVE
        // ENCRYPT PASSWORD
        // CHECK CASING AND SANITISING
        return userRepository.save(newUser)
    }
}