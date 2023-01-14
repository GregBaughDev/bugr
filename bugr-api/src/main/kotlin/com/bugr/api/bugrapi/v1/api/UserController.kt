package com.bugr.api.bugrapi.v1.api

import com.bugr.api.bugrapi.business.UserService
import com.bugr.api.bugrapi.models.LoggedInUser
import com.bugr.api.bugrapi.models.LoginForm
import com.bugr.api.bugrapi.models.State
import com.bugr.api.bugrapi.models.Users
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@CrossOrigin(
    origins = ["*"],
    methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS],
    allowedHeaders = ["*"])
@RestController
@RequestMapping("/api/v1/users")
class UserController(private val userService: UserService) {

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun userLogin(@RequestBody login: LoginForm): LoggedInUser? {
        // SORT OUT SECURITY ISSUES WITH SPRING SECURITY
        return userService.userLogin(login.username, login.password)
    }

    @PostMapping("/new", consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun newUser(@RequestBody newUser: Users): Users {
        return userService.newUser(newUser)
    }

    @PostMapping("/{id}/confirm")
    @ResponseStatus(HttpStatus.CREATED)
    fun confirmUser(@PathVariable id: String): Int {
        return userService.confirmUser(id.toInt())
    }

    @GetMapping()
    fun findUsers(@RequestParam(value = "state", required = true) state: State): List<Users> {
        return userService.findUsers(state)
    }

}