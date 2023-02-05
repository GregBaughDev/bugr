package com.bugr.api.bugrapi.models

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "DATES")
data class Date (
    @Id
    @Column(name = "DATE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val dateId: Int,
    @Column(name = "USER_DATES")
    val userDates: Int,
    @Column(name = "DATE_FROM")
    val dateFrom: LocalDate?,
    @Column(name = "DATE_TO")
    val dateTo: LocalDate?
    )