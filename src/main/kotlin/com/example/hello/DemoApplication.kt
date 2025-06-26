package com.example.hello

import com.udemy.libraries.l10n.gettext
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

@RestController
class HelloController {
	private val greetings = listOf(
		gettext("Welcome"),
		gettext("Hello, World"),
		gettext("This is a sample demo application to test translations.")
	)

	@GetMapping("/hello")
	fun sayHello(): List<String> = greetings
}
