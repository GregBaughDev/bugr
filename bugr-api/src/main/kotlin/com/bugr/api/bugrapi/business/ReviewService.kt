package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.ReviewRepository
import com.bugr.api.bugrapi.models.Reviews
import com.bugr.api.bugrapi.models.mutations.ReviewsMutation
import org.springframework.stereotype.Service
import java.util.*

@Service
class ReviewService(val reviewRepository: ReviewRepository) {

    fun getReviews(id: Int): Optional<List<Reviews>> {
        return reviewRepository.getAllReviewsForUser(id)
    }

    fun saveReview(reviews: Reviews): Reviews {
        return reviewRepository.save(reviews)
    }

    fun deleteReview(reviewId: Int) {
        return reviewRepository.deleteById(reviewId)
    }

    fun updateReview(reviewMutation: ReviewsMutation): Int {
        return reviewRepository.updateReview(reviewMutation.reviewId, reviewMutation.review)
    }

}