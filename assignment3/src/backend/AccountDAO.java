//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 3

package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// AccountDAO class implementing DAOInterface for Account objects
public class AccountDAO implements DAOInterface<Account> {

    private static final String INSERT_SQL = "INSERT INTO Accounts (customerId, type, balance, creationDate) VALUES (?, ?, ?, ?)";
    private static final String SELECT_SQL_BY_ID = "SELECT * FROM Accounts WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE Accounts SET customerId = ?, type = ?, balance = ?, creationDate = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM Accounts WHERE id = ?";

    public AccountDAO() {
    }

    // Retrieve an account from the database by its ID
    @Override
    public Account get(int id) throws SQLException {
        Connection connection = null;
        try {
            connection = dbConnection.getDBConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_SQL_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Account account = new Account();
                // Set account details from the database result
                account.setId(resultSet.getInt("id"));
                account.setCustomerId(resultSet.getInt("customerId"));
                account.setType(resultSet.getString("type"));
                account.setBalance(resultSet.getDouble("balance"));
                account.setCreationDate(resultSet.getDate("creationDate"));
                return account;
            }
            resultSet.close();
            statement.close();
            return null; // If no account found with the given id
        } finally {
            if (connection != null) {
                dbConnection.disconnect(); // Disconnect from the database
            }
        }
    }

    // Insert a new account into the database
    @Override
    public int insert(Account e) throws SQLException {
        Connection connection = null;
        try {
            connection = dbConnection.getDBConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_SQL);
            // Set parameters for the new account
            statement.setInt(1, e.getCustomerId());
            statement.setString(2, e.getType());
            statement.setDouble(3, e.getBalance());
            statement.setDate(4, e.getCreationDate());
            return statement.executeUpdate();
        } finally {
            if (connection != null) {
                dbConnection.disconnect();
            }
        }
    }

    // Update an existing account in the database
    @Override
    public int update(Account e) throws SQLException {
        Connection connection = null;
        try {
            connection = dbConnection.getDBConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_SQL);
            // Set parameters for updating the account
            statement.setInt(1, e.getCustomerId());
            statement.setString(2, e.getType());
            statement.setDouble(3, e.getBalance());
            statement.setDate(4, e.getCreationDate());
            statement.setInt(5, e.getId());
            return statement.executeUpdate();
        } finally {
            if (connection != null) {
                dbConnection.disconnect();
            }
        }
    }

    // Delete an account from the database by its ID
    @Override
    public int delete(int id) throws SQLException {
        Connection connection = null;
        try {
            connection = dbConnection.getDBConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_SQL);
            statement.setInt(1, id);
            return statement.executeUpdate();
        } finally {
            if (connection != null) {
                dbConnection.disconnect();
            }
        }
    }

    // Get account ID by customer ID from the database
    public int getAccountIdByCustomerId(int customerId) throws SQLException {
        Connection connection = null;
        try {
            connection = dbConnection.getDBConnection();
            String sql = "SELECT id FROM Accounts WHERE customerId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, customerId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt("id"); // Return the account ID
                    }
                }
            }
            return -1; // Return -1 if no account found with the provided customer ID
        } finally {
            if (connection != null) {
                dbConnection.disconnect();
            }
        }
    }
}

