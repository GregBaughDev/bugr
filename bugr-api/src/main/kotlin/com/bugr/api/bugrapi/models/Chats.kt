package com.bugr.api.bugrapi.models

import javax.persistence.*

@Entity
@Table(name = "CHATS")
data class Chats (
    @Id
    @Column(name = "CHAT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var chatId: Int,
    @Column(name = "FROM_USER")
    var fromUser: Int,
    @Column(name = "TO_USER")
    var toUser: Int
    )