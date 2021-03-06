package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.UserRepository
import com.bugr.api.bugrapi.models.LoggedInUser
import com.bugr.api.bugrapi.models.Users
import com.bugr.api.bugrapi.models.exceptions.InvalidInputException
import com.bugr.api.bugrapi.models.exceptions.UserException
import com.bugr.api.bugrapi.models.exceptions.UserExceptionResponse
import org.springframework.security.crypto.bcrypt.BCrypt
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

    fun userLogin(username: String, password: String): LoggedInUser? {
        if(username.isEmpty() || password.isEmpty()) throw InvalidInputException()

        var userResult: LoggedInUser? = userRepository.userLogin(username)

        if (userResult == null || !BCrypt.checkpw(password, userResult.password)) {
            throw UserException(UserExceptionResponse.INCORRECT_CREDENTIALS.responseToString())
        }
        // TO DO -> ADD NEW USER, CHECK ABOVE IS WORKING AS EXPECTED
        return userResult
    }

    fun newUser(newUser: Users): Users {
        if (!emailRegex.matches(newUser.email)) throw InvalidInputException()
        if (checkUsernameExists(newUser.username)) throw UserException(UserExceptionResponse.USERNAME_EXISTS.responseToString())
        if (checkEmailExists(newUser.email)) throw UserException(UserExceptionResponse.EMAIL_EXISTS.responseToString())
        newUser.password = BCrypt.hashpw(newUser.password, BCrypt.gensalt())
        // TO DO: CHECK CASING AND SANITISING (Spring security)
        return userRepository.save(newUser)
    }
}