//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 3

package frontend;

import backend.Account;
import backend.AccountDAO;
import backend.Customer;
import backend.CustomerDAO;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class EditAccount extends javax.swing.JFrame {
    private int accountID = -1; // Initialize account ID to -1 (invalid)
    private int customerID = -1; // Initialize customer ID to -1 (invalid)

    public EditAccount() {
        initComponents();
    }

    public EditAccount(int accountID, int customerID) {
        initComponents(); // Initialize components of the GUI
        this.accountID = accountID;
        this.customerID = customerID;
        fill(); // Fill the form with existing data
    }

    // Method to fill the form with existing customer and account details
    private void fill() {
        try {
            CustomerDAO customerDAO = new CustomerDAO();
            Customer customer = customerDAO.get(customerID);
            if (customer != null) {
                emailText.setText(customer.getCustomerEmail());
                nameText.setText(customer.getCustomerName());
                addressText.setText(customer.getCustomerAddress());
            } else {
                JOptionPane.showMessageDialog(this, "Customer not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            AccountDAO accountDAO = new AccountDAO();
            Account account = accountDAO.get(accountID);
            if (account != null) {
                type.setSelectedItem(account.getType());
            } else {
                JOptionPane.showMessageDialog(this, "Account not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error fetching details: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {

        emailText = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        signupLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        confirmPasswordLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressText = new javax.swing.JTextField();
        signupButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        passwordText = new javax.swing.JPasswordField();
        password2Text = new javax.swing.JPasswordField();
        typeLabel = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        passwordLabel1 = new javax.swing.JLabel();
        oldText = new javax.swing.JPasswordField();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);



        emailLabel.setText("Email:");

        signupLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        signupLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signupLabel.setText("Edit Form");

        passwordLabel.setText("Password:");

        confirmPasswordLabel.setText("Confirm Password:");

        nameLabel.setText("Name:");



        addressLabel.setText("Address:");



        signupButton.setText("Update");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });

        loginButton.setText("Back");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });



        typeLabel.setText("Account Type");

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Current", "Savings" }));

        passwordLabel1.setText("old password:");



        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(51, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(loginButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(signupButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(passwordLabel1)
                                                        .addComponent(passwordLabel)
                                                        .addComponent(confirmPasswordLabel)
                                                        .addComponent(emailLabel)
                                                        .addComponent(nameLabel)
                                                        .addComponent(addressLabel)
                                                        .addComponent(typeLabel))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(47, 47, 47)
                                                                .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(password2Text)
                                                                        .addComponent(nameText)
                                                                        .addComponent(addressText)
                                                                        .addComponent(type)
                                                                        .addComponent(passwordText)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(46, 46, 46)
                                                                .addComponent(oldText)))))
                                .addGap(83, 83, 83))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(logoutButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(signupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(logoutButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(emailLabel)
                                        .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(oldText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordLabel)
                                        .addComponent(passwordText))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(confirmPasswordLabel)
                                        .addComponent(password2Text))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel)
                                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addressLabel)
                                        .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(typeLabel)
                                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginButton)
                                        .addComponent(signupButton))
                                .addGap(26, 26, 26))
        );

        pack();
    }

    // Update customer and account details based on form inputs
    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CustomerDAO customerDAO = new CustomerDAO();
        AccountDAO accountDAO = new AccountDAO();
        try {
            String email = emailText.getText();
            String oldPassword = oldText.getText();
            String newPassword = passwordText.getText();
            String confirmPassword = password2Text.getText();
            String name = nameText.getText();
            String address = addressText.getText();
            String type1 = String.valueOf(type.getSelectedItem());

            Customer existingCustomer = customerDAO.get(customerID);
            if (existingCustomer == null) {
                JOptionPane.showMessageDialog(this, "Customer not found with the provided email!");
                return;
            }

            if (!existingCustomer.getCustomerPassword().equals(oldPassword)) {
                JOptionPane.showMessageDialog(this, "Old password does not match!");
                return;
            }

            if (!newPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "New passwords do not match!");
                return;
            }

            if(newPassword.isEmpty()) {
                existingCustomer.setCustomerPassword(oldPassword);
            } else {
                existingCustomer.setCustomerPassword(newPassword);
            }
            existingCustomer.setCustomerEmail(email);
            existingCustomer.setCustomerName(name);
            existingCustomer.setCustomerAddress(address);
            int customerUpdateResult = customerDAO.update(existingCustomer);

            // Check if customer update was successful and update account details
            if (customerUpdateResult == -1) {
                JOptionPane.showMessageDialog(this, "Error occurred while updating customer!");
                return;
            }

            Account account = accountDAO.get(accountID);
            if (account == null) {
                JOptionPane.showMessageDialog(this, "Account not found!");
                return;
            }

            account.setType(type1);
            int accountUpdateResult = accountDAO.update(account);

            if (accountUpdateResult == -1) {
                JOptionPane.showMessageDialog(this, "Error occurred while updating account!");
                return;
            }

            JOptionPane.showMessageDialog(this, "Updated successfully!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage());
        }
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        Homepage homepage = new Homepage(accountID, customerID);
        homepage.setLocationRelativeTo(null);
        homepage.setVisible(true);
    }

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        Startup startup = new Startup();
        startup.setLocationRelativeTo(null);
        startup.setVisible(true);
    }

    // Declaration of GUI components
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressText;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailText;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JPasswordField oldText;
    private javax.swing.JPasswordField password2Text;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JButton signupButton;
    private javax.swing.JLabel signupLabel;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JLabel typeLabel;
}

