package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.UserRepository
import com.bugr.api.bugrapi.models.LoggedInUser
import com.bugr.api.bugrapi.models.UserSearch
import com.bugr.api.bugrapi.models.User
import com.bugr.api.bugrapi.models.exceptions.InvalidInputException
import com.bugr.api.bugrapi.models.exceptions.UserException
import com.bugr.api.bugrapi.models.exceptions.UserExceptionResponse
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    private val emailRegex: Regex = "\\b[\\w.-]+@[\\w.-]+\\.\\w{2,4}\\b".toRegex()

    fun doesUsernameExist(username: String): Boolean {
        return userRepository.checkUsernameExists(username) == 1
    }

    fun doesEmailExist(email: String): Boolean {
        return userRepository.checkEmailExists(email) == 1
    }

    fun userLogin(username: String, password: String): LoggedInUser? {
        if (username.isEmpty() || password.isEmpty()) throw InvalidInputException()
        // TO DO: " " is not empty!
        val passwordCheck: String? = userRepository.checkPassword(username)

        if (passwordCheck == null || !BCrypt.checkpw(password, passwordCheck)) {
            throw UserException(UserExceptionResponse.INCORRECT_CREDENTIALS.responseToString())
        }

        return userRepository.userLogin(username)
    }

    fun newUser(newUser: User): User {
        if (!emailRegex.matches(newUser.email)) throw InvalidInputException()
        if (doesUsernameExist(newUser.username)) throw UserException(UserExceptionResponse.USERNAME_EXISTS.responseToString())
        if (doesEmailExist(newUser.email)) throw UserException(UserExceptionResponse.EMAIL_EXISTS.responseToString())

        newUser.password = BCrypt.hashpw(newUser.password, BCrypt.gensalt())
        // TO DO: CHECK CASING AND SANITISING (Spring security)
        return userRepository.save(newUser)
    }

    fun confirmUser(id: Int): Int {
        // Need exception
        return userRepository.confirmUser(id)
    }

    fun findUsersByState(state: String): List<UserSearch> {
        // Need exception
        return userRepository.findByState(state)
    }

    fun findUserById(id: Int): UserSearch {
        // Need exception
        return userRepository.findUserById(id)
    }
}