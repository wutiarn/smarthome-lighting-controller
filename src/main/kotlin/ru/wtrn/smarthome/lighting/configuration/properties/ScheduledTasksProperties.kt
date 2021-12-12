package ru.wtrn.smarthome.lighting.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.time.ZoneId

@ConfigurationProperties("ru.wtrn.snarthome.lighting.scheduled")
@ConstructorBinding
data class ScheduledTasksProperties(
    val tasks: List<Task>,
    val timezone: String
) {
    data class Task(
        val cron: String,
        val device: String,
        val state: Map<String, Any>
    )
}