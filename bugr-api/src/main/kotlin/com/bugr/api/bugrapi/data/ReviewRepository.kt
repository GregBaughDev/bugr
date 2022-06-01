package com.bugr.api.bugrapi.data

import com.bugr.api.bugrapi.models.Reviews
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ReviewRepository : JpaRepository<Reviews, Int> {

    @Query(
        value = "SELECT * FROM reviews WHERE user_reviewed = :id",
        nativeQuery = true
    )
    fun getAllReviewsForUser(id: Int): Optional<List<Reviews>>

}