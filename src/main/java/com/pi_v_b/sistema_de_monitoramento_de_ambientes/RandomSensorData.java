package com.pi_v_b.sistema_de_monitoramento_de_ambientes;

public class RandomSensorData {
    public String generateRandomData() {
        float umidade, temperatura, luminosidade;
        umidade = (float) Math.random() * 100;
        temperatura = (float) Math.random() * 100;
        luminosidade = (float) Math.random() * 1000;

        return String.format("%.2f;%.2f;%.2f", umidade, temperatura, luminosidade);
    }
}
