package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.Impl.PageRoleImpl;
import edu.northeastern.cs5200.models.PageRole;

import java.sql.*;

public class PageRoleDao implements PageRoleImpl {
    Connection conn;
    Statement statement;
    PreparedStatement pStatement;
    ResultSet results;
    private static String FOR_NAME = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://cs5200-spring2020-jin.cparjdavcbcl.us-east-2.rds.amazonaws.com/cs5200_jdbc";
    private static String USER = "jinyaoyu";
    private static String PASSWORD = "jyy314159";

    @Override
    public void createPageRole(PageRole pageRole) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String CREATE_PAGEROLE = "insert into page_role (developer_fk, page_fk, role_fk) value (?,?,?)";
            pStatement = conn.prepareStatement(CREATE_PAGEROLE);
            pStatement.setInt(1, pageRole.getDeveloper_fk());
            pStatement.setInt(2, pageRole.getPage_fk());
            pStatement.setInt(3, pageRole.getRole_fk());
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
    public void updatePageRole(PageRole pageRole) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String UPDATE_PAGE_ROLE = "update page_role set role_fk=? where developer_fk=? and page_fk=?";
            pStatement = conn.prepareStatement(UPDATE_PAGE_ROLE);
            pStatement.setInt(1, pageRole.getRole_fk());
            pStatement.setInt(2, pageRole.getDeveloper_fk());
            pStatement.setInt(3, pageRole.getPage_fk());
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
