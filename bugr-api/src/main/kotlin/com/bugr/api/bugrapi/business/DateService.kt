package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.DateRepository
import com.bugr.api.bugrapi.models.Date
import com.bugr.api.bugrapi.models.exceptions.InvalidDateException
import com.bugr.api.bugrapi.models.mutations.DateMutation
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class DateService(private val dateRepository: DateRepository) {

    fun validateDates(from: LocalDate, to: LocalDate): Boolean {
        return from.isBefore(to) || from.isEqual(to)
    }

    fun getAllDatesForUser(id: Int): Optional<List<Date>> {
        return dateRepository.getAllDatesForUser(id)
    }

    fun saveDates(dates: Date): Date {
        if (dates.dateTo === null ||
            dates.dateFrom === null ||
            !validateDates(dates.dateFrom, dates.dateTo)) throw InvalidDateException()

        return dateRepository.save(dates)
    }

    fun updateDates(datesMutation: DateMutation): Int {
        if (!validateDates(datesMutation.dateFrom, datesMutation.dateTo)) throw InvalidDateException()

        return dateRepository.updateDates(datesMutation.userDates, datesMutation.dateId, datesMutation.dateFrom, datesMutation.dateTo)
    }
}