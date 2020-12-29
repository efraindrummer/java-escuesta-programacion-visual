/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoencuesta;


import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author javier
 */
public class Ventana extends JFrame {
    
    public Ventana(int total,int bajoPeso,int normal,int sobrePeso,int obeso){
        this.setLocation(100, 100);
        setSize(450, 550);
        setBackground(Color.black);
        add(new Dibujo(total,bajoPeso,normal,sobrePeso,obeso));
        setVisible(true);
        setBackground(Color.black);
        
    }
    
}
