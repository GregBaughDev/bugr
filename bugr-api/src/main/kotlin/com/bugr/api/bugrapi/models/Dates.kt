package com.bugr.api.bugrapi.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "DATES")
class Dates (
    @Id
    @Column(name = "DATE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var dateId: Int,
    @Column(name = "USER_DATES")
    var userDates: Int,
    @Column(name = "DATE_FROM")
    var dateFrom: Date,
    @Column(name = "DATE_TO")
    var dateTo: Date
    )