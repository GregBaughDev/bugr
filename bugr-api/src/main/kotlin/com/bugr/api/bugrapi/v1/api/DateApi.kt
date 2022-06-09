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
class DateApi(var dateService: DateService) {

    @GetMapping("/dates")
    @ResponseStatus(HttpStatus.OK)
    fun getDatesForUser(@RequestParam(value = "userId", required = true) userId: Int): Optional<List<Dates>> {
        return dateService.getAllDatesForUser(userId)
    }

    @PostMapping("/dates", consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun saveNewDate(@RequestBody dates: Dates): Dates {
        return dateService.saveDates(dates)
    }

    @PatchMapping("/dates", consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun updateDate(@RequestBody datesMutation: DatesMutation): Dates {
        return dateService.updateDates(datesMutation)
    }
}