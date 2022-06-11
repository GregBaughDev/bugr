package com.bugr.api.bugrapi.data

import com.bugr.api.bugrapi.models.Reviews
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Transactional
@Repository
interface ReviewRepository : JpaRepository<Reviews, Int> {

    @Query(
        value = "SELECT * FROM reviews WHERE user_reviewed = :id",
        nativeQuery = true
    )
    fun getAllReviewsForUser(id: Int): Optional<List<Reviews>>

    @Modifying
    @Query(
        value = "UPDATE reviews SET review = :review WHERE review_id = :reviewId",
        nativeQuery = true
    )
    fun updateReview(reviewId: Int, review: String): Int

}