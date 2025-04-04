package com.pi_v_b.sistema_de_monitoramento_de_ambientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
public class SistemaDeMonitoramentoDeAmbientesApplication {

	public static void main(String[] args) {

		SpringApplication.run(SistemaDeMonitoramentoDeAmbientesApplication.class, args);


	}

}
