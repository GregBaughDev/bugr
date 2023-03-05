package com.bugr.api.bugrapi.v1.api

import com.bugr.api.bugrapi.business.MessageService
import com.bugr.api.bugrapi.models.Message
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@CrossOrigin(
    origins = ["*"],
    methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS],
    allowedHeaders = ["*"])
@RestController
@RequestMapping("/api/v1/messages")
class MessageController(private val messageService: MessageService) {

    @GetMapping()
    fun getAllUserChats(@RequestParam(value = "userId", required = true) userId: Int): MutableList<List<Message>> {
        return messageService.getMessages(userId)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun saveNewMessage(@RequestBody message: Message) {
        return messageService.postMessage(message)
    }

    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun updateMessageOpened(@RequestBody messageId: Int) {
        return messageService.updateMessageOpened(messageId)
    }
}