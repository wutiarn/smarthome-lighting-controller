package ru.wtrn.smarthome.lighting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableScheduling
class SmarthomeLightingControllerApplication

fun main(args: Array<String>) {
	runApplication<SmarthomeLightingControllerApplication>(*args)
}
