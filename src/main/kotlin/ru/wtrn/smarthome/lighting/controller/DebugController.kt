package ru.wtrn.smarthome.lighting.controller

import org.springframework.web.bind.annotation.*
import ru.wtrn.smarthome.lighting.service.ZigbeeDeviceConfigurer

@RestController
@RequestMapping("/debug")
class DebugController(private val zigbeeDeviceConfigurer: ZigbeeDeviceConfigurer) {
    @PostMapping("/device/{deviceId}/setState")
    fun setDeviceState(@RequestBody state: Map<String, Any>, @PathVariable deviceId: String) {
        zigbeeDeviceConfigurer.changeDeviceState(deviceId, state)
    }
}