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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SSC
 */
public class ViewClientFrame extends javax.swing.JFrame {

    /**
     * Creates new form ViewClient
     */
    private ArrayList<Login> loginInfo;

    public ViewClientFrame() {
        initComponents();
        updateClientButton.setEnabled(false);
        blockClientButton.setEnabled(false);
        viewClientButton.setEnabled(false);
        transactionButton.setEnabled(false);
        StaticData.resizeLabelImage(StaticData.getImage(StaticData.BackGroundImages.SIMPLEBACKGROUND), backgroundImage);
        StaticData.resizeButtonImage(StaticData.getImage(StaticData.BackGroundImages.HOMELOGO), homeButton, homeButton.getWidth() - 10, homeButton.getHeight() - 8);
        StaticData.resizeButtonImage(StaticData.getImage(StaticData.BackGroundImages.LOGOUTLOGO), logoutButton, 30, logoutButton.getHeight() - 8);
        populateHallData();

    }

    private void populateHallData() {
        clientTable.removeAll();
        loginInfo = DatabaseQueries.getAllClientData();
        Object[][] data = new Object[loginInfo.size()][];
        for (int i = 0; i < loginInfo.size(); i++) {
            data[i] = new Object[]{i + 1, loginInfo.get(i).getUserName(), loginInfo.get(i).getPassword(),
                loginInfo.get(i).getFirstName(), loginInfo.get(i).getLastName()};
        }

        String[] columns = {
            "SNO", "Username", "Password", "FirstName", "LastName"
        };

        DefaultTableModel tmodel = new DefaultTableModel(data, columns) {

        };

        clientTable.setModel(tmodel);
        clientTable.setRowHeight(30);
        clientTable.getColumn("SNO").setMaxWidth(40);

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
        jScrollPane1 = new javax.swing.JScrollPane();
        clientTable = new javax.swing.JTable();
        homeButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        addClientButton = new javax.swing.JButton();
        updateClientButton = new javax.swing.JButton();
        blockClientButton = new javax.swing.JButton();
        viewClientButton = new javax.swing.JButton();
        transactionButton = new javax.swing.JButton();
        backgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View Clients - Banking App  ");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 70)); // NOI18N
        jLabel5.setText("Clients");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 210, 70));

        clientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        clientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(clientTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 660, 180));

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

        addClientButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        addClientButton.setText("Add Client");
        addClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClientButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addClientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 160, 30));

        updateClientButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        updateClientButton.setText("Update Client");
        updateClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateClientButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateClientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 160, 30));

        blockClientButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        blockClientButton.setText("Block Cl. Acc");
        blockClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockClientButtonActionPerformed(evt);
            }
        });
        getContentPane().add(blockClientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 160, 30));

        viewClientButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        viewClientButton.setText("View Client");
        viewClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewClientButtonActionPerformed(evt);
            }
        });
        getContentPane().add(viewClientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 160, 30));

        transactionButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        transactionButton.setText("View Transaction");
        transactionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionButtonActionPerformed(evt);
            }
        });
        getContentPane().add(transactionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 170, 30));
        getContentPane().add(backgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AdminHomeFrame().setVisible(true);

    }//GEN-LAST:event_homeButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.dispose();
        new LoginFrame().setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void addClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClientButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AddClientFrame().setVisible(true);

    }//GEN-LAST:event_addClientButtonActionPerformed

    private void updateClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateClientButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new UpdateClientFrame(loginInfo.get(clientTable.getSelectedRow()).getUserName(),1).setVisible(true);

    }//GEN-LAST:event_updateClientButtonActionPerformed

    private void blockClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockClientButtonActionPerformed
        // TODO add your handling code here:
        Account acc = DatabaseQueries.getAccountDataByClientUserName(loginInfo.get(clientTable.getSelectedRow()).getUserName());
        if (acc.getStatus().equals("ACTIVE")) {
            if (DatabaseQueries.blockedAccountByClientUsername(acc.getClientUsername()) > 0) {
                JOptionPane.showConfirmDialog(null, "Account Block Successfully", "Successfull", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showConfirmDialog(null, "Account Not Blocked", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showConfirmDialog(null, "Account Already Blocked", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_blockClientButtonActionPerformed

    private void viewClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewClientButtonActionPerformed
        // TODO add your handling code here:
        new ViewCompleteClientInfoFrame(loginInfo.get(clientTable.getSelectedRow()).getUserName()).setVisible(true);

    }//GEN-LAST:event_viewClientButtonActionPerformed

    private void transactionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ViewTransactionHistoryForAdminFrame(DatabaseQueries.getAccountDataByClientUserName(loginInfo.get(clientTable.getSelectedRow()).getUserName()).getAccountNumber()).setVisible(true);
    }//GEN-LAST:event_transactionButtonActionPerformed

    private void clientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientTableMouseClicked
        // TODO add your handling code here:
        updateClientButton.setEnabled(true);
        blockClientButton.setEnabled(true);
        viewClientButton.setEnabled(true);
        transactionButton.setEnabled(true);

    }//GEN-LAST:event_clientTableMouseClicked

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
//            java.util.logging.Logger.getLogger(ViewClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ViewClientFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addClientButton;
    private javax.swing.JLabel backgroundImage;
    private javax.swing.JButton blockClientButton;
    private javax.swing.JTable clientTable;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton transactionButton;
    private javax.swing.JButton updateClientButton;
    private javax.swing.JButton viewClientButton;
    // End of variables declaration//GEN-END:variables
}
