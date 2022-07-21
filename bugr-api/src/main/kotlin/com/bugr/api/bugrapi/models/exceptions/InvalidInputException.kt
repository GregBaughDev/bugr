package com.bugr.api.bugrapi.models.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(
    value = HttpStatus.BAD_REQUEST,
    reason = "Input is invalid"
)
class InvalidInputException() : Exception()
// LOOK INTO PASSING A CUSTOM EXCEPTION MESSAGE THROUGH