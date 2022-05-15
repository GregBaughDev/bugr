package com.bugr.api.bugrapi.models

class User (
    var id: Int,
    var userName: String,
    var password: String,
    var email: String,
    var location: String,
    var userType: String,
    var instructions: String,
    var emailConfirmed: Boolean,
    ) {
    // TO DO: make userType ENUM
}