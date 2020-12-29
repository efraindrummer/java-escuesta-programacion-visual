/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoencuesta;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author javier
 */
public class Conectar {
    Connection conec=null;
    private boolean con=false;

    public Conectar() {
    }

    
    public Connection getConec() {
        return conec;
    }

    public void setConec(Connection conec) {
        this.conec = conec;
    }

    public boolean isCon() {
        return con;
    }

    public void setCon(boolean con) {
        this.con = con;
    }
    
    public Connection conexion(){
        try {
            //buscar y carga el driver de la conexion sql 
            Class.forName("com.mysql.jdbc.Driver");
           
            conec=DriverManager.getConnection("jdbc:mysql://localhost/trabajoJava","root","javier");
         
            con=true;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Conexion fallida "+ e);
           
        }
        return conec;
    }
    
    
}
