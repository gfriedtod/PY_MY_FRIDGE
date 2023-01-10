package model.Database.doa;

//import jpu2016.javapetri.model.JavaPetri;
import model.SerailConnection.SerialReader;

import java.util.ArrayList;

import model.ThisDays;
//import model.SerailConnection.SerialWriter;

public class QueryTemperature {
	

    public  String getQueryInsert(final SerialReader serialReader, ThisDays thisDays,String[] arg) {
    	String str = serialReader.getOutput();
    	String[] splitStr = str.split(":");
    	for (String a: splitStr)
    		System.out.println(a);
    	return "INSERT INTO `PMF`.`Temperature` (`ID`, `, `date_sampling`)" + " VALUES (NULL, '"  +splitStr[0]+ "' ," +splitStr[1]+"' ,"+thisDays.getDays()+" );";
    }
    
   
        public  String getDATA(ThisDays thisDays){
        return "SELECT * FROM `PMF`.`Temperature`";
    }


    public String getDATA_YEARS(ThisDays thisDays) {

        return "\n" +
                "select *\n" +
                "from temperature\n" +
                "where EXTRACT(year  from  date_sampling)= EXTRACT( year from  "+thisDays.getDays()+")\n";
    }

    public String getDATA_DAYS(ThisDays thisDays) {

        return "select *\n" +
                "from temperature\n" +
                "where EXTRACT(day  from  date_sampling)= EXTRACT( day from  "+thisDays.getDays()+") and\n" +
                "      EXTRACT(YEAR_MONTH  from  date_sampling)= EXTRACT( YEAR_MONTH from   "+thisDays.getDays()+") \n";
    }

    public String getDATA_Month(ThisDays thisDays) {

        return "select *\n" +
                "from temperature\n" +
                "where\n" +
                "        EXTRACT(YEAR_MONTH  from  date_sampling)= EXTRACT( YEAR_MONTH from  "+thisDays.getDays()+")\n";
    }
}
