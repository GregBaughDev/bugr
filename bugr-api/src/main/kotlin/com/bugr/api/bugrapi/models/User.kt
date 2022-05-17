package com.bugr.api.bugrapi.models

enum class UserType {
    SEEKING, OFFERING, CARER
}

class User (
    var id: Int,
    var userName: String,
    var password: String,
    var email: String,
    var location: String,
    var userType: UserType,
    var instructions: String,
    var emailConfirmed: Boolean,
    ) {
}