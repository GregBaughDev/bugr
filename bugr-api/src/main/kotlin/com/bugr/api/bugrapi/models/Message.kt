package com.bugr.api.bugrapi.models

import javax.persistence.*

@Entity
@Table(name = "MESSAGES")
data class Message (
    @Id
    @Column(name = "MESSAGE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val messageId: Int,
    @Column(name = "CHAT_ID")
    var chatId: Int?,
    @Column(name = "FROM_USER")
    val fromUser: Int,
    @Column(name = "TO_USER")
    val toUser: Int,
    @Column(name = "MESSAGE")
    val message: String,
    @Column(name = "MESSAGE_DATE")
    val messageDate: String?,
    @Column(name = "OPENED")
    val opened: Boolean,
    val username: String?
    )