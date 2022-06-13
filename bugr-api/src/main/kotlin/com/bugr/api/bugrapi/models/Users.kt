package com.bugr.api.bugrapi.models

import javax.persistence.*

enum class UserType {
    SEEKING, OFFERING, CARER
}

enum class State {
    VIC, NSW, QLD, SA, WA, NT, TAS, ACT
}

@Entity
@Table(name = "USERS")
data class Users (
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Int,
    @Column(name = "USERNAME")
    val username: String,
    @Column(name = "USER_PASSWORD")
    val userPassword: String,
    @Column(name = "EMAIL")
    val email: String,
    @Column(name = "LOCATION")
    val location: String,
    @Column(name = "STATE")
    @Enumerated(EnumType.STRING)
    var state: State,
    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE")
    val userType: UserType,
    @Column(name = "ABOUT_BUG")
    val aboutBug: String,
    @Column(name = "IS_CONFIRMED")
    val isConfirmed: Boolean,
    )