package com.bugr.api.bugrapi.models

import javax.persistence.*

@Entity
@Table(name = "CHATS")
data class Chats (
    @Id
    @Column(name = "CHAT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val chatId: Int,
    @Column(name = "TO_USER")
    val toUser: Int,
    @Column(name = "FROM_USER")
    val fromUser: Int,
)