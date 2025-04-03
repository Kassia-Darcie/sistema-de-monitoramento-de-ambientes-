package com.pi_v_b.sistema_de_monitoramento_de_ambientes.controller;

import com.pi_v_b.sistema_de_monitoramento_de_ambientes.dto.SensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class SensorController {

    @Autowired
    private SimpMessagingTemplate messageTemplate;

    public void sendSensorData(double umidade, double temperatura, double luminosidade) {
        String destination = "/topic/sensor-data";
        SensorData sensorData = new SensorData(umidade, temperatura, luminosidade);
        messageTemplate.convertAndSend(destination, sensorData);
    }
}
