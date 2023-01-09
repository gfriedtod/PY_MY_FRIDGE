package model.SerailConnection;

import
        model.Database.doa.DAOTemperature;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * la lecture des informations venant du por serie
 *
 * cette classe permet
 */
public  class SerialReader implements Runnable {
    /**
     * The In.
     */
    InputStream in;
    private  String Output ="null";
    private  DAOTemperature daoTemperature;


    /**
     * Instantiates a new Serial reader.
     * elle prent en parametre InputStream du port en question
     * (Pour l'usage ce referer a la classe TwoWaySerialComm)
     *
     * @param in             the in
     * @param daoTemperature
     */
    public SerialReader(InputStream in, DAOTemperature daoTemperature) {
        this.in = in;
        this.daoTemperature =daoTemperature;
    }

    public void run() {
        byte[] buffer = new byte[1024];
        int len = -1;
        try {
            while((len = this.in.read(buffer)) > -1) {
                System.out.println("len "+len
                );
               System.out.print(new String(buffer,0,len));
               System.out.println("--------------------------------");
               Output =new String(buffer,0,len);
                //insertion des donne entrante dans la base de donne



            }
        }

        catch ( IOException e ) {
            //System.out.println("ooo");


        }


    }

    /**
     * Gets output.
     *
     * @return the output
     * renvoie la sortie serie
     */
    public String getOutput() {
        return Output;
    }
}

/** */
