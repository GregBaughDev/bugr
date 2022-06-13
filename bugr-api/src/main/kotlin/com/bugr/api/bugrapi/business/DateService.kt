package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.DateRepository
import com.bugr.api.bugrapi.models.Dates
import com.bugr.api.bugrapi.models.mutations.DatesMutation
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class DateService(private val dateRepository: DateRepository) {

    fun getAllDatesForUser(id: Int): Optional<List<Dates>> {
        // EXCEPTION TO DO -> User doesn't exist + generic server error
        return dateRepository.getAllDatesForUser(id)
    }

    fun saveDates(dates: Dates): Dates {
        // EXCEPTION TO DO -> Validate end date is after start date + generic server error
        return dateRepository.save(dates)
    }

    fun updateDates(datesMutation: DatesMutation): Int {
        // EXCEPTION TO DO -> Validate end date is after start date + generic server error
        return dateRepository.updateDates(datesMutation.userDates, datesMutation.dateId, datesMutation.dateFrom, datesMutation.dateTo)
    }
}