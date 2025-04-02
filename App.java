package com.estudo;

import com.fazecast.jSerialComm.SerialPort;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*RandomSensorData data = new RandomSensorData();

        System.out.println(data.generateRandomData());
        System.out.println(data.generateRandomData());
        System.out.println(data.generateRandomData());*/
        SerialPort[] ports = SerialPort.getCommPorts();
        SerialPort arduinoPort = null;

        for (SerialPort port : ports) {
            if (port.getDescriptivePortName().toLowerCase().contains("arduino")) {
                arduinoPort = port;
                break;
            }
        }
            System.out.println(arduinoPort);

        if (arduinoPort.openPort()) {

            arduinoPort.setComPortParameters(9600, 8, 1, 0);
            arduinoPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 0, 0);

            try (Scanner scanner = new Scanner(arduinoPort.getInputStream())) {
                    System.out.println(scanner.nextLine());
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    String[] valores = data.split(";");
                    System.out.println(valores);

                    if(valores.length == 3) {
                        double umidade = Double.parseDouble(valores[0]);
                        double temperatura = Double.parseDouble(valores[1]);
                        double luminosidade = Double.parseDouble(valores[2]);

                        System.out.println("Umidade: " + umidade);
                        System.out.println("Temperatura: " + temperatura);
                        System.out.println("Luminosidade: " + luminosidade);
                    }
                }
            }
            arduinoPort.closePort();
        }
    }
}
