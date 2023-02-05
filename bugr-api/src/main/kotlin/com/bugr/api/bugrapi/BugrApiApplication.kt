package com.bugr.api.bugrapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BugrApiApplication

fun main(args: Array<String>) {
	runApplication<BugrApiApplication>(*args)
}
