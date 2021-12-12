package ru.wtrn.smarthome.lighting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SmarthomeLightingControllerApplication

fun main(args: Array<String>) {
	runApplication<SmarthomeLightingControllerApplication>(*args)
}
