//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 3

package frontend;

import backend.Account;
import backend.AccountDAO;
import backend.Customer;
import backend.CustomerDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

// Signup class extending javax.swing.JFrame for the signup form
public class Signup extends javax.swing.JFrame {

    public Signup() {
        initComponents();
    }

    // Method to initialize GUI components
    @SuppressWarnings("unchecked")
    private void initComponents() {

        // GUI component declarations
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);



        emailLabel.setText("Email:");

        signupLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        signupLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signupLabel.setText("Signup Form");

        passwordLabel.setText("Password:");

        confirmPasswordLabel.setText("Confirm Password:");

        nameLabel.setText("Name:");

        addressLabel.setText("Address:");

        signupButton.setText("Signup");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });


        typeLabel.setText("Account Type");

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Current", "Savings"}));

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
                                                        .addComponent(passwordLabel)
                                                        .addComponent(confirmPasswordLabel)
                                                        .addComponent(emailLabel)
                                                        .addComponent(nameLabel)
                                                        .addComponent(addressLabel)
                                                        .addComponent(typeLabel))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(47, 47, 47)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(emailText)
                                                                                .addComponent(passwordText, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                                                        .addComponent(password2Text, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(nameText)
                                                                        .addComponent(addressText)
                                                                        .addComponent(type))))))
                                .addGap(83, 83, 83))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(signupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(signupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(emailLabel)
                                        .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(password2Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(confirmPasswordLabel))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginButton)
                                        .addComponent(signupButton))
                                .addGap(53, 53, 53))
        );

        pack();
    }



    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CustomerDAO dao = new CustomerDAO();
        AccountDAO dao1 = new AccountDAO();
        try {
            boolean emailExists = dao.emailExists(emailText.getText());

            if (emailExists) {
                JOptionPane.showMessageDialog(this, "Email already exists!");
            } else {
                String password = passwordText.getText();
                String confirmPassword = password2Text.getText();

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(this, "Passwords do not match!");
                } else {
                    Customer customer = new Customer(emailText.getText(), passwordText.getText(), nameText.getText(), addressText.getText());
                    int rowsAffected = dao.insert(customer);

                    if (rowsAffected != -1) {
                        LocalDate currentDate = LocalDate.now();
                        Date sqlDate = Date.valueOf(currentDate);
                        Account account = new Account(rowsAffected, String.valueOf(type.getSelectedItem()), 0, sqlDate);
                        dao1.insert(account);
                        JOptionPane.showMessageDialog(this, "Signup successful!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Error occurred while signing up.");
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage());
        }
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Login login = new Login();
        this.setVisible(false);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }


    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressText;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailText;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JPasswordField password2Text;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JButton signupButton;
    private javax.swing.JLabel signupLabel;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JLabel typeLabel;
}

