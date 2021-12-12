package ru.wtrn.smarthome.lighting.service

import mu.KotlinLogging
import org.springframework.scheduling.TaskScheduler
import org.springframework.scheduling.support.CronTrigger
import org.springframework.stereotype.Service
import ru.wtrn.smarthome.lighting.configuration.properties.ScheduledTasksProperties
import javax.annotation.PostConstruct

@Service
class ScheduledTaskExecutionService(
    private val zigbeeDeviceConfigurer: ZigbeeDeviceConfigurer,
    private val properties: ScheduledTasksProperties,
    private val taskScheduler: TaskScheduler
) {

    private val logger = KotlinLogging.logger {}

    @PostConstruct
    fun configureTasks() {
        properties.tasks.forEach { task ->
            logger.info { "Registering task: $task" }
            taskScheduler.schedule(
                { executeTask(task) },
                CronTrigger(task.cron, properties.timezone)
            )
        }
    }

    fun executeTask(task: ScheduledTasksProperties.Task) {
        logger.info { "Executing task: $task" }
        zigbeeDeviceConfigurer.changeDeviceState(task.device, task.state)
    }
}