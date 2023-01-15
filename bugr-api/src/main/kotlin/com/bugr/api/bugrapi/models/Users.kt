package com.bugr.api.bugrapi.models

import com.vladmihalcea.hibernate.type.array.IntArrayType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import javax.persistence.*

enum class UserType {
    SEEKING, OFFERING, CARER
}

enum class State {
    VIC, NSW, QLD, SA, WA, NT, TAS, ACT
}

@TypeDef(name = "int-array", typeClass = IntArrayType::class)
@Entity
@Table(name = "USERS")
data class Users(
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Int,
    @Column(name = "USERNAME")
    val username: String,
    @Column(name = "USER_PASSWORD")
    var password: String,
    @Column(name = "EMAIL")
    val email: String,
    @Column(name = "LOCATION")
    val location: String,
    @Column(name = "STATE")
    @Enumerated(EnumType.STRING)
    val state: State,
    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE")
    val userType: UserType,
    @Column(name = "ABOUT_BUG")
    val aboutBug: String,
    @Column(name = "IS_CONFIRMED", columnDefinition = "BOOLEAN DEFAULT FALSE")
    val isConfirmed: Boolean? = false,
    @Type(type = "int-array")
    @Column(name = "CHATS")
    var chats: Array<Int> = arrayOf()
    )

interface UserSearch {
    val userId: Int
    val username: String
    val location: String
    val state: State
    val aboutBug: String
    val userType: UserType
}