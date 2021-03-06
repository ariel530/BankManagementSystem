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
public class ViewComplainsFormForClient extends javax.swing.JFrame {

    /**
     * Creates new form Complains
     */
    public ViewComplainsFormForClient() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        complainTable = new javax.swing.JTable();
        addComplain = new javax.swing.JButton();
        viewComplain = new javax.swing.JButton();
        backgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Complain - Banking App");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 70)); // NOI18N
        jLabel5.setText("Compains");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 280, 70));

        homeButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 110, 30));

        logoutButton.setBackground(new java.awt.Color(255, 255, 255));
        logoutButton.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        logoutButton.setText("ogout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 110, 30));

        complainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        complainTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                complainTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(complainTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 660, 180));

        addComplain.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        addComplain.setText("Add Complain");
        addComplain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addComplainActionPerformed(evt);
            }
        });
        getContentPane().add(addComplain, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 180, 30));

        viewComplain.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        viewComplain.setText("View Complain");
        viewComplain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewComplainActionPerformed(evt);
            }
        });
        getContentPane().add(viewComplain, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 180, 30));

        backgroundImage.setText("jLabel1");
        getContentPane().add(backgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 400));

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

    private void complainTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_complainTableMouseClicked
        // TODO add your handling code here:
        viewComplain.setEnabled(true);
    }//GEN-LAST:event_complainTableMouseClicked

    private void addComplainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addComplainActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addComplainActionPerformed

    private void viewComplainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewComplainActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewComplainActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewComplainsFormForClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewComplainsFormForClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewComplainsFormForClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewComplainsFormForClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewComplainsFormForClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addComplain;
    private javax.swing.JLabel backgroundImage;
    private javax.swing.JTable complainTable;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton viewComplain;
    // End of variables declaration//GEN-END:variables
}
