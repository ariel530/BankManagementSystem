/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Common.StaticData;
import Db.DatabaseQueries;
import Modal.Deposit;
import Modal.WithDraw;
import javax.swing.JOptionPane;

/**
 *
 * @author SSC
 */
public class WithdrawFrame extends javax.swing.JFrame {

    /**
     * Creates new form WithdrawFrame
     */
    public WithdrawFrame() {
        initComponents();
        StaticData.resizeLabelImage(StaticData.getImage(StaticData.BackGroundImages.SIMPLEBACKGROUND), backgroundImage);
        StaticData.resizeButtonImage(StaticData.getImage(StaticData.BackGroundImages.HOMELOGO), homeButton, homeButton.getWidth() - 10, homeButton.getHeight() - 8);
        StaticData.resizeButtonImage(StaticData.getImage(StaticData.BackGroundImages.LOGOUTLOGO), logoutButton, 30, logoutButton.getHeight() - 8);

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
        homeButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        depositAmount = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        withdrawButton = new javax.swing.JButton();
        backgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Withdraw - Banking App");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 70)); // NOI18N
        jLabel5.setText("Withdraw");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        homeButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 30));

        logoutButton.setBackground(new java.awt.Color(255, 255, 255));
        logoutButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        logoutButton.setText("ogout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 110, 30));

        depositAmount.setToolTipText("Deposit Amount");
        depositAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositAmountActionPerformed(evt);
            }
        });
        getContentPane().add(depositAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 230, 30));

        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel13.setText("Withdraw Amount");
        jLabel13.setToolTipText("Login");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 190, -1));

        withdrawButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        withdrawButton.setText("Withdraw");
        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawButtonActionPerformed(evt);
            }
        });
        getContentPane().add(withdrawButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 270, 30));

        backgroundImage.setText("jLabel1");
        getContentPane().add(backgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 290));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ClientHomeFrame().setVisible(true);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.dispose();
        new LoginFrame().setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void depositAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depositAmountActionPerformed

    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawButtonActionPerformed
        // TODO add your handling code here:
        double depAmount = StaticData.getAndValidatePrice(depositAmount.getText(), "Withdraw Amount");
        double remainingDailyLimit = StaticData.currentClientAccountInfo.getWithdrawLimit() - DatabaseQueries.getTotalTransactionAmountOfSpecificType(StaticData.currentClientAccountInfo.getAccountNumber(), "WITHDRAW");
        if (depAmount <= 0) {

        } else if (depAmount > StaticData.currentClientAccountInfo.getWithdrawLimit()) {
            JOptionPane.showConfirmDialog(null, "Your withdraw limit is ₪ : " + StaticData.currentClientAccountInfo.getWithdrawLimit() + ". Kindly enter amount within that limit.", "Withdraw MAx Limit Errors", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);

        } else if (depAmount > remainingDailyLimit) {
            JOptionPane.showConfirmDialog(null, "Your today withdraw remaining limit is ₪ : " +remainingDailyLimit + ". Kindly enter amount within that limit.", "Withdraw MAx Limit Errors", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        } else {
            int row = DatabaseQueries.insertTransactionData(new WithDraw(0, StaticData.currentClientAccountInfo.getAccountNumber(), null, null, depAmount));
            if (row > 0) {
                StaticData.currentClientAccountInfo = DatabaseQueries.getAccountDataByClientUserName(StaticData.loginUserInfo.getUserName());
                this.dispose();
                new ReciptFrame("WITHDRAW", "₪ : " + depAmount + " has been successfully withdraw from your account."
                ).setVisible(true);
                new ClientHomeFrame().setVisible(true);
            } else {
                JOptionPane.showConfirmDialog(null, "Amount not withdraw", "Withdraw Errors", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_withdrawButtonActionPerformed

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
//            java.util.logging.Logger.getLogger(WithdrawFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(WithdrawFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(WithdrawFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(WithdrawFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new WithdrawFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundImage;
    private javax.swing.JTextField depositAmount;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton withdrawButton;
    // End of variables declaration//GEN-END:variables
}
