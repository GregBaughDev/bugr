package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.UserRepository
import com.bugr.api.bugrapi.models.LoggedInUser
import com.bugr.api.bugrapi.models.Users
import com.bugr.api.bugrapi.models.exceptions.InvalidInputException
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun userLogin(username: String, password: String): LoggedInUser {
        if(username.isEmpty() || password.isEmpty()) throw InvalidInputException()
        return userRepository.userLogin(username, password)
    }

    fun newUser(newUser: Users): Users {
        println(newUser.email)
        println(newUser.userPassword)
        // TO DO WIP -> Below regex doesnt work
        if (!emailRegex.matches(newUser.email)) throw InvalidInputException()
        // if (!Regex("/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}\$/gm").matches(newUser.userPassword)) throw InvalidInputException()
        // ENCRYPT PASSWORD

        return userRepository.save(newUser)
    }

    private val emailRegex: Regex = "/\b[\\w.-]+@[\\w.-]+\\.\\w{2,4}\b/gi".toRegex()

}