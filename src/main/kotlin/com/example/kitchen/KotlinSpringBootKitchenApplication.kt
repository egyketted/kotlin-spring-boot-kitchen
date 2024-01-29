package com.example.kitchen

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringBootKitchenApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringBootKitchenApplication>(*args)
}
