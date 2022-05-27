//package com.bugr.api.bugrapi.v1.api;
//
//import com.bugr.api.bugrapi.models.*
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController
//import java.util.*
//import kotlin.collections.ArrayList
//
//@RestController
//@RequestMapping("/api/v1")
//public class api {
//
//    @GetMapping("/user")
//    fun userResponse(): ArrayList<Users> {
//        var testArray: ArrayList<Users> = ArrayList()
//        testArray.add(
//            Users(
//                1,
//                "TestUser",
//                "TestPass",
//                "test@user.com",
//                "Melbourne",
//                UserType.OFFERING,
//                "Fridge and feed every 3 days",
//                true
//            ))
//        return testArray
//        // TO DO: Login will be a POST that sends user info and returns above
//    }
//
//    @GetMapping("/reviews")
//    fun reviewResponse(): ArrayList<Review> {
//        var testReview: ArrayList<Review> = ArrayList()
//        testReview.add(
//            Review(
//                1,
//                1,
//                2,
//                Date(),
//                "So friendly and happy to provide their bug"
//            )
//        )
//        return testReview
//        // TO DO: Review will be timestamped when it's submitted
//        // TO DO: Create POST for submitting review
//        // TO DO: Pagination for reviews
//    }
//
//    @GetMapping("/login")
//    fun loginResponse(): Login {
//        var reviews: ArrayList<Review> = ArrayList()
//        reviews.add(
//            Review(
//                1,
//                1,
//                2,
//                Date(),
//                "So friendly and happy to provide their bug"
//            )
//        )
//        return Login(
//            User(
//                1,
//                "TestUser",
//                "TestPass",
//                "test@user.com",
//                "Melbourne",
//                UserType.OFFERING,
//                "Fridge and feed every 3 days",
//                true
//            ), reviews
//        )
//    }
//
//}