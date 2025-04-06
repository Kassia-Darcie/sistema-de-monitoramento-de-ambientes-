# Sistema de Monitoramento de ambientes em Tempo Real 🌡️

Monitoramento inteligente de umidade, temperatura e luminosidade com alertas automáticos
- [Prótotipo do arduino](https://wokwi.com/projects/425598776942977025)
- [Diagrama de classe UML](https://lucid.app/lucidchart/8517f2f1-b970-4ed1-b0ce-36e6581e3479/view)
- [Protótipo no Figma](https://www.figma.com/design/fq2kdRA37NQsvlHHHGAU1G/Interface-dos-sensores?node-id=0-1&p=f&t=fyyWFGy0pTsQ2XJG-0)

## 🚀 Tecnologias Utilizadas
- **Java 21**
- **Spring Boot** (WebSocket, Scheduling)
- **Lombok** (Redução de boilerplate)
- **Maven** (Gerenciamento de dependências)

## 🔍 Funcionalidades Principais
1. **Coleta de Dados** 📊
    - Geração simulada de dados a cada 2 segundos
    - Parâmetros monitorados:
        - Umidade (20% a 100%)
        - Temperatura (10°C a 40°C)
        - Luminosidade (100lx a 1000lx)

2. **Processamento Inteligente** ⚙️
    - Conversão de dados brutos (`String` → `SensorData`)
    - Detecção automática de condições críticas:
        - Temperatura ≥ 30°C → Alerta para ar-condicionado
        - Umidade ≤ 30% → Alerta para umidificador

3. **Transmissão em Tempo Real** 📡
    - WebSocket para atualizações contínuas:
        - `/topic/sensor-data` (Dados dos sensores)
        - `/topic/alerts` (Alertas críticos)

## ⚙️ Estrutura do Projeto
```plaintext
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── pi_v_b/
│   │           └── sistema_de_monitoramento_de_ambientes/
│   │               ├── config/           # Configurações do sistema
│   │               │   ├── ArduinoReaderConfig.java
│   │               │   └── WebSocketConfig.java
│   │               ├── controller/       # Lógica de comunicação
│   │               │   └── SensorController.java
│   │               ├── dto/              # Modelo de dados
│   │               │   └── SensorData.java
│   │               ├── service/          # Regras de negócio
│   │               │   └── SensorService.java
│   │               └── RandomSensorData.java # Gerador de dados
└── resources/
    └── application.properties
```

## 🛠️ Pré-requisitos
- JDK 21+
- Maven 3.6+
- IDE com suporte a Lombok

## 📥 Instalação e Execução

   ```bash
   # Clonar repositório
   git clone https://github.com/Kassia-Darcie/sistema-de-monitoramento-de-ambientes-.git

   # Instalar dependências
   mvn clean install

   # Executar aplicação
   mvn spring-boot:run
   ```

## ⚠️ Alertas Configurados
| Condição                | Ação Recomendada                          |
|-------------------------|-------------------------------------------|
| Temperatura ≥ 30°C      | Recomendar ligar o ar condicionado        |
| Umidade ≤ 30%           | Recomendar ligar o umidificador |

## 📌 Próximos Passos
- [ ] Integração com hardware real via Arduino
- [ ] Histórico de medições em banco de dados
