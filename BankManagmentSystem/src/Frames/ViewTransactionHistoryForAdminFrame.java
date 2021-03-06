/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Common.StaticData;
import Db.DatabaseQueries;
import Modal.Account;
import Modal.Login;
import Modal.Transactions;
import Modal.Transfer;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SSC
 */
public class ViewTransactionHistoryForAdminFrame extends javax.swing.JFrame {

    /**
     * Creates new form ViewTransactionHistoryForAdminFrame
     */
    private ArrayList<Transactions> transactionData;

    public ViewTransactionHistoryForAdminFrame() {
        initComponents();
        StaticData.resizeLabelImage(StaticData.getImage(StaticData.BackGroundImages.SIMPLEBACKGROUND), backgroundImage);
        StaticData.resizeButtonImage(StaticData.getImage(StaticData.BackGroundImages.HOMELOGO), homeButton, homeButton.getWidth() - 10, homeButton.getHeight() - 8);
        StaticData.resizeButtonImage(StaticData.getImage(StaticData.BackGroundImages.LOGOUTLOGO), logoutButton, 30, logoutButton.getHeight() - 8);
        transactionData = DatabaseQueries.getAllTransactionsData();
        populateHallData("ALL");
        printOutButton.setEnabled(false);
    }
    private Account tempAccount;
    private Login temLogin;

    public ViewTransactionHistoryForAdminFrame(String accNumber) {
        initComponents();
        System.out.println(accNumber);
        StaticData.resizeLabelImage(StaticData.getImage(StaticData.BackGroundImages.SIMPLEBACKGROUND), backgroundImage);
        StaticData.resizeButtonImage(StaticData.getImage(StaticData.BackGroundImages.HOMELOGO), homeButton, homeButton.getWidth() - 10, homeButton.getHeight() - 8);
        StaticData.resizeButtonImage(StaticData.getImage(StaticData.BackGroundImages.LOGOUTLOGO), logoutButton, 30, logoutButton.getHeight() - 8);
        transactionData = DatabaseQueries.getAllTransactionsDataByAccountNumber(accNumber);
         tempAccount = DatabaseQueries.getAccountDataByAccountNumber(accNumber);
        temLogin = DatabaseQueries.getUserByUsername(tempAccount.getClientUsername());
        
        populateHallData("ALL");
      
    }

    private void populateHallData(String type) {
        transactionTable.removeAll();
        Object[][] data = new Object[transactionData.size()][];
        int counter = 0;
        for (int i = 0; i < transactionData.size(); i++) {
            if (transactionData.get(i).getTransactionType().equals(type) && type.equals("DEPOSIT")) {
                data[counter++] = new Object[]{i + 1, transactionData.get(i).getSenderAccountNumber(), "", transactionData.get(i).getSendingDate(),
                    transactionData.get(i).getSendingTime(), transactionData.get(i).getTransactionType(), ("??? : " + transactionData.get(i).getTransactionAmount())};
            } else if (transactionData.get(i).getTransactionType().equals(type) && type.equals("WITHDRAW")) {
                data[counter++] = new Object[]{i + 1, transactionData.get(i).getSenderAccountNumber(), "", transactionData.get(i).getSendingDate(),
                    transactionData.get(i).getSendingTime(), transactionData.get(i).getTransactionType(), ("??? : " + transactionData.get(i).getTransactionAmount())};
            } else if (transactionData.get(i).getTransactionType().equals(type) && type.equals("TRANSFER")) {
                data[counter++] = new Object[]{i + 1, transactionData.get(i).getSenderAccountNumber(), ((Transfer) transactionData.get(i)).getRecieverName(), transactionData.get(i).getSendingDate(),
                    transactionData.get(i).getSendingTime(), transactionData.get(i).getTransactionType(), ("??? : " + transactionData.get(i).getTransactionAmount())};
            } else if (type.equals("ALL")) {
                if (transactionData.get(i).getTransactionType().equals("DEPOSIT")) {
                    data[counter++] = new Object[]{i + 1, transactionData.get(i).getSenderAccountNumber(), "", transactionData.get(i).getSendingDate(),
                        transactionData.get(i).getSendingTime(), transactionData.get(i).getTransactionType(), ("??? : " + transactionData.get(i).getTransactionAmount())};
                } else if (transactionData.get(i).getTransactionType().equals("WITHDRAW")) {
                    data[counter++] = new Object[]{i + 1, transactionData.get(i).getSenderAccountNumber(), "", transactionData.get(i).getSendingDate(),
                        transactionData.get(i).getSendingTime(), transactionData.get(i).getTransactionType(), ("??? : " + transactionData.get(i).getTransactionAmount())};
                } else if (transactionData.get(i).getTransactionType().equals("TRANSFER")) {
                    data[counter++] = new Object[]{i + 1, transactionData.get(i).getSenderAccountNumber(), ((Transfer) transactionData.get(i)).getRecieverName(), transactionData.get(i).getSendingDate(),
                        transactionData.get(i).getSendingTime(), transactionData.get(i).getTransactionType(), ("??? : " + transactionData.get(i).getTransactionAmount())};
                }
            }

        }

        String[] columns = {
            "SNO", "Sender AC#", "Reciever AC#", "Date", "Time", "Type", "Amount"
        };

        DefaultTableModel tmodel = new DefaultTableModel(data, columns) {

        };

        transactionTable.setModel(tmodel);
        transactionTable.setRowHeight(30);
        transactionTable.getColumn("SNO").setMaxWidth(40);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        transactionTypes = new javax.swing.JComboBox<>();
        searchButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        printOutButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        backgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transaction History - Banking App");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 70)); // NOI18N
        jLabel5.setText("Transactoin History");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 490, 70));

        transactionTypes.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        transactionTypes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "DEPOSIT", "WITHDRAW", "TRANSFER" }));
        getContentPane().add(transactionTypes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 220, 30));

        searchButton1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        searchButton1.setText("Search");
        searchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 230, 30));

        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(transactionTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 670, 220));

        printOutButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        printOutButton.setText("Get PrintOut");
        printOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printOutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(printOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 230, 30));

        homeButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 30));

        logoutButton.setBackground(new java.awt.Color(255, 255, 255));
        logoutButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        logoutButton.setText("ogout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 110, 30));

        backgroundImage.setText("jLabel1");
        getContentPane().add(backgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButton1ActionPerformed
        // TODO add your handling code here:
        populateHallData(transactionTypes.getSelectedItem().toString());
    }//GEN-LAST:event_searchButton1ActionPerformed

    private void printOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printOutButtonActionPerformed
        // TODO add your handling code here:
        try {

            String fileName = tempAccount.getClientUsername() + "_" + tempAccount.getAccountNumber()+"_" + (new Random().nextLong()) + ".txt";
            FileWriter fWriter = new FileWriter(
                    fileName);
            fWriter.write("Account Number : " +tempAccount.getAccountNumber() + "\n");
            fWriter.write("Username :       " +tempAccount.getClientUsername() + "\n");
            fWriter.write("Full Name:       " + temLogin.getFirstName() + " " + temLogin.getLastName() + "\n");

            fWriter.write("\n\n");
            fWriter.write(String.format("%-8s %-20s %-20s %-20s %-20s %-10s %-5s\n", "Id", "Sender Account", "Reciver Account", "Date", "Time", "Type", "Amount"));
            for (Transactions temp : transactionData) {
                fWriter.write(temp.toString() + "\n");
            }
            fWriter.write("\n\n=====================================================================================\n");
            fWriter.write("=====================================================================================\n");
            fWriter.write("=====================================================================================\n");
            fWriter.close();
            JOptionPane.showConfirmDialog(null, "Transaction history downloaded as " + fileName + " in your folder.", "Success", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {

            // Print the exception
            System.out.print(e.getMessage());
        }
    }//GEN-LAST:event_printOutButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AdminHomeFrame().setVisible(true);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.dispose();
        new LoginFrame().setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ViewTransactionHistoryForAdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewTransactionHistoryForAdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewTransactionHistoryForAdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewTransactionHistoryForAdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ViewTransactionHistoryForAdminFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundImage;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton printOutButton;
    private javax.swing.JButton searchButton1;
    private javax.swing.JTable transactionTable;
    private javax.swing.JComboBox<String> transactionTypes;
    // End of variables declaration//GEN-END:variables
}
