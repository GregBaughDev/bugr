package com.bugr.api.bugrapi.models

import javax.persistence.*

data class UserChats (
    val fromUser: String,
    val chatId: Int,
    val messages: Messages
    )