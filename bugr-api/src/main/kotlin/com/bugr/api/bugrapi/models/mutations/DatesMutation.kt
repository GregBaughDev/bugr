package com.bugr.api.bugrapi.models.mutations

import java.util.Date

class DatesMutation(
    var dateId: Int,
    var userDates: Int,
    var dateFrom: Date,
    var dateTo: Date
)