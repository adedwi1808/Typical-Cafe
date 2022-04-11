/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

/**
 *
 * @author wolfie
 */

import java.sql.*;


public class Koneksi {
    public static Connection con;
    public static Statement stm;
    
    public  void config(){
        try {
            String url ="jdbc:mysql://localhost:3306/typical_cafe";
            String user="root";
            String pass="";
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection(url,user,pass);
            stm = con.createStatement();
            
        } catch (Exception e) {
            System.err.println("Gagal Terhubung ke Database " +e.getMessage());
        }
    }
}

