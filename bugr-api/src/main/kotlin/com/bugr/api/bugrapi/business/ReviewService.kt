package com.bugr.api.bugrapi.business

import com.bugr.api.bugrapi.data.ReviewRepository
import com.bugr.api.bugrapi.models.Reviews
import org.springframework.stereotype.Service
import java.util.*

@Service
class ReviewService(val reviewRepository: ReviewRepository) {

    fun getReviews(id: Int): Optional<List<Reviews>> {
        return reviewRepository.getAllReviewsForUser(id)
    }

    fun getReviewById(id: Int): Optional<Reviews> {
        return reviewRepository.getIndividualReview(id)
    }

    fun saveReview(reviews: Reviews): Reviews {
        return reviewRepository.save(reviews)
    }

    fun deleteReview(reviewId: Int): Unit {
        return reviewRepository.deleteById(reviewId)
    }

}