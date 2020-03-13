package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.Impl.PriviledgeImpl;

import java.sql.*;

public class PriviledgeDao implements PriviledgeImpl {
    Connection conn;
    Statement statement;
    PreparedStatement pStatement;
    ResultSet results;
    private static String FOR_NAME = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://cs5200-spring2020-jin.cparjdavcbcl.us-east-2.rds.amazonaws.com/cs5200_jdbc";
    private static String USER = "jinyaoyu";
    private static String PASSWORD = "jyy314159";

    @Override
    public void assignWebsitePriviledge(int developerId, int websiteId, int PriviledgeId) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String ASSIGN_WEBSITE_Priviledge = "insert into web_Priviledge (developer_fk, website_fk, Priviledge) value (?,?,?) ";
            pStatement = conn.prepareStatement(ASSIGN_WEBSITE_Priviledge);
            pStatement.setInt(1, developerId);
            pStatement.setInt(2, websiteId);
            pStatement.setInt(3, PriviledgeId);
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
    public void assignPagePriviledge(int developerId, int pageId, int PriviledgeId) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String ASSIGN_PAGE_Priviledge = "insert into page_Priviledge (developer_fk, page_fk, Priviledge) value (?,?,?) ";
            pStatement = conn.prepareStatement(ASSIGN_PAGE_Priviledge);
            pStatement.setInt(1, developerId);
            pStatement.setInt(2, pageId);
            pStatement.setInt(3, PriviledgeId);
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
    public void deleteWebsitePriviledge(int developerId, int websiteId, int PriviledgeId) {
        String DELETE_WEB_Priviledge = "delete from web_Priviledge where developer_fk=? and website_fk=? and Priviledge_fk=?";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(DELETE_WEB_Priviledge);
            pStatement.setInt(1, developerId);
            pStatement.setInt(2, websiteId);
            pStatement.setInt(3, PriviledgeId);
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
    public void deletePagePriviledge(int developerId, int pageId, int PriviledgeId) {
        String DELETE_PAGE_Priviledge = "delete from page_Priviledge where developer_fk=? and page_fk=? and Priviledge_fk=?";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(DELETE_PAGE_Priviledge);
            pStatement.setInt(1, developerId);
            pStatement.setInt(2, pageId);
            pStatement.setInt(3, PriviledgeId);
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
