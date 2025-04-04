package com.pi_v_b.sistema_de_monitoramento_de_ambientes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class SensorData {
    private double umidade;
    private double temperatura;
    private double luminosidade;
}
