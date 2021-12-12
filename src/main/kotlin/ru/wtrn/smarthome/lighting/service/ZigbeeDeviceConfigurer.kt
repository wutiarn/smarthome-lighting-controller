package ru.wtrn.smarthome.lighting.service

import com.fasterxml.jackson.databind.ObjectMapper
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.springframework.stereotype.Service

@Service
class ZigbeeDeviceConfigurer(private val objectMapper: ObjectMapper, private val mqttClient: MqttClient) {
    fun changeDeviceState(deviceId: String, state: Any) {
        val messageBytes = objectMapper.writeValueAsBytes(state);
        val message = MqttMessage(messageBytes).also {
            it.qos = 0
            it.isRetained = false
        }
        val topic = "zigbee2mqtt/$deviceId/set"
        mqttClient.publish(topic, message)
    }
}