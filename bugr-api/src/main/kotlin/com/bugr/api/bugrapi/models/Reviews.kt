package com.bugr.api.bugrapi.models

import javax.persistence.*

@Entity
@Table(name = "REVIEWS")
data class Reviews (
    @Id
    @Column(name = "REVIEW_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val reviewId: Int,
    @Column(name="USER_REVIEWED")
    val userReviewed: Int,
    @Column(name="AUTHOR")
    val author: Int,
    @Column(name="REVIEW")
    val review: String
    )