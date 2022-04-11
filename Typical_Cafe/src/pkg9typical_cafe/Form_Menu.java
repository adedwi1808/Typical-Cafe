/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9typical_cafe;

import Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author wolfie
 */

public class Form_Menu extends javax.swing.JInternalFrame {

    /**
     * Creates new form Form_Menu
     */
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
    private String coffeeBarista;
    private String iceCoffee;
    private Boolean selected_iceCoffee = false, selected_coffeBarista = false;
    private int jumlahCoffeBarista, jumlahIceCoffee;
    
    
    ArrayList<Integer> inventory = new ArrayList<>();
    
    public Form_Menu() {
        initComponents();
        Koneksi DB = new Koneksi();
        DisableMenu();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        AssigmentValueMenu();
        CheckInventory();
        CheckMenu();

    }
    
    private void DisableMenu(){

        jRB_americano.setEnabled(false);
        jRB_cappucino.setEnabled(false);
        jRB_coffeLatte.setEnabled(false);
        jRB_coffeMocca.setEnabled(false);
        jRB_espresso.setEnabled(false);
        

        jRB_iceCappucino.setEnabled(false);
        jRB_iceCaramelLatte.setEnabled(false);
        jRB_iceCoffeLatte.setEnabled(false);
        jRB_iceHazelnutLatte.setEnabled(false);
        jRB_iceVanilaLatte.setEnabled(false);
    }
    private void AssigmentValueMenu(){
        //Assigment Value kedalam Radio button Coffe Barista
        jRB_americano.setActionCommand("Americano");
        jRB_cappucino.setActionCommand("Cappucino");
        jRB_coffeLatte.setActionCommand("Coffee Latte");
        jRB_coffeMocca.setActionCommand("Coffee Mocca");
        jRB_espresso.setActionCommand("Espresso");
        
        //Assigment Value kedalam Radio button ice coffee
        jRB_iceCappucino.setActionCommand("Ice Cappucino");
        jRB_iceCaramelLatte.setActionCommand("Ice Caramel Latte");
        jRB_iceCoffeLatte.setActionCommand("Ice Coffee Latte");
        jRB_iceHazelnutLatte.setActionCommand("Ice Hazelnut Latte");
        jRB_iceVanilaLatte.setActionCommand("Ice Vanilla Latte");
    }
    
    private void CheckInventory(){
        try {
            sql = "SELECT jumlah_inventory FROM inventory";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                inventory.add(Integer.valueOf(rs.getString(1)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void CheckMenu(){
        
        if(inventory.get(12) > 0){
            //Coffe Barista
            if(inventory.get(0)>0 && inventory.get(3)>0 && inventory.get(2)>0 && inventory.get(4)>0)
                jRB_coffeMocca.setEnabled(true);
            if(inventory.get(1)>0 && inventory.get(4)>0)
                jRB_coffeLatte.setEnabled(true);
            if(inventory.get(0)>0 && inventory.get(4)>0)
                jRB_cappucino.setEnabled(true);
            if(inventory.get(0)>0)
                jRB_americano.setEnabled(true);
            if(inventory.get(1)>0 && inventory.get(11)>0)
                jRB_espresso.setEnabled(true);
            
        if(inventory.get(13) > 0){
                //Ice Coffee
            if(inventory.get(0)>0 && inventory.get(7)>0 && inventory.get(4)>0)
                jRB_iceHazelnutLatte.setEnabled(true);
            if(inventory.get(0)>0 && inventory.get(8)>0 && inventory.get(10)>0 && inventory.get(4)>0 && inventory.get(9)>0 )
                jRB_iceCaramelLatte.setEnabled(true);
            if(inventory.get(0)>0&& inventory.get(6)>0 && inventory.get(4)>0)
                jRB_iceVanilaLatte.setEnabled(true);
            if(inventory.get(1)>0 && inventory.get(4)>0)
                jRB_iceCoffeLatte.setEnabled(true);
            if(inventory.get(0)>0 && inventory.get(4)>0)
                jRB_iceCappucino.setEnabled(true);
            }
        }
        
        
    }
    
    private void setCoffeeBarista(){
        
        String selectCoffeeBarista = bG_coffeeBarista.getSelection().getActionCommand();
        if(selectCoffeeBarista != null) {
                switch(selectCoffeeBarista) {
                case "Americano" : this.coffeeBarista = selectCoffeeBarista;
                                   break;
                case "Cappucino" : this.coffeeBarista = selectCoffeeBarista;
                                   break;
                case "Coffee Latte" : this.coffeeBarista = selectCoffeeBarista;
                                    break;
                case "Coffee Mocca" : this.coffeeBarista = selectCoffeeBarista;
                                      break;
                case "Espresso" : this.coffeeBarista = selectCoffeeBarista;
                                   break;
            }
        } else {
            this.coffeeBarista = "Null";
        }
        
    }
    public String getCoffeeBarista() {
        return coffeeBarista;
    }
    
    private void setIceCoffee() {
        String selectIceCoffe = bG_iceCoffee.getSelection().getActionCommand();
        
        switch(selectIceCoffe) {
            case "Ice Cappucino" : this.iceCoffee = selectIceCoffe;
                                   break;
            case "Ice Coffee Latte" : this.iceCoffee = selectIceCoffe;
                                      break;
            case "Ice Hazelnut Latte" : this.iceCoffee = selectIceCoffe;
                                        break;
            case "Ice Caramel Latte"  : this.iceCoffee = selectIceCoffe;
                                        break;
            case "Ice Vanilla Latte" : this.iceCoffee = selectIceCoffe;
                                 break;
            default : this.iceCoffee = "Null";
        }
    }
    
    private  String getIceCoffe(){
        return iceCoffee;
    }
    
    private void checkOrder(){
        if(selected_iceCoffee && selected_coffeBarista) {
            setIceCoffee();

            setCoffeeBarista();

        }else if(selected_iceCoffee) {
            setIceCoffee();

        }else if(selected_coffeBarista) {
            setCoffeeBarista();

        }
    }
    
    private void setJumlahCoffeBarista(){
        jumlahCoffeBarista = (Integer) jS_coffeBarista.getValue();
    }
    
    public int getJumlahCoffeBarista() {
        return jumlahCoffeBarista;
    }
    
    private void setJumlahIceCoffee(){
        jumlahIceCoffee = (Integer) jS_iceCoffe.getValue();
    }
    
    public int getJumlahIceCoffee() {
        return jumlahIceCoffee;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bG_coffeeBarista = new javax.swing.ButtonGroup();
        bG_iceCoffee = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRB_coffeMocca = new javax.swing.JRadioButton();
        jRB_espresso = new javax.swing.JRadioButton();
        jRB_coffeLatte = new javax.swing.JRadioButton();
        jRB_cappucino = new javax.swing.JRadioButton();
        jRB_americano = new javax.swing.JRadioButton();
        jRB_iceCappucino = new javax.swing.JRadioButton();
        jRB_iceHazelnutLatte = new javax.swing.JRadioButton();
        jRB_iceCaramelLatte = new javax.swing.JRadioButton();
        jRB_iceVanilaLatte = new javax.swing.JRadioButton();
        jRB_iceCoffeLatte = new javax.swing.JRadioButton();
        jB_next = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jS_coffeBarista = new javax.swing.JSpinner();
        jS_iceCoffe = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 590));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Beverage Menu");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ice Coffee");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 150, 252, 39));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Coffee Barista");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 281, 39));

        bG_coffeeBarista.add(jRB_coffeMocca);
        jRB_coffeMocca.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jRB_coffeMocca.setText("Coffee Mocca");
        jRB_coffeMocca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_coffeMoccaActionPerformed(evt);
            }
        });
        getContentPane().add(jRB_coffeMocca, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        bG_coffeeBarista.add(jRB_espresso);
        jRB_espresso.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jRB_espresso.setText("Espresso");
        jRB_espresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_espressoActionPerformed(evt);
            }
        });
        getContentPane().add(jRB_espresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, -1, -1));

        bG_coffeeBarista.add(jRB_coffeLatte);
        jRB_coffeLatte.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jRB_coffeLatte.setText("Coffee Latte");
        jRB_coffeLatte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_coffeLatteActionPerformed(evt);
            }
        });
        getContentPane().add(jRB_coffeLatte, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, -1, -1));

        bG_coffeeBarista.add(jRB_cappucino);
        jRB_cappucino.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jRB_cappucino.setText("Cappucino");
        jRB_cappucino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_cappucinoActionPerformed(evt);
            }
        });
        getContentPane().add(jRB_cappucino, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, -1, -1));

        bG_coffeeBarista.add(jRB_americano);
        jRB_americano.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jRB_americano.setText("Americano");
        jRB_americano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_americanoActionPerformed(evt);
            }
        });
        getContentPane().add(jRB_americano, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, -1, -1));

        bG_iceCoffee.add(jRB_iceCappucino);
        jRB_iceCappucino.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jRB_iceCappucino.setText("Cappucino");
        jRB_iceCappucino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_iceCappucinoActionPerformed(evt);
            }
        });
        getContentPane().add(jRB_iceCappucino, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 340, -1, -1));

        bG_iceCoffee.add(jRB_iceHazelnutLatte);
        jRB_iceHazelnutLatte.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jRB_iceHazelnutLatte.setText("Hazelnut Latte");
        jRB_iceHazelnutLatte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_iceHazelnutLatteActionPerformed(evt);
            }
        });
        getContentPane().add(jRB_iceHazelnutLatte, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 220, -1, -1));

        bG_iceCoffee.add(jRB_iceCaramelLatte);
        jRB_iceCaramelLatte.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jRB_iceCaramelLatte.setText("Caramel Latte");
        jRB_iceCaramelLatte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_iceCaramelLatteActionPerformed(evt);
            }
        });
        getContentPane().add(jRB_iceCaramelLatte, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 250, -1, -1));

        bG_iceCoffee.add(jRB_iceVanilaLatte);
        jRB_iceVanilaLatte.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jRB_iceVanilaLatte.setText("Vanila Latte");
        jRB_iceVanilaLatte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_iceVanilaLatteActionPerformed(evt);
            }
        });
        getContentPane().add(jRB_iceVanilaLatte, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 280, -1, -1));

        bG_iceCoffee.add(jRB_iceCoffeLatte);
        jRB_iceCoffeLatte.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jRB_iceCoffeLatte.setText("Coffee Latte");
        jRB_iceCoffeLatte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_iceCoffeLatteActionPerformed(evt);
            }
        });
        getContentPane().add(jRB_iceCoffeLatte, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 310, -1, -1));

        jB_next.setText("Next");
        jB_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_nextActionPerformed(evt);
            }
        });
        getContentPane().add(jB_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 460, 210, 60));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setText("Jumlah :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, -1, -1));

        jS_coffeBarista.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jS_coffeBarista.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        getContentPane().add(jS_coffeBarista, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 70, 40));

        jS_iceCoffe.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jS_iceCoffe.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        getContentPane().add(jS_iceCoffe, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 400, 70, 40));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setText("Jumlah :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 400, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRB_coffeMoccaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_coffeMoccaActionPerformed
        // TODO add your handling code here:
        selected_coffeBarista = true;
    }//GEN-LAST:event_jRB_coffeMoccaActionPerformed

    private void jRB_espressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_espressoActionPerformed
        // TODO add your handling code here:
        selected_coffeBarista = true;
    }//GEN-LAST:event_jRB_espressoActionPerformed

    private void jRB_cappucinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_cappucinoActionPerformed
        // TODO add your handling code here:
        selected_coffeBarista = true;
    }//GEN-LAST:event_jRB_cappucinoActionPerformed

    private void jRB_americanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_americanoActionPerformed
        // TODO add your handling code here:
        selected_coffeBarista = true;
    }//GEN-LAST:event_jRB_americanoActionPerformed
    
    private void jB_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_nextActionPerformed
        // TODO add your handling code here:
        
        checkOrder();

        setJumlahIceCoffee();
        setJumlahCoffeBarista();
        
        
        
        if(getIceCoffe() != null || getCoffeeBarista() != null) {
            if(getJumlahIceCoffee() > 0 || getJumlahCoffeBarista() > 0) {
                
                Form_ConfirmOrder fco = new Form_ConfirmOrder(getCoffeeBarista(),getIceCoffe(), getJumlahCoffeBarista(), getJumlahIceCoffee());
                Home.jDesktopPane.removeAll();
                Home.jDesktopPane.repaint();

                fco.setVisible(true);
                Home.jDesktopPane.add(fco);
            } else {
                JOptionPane.showMessageDialog(this, "Masukkan Jumlah Minuman !");
            }
        }else {
            JOptionPane.showMessageDialog(this, "Pilih menu !");
        }
    }//GEN-LAST:event_jB_nextActionPerformed

    private void jRB_iceVanilaLatteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_iceVanilaLatteActionPerformed
        // TODO add your handling code here:
        selected_iceCoffee = true;
    }//GEN-LAST:event_jRB_iceVanilaLatteActionPerformed

    private void jRB_coffeLatteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_coffeLatteActionPerformed
        // TODO add your handling code here:
        selected_coffeBarista = true;
    }//GEN-LAST:event_jRB_coffeLatteActionPerformed

    private void jRB_iceHazelnutLatteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_iceHazelnutLatteActionPerformed
        // TODO add your handling code here:
        selected_iceCoffee = true;
    }//GEN-LAST:event_jRB_iceHazelnutLatteActionPerformed

    private void jRB_iceCaramelLatteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_iceCaramelLatteActionPerformed
        // TODO add your handling code here:
        selected_iceCoffee = true;
    }//GEN-LAST:event_jRB_iceCaramelLatteActionPerformed

    private void jRB_iceCoffeLatteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_iceCoffeLatteActionPerformed
        // TODO add your handling code here:
        selected_iceCoffee = true;
    }//GEN-LAST:event_jRB_iceCoffeLatteActionPerformed

    private void jRB_iceCappucinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_iceCappucinoActionPerformed
        // TODO add your handling code here:
        selected_iceCoffee = true;
    }//GEN-LAST:event_jRB_iceCappucinoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bG_coffeeBarista;
    private javax.swing.ButtonGroup bG_iceCoffee;
    private javax.swing.JButton jB_next;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRB_americano;
    private javax.swing.JRadioButton jRB_cappucino;
    private javax.swing.JRadioButton jRB_coffeLatte;
    private javax.swing.JRadioButton jRB_coffeMocca;
    private javax.swing.JRadioButton jRB_espresso;
    private javax.swing.JRadioButton jRB_iceCappucino;
    private javax.swing.JRadioButton jRB_iceCaramelLatte;
    private javax.swing.JRadioButton jRB_iceCoffeLatte;
    private javax.swing.JRadioButton jRB_iceHazelnutLatte;
    private javax.swing.JRadioButton jRB_iceVanilaLatte;
    private javax.swing.JSpinner jS_coffeBarista;
    private javax.swing.JSpinner jS_iceCoffe;
    // End of variables declaration//GEN-END:variables
}
