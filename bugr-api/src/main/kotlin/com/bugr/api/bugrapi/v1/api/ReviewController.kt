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
class ReviewController(private val reviewService: ReviewService) {

    @GetMapping("/reviews")
    fun getReviewsForUser(@RequestParam(value = "id", required = true) id: Int): Optional<List<Reviews>> {
        return reviewService.getReviews(id)
    }

    @PostMapping("/reviews", consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun saveNewReview(@RequestBody reviews: Reviews): Reviews {
        return reviewService.saveReview(reviews)
    }

    @DeleteMapping("/reviews")
    fun deleteReview(@RequestParam(value = "reviewId", required = true) reviewId: Int) {
        return reviewService.deleteReview(reviewId)
    }

    @PatchMapping("/reviews", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateReview(@RequestBody reviewMutation: ReviewsMutation): Int {
        return reviewService.updateReview(reviewMutation)
    }

}