package com.bugr.api.bugrapi.v1.api

import com.bugr.api.bugrapi.business.MessageService
import com.bugr.api.bugrapi.models.Messages
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/api/v1")
class MessageApi(var messageService: MessageService) {

    @GetMapping("/messages")
    @ResponseStatus(HttpStatus.OK)
    fun getMessagesForChat(@RequestParam(value = "chatId", required = true) chatId : Int): Optional<Messages> {
        return messageService.getMessages(chatId)
    }

}