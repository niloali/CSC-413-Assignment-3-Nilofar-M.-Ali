//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 3

package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// TransactionDAO class implementing DAOInterface for Transaction objects
public class TransactionDAO implements DAOInterface<Transaction> {

    // SQL queries for database operations
    private static final String INSERT_SQL = "INSERT INTO Transactions (accountId, type, amount, timestamp) VALUES (?, ?, ?, ?)";
    private static final String SELECT_SQL_BY_ID = "SELECT * FROM Transactions WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM Transactions WHERE id = ?";

    public TransactionDAO() {
    }

    // Method to retrieve a Transaction object by ID from the database
    @Override
    public Transaction get(int id) throws SQLException {
        Connection connection = null;
        try {
            connection = dbConnection.getDBConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_SQL_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getInt("id"));
                transaction.setAccountId(resultSet.getInt("accountId"));
                transaction.setType(resultSet.getString("type"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setTimestamp(resultSet.getTimestamp("timestamp"));
                return transaction; // Return the populated Transaction object
            }
            resultSet.close();
            statement.close();
            return null; // If no transaction found with the given id
        } finally {
            if (connection != null) {
                dbConnection.disconnect();
            }
        }
    }

    // Method to insert a Transaction object into the database
    @Override
    public int insert(Transaction e) throws SQLException {
        Connection connection = null;
        try {
            connection = dbConnection.getDBConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_SQL);
            statement.setInt(1, e.getAccountId());
            statement.setString(2, e.getType());
            statement.setDouble(3, e.getAmount());
            statement.setTimestamp(4, e.getTimestamp());
            return statement.executeUpdate();
        } finally {
            if (connection != null) {
                dbConnection.disconnect();
            }
        }
    }

    // Method to update a Transaction object in the database
    @Override
    public int update(Transaction e) throws SQLException {
        throw new UnsupportedOperationException("Updating Transactions is not allowed");
    }

    // Method to delete a Transaction object from the database by ID
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
}

