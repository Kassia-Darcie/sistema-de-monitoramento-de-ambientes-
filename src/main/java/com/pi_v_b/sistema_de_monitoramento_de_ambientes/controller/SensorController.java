package com.pi_v_b.sistema_de_monitoramento_de_ambientes.controller;

import com.pi_v_b.sistema_de_monitoramento_de_ambientes.dto.SensorData;
import com.pi_v_b.sistema_de_monitoramento_de_ambientes.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SensorController {

    private final SimpMessagingTemplate messageTemplate;
    private final SensorService sensorService;

    @Scheduled(fixedRate = 2000)
    public void sendSensorData() {
        String destination = "/topic/sensor-data";
        SensorData sensorData = this.sensorService.getSensorData();

        messageTemplate.convertAndSend(destination, sensorData);

        List<String> alerts = this.sensorService.checkAlerts();
        if (!alerts.isEmpty()) {
            String alertDestination = "/topic/alerts";
            messageTemplate.convertAndSend(alertDestination, alerts);
        }
    }
}
