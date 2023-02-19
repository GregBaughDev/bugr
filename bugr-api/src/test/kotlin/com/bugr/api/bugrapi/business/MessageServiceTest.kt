package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.MessageRepository
import com.bugr.api.bugrapi.models.Message
import com.bugr.api.bugrapi.models.exceptions.InvalidInputException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*
import kotlin.test.assertFailsWith

@ExtendWith(MockitoExtension::class)
internal class MessageServiceTest {
    @Mock
    lateinit var messageRepository: MessageRepository

    @InjectMocks
    lateinit var messageService: MessageService

    @Test
    @DisplayName("Should throw exception when message body is empty")
    fun shouldThrowExceptionWhenEmptyMessage() {
        val message = Message(1, 1, 1, 2, "", "12-10-2023", false, "testUser")
        assertFailsWith(
            exceptionClass = InvalidInputException::class,
            block = { messageService.postMessage(message) }
        )
    }

    @Test
    @DisplayName("Should save message")
    fun shouldSaveMessage() {
        val message = Message(1, 1, 1, 2, "Test message!", "12-10-2023", false, "testUser")
        messageService.postMessage(message)
        verify(messageRepository, times(1)).saveUserMessage(message.chatId, message.fromUser, message.toUser, message.message)
    }

    // TO DO: Add getMessages test -> Lots of issues with mocking ChatService
}