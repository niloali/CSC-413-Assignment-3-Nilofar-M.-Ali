//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 3

package frontend;

import backend.AccountDAO;
import backend.CustomerDAO;
import javax.swing.JOptionPane;

// Login class extending javax.swing.JFrame for the login form
public class Login extends javax.swing.JFrame {

    //Initialize the login form components
    public Login() {
        initComponents();
    }

    private void initComponents() {

        // GUI component declarations
        emailText = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        signupLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        signupButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        passwordText = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        emailLabel.setText("Email:");

        signupLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        signupLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signupLabel.setText("Login Form");

        passwordLabel.setText("Password:");

        signupButton.setText("Signup");
        signupButton.addActionListener(evt -> signupButtonActionPerformed(evt));

        loginButton.setText("Login");
        loginButton.addActionListener(evt -> loginButtonActionPerformed(evt));


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(signupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(115, 115, 115)
                                                .addComponent(emailLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                                .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(94, 94, 94)
                                                .addComponent(passwordLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(signupButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(loginButton)))
                                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(signupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(emailLabel)
                                        .addComponent(emailText))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordLabel))
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginButton)
                                        .addComponent(signupButton))
                                .addGap(53, 53, 53))
        );

        pack();
    }


    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        Signup signup = new Signup();
        signup.setLocationRelativeTo(null);
        signup.setVisible(true);
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CustomerDAO dao = new CustomerDAO();

        try {
            String email = emailText.getText();
            String password = passwordText.getText();

            int loginSuccessful = dao.login(email, password);
            int id = dao.getUserIdByEmail(email);
            AccountDAO dao1 = new AccountDAO();

            if (loginSuccessful == 1) {
                Homepage home = new Homepage(dao1.getAccountIdByCustomerId(id), id);
                this.setVisible(false);
                home.setLocationRelativeTo(null);
                home.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage());

        }

    }



    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailText;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JButton signupButton;
    private javax.swing.JLabel signupLabel;
}

