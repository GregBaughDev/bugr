package com.bugr.api.bugrapi.models

import java.util.Date
import javax.persistence.*

@Entity
@Table(name="REVIEWS")
class Reviews (
    @Id
    @Column(name="REVIEW_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @Column(name="USER_REVIEWED")
    var user: Int,
    @Column(name="AUTHOR")
    var author: Int,
    @Column(name="DATE")
    var date: Date,
    @Column(name="REVIEW")
    var review: String
    ){
//    TO DO: User and Author will both be FK
//    User will be the reviewee
//    Author will be the reviewer
}