package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.Impl.WebsiteImpl;
import edu.northeastern.cs5200.Impl.WebsiteRoleImpl;
import edu.northeastern.cs5200.models.WebRole;

import java.sql.*;

public class WebsiteRoleDao implements WebsiteRoleImpl {
    Connection conn;
    Statement statement;
    PreparedStatement pStatement;
    ResultSet results;
    private static String FOR_NAME = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://cs5200-spring2020-jin.cparjdavcbcl.us-east-2.rds.amazonaws.com/cs5200_jdbc";
    private static String USER = "jinyaoyu";
    private static String PASSWORD = "jyy314159";

    @Override
    public void createWebRole(WebRole webRole) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String CREATE_WEBROLE = "insert into web_role (developer_fk, website_fk, role_fk) value (?,?,?)";
            pStatement = conn.prepareStatement(CREATE_WEBROLE);
            pStatement.setInt(1, webRole.getDeveloper_fk());
            pStatement.setInt(2, webRole.getWebsite_fk());
            pStatement.setInt(3, webRole.getRole_fk());
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

    @Override
    public void deleteWebRole(int website_fk) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String DELETE_WEB_ROLE = "delete from web_role where website_fk = ?";
            pStatement = conn.prepareStatement(DELETE_WEB_ROLE);
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
