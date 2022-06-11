package com.bugr.api.bugrapi.v1.api

import com.bugr.api.bugrapi.business.UserService
import com.bugr.api.bugrapi.models.LoggedInUser
import com.bugr.api.bugrapi.models.LoginForm
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class UserApi(var userService: UserService) {

    @PostMapping("/users", consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun userLogin(@RequestBody login: LoginForm): LoggedInUser {
        // TO DO - Sort out below, not working - LoggedInUser interface not working
        return  userService.userLogin(login.username, login.password)
    }

}