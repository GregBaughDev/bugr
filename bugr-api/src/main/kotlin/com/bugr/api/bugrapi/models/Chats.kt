package com.bugr.api.bugrapi.models

data class UserChats (
    val fromUser: String,
    val chatId: Int,
    val messages: List<Messages>
    )