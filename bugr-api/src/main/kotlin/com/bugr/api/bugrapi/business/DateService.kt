package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.DateRepository
import com.bugr.api.bugrapi.models.Dates
import com.bugr.api.bugrapi.models.mutations.DatesMutation
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class DateService(val dateRepository: DateRepository) {

    fun getAllDatesForUser(id: Int): Optional<List<Dates>> {
        return dateRepository.getAllDatesForUser(id)
    }

    fun saveDates(dates: Dates): Dates {
        return dateRepository.save(dates)
    }

    fun getDatesById(id: Int): List<Dates> {
        return dateRepository.getDatesById(id)
    }

    fun updateDates(datesMutation: DatesMutation): Dates {
        val currentDates = this.getDatesById(datesMutation.dateId)
        val updatedDates = Dates(
            datesMutation.dateId,
            datesMutation.userDates,
            if (datesMutation.dateFrom != null) datesMutation.dateFrom else currentDates[0].dateFrom,
            if (datesMutation.dateTo != null) datesMutation.dateTo else currentDates[0].dateTo
        )
        return this.saveDates(updatedDates)
    }
}