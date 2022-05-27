package com.bugr.api.bugrapi.v1.api

import com.bugr.api.bugrapi.business.UserService
import com.bugr.api.bugrapi.models.Users
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/v1")
class UserApi(var userService: UserService) {

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    fun getUserById(@RequestParam(value = "id", required = true) id: Int): Optional<Users> {
        return userService.getUser(id)
    }

}