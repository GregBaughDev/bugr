package com.bugr.api.bugrapi.v1.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
public class api {

    @GetMapping("/test")
    fun testResponse(): String {
        return "test";
    }

}