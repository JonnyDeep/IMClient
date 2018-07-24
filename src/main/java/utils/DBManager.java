package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private final static String USERNAME="root";
    private final static String PASSWORD="123456";
    private final static String URL="jdbc:mysql://localhost:3306/IMDB?serverTimezone=GMT";
    private final static String DRIVER="com.mysql.cj.jdbc.Driver";

    private static Connection con = null;

    public static Connection getConnection() throws ClassNotFoundException,SQLException
    {
        Class.forName(DRIVER);
        con = (Connection)DriverManager.getConnection(URL,USERNAME,PASSWORD);

        if(con!=null){
            System.out.println("connect success");
        }else{
            System.out.println("connect failed");
        }
        return con;
    }

    public static void close() throws SQLException
    {
        if(con!=null)
        {
            con.close();
        }
    }



}
