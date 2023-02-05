package com.bugr.api.bugrapi.models.mutations

import java.time.LocalDate

data class DatesMutation(
    var dateId: Int,
    var userDates: Int,
    var dateFrom: LocalDate,
    var dateTo: LocalDate
)