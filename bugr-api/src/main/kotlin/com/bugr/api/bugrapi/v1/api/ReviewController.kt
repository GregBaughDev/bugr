package com.bugr.api.bugrapi.v1.api

import com.bugr.api.bugrapi.business.ReviewService
import com.bugr.api.bugrapi.models.Review
import com.bugr.api.bugrapi.models.mutations.ReviewMutation
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping("/api/v1/reviews")
class ReviewController(private val reviewService: ReviewService) {

    @GetMapping()
    fun getReviewsForUser(@RequestParam(value = "id", required = true) id: Int): Optional<List<Review>> {
        return reviewService.getReviews(id)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun saveNewReview(@RequestBody reviews: Review): Review {
        return reviewService.saveReview(reviews)
    }

    @DeleteMapping()
    fun deleteReview(@RequestParam(value = "reviewId", required = true) reviewId: Int) {
        return reviewService.deleteReview(reviewId)
    }

    @PatchMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateReview(@RequestBody reviewMutation: ReviewMutation): Int {
        return reviewService.updateReview(reviewMutation)
    }

}