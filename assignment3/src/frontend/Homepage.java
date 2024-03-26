//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 3

package frontend;

import backend.Account;
import backend.AccountDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

// Homepage class extending javax.swing.JFrame for the main user interface
public class Homepage extends javax.swing.JFrame {
    int accountID = -1;
    int customerID = -1;

    public Homepage(int id, int id1) {
        initComponents();
        accountID = id; // Set account ID from parameter
        customerID = id1; // Set customer ID from parameter
    }

    public Homepage() {
        initComponents();
    }

    // Method to initialize GUI components
    @SuppressWarnings("unchecked")
    private void initComponents() {

        signupLabel = new javax.swing.JLabel(); // Label for the homepage title
        //Buttons for actions
        transactionButton = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        balanceButton = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        signupLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        signupLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signupLabel.setText("Homepage");

        // Set text and action listener for the transaction button
        transactionButton.setText("Make a Transaction");
        transactionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionButtonActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Edit Account Details");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        balanceButton.setText("Check Balance");
        balanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceButtonActionPerformed(evt);
            }
        });

        jToggleButton6.setText("Logout");
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(127, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(signupLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                        .addComponent(transactionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(balanceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToggleButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(signupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(balanceButton)
                                .addGap(18, 18, 18)
                                .addComponent(transactionButton)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton6)
                                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }

    private void transactionButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        TransactionForm t = new TransactionForm(accountID, customerID);
        t.setLocationRelativeTo(null);
        t.setVisible(true);
    }

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        EditAccount t = new EditAccount(accountID, customerID);
        t.setLocationRelativeTo(null);
        t.setVisible(true);
    }

    private void balanceButtonActionPerformed(java.awt.event.ActionEvent evt) {
        AccountDAO dao = new AccountDAO();
        try {
            Account account = dao.get(accountID);

            if (account != null) {
                double balance = account.getBalance();
                JOptionPane.showMessageDialog(null, "Account Balance: $" + balance, "Account Balance", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Account not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fetching account details: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        Startup s = new Startup();
        s.setLocationRelativeTo(null);
        s.setVisible(true);
    }


    private javax.swing.JToggleButton balanceButton;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JLabel signupLabel;
    private javax.swing.JToggleButton transactionButton;
}

