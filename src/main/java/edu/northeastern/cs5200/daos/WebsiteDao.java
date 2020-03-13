package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.Impl.WebsiteImpl;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.Website;

import java.sql.*;
import java.util.Collection;

public class WebsiteDao implements WebsiteImpl {
    Connection conn;
    Statement statement;
    PreparedStatement pStatement;
    ResultSet results;
    private static String FOR_NAME = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://cs5200-spring2020-jin.cparjdavcbcl.us-east-2.rds.amazonaws.com/cs5200_jdbc";
    private static String USER = "jinyaoyu";
    private static String PASSWORD = "jyy314159";
    @Override
    public void createWebsiteForDeveloper(int developerId, Website website) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String CREATE_WEBSITE_FOR_WEBSITE = "insert into website (website_id, name,description, created, updated, visits, developer_fk) value (?,?,?,?,?,?,?)";
            pStatement = conn.prepareStatement(CREATE_WEBSITE_FOR_WEBSITE);
            pStatement.setInt(1, website.getWebsite_id());
            pStatement.setString(2, website.getName());
            pStatement.setString(3, website.getDescription());
            pStatement.setDate(4, website.getCreated());
            pStatement.setDate(5, website.getUpdated());
            pStatement.setInt(6, website.getVisits());
            pStatement.setInt(7, developerId);
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
    public Collection<Website> findAllWebsites() {
        Collection<Website> websites = null;
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String FIND_ALL_WEBSITES = "select * from website";

            statement = conn.createStatement();
            results = statement.executeQuery(FIND_ALL_WEBSITES);
            while (results.next()) {
                int website_id = results.getInt("website_id");
                String name = results.getString("name");
                String description = results.getString("description");
                Date created = results.getDate("created");
                Date updated = results.getDate("update");
                int visits = results.getInt("visits");
                Website website = new Website(website_id, name, description, created,updated, visits);
                websites.add(website);
            }

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
        return websites;
    }
    @Override
    public Collection<Website> findWebsiteForDeveloper(int developerId) {
        Collection<Website> websites = null;
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String FIND_WEBSITE_FOR_DEVELOPER = "select * from website where developer_fk=?";

            pStatement = conn.prepareStatement(FIND_WEBSITE_FOR_DEVELOPER);
            pStatement.setInt(1, developerId);
            ResultSet resultSet = pStatement.executeQuery();
            while (results.next()) {
                int website_id = results.getInt("website_id");
                String name = results.getString("name");
                String description = results.getString("description");
                Date created = results.getDate("created");
                Date updated = results.getDate("update");
                int visits = results.getInt("visits");
                Website website = new Website(website_id, name, description, created,updated, visits);
                websites.add(website);
            }
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
        return websites;
    }
    @Override
    public Website findWebsiteById(int websiteId) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String FIND_WEBSITE_BY_ID = "select * from website where website_id=?";
            pStatement = conn.prepareStatement(FIND_WEBSITE_BY_ID);
            pStatement.setInt(1, websiteId);
            ResultSet resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                Website website = new Website(
                        results.getInt("website_id"),
                        results.getString("name"),
                        results.getString("description"),
                        results.getDate("created"),
                        results.getDate("update"),
                        results.getInt("visits")
                );
                return website;
            }
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
        return null;
    }
    @Override
    public int updateWebsite(int websiteId, Website website) {
        String UPDATE_WEBSITE = "update website set name = ?, desvription=?, created=?, updated=?, visits=?, developer_fk=? where website_id = ?";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(UPDATE_WEBSITE);
            pStatement.setString(1, website.getName());
            pStatement.setString(2, website.getDescription());
            pStatement.setDate(3, (Date) website.getCreated());
            pStatement.setDate(4, (Date) website.getUpdated());
            pStatement.setInt(5, website.getVisits());
            pStatement.setInt(6, website.getDeveloper_fk());
            pStatement.setInt(7, websiteId);

            return pStatement.executeUpdate();

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
        return -1;
    }
    @Override
    public int deleteWebsite(int websiteId) {
        String DELETE_WEBSITE = "delete from website where website_id=?";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(DELETE_WEBSITE);
            pStatement.setInt(1, websiteId);
            return pStatement.executeUpdate();

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
        return -1;
    }
}
