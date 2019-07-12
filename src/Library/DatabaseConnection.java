package Library;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;

public class DatabaseConnection {
    private String username = "root";
    private String password = "hem@1234";
    private String url = "jdbc:mysql://localhost:3306/library";
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private String query = null;

    protected void connect() {
        try {
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to db");
        }
        catch (java.sql.SQLException e) {
            System.out.print("unable to connect to db " + e);
        }
    }
}
