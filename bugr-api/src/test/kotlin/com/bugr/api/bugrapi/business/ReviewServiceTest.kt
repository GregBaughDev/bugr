package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.ReviewRepository
import com.bugr.api.bugrapi.models.Reviews
import com.bugr.api.bugrapi.models.exceptions.InvalidInputException
import com.bugr.api.bugrapi.models.mutations.ReviewsMutation
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.assertFailsWith

@ExtendWith(MockitoExtension::class)
internal class ReviewServiceTest {
    @Mock
    lateinit var reviewRepository: ReviewRepository

    @InjectMocks
    lateinit var reviewService: ReviewService

    @Test
    @DisplayName("Should call get reviews for user method")
    fun shouldCallGetReviewsForUserMethod() {
        reviewService.getReviews(1)
        verify(reviewRepository, times(1)).getAllReviewsForUser(1)
    }

    @Test
    @DisplayName("Should throw exception when review is empty")
    fun throwExceptionWhenReviewIsEmpty() {
        val review = Reviews(1, 2, 3, "")
        assertFailsWith(
            exceptionClass = InvalidInputException::class,
            block = { reviewService.saveReview(review) }
        )
    }

    @Test
    @DisplayName("Should throw exception when review update length is less than 10")
    fun throwExceptionIfReviewUpdateIsTooShort() {
        val reviewMutation = ReviewsMutation(1, "short")
        assertFailsWith(
            exceptionClass = InvalidInputException::class,
            block = { reviewService.updateReview(reviewMutation) }
        )
    }
}