package com.bugr.api.bugrapi.models

import javax.persistence.*

@Entity
@Table(name = "MESSAGES")
data class Messages (
    @Id
    @Column(name = "MESSAGE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val messageId: Int,
    @Column(name = "CHAT_ID")
    val chatId: Int,
    @Column(name = "MESSAGE")
    val message: String
    )