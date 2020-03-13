package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.Impl.RoleImpl;

import java.sql.*;

public class RoleDao implements RoleImpl {
    Connection conn;
    Statement statement;
    PreparedStatement pStatement;
    ResultSet results;
    private static String FOR_NAME = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://cs5200-spring2020-jin.cparjdavcbcl.us-east-2.rds.amazonaws.com/cs5200_jdbc";
    private static String USER = "jinyaoyu";
    private static String PASSWORD = "jyy314159";

    @Override
    public void assignWebsiteRole(int developerId, int websiteId, int roleId) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String ASSIGN_WEBSITE_ROLE = "insert into web_role (developer_fk, website_fk, role) value (?,?,?) ";
            pStatement = conn.prepareStatement(ASSIGN_WEBSITE_ROLE);
            pStatement.setInt(1, developerId);
            pStatement.setInt(2, websiteId);
            pStatement.setInt(3, roleId);
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
    public void assignPageRole(int developerId, int pageId, int roleId) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String ASSIGN_PAGE_ROLE = "insert into page_role (developer_fk, page_fk, role) value (?,?,?) ";
            pStatement = conn.prepareStatement(ASSIGN_PAGE_ROLE);
            pStatement.setInt(1, developerId);
            pStatement.setInt(2, pageId);
            pStatement.setInt(3, roleId);
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
    public void deleteWebsiteRole(int developerId, int websiteId, int roleId) {
        String DELETE_WEB_ROLE = "delete from web_role where developer_fk=? and website_fk=? and role_fk=?";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(DELETE_WEB_ROLE);
            pStatement.setInt(1, developerId);
            pStatement.setInt(2, websiteId);
            pStatement.setInt(3, roleId);
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
    public void deletePageRole(int developerId, int pageId, int roleId) {
        String DELETE_PAGE_ROLE = "delete from page_role where developer_fk=? and page_fk=? and role_fk=?";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(DELETE_PAGE_ROLE);
            pStatement.setInt(1, developerId);
            pStatement.setInt(2, pageId);
            pStatement.setInt(3, roleId);
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
