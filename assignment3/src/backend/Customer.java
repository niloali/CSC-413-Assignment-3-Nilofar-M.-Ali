//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 3

package backend;

// Define the Customer class to represent customer data
public class Customer {
    private int id;
    private String customerEmail;
    private String customerPassword;
    private String customerName;
    private String customerAddress;

    public Customer() {
    }

    // Parameterized constructor to initialize customer details
    public Customer(String customerEmail, String customerPassword, String customerName, String customerAddress) {
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    //getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    // Method to print customer details
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public void printCustomer() {
        System.out.println("backend.Customer ID: " + id);
        System.out.println("backend.Customer Email: " + customerEmail);
        System.out.println("backend.Customer Password: " + customerPassword);
        System.out.println("backend.Customer Name: " + customerName);
        System.out.println("backend.Customer Address: " + customerAddress);
    }
}

