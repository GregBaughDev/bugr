package com.bugr.api.bugrapi.v1.api

import com.bugr.api.bugrapi.business.ReviewService
import com.bugr.api.bugrapi.models.Reviews
import com.bugr.api.bugrapi.models.mutations.ReviewsMutation
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping("/api/v1")
class ReviewApi(var reviewService: ReviewService) {

    @GetMapping("/reviews")
    @ResponseStatus(HttpStatus.OK)
    fun getReviewsForUser(@RequestParam(value = "id", required = true) id: Int): Optional<List<Reviews>> {
        return reviewService.getReviews(id)
    }

    @PostMapping("/reviews", consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun saveNewReview(@RequestBody reviews: Reviews): Reviews {
        return reviewService.saveReview(reviews)
    }

    @DeleteMapping("/reviews")
    @ResponseStatus(HttpStatus.OK)
    fun deleteReview(@RequestParam(value = "reviewId", required = true) reviewId: Int): Unit {
        return reviewService.deleteReview(reviewId)
    }

    @PatchMapping("/reviews", consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun updateReview(@RequestBody reviewMutation: ReviewsMutation): Reviews {
        // Move below into reviewService
        val currentReview = reviewService.getReviewById(reviewMutation.reviewId)
        val updatedReview = Reviews(reviewMutation.reviewId, currentReview.get().userReviewed, currentReview.get().author, reviewMutation.review)
        return reviewService.saveReview(updatedReview)
    }

}