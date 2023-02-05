package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.ReviewRepository
import com.bugr.api.bugrapi.models.Review
import com.bugr.api.bugrapi.models.exceptions.InvalidInputException
import com.bugr.api.bugrapi.models.mutations.ReviewMutation
import org.springframework.stereotype.Service
import java.util.*

@Service
class ReviewService(private val reviewRepository: ReviewRepository) {

    fun getReviews(id: Int): Optional<List<Review>> {
        return reviewRepository.getAllReviewsForUser(id)
    }

    fun saveReview(reviews: Review): Review {
        if (reviews.review.isEmpty()) throw InvalidInputException()
        // TO DO: " " is not empty
        return reviewRepository.save(reviews)
    }

    fun deleteReview(reviewId: Int) {
        return reviewRepository.deleteById(reviewId)
    }

    fun updateReview(reviewMutation: ReviewMutation): Int {
        if (reviewMutation.review.length <= 10) throw InvalidInputException()

        return reviewRepository.updateReview(reviewMutation.reviewId, reviewMutation.review)
    }
}