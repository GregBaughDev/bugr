package com.bugr.api.bugrapi.v1.api

import com.bugr.api.bugrapi.business.DateService
import com.bugr.api.bugrapi.models.Date
import com.bugr.api.bugrapi.models.mutations.DateMutation
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/dates")
class DateController(private val dateService: DateService) {

    @GetMapping()
    fun getDatesForUser(@RequestParam(value = "userId", required = true) userId: Int): Optional<List<Date>> {
        return dateService.getAllDatesForUser(userId)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun saveNewDate(@RequestBody dates: Date): Date {
        return dateService.saveDates(dates)
    }

    @PatchMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateDate(@RequestBody datesMutation: DateMutation): Int {
        return dateService.updateDates(datesMutation)
    }
}