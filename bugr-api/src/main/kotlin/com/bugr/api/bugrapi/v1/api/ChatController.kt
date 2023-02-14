package com.bugr.api.bugrapi.v1.api

import com.bugr.api.bugrapi.business.ChatService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(
    origins = ["*"],
    methods = [RequestMethod.DELETE],
    allowedHeaders = ["*"]
)
@RestController
@RequestMapping("/api/v1/chats")
class ChatController(private val chatService: ChatService) {

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteChatForUser(@PathVariable id: String) {
        return chatService.deleteUserChat(id.toInt())
    }
}