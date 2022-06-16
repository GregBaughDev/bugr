package com.bugr.api.bugrapi.v1.api

import com.bugr.api.bugrapi.business.DateService
import com.bugr.api.bugrapi.models.Dates
import com.bugr.api.bugrapi.models.mutations.DatesMutation
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1")
class DateController(private val dateService: DateService) {

    @GetMapping("/dates")
    fun getDatesForUser(@RequestParam(value = "userId", required = true) userId: Int): Optional<List<Dates>> {
        return dateService.getAllDatesForUser(userId)
    }

    @PostMapping("/dates", consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun saveNewDate(@RequestBody dates: Dates): Dates {
        return dateService.saveDates(dates)
    }

    @PatchMapping("/dates", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateDate(@RequestBody datesMutation: DatesMutation): Int {
        return dateService.updateDates(datesMutation)
    }
}