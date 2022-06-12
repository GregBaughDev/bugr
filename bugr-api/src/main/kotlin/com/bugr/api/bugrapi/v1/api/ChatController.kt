package com.bugr.api.bugrapi.v1.api

import com.bugr.api.bugrapi.business.ChatService
import com.bugr.api.bugrapi.models.Chats
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/api/v1")
class ChatController(private val chatService: ChatService) {

    @GetMapping("/chats")
    @ResponseStatus(HttpStatus.OK)
    fun getChatsForUser(@RequestParam(value = "id", required = true) id: Int): Optional<Chats> {
        return chatService.getAllChatsForUser(id)
    }

}