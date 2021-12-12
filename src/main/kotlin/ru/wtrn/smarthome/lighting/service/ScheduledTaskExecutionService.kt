package ru.wtrn.smarthome.lighting.service

import org.springframework.scheduling.TaskScheduler
import org.springframework.scheduling.support.CronTrigger
import org.springframework.stereotype.Service
import ru.wtrn.smarthome.lighting.configuration.properties.ScheduledTasksProperties
import java.time.ZoneId
import javax.annotation.PostConstruct

@Service
class ScheduledTaskExecutionService(
    private val zigbeeDeviceConfigurer: ZigbeeDeviceConfigurer,
    private val properties: ScheduledTasksProperties,
    private val taskScheduler: TaskScheduler
) {

    @PostConstruct
    fun configureTasks() {
        val timezone = properties.timezone.let { ZoneId.of(it) }
        properties.tasks.forEach { task ->
            taskScheduler.schedule(
                { executeTask(task) },
                CronTrigger(task.cron, timezone)
            )
        }
    }

    fun executeTask(task: ScheduledTasksProperties.Task) {
        zigbeeDeviceConfigurer.changeDeviceState(task.device, task.state)
    }
}