package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.Impl.UserImpl;
import edu.northeastern.cs5200.models.User;

import java.sql.*;

public class UserDao implements UserImpl {
    Connection conn;
    Statement statement;
    PreparedStatement pStatement;
    ResultSet results;
    private static String FOR_NAME = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://cs5200-spring2020-jin.cparjdavcbcl.us-east-2.rds.amazonaws.com/cs5200_jdbc";
    private static String USER = "jinyaoyu";
    private static String PASSWORD = "jyy314159";

    @Override
    public void createUser(User user) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String CREATE_USER = "insert into user (person_fk, user_agreement) value (?,?)";
            pStatement = conn.prepareStatement(CREATE_USER);
            pStatement.setInt(1, user.getPerson_fk());
            //boolean test = user.isUser_agreement();
            pStatement.setBoolean(2, user.isUser_agreement());
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
