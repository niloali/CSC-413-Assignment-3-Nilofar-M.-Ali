//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 3

package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Managing database connections
public class dbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/CS413";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Nilojan143!";

    private static Connection connection;

    public dbConnection() {
    }

    // Method to establish a database connection
    public static Connection getDBConnection() throws SQLException {

        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        return connection;
    }
    // Method to disconnect from the database
    public static void disconnect() throws SQLException {
        // Checking if the connection is not null and is open
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

