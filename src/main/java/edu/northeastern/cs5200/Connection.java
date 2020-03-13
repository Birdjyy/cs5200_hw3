package edu.northeastern.cs5200;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://cs5200-spring2020-jin.cparjdavcbcl.us-east-2.rds.amazonaws.com/cs5200_jdbc";
    private static final String USER = "jinyaoyu";
    private static final String PASSWORD = "jyy314159";
    private static 	java.sql.Connection dbConnection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);

        if (dbConnection == null) {
            dbConnection = DriverManager.getConnection(URL, USER, PASSWORD);
            return (Connection) dbConnection;
        } else { return (Connection) dbConnection; } }

    public static void closeConnection() {
        try {
            if (dbConnection != null) {
                dbConnection.close();
                dbConnection = null; }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
