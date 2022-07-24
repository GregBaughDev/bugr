package com.bugr.api.bugrapi.models.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

enum class UserExceptionResponse(private val response: String) {
    USERNAME_EXISTS("Username exists"),
    EMAIL_EXISTS("Email exists"),
    INCORRECT_CREDENTIALS("Incorrect credentials");

    fun responseToString() : String {
        return response.toString();
    }
}

@ResponseStatus(
    value = HttpStatus.BAD_REQUEST
)
class UserException(message: String) : Exception(message)