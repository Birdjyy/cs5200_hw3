package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.Impl.PageImpl;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Website;

import java.sql.*;
import java.util.Collection;

public class PageDao implements PageImpl {
    Connection conn;
    Statement statement;
    PreparedStatement pStatement;
    ResultSet results;
    private static String FOR_NAME = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://cs5200-spring2020-jin.cparjdavcbcl.us-east-2.rds.amazonaws.com/cs5200_jdbc";
    private static String USER = "jinyaoyu";
    private static String PASSWORD = "jyy314159";

    @Override
    public void createPageForWebsite(int websiteId, Page page) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String CREATE_WEBSITE_FOR_PAGE = "insert into page (page_id, title,description, created, updated, views, website_fk) value (?,?,?,?,?,?,?)";
            pStatement = conn.prepareStatement(CREATE_WEBSITE_FOR_PAGE);
            pStatement.setInt(1, page.getPage_id());
            pStatement.setString(2, page.getTitle());
            pStatement.setString(3, page.getDescription());
            pStatement.setDate(4, page.getCreated());
            pStatement.setDate(5, page.getUpdated());
            pStatement.setInt(6, page.getViews());
            pStatement.setInt(7, websiteId);
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
    public Collection<Page> findAllPages() {
        Collection<Page> pages = null;
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String FIND_ALL_PAGES = "select * from page";

            statement = conn.createStatement();
            results = statement.executeQuery(FIND_ALL_PAGES);
            while (results.next()) {
                int page_id = results.getInt("page_id");
                String title = results.getString("title");
                String description = results.getString("description");
                Date created = results.getDate("created");
                Date updated = results.getDate("update");
                int views = results.getInt("views");
                Page page = new Page(page_id, title, description, created,updated, views);
                pages.add(page);
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
        return pages;
    }
    @Override
    public Page findPageById(int pageId) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String FIND_PAGE_BY_ID = "select * from page where page_id=?";
            pStatement = conn.prepareStatement(FIND_PAGE_BY_ID);
            pStatement.setInt(1, pageId);
            ResultSet resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                Page page = new Page(
                        results.getInt("page_id"),
                        results.getString("title"),
                        results.getString("description"),
                        results.getDate("created"),
                        results.getDate("update"),
                        results.getInt("views")
                );
                return page;
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
    public Collection<Page> findPagesForWebsite(int websiteId) {
        Collection<Page> pages = null;
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String FIND_PAGE_FOR_WEBSITE = "select * from page where website_fk=?";

            pStatement = conn.prepareStatement(FIND_PAGE_FOR_WEBSITE);
            pStatement.setInt(1, websiteId);
            ResultSet resultSet = pStatement.executeQuery();
            while (results.next()) {
                int page_id = results.getInt("page_id");
                String title = results.getString("title");
                String description = results.getString("description");
                Date created = results.getDate("created");
                Date updated = results.getDate("update");
                int views = results.getInt("views");
                Page page = new Page(page_id, title, description, created,updated, views);
                pages.add(page);
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
        return pages;
    }
    @Override
    public int updatePage(int pageId, Page page) {
        String UPDATE_PAGE = "update page set title = ?, description=?, created=?, updated=?, views=?, website_fk=? where page_id = ?";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(UPDATE_PAGE);
            pStatement.setString(1, page.getTitle());
            pStatement.setString(2, page.getDescription());
            pStatement.setDate(3, (Date) page.getCreated());
            pStatement.setDate(4, (Date) page.getUpdated());
            pStatement.setInt(5, page.getViews());
            pStatement.setInt(6, page.getWebsite_fk());
            pStatement.setInt(7, pageId);

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
    public int deletePage(int pageId) {
        String DELETE_PAGE = "delete from page where page_id=?";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(DELETE_PAGE);
            pStatement.setInt(1, pageId);
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
    public int deleteLastPage(int website_fk) {
        String DELETE_LAST_PAGE = "delete from page where website_fk=? and updated= (select max(updated) from page having website_fk=?)";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(DELETE_LAST_PAGE);
            pStatement.setInt(1, website_fk);
            pStatement.setInt(2, website_fk);
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
