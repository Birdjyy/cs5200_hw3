package edu.northeastern.cs5200.daos;


import edu.northeastern.cs5200.Impl.DeveloperImpl;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Person;

import java.sql.*;
import java.util.Collection;

public class DeveloperDao implements DeveloperImpl {
    Connection conn;
    Statement statement;
    PreparedStatement pStatement;
    ResultSet results;
    private static String FOR_NAME = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://cs5200-spring2020-jin.cparjdavcbcl.us-east-2.rds.amazonaws.com/cs5200_jdbc";
    private static String USER = "jinyaoyu";
    private static String PASSWORD = "jyy314159";
    private static String CREATE_DEVELOPER = "insert into developer (person_fk, developer_key) values (?, ?)";
    private static String CREATE_PERSON = "insert into person value (?,?,?,?,?,?,?)";
    private static String FIND_ALL_DEVELOPERS = "select * from developer";
    private static String FIND_DEVELOPER_BY_ID = "select * from developer where person_fk = ?";
    @Override
    public void createDeveloper(Developer developer) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(CREATE_PERSON);
            pStatement.setInt(1, developer.getPerson().getPerson_id());
            pStatement.setString(2, developer.getPerson().getFirstname());
            pStatement.setString(3, developer.getPerson().getLastname());
            pStatement.setString(4, developer.getPerson().getUsername());
            pStatement.setString(5, developer.getPerson().getPassword());
            pStatement.setString(6, developer.getPerson().getEmail());
            pStatement.setString(7, developer.getPerson().getDob());
            pStatement.executeUpdate();

            pStatement = conn.prepareStatement(CREATE_DEVELOPER);
            pStatement.setInt(1, developer.getPerson().getPerson_id());
            pStatement.setString(2, developer.getDeveloper_key());
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
    public Collection<Developer> findAllDevelopers() {
        Collection<Developer> developers = null;
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            statement = conn.createStatement();
            results = statement.executeQuery(FIND_ALL_DEVELOPERS);
            while (results.next()) {
                int person_fk = results.getInt("person_fk");
                String developer_key = results.getString("developer_key");
                Person person = (Person) results.getObject("person");
                Developer developer = new Developer(person_fk, person, developer_key);
                developers.add(developer);
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
        return developers;
    }
    @Override
    public Developer findDeveloperById(int developerId) {
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(FIND_DEVELOPER_BY_ID);
            pStatement.setInt(1, developerId);
            ResultSet resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                Developer developer = new Developer(
                        resultSet.getInt("person_fk"),
                        (Person) resultSet.getObject("person"),
                        resultSet.getString("developer_key")
                );
                return developer;
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
    public Developer findDeveloperByUsername (String username) {
        String FIND_DEVELOPER_BY_USERNAME = "select * from developer where person_fk = (select person_id from person where username = ?)";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(FIND_DEVELOPER_BY_USERNAME);
            pStatement.setString(1, username);
            ResultSet resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                Developer developer = new Developer(
                        resultSet.getInt("person_fk"),
                        (Person) resultSet.getObject("person"),
                        resultSet.getString("developer_key")
                );
                return developer;
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
    public  Developer findDeveloperByCredentials(String username, String password) {
        String FIND_DEVELOPER_BY_CREDENTIALS = "select * from developer where person_fk = (select person_id from person where username = ? and password = ?)";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(FIND_DEVELOPER_BY_CREDENTIALS);
            pStatement.setString(1, username);
            pStatement.setString(2, password);
            ResultSet resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                Developer developer = new Developer(
                        resultSet.getInt("person_fk"),
                        (Person) resultSet.getObject("person"),
                        resultSet.getString("developer_key")
                );
                return developer;
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
    public int updateDeveloper(int developerId, Developer developer) {
        String UPDATE_DEVELOPER = "update developer set person_fk = ?, developer_key = ? where person_fk = ?";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(UPDATE_DEVELOPER);
            pStatement.setInt(1, developer.getPerson_fk());
            pStatement.setString(2, developer.getDeveloper_key());
            pStatement.setInt(3, developerId);
            pStatement.executeUpdate();

            String UPDATE_PERSON = "update person set person_id=?, firstname=?, lastname=?, username=?, password=?, email=?, dob=? where person_id=?";
            pStatement = conn.prepareStatement(UPDATE_PERSON);
            pStatement.setInt(1, developer.getPerson().getPerson_id());
            pStatement.setString(2, developer.getPerson().getFirstname());
            pStatement.setString(3, developer.getPerson().getLastname());
            pStatement.setString(4, developer.getPerson().getUsername());
            pStatement.setString(5, developer.getPerson().getPassword());
            pStatement.setString(6, developer.getPerson().getEmail());
            pStatement.setString(7, developer.getPerson().getDob());
            pStatement.setInt(7, developerId);
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
    public void updatephone(int developerId, String phone) {
        String UPDATE_PHONE = "update phone set phone=? where p_primary=true and person_fk=?";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(UPDATE_PHONE);
            pStatement.setString(1, phone);
            pStatement.setInt(2, developerId);
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
    public int deleteDeveloper(int developerId) {
        String DELETE_DEVELOPER = "delete from developer where person_fk=?";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(DELETE_DEVELOPER);
            pStatement.setInt(1, developerId);
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
    public void deleteAdress(int developerId, boolean primary) {
        String DELETE_ADDRESS = "delete from address where person_fk=? and primary=?";
        try {
            Class.forName(FOR_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            pStatement = conn.prepareStatement(DELETE_ADDRESS);
            pStatement.setInt(1, developerId);
            pStatement.setBoolean(1, primary);
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
