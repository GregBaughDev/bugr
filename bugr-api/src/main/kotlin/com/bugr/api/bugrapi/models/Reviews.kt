package com.bugr.api.bugrapi.models

import javax.persistence.*

@Entity
@Table(name = "REVIEWS")
class Reviews (
    @Id
    @Column(name = "REVIEW_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var reviewId: Int,
    @Column(name="USER_REVIEWED")
    var userReviewed: Int,
    @Column(name="AUTHOR")
    var author: Int,
    @Column(name="REVIEW")
    var review: String
    )