//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 3

package Tests;

import backend.Customer;
import backend.CustomerDAO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerDAOTest {
    private CustomerDAO customerDAO;
    private int customerId;

    public CustomerDAOTest() {
    }

    @Before
    public void setUp() {
        this.customerDAO = new CustomerDAO();
    }

    @Test
    public void testInsert() {
        Customer customer = new Customer("test@example.com", "password123", "Test User", "Test Address");

        try {
            this.customerId = this.customerDAO.insert(customer);
            Assert.assertTrue(this.customerId > 0);
            this.customerDAO.delete(this.customerId);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    @Test
    public void testGet() {
        Customer customer = new Customer("test@example.com", "password123", "Test User", "Test Address");

        try {
            this.customerId = this.customerDAO.insert(customer);
            customer.setId(this.customerId);
            Customer customer1 = this.customerDAO.get(this.customerId);
            Assert.assertTrue(customer.getId() == customer1.getId());
            this.customerDAO.delete(this.customerId);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    @Test
    public void testUpdate() {
        Customer customer = new Customer("test@example.com", "password123", "Test User", "Test Address");

        try {
            this.customerId = this.customerDAO.insert(customer);
            customer.setId(this.customerId);
            int rowsUpdated = this.customerDAO.update(customer);
            Assert.assertTrue(rowsUpdated > 0);
            this.customerDAO.delete(this.customerId);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    @Test
    public void testLogin() {
        Customer customer = new Customer("test@example.com", "password123", "Test User", "Test Address");

        try {
            this.customerId = this.customerDAO.insert(customer);
            int loginResult = this.customerDAO.login("test@example.com", "password123");
            Assert.assertEquals(1L, (long)loginResult);
            this.customerDAO.delete(this.customerId);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    @Test
    public void testEmailExists() {
        Customer customer = new Customer("test@example.com", "password123", "Test User", "Test Address");

        try {
            this.customerId = this.customerDAO.insert(customer);
            boolean emailExists = this.customerDAO.emailExists("test@example.com");
            Assert.assertTrue(emailExists);
            this.customerDAO.delete(this.customerId);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    @Test
    public void testGetUserIdByEmail() {
        Customer customer = new Customer("test@example.com", "password123", "Test User", "Test Address");

        try {
            this.customerId = this.customerDAO.insert(customer);
            int userId = this.customerDAO.getUserIdByEmail("test@example.com");
            Assert.assertTrue(userId > 0);
            this.customerDAO.delete(this.customerId);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    @Test
    public void testDelete() {
        Customer customer = new Customer("test@example.com", "password123", "Test User", "Test Address");

        try {
            this.customerId = this.customerDAO.insert(customer);
            int rowsDeleted = this.customerDAO.delete(this.customerId);
            Assert.assertTrue(rowsDeleted > 0);
            this.customerDAO.delete(this.customerId);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }
}

