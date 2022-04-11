/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9typical_cafe;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author wolfie
 */
public class Form_Home extends javax.swing.JInternalFrame {

    /**
     * Creates new form Form_Home
     */
    public Form_Home() {
        initComponents();
        visibilitas();
  
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jB_nextAdmin = new javax.swing.JButton();
        jB_next = new javax.swing.JButton();
        logo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 590));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel1.setText("Welcome! 9 Typical Cafe");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 49, -1, 77));

        jB_nextAdmin.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jB_nextAdmin.setText("NEXT");
        jB_nextAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_nextAdminActionPerformed(evt);
            }
        });
        getContentPane().add(jB_nextAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1031, 441, 183, 67));

        jB_next.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jB_next.setText("NEXT");
        jB_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_nextActionPerformed(evt);
            }
        });
        getContentPane().add(jB_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 440, 183, 67));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 300, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void visibilitas(){
        jB_next.setVisible(false);
        jB_nextAdmin.setVisible(false);
    }
    public void kasir(){
        jLabel1.setText("Welcome! 9 Typical");
        jB_next.setVisible(true);
    }
    
    public void admin(){
        jLabel1.setText("Hello Admin! 9 Typical");
        jB_nextAdmin.setVisible(true);
    }
    
    private void jB_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_nextActionPerformed
        // TODO add your handling code here:
        Home.jDesktopPane.removeAll();
        Home.jDesktopPane.repaint();
        Form_Menu fm = new Form_Menu();
        fm.setVisible(true);
        Home.jDesktopPane.add(fm);
    }//GEN-LAST:event_jB_nextActionPerformed

    private void jB_nextAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_nextAdminActionPerformed
        // TODO add your handling code here:
        Home.jDesktopPane.removeAll();
        Home.jDesktopPane.repaint();
        Form_MenuAdmin fm = new Form_MenuAdmin();
        fm.setVisible(true);
        Home.jDesktopPane.add(fm);
    }//GEN-LAST:event_jB_nextAdminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_next;
    private javax.swing.JButton jB_nextAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
