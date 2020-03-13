package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.Impl.WebPriviledgeImpl;

import java.sql.*;

public class WebPriviledgeDao implements WebPriviledgeImpl {
    Connection conn;
    Statement statement;
    PreparedStatement pStatement;
    ResultSet results;
    private static String FOR_NAME = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://cs5200-spring2020-jin.cparjdavcbcl.us-east-2.rds.amazonaws.com/cs5200_jdbc";
    private static String USER = "jinyaoyu";
    private static String PASSWORD = "jyy314159";

    @Override
    public void deleteWebRole(int website_fk) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String DELETE_WEB_PRIVILEDGE = "delete from web_priviledge where website_fk = ?";
            pStatement = conn.prepareStatement(DELETE_WEB_PRIVILEDGE);
            pStatement.setInt(1, website_fk);
            pStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
