package model.SerailConnection;

public class Model {
	 private  SerialReader serialReader;
	 private float humidity;
		private float temperature_ext;
		private float temperature_int;
	public Model() {
		// TODO Auto-generated constructor stub
		String str = serialReader.getOutput();
    	String[] splitStr = str.split(":");
    	for (String a: splitStr)
    		System.out.println(a);
    	this.humidity = Float.parseFloat(splitStr[0]);
    	this.temperature_ext = Float.parseFloat(splitStr[1]);
    	this.temperature_int = Float.parseFloat(splitStr[2]);
    	
	}
	

	
	
}
