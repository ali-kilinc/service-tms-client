package com.example.hello

import com.udemy.libraries.l10n.gettext
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Locale

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

@RestController
class HelloController {
	fun getGreetings(locale: Locale): List<String> = listOf(
		gettext("Welcome", locale),
		gettext("Hello, World", locale),
		gettext("This is a sample demo application to test translations.", locale)
	)

	@GetMapping("/hello")
	fun sayHello(@RequestParam("locale") locale: String): List<String> {
		val localeParts = locale.split('_')
		val loc = when (localeParts.size) {
			2 -> Locale(localeParts[0], localeParts[1])
			1 -> Locale(localeParts[0])
			else -> Locale.getDefault()
		}
		return listOf("Locale: $loc") + getGreetings(loc)
	}
}
