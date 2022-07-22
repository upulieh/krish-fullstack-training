import java.sql.Connection;

import mypackage.DBManager;

public class Application {
    public static void main(String args[]){

        //for performance measuring
        long start;
        long end;

        //option 1 (creating instance)
        DBManager dbManager1=DBManager.getDbManager();
        start=System.currentTimeMillis(); //time before creating the instance
        Connection connection1=dbManager1.getConnection();
        end=System.currentTimeMillis(); //time before creating the instance
        System.out.println(end-start); //time taken to create the instance

        //option 2 (using the created instance)
        DBManager dbManager2=DBManager.getDbManager();
        start=System.currentTimeMillis(); //time before creating the instance
        Connection connection2=dbManager2.getConnection();
        end=System.currentTimeMillis(); //time before creating the instance
        System.out.println(end-start); //time taken to create the instance
    }
}
