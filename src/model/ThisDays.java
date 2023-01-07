package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type This days.
 *
 * renvoie la date actuelle pour etre utiliser au niveau de la base de donne
 */
public class ThisDays {

    public  String getDays(){
        SimpleDateFormat formater = null;

        Date aujourdhui = new Date();

        formater = new SimpleDateFormat("dd-MM-yy h:m:s");
        System.out.println(formater.format(aujourdhui));
        return formater.format(aujourdhui) ;
    }
}
