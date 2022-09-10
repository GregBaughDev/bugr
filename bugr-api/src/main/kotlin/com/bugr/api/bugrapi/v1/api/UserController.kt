package com.bugr.api.bugrapi.v1.api

import com.bugr.api.bugrapi.business.UserService
import com.bugr.api.bugrapi.models.LoggedInUser
import com.bugr.api.bugrapi.models.LoginForm
import com.bugr.api.bugrapi.models.Users
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(
    origins = ["*"],
    methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS],
    allowedHeaders = ["*"])
@RestController
@RequestMapping("/api/v1")
class UserController(private val userService: UserService) {

    @PostMapping("/users", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun userLogin(@RequestBody login: LoginForm): LoggedInUser? {
        // SORT OUT SECURITY ISSUES WITH SPRING SECURITY
        return userService.userLogin(login.username, login.password)
    }

    @PostMapping("/users/new", consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun newUser(@RequestBody newUser: Users): Users {
        return userService.newUser(newUser)
    }

    @PostMapping("/users/{id}/confirm")
    @ResponseStatus(HttpStatus.CREATED)
    fun confirmUser(@PathVariable id: String): Int {
        return userService.confirmUser(id.toInt())
    }

}