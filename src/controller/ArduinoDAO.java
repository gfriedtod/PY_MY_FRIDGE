package controller;

import gnu.io.CommPortIdentifier;
import java.util.Enumeration;

public class ArduinoDAO {

	public ArduinoDAO() {
		// TODO Auto-generated constructor stub
		CommPortIdentifier serialPort;
		Enumeration enumPort;
		
		enumPort = CommPortIdentifier.getPortIdentifiers();
		//While (enumPort.hasMoreElements()){
			serialPort = (CommPortIdentifier)enumPort.nextElement();
			if (serialPort.getPortType() == CommPortIdentifier.PORT_SERIAL) {
			System.out.println(serialPort.getName());}
			else {
				System.out.println("no optimal connection to serial port");
			}
			}
		
	


}
