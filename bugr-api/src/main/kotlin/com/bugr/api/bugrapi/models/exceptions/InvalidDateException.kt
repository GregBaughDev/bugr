package com.bugr.api.bugrapi.models.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(
    value = HttpStatus.BAD_REQUEST,
    reason = "Dates are invalid"
)
class InvalidDateException() : Exception()