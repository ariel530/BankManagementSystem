/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Common.StaticData;

/**
 *
 * @author SSC
 */
public class AdminHomeFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminHome
     */
    public AdminHomeFrame() {
        initComponents();
              StaticData.resizeLabelImage(StaticData.getImage(StaticData.BackGroundImages.SIMPLEBACKGROUND), backgroundImage);
              StaticData.resizeLabelImage(StaticData.getImage(StaticData.BackGroundImages.ADMINLOGO), loginlogo);
  
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
        loginlogo = new javax.swing.JLabel();
        updateProfile = new javax.swing.JButton();
        clientButton = new javax.swing.JButton();
        accountButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        backgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Home - Banking App");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 70)); // NOI18N
        jLabel5.setText("Admin Home");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        loginlogo.setText("                      loginlogo");
        getContentPane().add(loginlogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 180, 200));

        updateProfile.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        updateProfile.setText("Transaction");
        updateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProfileActionPerformed(evt);
            }
        });
        getContentPane().add(updateProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 160, 40));

        clientButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        clientButton.setText("Client");
        clientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 160, 40));

        accountButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        accountButton.setText("Accounts");
        accountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountButtonActionPerformed(evt);
            }
        });
        getContentPane().add(accountButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 160, 40));

        logoutButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 160, 40));

        backgroundImage.setToolTipText("");
        getContentPane().add(backgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProfileActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ViewTransactionHistoryForAdminFrame().setVisible(true);
     
    }//GEN-LAST:event_updateProfileActionPerformed

    
    private void clientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ViewClientFrame().setVisible(true);
    }//GEN-LAST:event_clientButtonActionPerformed

    private void accountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ViewAccountForAdminForm().setVisible(true);
    }//GEN-LAST:event_accountButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
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
//            java.util.logging.Logger.getLogger(AdminHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AdminHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AdminHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AdminHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AdminHomeFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountButton;
    private javax.swing.JLabel backgroundImage;
    private javax.swing.JButton clientButton;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel loginlogo;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton updateProfile;
    // End of variables declaration//GEN-END:variables
}
