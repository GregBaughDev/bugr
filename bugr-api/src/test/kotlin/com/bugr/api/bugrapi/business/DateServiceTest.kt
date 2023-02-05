package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.DateRepository
import com.bugr.api.bugrapi.models.Dates
import com.bugr.api.bugrapi.models.exceptions.InvalidDateException
import com.bugr.api.bugrapi.models.mutations.DatesMutation
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@ExtendWith(MockitoExtension::class)
internal class DateServiceTest {
    @Mock
    lateinit var dateRepository: DateRepository

    @InjectMocks
    lateinit var dateService: DateService

    @Test
    @DisplayName("Should return true when the from date is earlier than to date")
    fun shouldReturnTrueWhenDatesAreCorrect() {
        val from = LocalDate.parse("2020-10-10")
        val to = LocalDate.parse("2020-11-10")
        assertEquals(true, dateService.validateDates(from, to))
    }

    @Test
    @DisplayName("Should return true when the to and from dates are equal")
    fun shouldReturnTrueWhenDatesAreEqual() {
        val from = LocalDate.parse("2020-10-10")
        val to = LocalDate.parse("2020-10-10")
        assertEquals(true, dateService.validateDates(from, to))
    }

    @Test
    @DisplayName("Should return false when from date is after to date")
    fun shouldReturnFalseWhenDatesAreInvalid() {
        val from = LocalDate.parse("2020-11-10")
        val to = LocalDate.parse("2020-10-10")
        assertEquals(false, dateService.validateDates(from, to))
    }

    @Test
    @DisplayName("Should call get all dates for user ID method")
    fun shouldCallGetAllDatesMethod() {
        dateService.getAllDatesForUser(1)
        verify(dateRepository, times(1)).getAllDatesForUser(1)
    }

    @Test
    @DisplayName("Should throw exception when date to value is null")
    fun shouldThrowExceptionWhenDateToIsNull() {
        val date = Dates(1, 2, null, LocalDate.parse("2020-10-10"))
        assertFailsWith(
            exceptionClass = InvalidDateException::class,
            block = { dateService.saveDates(date) }
        )
    }

    @Test
    @DisplayName("Should throw exception when date from value is null")
    fun shouldThrowExceptionWhenDateFromIsNull() {
        val date = Dates(1, 2, LocalDate.parse("2020-10-10"), null)
        assertFailsWith(
            exceptionClass = InvalidDateException::class,
            block = { dateService.saveDates(date) }
        )
    }

    @Test
    @DisplayName("Should throw exception when dates are invalid")
    fun shouldThrowExceptionWhenDatesAreInvalid() {
        val date = Dates(1, 2, LocalDate.parse("2020-10-10"), LocalDate.parse("2020-01-01"))
        assertFailsWith(
            exceptionClass = InvalidDateException::class,
            block = { dateService.saveDates(date) }
        )
    }

    @Test
    @DisplayName("Should throw exception when updating with invalid dates")
    fun shouldThrowExceptionWhenUpdatingWithInvalidDates() {
        val date = DatesMutation(1, 2, LocalDate.parse("2020-10-10"), LocalDate.parse("2020-01-01"))
        assertFailsWith(
            exceptionClass = InvalidDateException::class,
            block = { dateService.updateDates(date) }
        )
    }

    @Test
    @DisplayName("Should call update dates method")
    fun shouldCallUpdateDatesMethod() {
        val date = DatesMutation(1, 2, LocalDate.parse("2020-01-01"), LocalDate.parse("2020-10-10"))
        dateService.updateDates(date)
        verify(dateRepository, times(1)).updateDates(date.userDates, date.dateId, date.dateFrom, date.dateTo)
    }
}