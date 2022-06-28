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
import javax.swing.JOptionPane;

/**
 *
 * @author SSC
 */
public class ViewCompleteClientInfoFrame extends javax.swing.JFrame {

    /**
     * Creates new form ViewCompleteClientInfoFrame
     */
    public ViewCompleteClientInfoFrame() {
        initComponents();
        StaticData.resizeLabelImage(StaticData.getImage(StaticData.BackGroundImages.SIMPLEBACKGROUND), backgroundImage);
       if(StaticData.currentClientAccountInfo==null)
       {
           updateStatusButton.setVisible(false);
       }
    }

    private Login userInfo;
    private Account accountInfo;

    public ViewCompleteClientInfoFrame(String clientusername) {
        initComponents();
        userInfo = DatabaseQueries.getUserByUsername(clientusername);
        accountInfo = DatabaseQueries.getAccountDataByClientUserName(clientusername);
             StaticData.resizeLabelImage(StaticData.getImage(StaticData.BackGroundImages.SIMPLEBACKGROUND), backgroundImage);

        accountNumber.setEnabled(false);
        firstname.setEnabled(false);
        lastname.setEnabled(false);
        username.setEnabled(false);
        password.setEnabled(false);
        transferAmountLimit.setEnabled(false);
        withDrawAmountLimit.setEnabled(false);
        currentAccount.setEnabled(false);
        savingAccont.setEnabled(false);
        if (userInfo != null && accountInfo != null) {
            accountNumber.setText(accountInfo.getAccountNumber());
            firstname.setText(userInfo.getFirstName());
            lastname.setText(userInfo.getLastName());
            username.setText(userInfo.getUserName());
            password.setText(userInfo.getPassword());
            balance.setText("₪ : " + accountInfo.getBalance());
            transferAmountLimit.setText("" + accountInfo.getTransferLimit());
            withDrawAmountLimit.setText("" + accountInfo.getWithdrawLimit());
            accountstatus.setText("" + accountInfo.getStatus());
            if (DatabaseQueries.getAccountTypeById(accountInfo.getAccountTypeId()).getName().equals("Current Account")) {
                currentAccount.setSelected(true);
                savingAccont.setSelected(false);
            } else {
                currentAccount.setSelected(false);
                savingAccont.setSelected(true);
            }
            if (accountInfo.getStatus().equals("ACTIVE")) {
                updateStatusButton.setText("Block Account");
            } else {
                updateStatusButton.setText("UnBlock Account");
            }
        } else {
            JOptionPane.showConfirmDialog(null, "Some error for fetching data", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);

        }

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
        jLabel2 = new javax.swing.JLabel();
        accountNumber = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        firstname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        withDrawAmountLimit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        transferAmountLimit = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        currentAccount = new javax.swing.JRadioButton();
        savingAccont = new javax.swing.JRadioButton();
        closeButton = new javax.swing.JButton();
        updateStatusButton = new javax.swing.JButton();
        accountstatus = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        backgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client Details - Banking App");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 70)); // NOI18N
        jLabel5.setText("Client Detail");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 300, 70));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel2.setText("Account #");
        jLabel2.setToolTipText("Login");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        accountNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        accountNumber.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(accountNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 210, 30));

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel11.setText("Username ");
        jLabel11.setToolTipText("Login");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setToolTipText("Login");
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 200, 30));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel3.setText("Password");
        jLabel3.setToolTipText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, -1));

        password.setToolTipText("Login");
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 210, 30));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel6.setText("LastName");
        jLabel6.setToolTipText("LastName");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, -1, -1));

        lastname.setToolTipText("LastName");
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });
        getContentPane().add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 210, 30));

        firstname.setToolTipText("First Name");
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        getContentPane().add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 200, 30));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel7.setText("First Name");
        jLabel7.setToolTipText("");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Limits", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 1, 24))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        withDrawAmountLimit.setToolTipText("Withdraw Limit");
        withDrawAmountLimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withDrawAmountLimitActionPerformed(evt);
            }
        });
        jPanel1.add(withDrawAmountLimit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 210, 30));

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel10.setText("Withdraw");
        jLabel10.setToolTipText("Login");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        transferAmountLimit.setToolTipText("Transfer Limit");
        transferAmountLimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferAmountLimitActionPerformed(evt);
            }
        });
        jPanel1.add(transferAmountLimit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 200, 30));

        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel13.setText("Transfer");
        jLabel13.setToolTipText("Login");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 690, 100));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel4.setText("Status:");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        currentAccount.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        currentAccount.setSelected(true);
        currentAccount.setText("Current Account");
        getContentPane().add(currentAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, -1, -1));

        savingAccont.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        savingAccont.setText("Saving Account");
        getContentPane().add(savingAccont, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, -1, -1));

        closeButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 230, 30));

        updateStatusButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        updateStatusButton.setText("Update Status");
        updateStatusButton.setToolTipText("");
        updateStatusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStatusButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateStatusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 520, 240, 30));

        accountstatus.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        accountstatus.setText("NA");
        accountstatus.setToolTipText("");
        getContentPane().add(accountstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel12.setText("Account Type");
        jLabel12.setToolTipText("");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel8.setText("Balance:");
        jLabel8.setToolTipText("");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, -1, -1));

        balance.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        balance.setText("₪ : 10000");
        balance.setToolTipText("");
        getContentPane().add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, -1, -1));

        backgroundImage.setText("jLabel1");
        getContentPane().add(backgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void withDrawAmountLimitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withDrawAmountLimitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_withDrawAmountLimitActionPerformed

    private void transferAmountLimitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferAmountLimitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transferAmountLimitActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_closeButtonActionPerformed

    private void updateStatusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStatusButtonActionPerformed
        // TODO add your handling code here:
        if (accountInfo.getStatus().equals("ACTIVE")) {
            if (DatabaseQueries.updateBlockedAccountByClientUsername(userInfo.getUserName(), "BLOCKED") > 0) {
                JOptionPane.showConfirmDialog(null, "Account Block Successfully", "Successfull", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new ViewCompleteClientInfoFrame(userInfo.getUserName()).setVisible(true);
            } else {
                JOptionPane.showConfirmDialog(null, "Account Not Blocked", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }
        } else {
            if (DatabaseQueries.updateBlockedAccountByClientUsername(userInfo.getUserName(), "ACTIVE") > 0) {
                JOptionPane.showConfirmDialog(null, "Account Active Successfully", "Successfull", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new ViewCompleteClientInfoFrame(userInfo.getUserName()).setVisible(true);
            } else {
                JOptionPane.showConfirmDialog(null, "Account Not Active", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_updateStatusButtonActionPerformed

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
//            java.util.logging.Logger.getLogger(ViewCompleteClientInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewCompleteClientInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewCompleteClientInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewCompleteClientInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ViewCompleteClientInfoFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountNumber;
    private javax.swing.JLabel accountstatus;
    private javax.swing.JLabel backgroundImage;
    private javax.swing.JLabel balance;
    private javax.swing.JButton closeButton;
    private javax.swing.JRadioButton currentAccount;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField password;
    private javax.swing.JRadioButton savingAccont;
    private javax.swing.JTextField transferAmountLimit;
    private javax.swing.JButton updateStatusButton;
    private javax.swing.JTextField username;
    private javax.swing.JTextField withDrawAmountLimit;
    // End of variables declaration//GEN-END:variables
}