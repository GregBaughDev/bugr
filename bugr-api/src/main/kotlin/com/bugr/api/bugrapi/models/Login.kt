package com.bugr.api.bugrapi.models

data class LoginForm (val username: String, val password: String)

interface LoggedInUser {
    val userId: Int
    val username: String
    val email: String
    val location: String
    val state: State
    val userType: UserType
    val aboutBug: String
    val confirmed: Boolean
}