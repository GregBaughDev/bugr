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
class Users (
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userId: Int,
    @Column(name = "USERNAME")
    var userName: String,
    @Column(name = "USER_PASSWORD")
    var userPassword: String,
    @Column(name = "EMAIL")
    var email: String,
    @Column(name = "LOCATION")
    var location: String,
    @Column(name = "STATE")
    var state: String,
    @Column(name = "USER_TYPE")
    var userType: UserType,
    @Column(name = "ABOUT_BUG")
    var aboutBug: String,
    @Column(name = "IS_CONFIRMED")
    var isConfirmed: Boolean,
    ) {
}