package com.bugr.api.bugrapi.v1.api

import com.bugr.api.bugrapi.business.ReviewService
import com.bugr.api.bugrapi.models.Reviews
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/api/v1")
class ReviewApi(var reviewService: ReviewService) {

    @GetMapping("/reviews")
    @ResponseStatus(HttpStatus.OK)
    fun getReviewsForUser(@RequestParam(value = "id", required = true) id: Int): Optional<Reviews> {
        return reviewService.getReviews(id)
    }

}