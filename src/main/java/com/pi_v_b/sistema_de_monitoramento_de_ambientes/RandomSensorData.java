package com.pi_v_b.sistema_de_monitoramento_de_ambientes;

import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Classe responsável por gerar dados aleatórios para simular os dados dos sensores.
 */
public class RandomSensorData {
    public static String generateRandomData() {
        Locale.setDefault(Locale.US); // Define o locale para garantir a formatação correta dos números
        float umidade, temperatura, luminosidade;
        umidade = (float) Math.random() * 100;
        temperatura = (float) Math.random() * 100;
        luminosidade = (float) Math.random() * 1000;

        return String.format("%.2f;%.2f;%.2f", umidade, temperatura, luminosidade);
    }
}
