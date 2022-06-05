package com.bugr.api.bugrapi.models

import javax.persistence.*

@Entity
@Table(name = "MESSAGES")
class Messages (
    @Id
    @Column(name = "MESSAGE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var messageId: Int,
    @Column(name = "CHAT_ID")
    var chatId: Int,
    @Column(name = "MESSAGE")
    var message: String
    )