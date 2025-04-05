package com.pi_v_b.sistema_de_monitoramento_de_ambientes;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

/**
 * Classe responsável por gerar dados aleatórios para simular os dados dos sensores.
 */

@RequiredArgsConstructor
public class RandomSensorData implements ArduinoReader {

    private final Consumer<String> dataConsumer;

    @Override
    public void start() {

    }

    @Scheduled(fixedRate = 2000)
    public void generateRandomData() {
        Locale.setDefault(Locale.US); // Define o locale para garantir a formatação correta dos números
        double umidade, temperatura, luminosidade;
        umidade = ThreadLocalRandom.current().nextDouble(20, 100);
        temperatura = ThreadLocalRandom.current().nextDouble(10, 40);
        luminosidade = ThreadLocalRandom.current().nextDouble(100, 1000);

        String dadosSimulados = String.format("%.2f;%.2f;%.2f", umidade, temperatura, luminosidade);

        dataConsumer.accept(dadosSimulados);
    }
}
