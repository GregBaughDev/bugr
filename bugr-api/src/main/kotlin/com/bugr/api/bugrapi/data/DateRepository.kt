package com.bugr.api.bugrapi.data

import com.bugr.api.bugrapi.models.Date
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.util.*

@Transactional
@Repository
interface DateRepository : JpaRepository<Date, Int> {

    @Query(
        value = "SELECT * FROM dates WHERE user_dates = :user",
        nativeQuery = true
    )
    fun getAllDatesForUser(user: Int): Optional<List<Date>>

    @Query(
        value = "SELECT * FROM dates WHERE date_id = :id",
        nativeQuery = true
    )
    fun getDatesById(id: Int): List<Date>

    @Modifying
    @Query(
        value = "UPDATE dates SET date_from = :dateFrom, date_to = :dateTo WHERE date_id = :dateId AND user_dates = :userId",
        nativeQuery = true
    )
    fun updateDates(userId: Int, dateId: Int, dateFrom: LocalDate, dateTo: LocalDate): Int
}