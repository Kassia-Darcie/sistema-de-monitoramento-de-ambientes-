package com.pi_v_b.sistema_de_monitoramento_de_ambientes.service;

import com.pi_v_b.sistema_de_monitoramento_de_ambientes.RandomSensorData;
import com.pi_v_b.sistema_de_monitoramento_de_ambientes.controller.SensorController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorService {

    @Autowired
    private SensorController sensorController;


    private void inicializar() {
        RandomSensorData randomSensorData = new RandomSensorData();

        while (true) {

        }
    }
}
