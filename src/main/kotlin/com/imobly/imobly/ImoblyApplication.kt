package com.imobly.imobly

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ImoblyApplication

fun main(args: Array<String>) {
	runApplication<ImoblyApplication>(*args)
}
