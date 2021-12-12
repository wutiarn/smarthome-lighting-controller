package ru.wtrn.smarthome.lighting.configuration

import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class MqttConfiguration {
    @Bean
    fun mqttClient(): MqttClient {
        val publisherId = UUID.randomUUID().toString()
        val publisher = MqttClient("tcp://100.64.0.2:1883", publisherId, MemoryPersistence())

        val options = MqttConnectOptions().also {
            it.isAutomaticReconnect = true
            it.isCleanSession = true
            it.connectionTimeout = 10
        }
        publisher.connect(options)

        return publisher
    }
}