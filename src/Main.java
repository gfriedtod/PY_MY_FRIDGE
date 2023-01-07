import model.Database.doa.DAOTemperature;
import model.SerailConnection.TwoWaySerialComm;

import java.sql.SQLException;

/**
 * The type Main.
 * eexemple d'implementation d'un controller
 */
public class Main {
    private static DAOTemperature  daoTemperature = new DAOTemperature();
    private static TwoWaySerialComm twoWaySerialComm= new TwoWaySerialComm();
    public static void main(String[] args) throws SQLException {
        try {

            daoTemperature.open();
            (twoWaySerialComm).connect("COM2",57600,Main.daoTemperature);
            //twoWaySerialComm.writeData("data");
            //twoWaySerialComm.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            daoTemperature.close();


        }
    }
}