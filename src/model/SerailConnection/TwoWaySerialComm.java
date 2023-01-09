package model.SerailConnection;

//import gnu.io.*;
import com.fazecast.jSerialComm.*;
//import gnu.io.SerialPortEventListener;
import model.Database.doa.DAOTemperature;
import model.SerailConnection.SerialReader;
import model.SerailConnection.SerialWriter;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Time;

import static com.fazecast.jSerialComm.SerialPort.LISTENING_EVENT_DATA_AVAILABLE;

/**
 * The type Two way serial comm.Cette classe permet
 * la connection au port serie et a la lecture  et
 * l'ecriture des information venant du port serie
 *  est a instantie obligatoirement au niveau du controller
 *  pour communocation avec l'arduino
 *
 */
public class TwoWaySerialComm implements SerialPortDataListener {
    private int BorderRate=57600;

   private InputStream in ;
    private  OutputStream out ;
    private  DAOTemperature daoTemperature;
    private  SerialReader serialReader;
    private  SerialWriter serialWriter;
  //  private CommPort commPort;
    private SerialPort portIdentifier;

    /**
     * Instantiates a new Two way serial comm.
     */
    public TwoWaySerialComm() {
        super();
    }

    /**
     * Connect.
     *
     * @param portName   the port name
     * @param BorderRate the border rate
     * @throws Exception the exception
     * connecte le pc au port  serie  et lance des thread pour l'eciture  et la lecture automatique sur le port serie
     */
    public void connect(String portName, int BorderRate , DAOTemperature daoTemperature) throws Exception {

        this.BorderRate =BorderRate;

         portIdentifier = SerialPort.getCommPort(portName);

        if (portIdentifier.isOpen()) System.out.println("Error: Port is currently in use");
        else {
             portIdentifier.openPort();

            System.out.println(portIdentifier.getSystemPortName());

            if (portIdentifier instanceof SerialPort) {
                SerialPort serialPort = (SerialPort) portIdentifier;


                serialPort.setComPortParameters(BorderRate,8, 1, 0);
                //serialPort.(true);

             //   System.out.println(serialPort.getBaudRate());

                 in = serialPort.getInputStream();
                 out = serialPort.getOutputStream();
                 this.daoTemperature=daoTemperature;
            //  SerialPortEvent


                 /*Ecriture et lecture automatique sur le port serie  grace au thread :
                  *ici on creait des threads qui vont s'executer automatiquement tout
                  *le long du code en prelevant les informations du ports serie  et en y envoyant des informations
                  *
                  *
                  */
                serialReader =new SerialReader(in,this.daoTemperature);
                serialWriter= new SerialWriter(this.out);
                serialPort.addDataListener(this);


            } else System.out.println("Error: Only serial ports are handled by this example.");
        }
    }
    public  void  close(){

        this.portIdentifier.closePort();

    }

    @Override
    public int getListeningEvents() {
        return LISTENING_EVENT_DATA_AVAILABLE;
    }

    //recupere des donnes lorsque qu'il sont disponible au niveau du port serie
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() ==getListeningEvents()) {
            try {
              //  System.out.println("ok");
                (new Thread(serialReader)).start();

                //System.out.println("output"+serialReader.getOutput());
                this.daoTemperature.insertTemperature(serialReader);
                Thread.sleep(1000);
            } catch (Exception e) {

                System.err.println(e.toString());
            }
        }

    }

    /**
     * Write data.
     *premet d'envoyer des donnes a la carte arduino
     * @param data the data
     */
    public synchronized void writeData(String data) {

        try {
            serialWriter.setData(data);
            (new Thread(serialWriter)).start();
            System.out.println("Sent: " + data);

        } catch (Exception e) {
            System.out.println("could not write to port");
        }
    }

    /**
     * Sets border rate.
     *
     * @param borderRate the border rate
     *
     *permet de modifier le borderate  (vitesse de transmission) )et les ajuster a nos besoins faites sans bonne usage
     */
    public void setBorderRate(int borderRate) {
        BorderRate = borderRate;
    }


}

    /** */
