//Nilofar M. Ali
//CSC413-02 Spring 2024
//Assignment 3

package frontend;

import backend.Account;
import backend.AccountDAO;
import backend.Transaction;
import backend.TransactionDAO;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.*;

// TransactionForm class extending javax.swing.JFrame for the transaction form
public class TransactionForm extends JFrame {
    private int accountID = -1;
    private int customerID = -1;

    public TransactionForm() {
        initComponents();
    }

    public TransactionForm(int currentAccountId, int customerId) {
        initComponents();
        this.accountID = currentAccountId;
        this.customerID = customerId;
        updateBalance(); // Call method to update balance label
    }

    // Method to update the balance label based on the account ID
    private void updateBalance() {
        AccountDAO accountDAO = new AccountDAO();
        try {
            Account account = accountDAO.get(accountID);
            if (account != null) {
                double balance = account.getBalance();
                balanceLabel.setText(String.valueOf(balance));
            } else {
                JOptionPane.showMessageDialog(null, "Account not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fetching account details: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to initialize GUI components
    @SuppressWarnings("unchecked")
    private void initComponents() {
        signupLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        transactionButton = new javax.swing.JButton();
        type = new javax.swing.JComboBox<>();
        amountText = new javax.swing.JTextField();
        balanceLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        signupLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        signupLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signupLabel.setText("Transaction Form");

        jLabel1.setText("Current Balance:");

        jLabel2.setText("Type:");

        jLabel3.setText("Amount");

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        transactionButton.setText("Make Transaction");
        transactionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionButtonActionPerformed(evt);
            }
        });

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deposit", "Withdrawal" }));

        balanceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        balanceLabel.setText("balanceLabel");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(logoutButton)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(signupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel3))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(type, 0, 130, Short.MAX_VALUE)
                                                                        .addComponent(amountText)
                                                                        .addComponent(balanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(backButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(transactionButton)))
                                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(logoutButton))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(balanceLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(amountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(transactionButton)
                                        .addComponent(backButton))
                                .addGap(21, 21, 21))
        );

        pack();
    }

    private void transactionButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String selectedType = (String) type.getSelectedItem();
            double amount = Double.parseDouble(amountText.getText());
            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

            Transaction transaction = new Transaction(accountID, selectedType, amount, timestamp);

            AccountDAO accountDAO = new AccountDAO();
            Account account = accountDAO.get(accountID);
            if (account != null) {
                if (selectedType.equals("Deposit")) {
                    account.setBalance(account.getBalance() + amount);
                } else if (selectedType.equals("Withdrawal")) {
                    double currentBalance = account.getBalance();
                    if (currentBalance < amount) {
                        JOptionPane.showMessageDialog(this, "Insufficient funds.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    account.setBalance(currentBalance - amount);
                }

                TransactionDAO transactionDAO = new TransactionDAO();
                transactionDAO.insert(transaction);

                accountDAO.update(account);
                updateBalance();
                JOptionPane.showMessageDialog(this, "Transaction performed successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Account not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error performing transaction: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        Startup startup = new Startup();
        startup.setLocationRelativeTo(null);
        startup.setVisible(true);
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        Homepage homepage = new Homepage(accountID, customerID);
        homepage.setLocationRelativeTo(null);
        homepage.setVisible(true);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new TransactionForm().setVisible(true);
        });
    }

    private javax.swing.JTextField amountText;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel signupLabel;
    private javax.swing.JButton transactionButton;
    private javax.swing.JComboBox<String> type;
}

