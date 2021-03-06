package com.bugr.api.bugrapi.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "DATES")
data class Dates (
    @Id
    @Column(name = "DATE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val dateId: Int,
    @Column(name = "USER_DATES")
    val userDates: Int,
    @Column(name = "DATE_FROM")
    val dateFrom: Date?,
    @Column(name = "DATE_TO")
    val dateTo: Date?
    )