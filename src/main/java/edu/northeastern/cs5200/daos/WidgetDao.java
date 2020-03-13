package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.Impl.WidgetImpl;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;
import sun.awt.WindowIDProvider;

import java.sql.*;
import java.util.Collection;

public class WidgetDao implements WidgetImpl {
    Connection conn;
    Statement statement;
    PreparedStatement pStatement;
    ResultSet results;
    private static String FOR_NAME = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://cs5200-spring2020-jin.cparjdavcbcl.us-east-2.rds.amazonaws.com/cs5200_jdbc";
    private static String USER = "jinyaoyu";
    private static String PASSWORD = "jyy314159";
    @Override
    public void createWidgetForPage(int pageId, Widget widget) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String CREATE_WIDGET_FOR_PAGE = "insert into widget (name,width, height, css_class, css_style, text, widget_order, page_fk) value (?,?,?,?,?,?,?,?)";
            pStatement = conn.prepareStatement(CREATE_WIDGET_FOR_PAGE);
            pStatement.setString(1, widget.getName());
            pStatement.setInt(2, widget.getWidth());
            pStatement.setInt(3, widget.getHeight());
            pStatement.setString(4, widget.getCss_class());
            pStatement.setString(5, widget.getCss_style());
            pStatement.setString(6, widget.getText());
            pStatement.setInt(7, widget.getWidget_order());
            pStatement.setInt(8, pageId);
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
    public void createImageWidgetForWieget(int widgetId, String src) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String CREATE_IMAGE_FOR_WIDGET = "insert into image_widget (src,widget_fk) value (?,?)";
            pStatement = conn.prepareStatement(CREATE_IMAGE_FOR_WIDGET);
            pStatement.setString(1, src);
            pStatement.setInt(2, widgetId);

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
    public void createYoutubeWidgetForWieget(int widgetId, String url) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String CREATE_YOUTUBE_FOR_WIDGET = "insert into youtube_widget (url,widget_fk) value (?,?)";
            pStatement = conn.prepareStatement(CREATE_YOUTUBE_FOR_WIDGET);
            pStatement.setString(1, url);
            pStatement.setInt(2, widgetId);

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
    public Collection<Widget> findAllWidgets() {
        Collection<Widget> widgets = null;
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String FIND_ALL_WIDGET = "select * from widget";

            statement = conn.createStatement();
            results = statement.executeQuery(FIND_ALL_WIDGET);
            while (results.next()) {
                int widget_id = results.getInt("widget_id");
                String name = results.getString("name");
                int width = results.getInt("width");
                int height = results.getInt("height");
                String  css_class = results.getString("css_class");
                String css_style = results.getString("css_style");
                String text = results.getString("text");
                int order = results.getInt("order");
                Widget widget = new Widget(widget_id, name, width, height,css_class, css_style, text, order);
                widgets.add(widget);
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
        return widgets;
    }
    @Override
    public Widget findWidgetById(int widgetId) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String FIND_WIDGET_BY_ID = "select * from widget where widget_id=?";
            pStatement = conn.prepareStatement(FIND_WIDGET_BY_ID);
            pStatement.setInt(1, widgetId);
            ResultSet resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                Widget widget = new Widget(
                        results.getInt("widget_id"),
                        results.getString("name"),
                        results.getInt("width"),
                        results.getInt("height"),
                        results.getString("css_class"),
                        results.getString("css_style"),
                        results.getString("text"),
                        results.getInt("order")
                );
                return widget;
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
    public Collection<Widget> findWidgetsForPage(int pageId) {
        Collection<Widget> widgets = null;
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String FIND_WIDGET_FOR_PAGE = "select * from widget where page_fk=?";

            pStatement = conn.prepareStatement(FIND_WIDGET_FOR_PAGE);
            pStatement.setInt(1, pageId);
            ResultSet resultSet = pStatement.executeQuery();
            while (results.next()) {
                int widget_id = results.getInt("widget_id");
                String name = results.getString("name");
                int width = results.getInt("width");
                int height = results.getInt("height");
                String  css_class = results.getString("css_class");
                String css_style = results.getString("css_style");
                String text = results.getString("text");
                int order = results.getInt("order");
                Widget widget = new Widget(widget_id, name, width, height,css_class, css_style, text, order);
                widgets.add(widget);
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
        return widgets;
    }
    @Override
    public int updateWidget(int widgetId, Widget widget) {
        String UPDATE_WIDGET = "update widget set name = ?, width=?, height=?, css_class=?, css_style=?, text=?, widget_order=?, page_fk=? where widget_id = ?";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(UPDATE_WIDGET);
            pStatement.setString(1, widget.getName());
            pStatement.setInt(2, widget.getWidth());
            pStatement.setInt(3, widget.getHeight());
            pStatement.setString(4, widget.getCss_class());
            pStatement.setString(5, widget.getCss_style());
            pStatement.setString(6, widget.getText());
            pStatement.setInt(7, widget.getWidget_order());
            pStatement.setInt(8, widget.getPage_fk());
            pStatement.setInt(9, widgetId);
            pStatement.executeUpdate();

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
    public int deleteWidget(int widgetId) {
        String DELETE_WIDGET = "delete from widget where widget_id=?";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(DELETE_WIDGET);
            pStatement.setInt(1, widgetId);
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
    public void deleteLastWidget(int pageFk) {
        String DELETE_LAST_WIDGET = "delete from widget where page_fk=? and order=(select max(order) from widget having page_fk=?)";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(DELETE_LAST_WIDGET);
            pStatement.setInt(1, pageFk);
            pStatement.setInt(2, pageFk);
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
