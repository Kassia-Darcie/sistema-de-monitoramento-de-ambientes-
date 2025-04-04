package com.pi_v_b.sistema_de_monitoramento_de_ambientes.service;

import com.pi_v_b.sistema_de_monitoramento_de_ambientes.RandomSensorData;
import com.pi_v_b.sistema_de_monitoramento_de_ambientes.controller.SensorController;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class SensorService {

    private final SensorController sensorController;

    public SensorService(SensorController sensorController) {
        this.sensorController = sensorController;
    }


    @Scheduled(fixedRate = 2000)
    private void inicializar() {
        String randomData = RandomSensorData.generateRandomData();
        processSensorData(randomData);
    }

    private void processSensorData(String rawSensorData) {
        String[] data = rawSensorData.split(";");
        double umidade = Double.parseDouble(data[0]);
        double temperatura = Double.parseDouble(data[1]);
        double luminosidade = Double.parseDouble(data[2]);

        sensorController.sendSensorData(umidade, temperatura, luminosidade);
    }
}
