package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static volatile DBManager dbManager;
    private static volatile Connection connection;

    private DBManager(){
        if(dbManager != null){
            throw new RuntimeException("Please use getDBManager method");
        }
    }
    public static DBManager getDbManager(){
        if(dbManager ==null) {
            synchronized (DBManager.class) { //to make it thread safe we use a double checking instance
                dbManager = new DBManager();
            }
        }
        return dbManager;
    }

    public Connection getConnection(){ //not made static as the dbManager instance could be used to acess this
        if(connection ==null) {
            synchronized (DBManager.class) { //to make it thread safe we use a double checking instance
                if(connection==null){
                    String url="jdbc:derby:memory:sample;create=true";
                    try {
                        connection = DriverManager.getConnection(url);
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
}
