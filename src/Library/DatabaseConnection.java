package Library;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
    private String username = "root";
    private String password = "hem@1234";
    private String url = "jdbc:mysql://localhost:3306/library";
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private String query = null;

    protected void connect() {      //Later chaneg into constructor
        try {
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to db");
        }
        catch (java.sql.SQLException e) {
            System.out.print("unable to connect to db " + e);
        }
    }

    /*
    protected String createTable(String tableName) {
        String res = "";
        int flag = -1;
        try {
            query = "show tables;";
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement(query);     //prepared statmnt improves perf
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if(resultSet.getString(1).equals(tableName)) {
                    flag = 0;break;
                }
            }
            if(flag == 0) {
                res = "Table Already Exists";
            }
            else {
                query = "create table " + tableName + "(userid varchar(500) ,password varchar(200),contact varchar(500))";
            }
        }
        catch (Exception e) {
            res = e.toString();
        }
        return res;
    }
     */

    protected boolean executeQuery(String Query) {              //for update, delete
        try {
            preparedStatement.executeUpdate(Query);
            return true;
        }
        catch (Exception e) {
            System.out.println("unable to process query"+e);
        }
        return false;
    }
    public boolean remove(String query,int id) {                   // for now remove based on id
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            //System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    protected ResultSet getData(String Query) {                     // To get data from database, read
        try {
            preparedStatement = connection.prepareStatement(Query);
            resultSet = preparedStatement.executeQuery(Query);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }
    public ResultSet getData(String query,int id) {                 // for now, get by id.
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public void saveToDB(String query, ArrayList<String> values) {    // create a prepared statement based on arguments.
        try {                                                         // Insert, Create
            preparedStatement = connection.prepareStatement(query);
            for (int i=1;i<=values.size();i++) {
                preparedStatement.setString(i,values.get(i-1));
            }
            preparedStatement.executeUpdate();
            System.out.print("Added To DataBase");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
