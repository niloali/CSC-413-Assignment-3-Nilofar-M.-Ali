//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 3

package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDAO implements DAOInterface<Customer> {

    private static final String INSERT_SQL = "INSERT INTO Customers (customerEmail, customerPassword, customerName, customerAddress) VALUES (?, ?, ?, ?)";
    private static final String SELECT_SQL_BY_ID = "SELECT * FROM Customers WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE Customers SET customerEmail = ?, customerPassword = ?, customerName = ?, customerAddress = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM Customers WHERE id = ?";

    public CustomerDAO() {
    }

    @Override
    public Customer get(int id) throws SQLException {
        Connection connection = null;
        try {
            connection = dbConnection.getDBConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_SQL_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setCustomerEmail(resultSet.getString("customerEmail"));
                customer.setCustomerPassword(resultSet.getString("customerPassword"));
                customer.setCustomerName(resultSet.getString("customerName"));
                customer.setCustomerAddress(resultSet.getString("customerAddress"));
                return customer;
            }
            resultSet.close();
            statement.close();
            return null; // If no customer found with the given id
        } finally {
            if (connection != null) {
                dbConnection.disconnect();
            }
        }
    }

    @Override
    public int insert(Customer e) throws SQLException {
        Connection connection = null;
        int generatedCustomerId = -1; // Initialize to a default value

        try {
            connection = dbConnection.getDBConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, e.getCustomerEmail());
            statement.setString(2, e.getCustomerPassword());
            statement.setString(3, e.getCustomerName());
            statement.setString(4, e.getCustomerAddress());
            int rowsAffected = statement.executeUpdate();

            // Retrieve auto-generated key
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                generatedCustomerId = generatedKeys.getInt(1);
            }

            return generatedCustomerId;
        } finally {
            if (connection != null) {
                dbConnection.disconnect();
            }
        }
    }


    @Override
    public int update(Customer e) throws SQLException {
        Connection connection = null;
        try {
            connection = dbConnection.getDBConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_SQL);
            statement.setString(1, e.getCustomerEmail());
            statement.setString(2, e.getCustomerPassword());
            statement.setString(3, e.getCustomerName());
            statement.setString(4, e.getCustomerAddress());
            statement.setInt(5, e.getId());
            return statement.executeUpdate();
        } finally {
            if (connection != null) {
                dbConnection.disconnect();
            }
        }
    }

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
    public int login(String email, String password) throws SQLException {
        Connection connection = null;
        try {
            connection = dbConnection.getDBConnection();
            String sql = "SELECT COUNT(*) FROM Customers WHERE customerEmail = ? AND customerPassword = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0 ? 1 : 0; // Return 1 if login successful, 0 otherwise
                    }
                }
            }
            return 0; // If no record found with the provided email and password
        } finally {
            if (connection != null) {
                dbConnection.disconnect();
            }
        }
    }
    public int signUp(Customer customer) throws SQLException {
        if (emailExists(customer.getCustomerEmail())) {
            // Email already exists, cannot sign up
            return 0;
        } else {
            // Email does not exist, proceed with sign-up
            return insert(customer);
        }
    }

    public boolean emailExists(String email) throws SQLException {
        Connection connection = null;
        try {
            connection = dbConnection.getDBConnection();
            String sql = "SELECT COUNT(*) FROM Customers WHERE customerEmail = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0; // Return true if email exists, false otherwise
                    }
                }
            }
            return false; // If no record found with the provided email
        } finally {
            if (connection != null) {
                dbConnection.disconnect();
            }
        }
    }

    public int getUserIdByEmail(String email) throws SQLException {
        Connection connection = null;
        try {
            connection = dbConnection.getDBConnection();
            String sql = "SELECT id FROM Customers WHERE customerEmail = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt("id");
                    }
                }
            }
            return -1; // Return -1 if no user found with the provided email
        } finally {
            if (connection != null) {
                dbConnection.disconnect();
            }
        }
    }

}

