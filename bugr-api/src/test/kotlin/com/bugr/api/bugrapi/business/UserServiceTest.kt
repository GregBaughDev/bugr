package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.UserRepository
import com.bugr.api.bugrapi.models.State
import com.bugr.api.bugrapi.models.UserType
import com.bugr.api.bugrapi.models.Users
import com.bugr.api.bugrapi.models.exceptions.InvalidInputException
import com.bugr.api.bugrapi.models.exceptions.UserException
import com.bugr.api.bugrapi.models.exceptions.UserExceptionResponse
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.assertFailsWith

@ExtendWith(MockitoExtension::class)
internal class UserServiceTest {
    @Mock
    lateinit var userRepository: UserRepository

    @InjectMocks
    lateinit var userService: UserService

    @Test
    @DisplayName("Should return false when username does not exist")
    fun noExistingUsername() {
        `when`(userRepository.checkUsernameExists(anyString())).thenReturn(0)
        assertEquals(false, userService.doesUsernameExist(anyString()))
    }

    @Test
    @DisplayName("Should return true when username does exist")
    fun existingUsername() {
        `when`(userRepository.checkUsernameExists(anyString())).thenReturn(1)
        assertEquals(true, userService.doesUsernameExist("test"))
    }

    @Test
    @DisplayName("Should return false when email does not exist")
    fun noExistingEmail() {
        `when`(userRepository.checkEmailExists(anyString())).thenReturn(0)
        assertEquals(false, userService.doesEmailExist(anyString()))
    }

    @Test
    @DisplayName("Should return true when email does exist")
    fun existingEmail() {
        `when`(userRepository.checkEmailExists(anyString())).thenReturn(1)
        assertEquals(true, userService.doesEmailExist(anyString()))
    }

    @Test
    @DisplayName("Should throw exception when username is empty for login")
    fun throwExceptionWhenNoUsernameOnLogin() {
        assertFailsWith(
            exceptionClass = InvalidInputException::class,
            block = { userService.userLogin("", "test") }
        )
    }

    @Test
    @DisplayName("Should throw exception when password is empty for login")
    fun throwExceptionWhenNoPasswordOnLogin() {
        assertFailsWith(
            exceptionClass = InvalidInputException::class,
            block = { userService.userLogin("test", "") }
        )
    }

    @Test
    @DisplayName("Should throw exception if password is not found")
    fun throwExceptionWhenPasswordIsNotFound() {
        `when`(userRepository.checkPassword(anyString())).thenReturn(null)
        assertFailsWith(
            exceptionClass = UserException::class,
            block = { userService.userLogin("test", "test") }
        )
    }

    @Test
    @DisplayName("Should throw exception if email does not match regex")
    fun throwExceptionWhenEmailIsInvalid() {
        val user = Users(0, "test", "test", "incorrectemail", "test", State.ACT, UserType.OFFERING, "test")
        assertFailsWith(
            exceptionClass = InvalidInputException::class,
            block = { userService.newUser(user) }
        )
    }

    @Test
    @DisplayName("Should throw exception when username exists")
    fun throwExceptionWhenUsernameExists() {
        val user = Users(0, "test", "test", "test@email.com", "test", State.ACT, UserType.OFFERING, "test")
        `when`(userRepository.checkUsernameExists(anyString())).thenReturn(1)
        assertFailsWith(
            exceptionClass = UserException::class,
            message = UserExceptionResponse.USERNAME_EXISTS.responseToString(),
            block = { userService.newUser(user) }
        )
    }

    @Test
    @DisplayName("Should throw exception when email exists")
    fun throwExceptionWhenEmailExists() {
        val user = Users(0, "test", "test", "test@email.com", "test", State.ACT, UserType.OFFERING, "test")
        `when`(userRepository.checkEmailExists(anyString())).thenReturn(1)
        assertFailsWith(
            exceptionClass = UserException::class,
            message = UserExceptionResponse.EMAIL_EXISTS.responseToString(),
            block = { userService.newUser(user) }
        )
    }

    @Test
    @DisplayName("Should call confirm user method")
    fun shouldCallConfirmUserMethod() {
        userService.confirmUser(1)
        verify(userRepository, times(1)).confirmUser(1)
    }

    @Test
    @DisplayName("Should call find by state method")
    fun shouldCallFindByStateMethod() {
        userService.findUsersByState("VIC")
        verify(userRepository, times(1)).findByState("VIC")
    }

    @Test
    @DisplayName("Should call find by user ID method")
    fun shouldCallFindByUserIDMethod() {
        userService.findUserById(2)
        verify(userRepository, times(1)).findUserById(2)
    }
}