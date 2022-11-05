package com.bugr.api.bugrapi.v1.api

import com.bugr.api.bugrapi.business.MessageService
import com.bugr.api.bugrapi.models.Messages
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@CrossOrigin(
    origins = ["*"],
    methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.OPTIONS],
    allowedHeaders = ["*"])
@RestController
@RequestMapping("/api/v1")
class MessageController(private val messageService: MessageService) {

    @GetMapping("/messages")
    fun getAllUserChats(@RequestParam(value = "userId", required = true) userId: Int): MutableList<List<Messages>> {
        return messageService.getMessages(userId)
    }

    @PostMapping("/messages", consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun saveNewMessage(@RequestBody message: Messages): Unit {
        return messageService.postMessage(message)
    }

    @PutMapping("/messages", consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun updateMessageOpened(@RequestBody messageId: Int): Unit {
        return messageService.updateMessageOpened(messageId)
    }

}