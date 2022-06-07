package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.DateRepository
import com.bugr.api.bugrapi.models.Dates
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

}