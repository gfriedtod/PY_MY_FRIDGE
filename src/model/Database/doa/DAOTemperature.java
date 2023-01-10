package model.Database.doa;


import model.SerailConnection.SerialReader;
import model.ThisDays;

import java.sql.*;

/**
 * The type Dao temperature.
 *
 * cette classe permet la connexion a la base de donne et te donne acces a differente donne
 * en foction de vos besoins
 */
public class DAOTemperature {
    private static String URL = "jdbc:mysql://localhost:3306/javapeti?autoReconnect=true&useSSL=false";
    private static String LOGIN = "gfried";
    private static String PASSWORD = "123456789Gfried";
    private  Connection connection;
    private  Statement statement;
    private  ResultSet cur;

    /**
     * Instantiates a new Dao temperature.
     */
    public DAOTemperature () {
        this.connection = null;
        this.statement = null;
    }

    /**
     * Open boolean.
     *c'est mon open personaliser utilisant mes identifiants
     * @return the boolean
     */
    public Boolean open (){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(DAOTemperature .URL,
                    DAOTemperature .LOGIN, DAOTemperature .PASSWORD);
            this.statement = this.connection.createStatement();
        } catch (final ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * Open boolean.
     *
     * @param sql_connector the sql connector
     * @param Url           the url
     * @param Login         the login
     * @param password      the password
     * @return the boolean
     *
     * utiliser ce open en utilisant vos identifiants et votre connecteur
     * a utiliser deans une boucle du genre
     * while( open()) (tand que ouvert in peut tourener )
     * et  lorsque l'on appelera close on sortra de la boucle )
     * sa serait inteligent qussi de l'ouvrir uniquement si la connection a la carte arduino est ouvert a vous de voir au niveau du
     * controller
     */
    public Boolean open( String sql_connector, String Url, String Login , String password) {
        DAOTemperature.URL =Url;
        DAOTemperature.LOGIN=Login;
        DAOTemperature.PASSWORD=password;

        /*
         * my on sql conector : com.mysql.cj.jdbc.Driver
         */


        try {
            Class.forName(sql_connector);
            this.connection = DriverManager.getConnection(DAOTemperature .URL,
                    DAOTemperature .LOGIN, DAOTemperature .PASSWORD);
            this.statement = this.connection.createStatement();
        } catch (final ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Close.
     *
     * @throws SQLException the sql exception
     * fermeture de la connection a la base de donne
     */
    public void close() throws SQLException {
        this.connection.close();

    }


    /**
     * Insert temperature.
     *
     * @param serialReader the serial reader
     * @throws SQLException the sql exception
     * insertion des donnes dans notre table tenperature
     * pou l'instant l'id est statique
     */
    public void insertTemperature( SerialReader serialReader) throws SQLException {
       this.executeUpdate(new QueryTemperature().getQueryInsert(serialReader,new ThisDays(), null));

    }

    /*
     * a ne pas toucher permetant l'execution des requetes qui renvoiye des valeurs
     */
    private ResultSet executeQuery(String query) throws SQLException {
        this.cur= this.statement.executeQuery(query);
        return this.cur;
    }
/*

egalement a ne pas toucher ou modifier
 */
    private int executeUpdate(String query) throws SQLException {

        return this.statement.executeUpdate(query);

    }

    /**
     * Select string [ ] [ ].
     *
     * @return the string [ ] [ ]
     * @throws SQLException the sql exception
     *
     * renvoie l'integraliter des donnes contenu dans la base de donne
     *  data[ligne de la table][colone dela table]
     */
    public String[][] select() throws SQLException {

        //this.executeUpdate(new QueryJavaPetri().getQuerySelectAll());
        this.cur =this.statement.executeQuery(new QueryTemperature().getDATA(new ThisDays()));
        cur.last();
        ResultSetMetaData meta = cur.getMetaData();
        String  data[][] =new String[cur.getRow()][meta.getColumnCount()];

        int j=1;
       // System.out.println(cur.getRow());
        cur.beforeFirst();
       // System.out.println(cur.getRow());
        while(cur.next()){//la lecteur est colonne par colonne
            System.out.println();
            for(int i = 1; i < meta.getColumnCount(); i++){
                //  if(cur.getObject(i).toString() != null) {
                System.out.println("okk" + cur.getObject(i).toString());

                data[j - 1][i - 1] = cur.getObject(i).toString();
            }
            //System.out.println(cur.getObject(i));
            //  }

        }
        return data;
    }


    /**
     * Select with month string [ ] [ ].
     *
     * @return the string [ ] [ ]
     * @throws SQLException the sql exception
     * renvoie l'integraliter des donnes contenu dans la base de donne durant le mois
     * data[ligne de la table][colone dela table]
     */
    public String[][] select_with_MONTH() throws SQLException {

        //this.executeUpdate(new QueryJavaPetri().getQuerySelectAll());
        this.cur =this.statement.executeQuery(new QueryTemperature().getDATA_Month(new ThisDays()));
        cur.last();
        ResultSetMetaData meta = cur.getMetaData();
        String  data[][] =new String[cur.getRow()][meta.getColumnCount()];

        int j=1;
        // System.out.println(cur.getRow());
        cur.beforeFirst();
        // System.out.println(cur.getRow());
        while(cur.next()){//la lecteur est colonne par colonne
            System.out.println();
            for(int i = 1; i < meta.getColumnCount(); i++){
                //  if(cur.getObject(i).toString() != null) {
                System.out.println("okk" + cur.getObject(i).toString());

                data[j - 1][i - 1] = cur.getObject(i).toString();
            }
            //System.out.println(cur.getObject(i));
            //  }

        }
        return data;
    }

    /**
     * Select with days string [ ] [ ].
     *
     * @return the string [ ] [ ]
     * @throws SQLException the sql exception
     * renvoie l'integraliter des donnes contenu dans la base de donne durant la journer
     * data[ligne de la table][colone de la table]
     */
    public String[][] select_with_DAYS() throws SQLException {

        //this.executeUpdate(new QueryJavaPetri().getQuerySelectAll());
        this.cur =this.statement.executeQuery(new QueryTemperature().getDATA_DAYS(new ThisDays()));
        cur.last();
        ResultSetMetaData meta = cur.getMetaData();
        String  data[][] =new String[cur.getRow()][meta.getColumnCount()];

        int j=1;
        // System.out.println(cur.getRow());
        cur.beforeFirst();
        // System.out.println(cur.getRow());
        while(cur.next()){//la lecteur est colonne par colonne
            System.out.println();
            for(int i = 1; i < meta.getColumnCount(); i++){
                //  if(cur.getObject(i).toString() != null) {
                System.out.println("okk" + cur.getObject(i).toString());

                data[j - 1][i - 1] = cur.getObject(i).toString();
            }
            //System.out.println(cur.getObject(i));
            //  }

        }
        return data;
    }

    /**
     * Select with years string [ ] [ ].
     *
     * @return the string [ ] [ ]
     * @throws SQLException the sql exception
     *renvoie l'integraliter des donnes contenu dans la base de donne durant l'anne
     * data[ligne de la table][colone dela table]
     */
    public String[][] select_with_YEARS() throws SQLException {

        //this.executeUpdate(new QueryJavaPetri().getQuerySelectAll());
        this.cur =this.statement.executeQuery(new QueryTemperature().getDATA_YEARS((new ThisDays())));
        cur.last();
        ResultSetMetaData meta = cur.getMetaData();
        String  data[][] =new String[cur.getRow()][meta.getColumnCount()];

        int j=1;
        // System.out.println(cur.getRow());
        cur.beforeFirst();
        // System.out.println(cur.getRow());
        while(cur.next()){//la lecteur est colonne par colonne
            System.out.println();
            for(int i = 1; i < meta.getColumnCount(); i++){
                //  if(cur.getObject(i).toString() != null) {
                System.out.println("okk" + cur.getObject(i).toString());

                data[j - 1][i - 1] = cur.getObject(i).toString();
            }
            //System.out.println(cur.getObject(i));
            //  }

        }
        return data;
    }
}
