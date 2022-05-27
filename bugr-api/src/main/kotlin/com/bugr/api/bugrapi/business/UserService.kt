package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.UserRepository
import com.bugr.api.bugrapi.models.Users
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {

    fun getUser(id: Int): Optional<Users> {
        return userRepository.findById(id)
    }
}