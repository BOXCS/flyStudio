package Test.RFID;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.InputStream;
import java.util.Enumeration;

public class RFIDPortScanner {

    public static void main(String[] args) {
        Enumeration<?> portList = CommPortIdentifier.getPortIdentifiers();
        while (portList.hasMoreElements()) {
            CommPortIdentifier portId = (CommPortIdentifier) portList.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                System.out.println("Found port: " + portId.getName());
                // Anda dapat mencoba membuka dan membaca dari port untuk memastikan itu adalah perangkat RFID Anda
                try {
                    SerialPort serialPort = (SerialPort) portId.open("RFIDReader", 2000);
                    InputStream inputStream = serialPort.getInputStream();
                    serialPort.addEventListener(new SerialPortEventListener() {
                        public void serialEvent(SerialPortEvent event) {
                            // Handle event here
                        }
                    });
                    serialPort.notifyOnDataAvailable(true);
                    serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                    System.out.println("RFID Reader connected on port: " + portId.getName());
                    // Close the port after testing
                    serialPort.close();
                } catch (Exception e) {
                    System.out.println("Failed to open port " + portId.getName());
                }
            }
        }
    }
}
