package com.bugr.api.bugrapi.v1.api

import com.bugr.api.bugrapi.business.MessageService
import com.bugr.api.bugrapi.models.Messages
import com.bugr.api.bugrapi.models.UserChats
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/api/v1")
class MessageController(private val messageService: MessageService) {

//    @GetMapping("/messages")
//    fun getMessagesForChat(@RequestParam(value = "chatId", required = true) chatId : Int): Optional<List<Messages>> {
//        return messageService.getMessages(chatId)
//    }

    @GetMapping("/messages")
    fun getAllUserChats(@RequestParam(value = "userId", required = true) userId: Int): List<UserChats> {
        return messageService.getMessages(userId)
    }

    @PostMapping("/messages", consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun saveNewMessage(@RequestBody message: Messages): Messages {
        return messageService.postMessage(message)
    }

}