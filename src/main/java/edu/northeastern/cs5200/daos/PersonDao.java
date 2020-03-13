package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.Impl.PersonImpl;
import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.User;

import java.sql.*;

public class PersonDao implements PersonImpl {
    Connection conn;
    Statement statement;
    PreparedStatement pStatement;
    ResultSet results;
    private static String FOR_NAME = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://cs5200-spring2020-jin.cparjdavcbcl.us-east-2.rds.amazonaws.com/cs5200_jdbc";
    private static String USER = "jinyaoyu";
    private static String PASSWORD = "jyy314159";

    @Override
    public void createPerson(Person person) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String CREATE_Person = "insert into person (person_id, firstname, lastname, username, password, email, dob) value (?,?,?,?,?,?,?)";
            pStatement = conn.prepareStatement(CREATE_Person);
            pStatement.setInt(1, person.getPerson_id());
            pStatement.setString(2, person.getFirstname());
            pStatement.setString(3, person.getLastname());
            pStatement.setString(4, person.getUsername());
            pStatement.setString(5, person.getPassword());
            pStatement.setString(6, person.getEmail());
            pStatement.setString(7, person.getDob());
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
