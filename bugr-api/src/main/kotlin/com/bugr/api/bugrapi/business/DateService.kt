package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.DateRepository
import com.bugr.api.bugrapi.models.Dates
import com.bugr.api.bugrapi.models.exceptions.InvalidDateException
import com.bugr.api.bugrapi.models.mutations.DatesMutation
import org.springframework.stereotype.Service
import java.util.*

@Service
class DateService(private val dateRepository: DateRepository) {

    fun validateDates(from: Date, to: Date): Boolean {
        return from.before(to) || from == to
    }

    fun getAllDatesForUser(id: Int): Optional<List<Dates>> {
        return dateRepository.getAllDatesForUser(id)
    }

    fun saveDates(dates: Dates): Dates {
        if (dates.dateTo === null ||
            dates.dateFrom === null ||
            !validateDates(dates.dateFrom, dates.dateTo)) throw InvalidDateException()

        return dateRepository.save(dates)
    }

    fun updateDates(datesMutation: DatesMutation): Int {
        if (!validateDates(datesMutation.dateFrom, datesMutation.dateTo)) throw InvalidDateException()

        return dateRepository.updateDates(datesMutation.userDates, datesMutation.dateId, datesMutation.dateFrom, datesMutation.dateTo)
    }
}