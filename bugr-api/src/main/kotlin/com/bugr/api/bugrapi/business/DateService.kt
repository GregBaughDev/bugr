package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.DateRepository
import com.bugr.api.bugrapi.models.Dates
import com.bugr.api.bugrapi.models.mutations.DatesMutation
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class DateService(private val dateRepository: DateRepository) {

    fun getAllDatesForUser(id: Int): Optional<List<Dates>> {
        return dateRepository.getAllDatesForUser(id)
    }

    fun saveDates(dates: Dates): Dates {
        return dateRepository.save(dates)
    }

    fun updateDates(datesMutation: DatesMutation): Int {
        return dateRepository.updateDates(datesMutation.userDates, datesMutation.dateId, datesMutation.dateFrom, datesMutation.dateTo)
    }
}