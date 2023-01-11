
import model.Database.doa.DAOTemperature;
import model.SerailConnection.TwoWaySerialComm;


import java.sql.SQLException;

import controller.Controller;
import controller.IModel;
import controller.Iview;

/**
 * The type Main.
 * eexemple d'implementation d'un controller
 */
public class Main {
    
    private static TwoWaySerialComm twoWaySerialComm= new TwoWaySerialComm();
 
    private static Iview view = new Iview(twoWaySerialComm);
    
    public static void main(String[] args) throws SQLException {
    	
        final Controller controller = new Controller(view,twoWaySerialComm );
        
        view.setController(controller);
    }
}