package com.bugr.api.bugrapi.models

data class LoginForm (var username: String, var password: String)

interface LoggedInUser {
    var userId: Int
    var username: String
    var email: String
    var location: String
    var state: State
    var userType: UserType
    var aboutBug: String
    var confirmed: Boolean
}