//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 3

package frontend;

import javax.swing.*;

// Startup class extending javax.swing.JFrame for the startup screen
public class Startup extends JFrame {

    public Startup() {
        initComponents();
    }

    private void initComponents() {

        // GUI component declarations
        signupButton = new JButton();
        loginButton = new JButton();
        signupLabel = new JLabel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        signupButton.setText("Signup");
        signupButton.addActionListener(evt -> signupButtonActionPerformed(evt));

        loginButton.setText("Login");
        loginButton.addActionListener(evt -> loginButtonActionPerformed(evt));

        signupLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        signupLabel.setHorizontalAlignment(SwingConstants.CENTER);
        signupLabel.setText("Startup");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(100, 100, 100)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(74, 74, 74)
                                                .addComponent(signupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(signupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Signup signup = new Signup();
        this.setVisible(false);
        signup.setLocationRelativeTo(null);
        signup.setVisible(true);
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Login login = new Login();
        this.setVisible(false);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }


    private JButton loginButton;
    private JButton signupButton;
    private JLabel signupLabel;
}

