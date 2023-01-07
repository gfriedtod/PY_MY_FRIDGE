package model.SerailConnection;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * The type Serial writer.
 * permet l'ecriture des donnes sur le port serie
 */
public class SerialWriter implements Runnable {
    private OutputStream out  ;
private  String data ="null";

    /**
     * Instantiates a new Serial writer.
     */
    public SerialWriter(){}

    /**
     * Instantiates a new Serial writer.
     * prend en parametre  OutputStream  du port en question
     * (Pour l'usage ce referer a la classe TwoWaySerialComm)
     *
     * @param out the out
     */
    public SerialWriter(OutputStream out ) {
        this.out = out;

    }

    public void run() {
        try {
           this.out.write(data.getBytes(StandardCharsets.UTF_8));
        }
        catch(IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * Sets data.
     *Modifie la valeur de la donne que l'on veur envoyer au port serie
     * @param data the data
     */
    public void setData(String data) {
        this.data = data;

        this.run();
    }


}

