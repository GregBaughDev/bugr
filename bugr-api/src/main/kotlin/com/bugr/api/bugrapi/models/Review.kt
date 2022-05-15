package com.bugr.api.bugrapi.models

import java.util.Date

class Review (
    var id: Int,
    var user: Int,
    var author: Int,
    var date: Date,
    var review: String
    ){
//    TO DO: User and Author will both be FK
//    User will be the reviewee
//    Author will be the reviewer
}