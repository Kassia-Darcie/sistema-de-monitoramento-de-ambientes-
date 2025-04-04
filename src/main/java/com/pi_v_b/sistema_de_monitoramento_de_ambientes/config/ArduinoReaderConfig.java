package com.pi_v_b.sistema_de_monitoramento_de_ambientes.config;

import com.pi_v_b.sistema_de_monitoramento_de_ambientes.ArduinoReader;
import com.pi_v_b.sistema_de_monitoramento_de_ambientes.RandomSensorData;
import com.pi_v_b.sistema_de_monitoramento_de_ambientes.service.SensorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class ArduinoReaderConfig {

    @Bean
    public ArduinoReader arduinoReader(SensorService sensorService) {

        Consumer<String> dataConsumer = sensorService::processSensorData;

        return new RandomSensorData(dataConsumer);
    }
}
