package com.pi_v_b.sistema_de_monitoramento_de_ambientes.service;

import com.pi_v_b.sistema_de_monitoramento_de_ambientes.dto.SensorData;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class SensorService {

    private SensorData sensorData = new SensorData();

    public void processSensorData(String rawSensorData) {
        String[] data = rawSensorData.split(";");
        double umidade = Double.parseDouble(data[0]);
        double temperatura = Double.parseDouble(data[1]);
        double luminosidade = Double.parseDouble(data[2]);
        this.sensorData.setUmidade(umidade);
        this.sensorData.setTemperatura(temperatura);
        this.sensorData.setLuminosidade(luminosidade);

    }

    public List<String> checkAlerts() {
        List<String> alerts = new ArrayList<>();
        if (this.sensorData.getTemperatura() >= 30) {
            alerts.add("A temperatura está alta, recomenda-se ligar o ar condicionado.");
        }

        if (this.sensorData.getUmidade() <= 30) {
            alerts.add("A umidade está baixa, recomenda-se ligar o umidificador.");
        }

        return alerts;
    }

}
