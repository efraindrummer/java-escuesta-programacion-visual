/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoencuesta;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.ImageIcon;

/**
 *
 * @author javier
 */
public class Dibujo extends Canvas {
    int total; 
    int bajoPeso;
        int normal;
        int sobrePeso;
        int obeso;
      
    public Dibujo(int total,int bajoPeso,int normal,int sobrePeso,int obeso){
        this.total=total;
        this.bajoPeso=bajoPeso;
        this.normal=normal;
        this.sobrePeso=sobrePeso;
        this.obeso=obeso;
    }

    
    @Override
    public void paint(Graphics g){
     double dba=(100/this.total)*this.bajoPeso;
     double dno=(100/this.total)*this.normal;
      double dso=(100/this.total)*this.sobrePeso;
      double dob=(100/this.total)*this.obeso;
     ImageIcon ima=new ImageIcon("image/logo.jpg"); 
     Image imaa=ima.getImage();
     
      
      g.setColor(Color.black);
      g.fillRect(0, 0, 550, 550);
      g.drawRect(0, 0, 550, 550);
      g.drawImage(imaa, 200, 200, null);
      g.drawImage(imaa, 200, 200, 50, 50, Color.yellow, null);
      
      
     g.setColor(Color.red);
     g.fillRect(10, 450, 40, (int)dba*-1*4);
     g.drawRect(10, 450, 40, (int)dba*-1*4);
     g.setColor(Color.white);
       g.drawString("personas", 10, 460);
     g.drawString("con imc", 10, 470);
     g.drawString("bajo peso", 10, 480);
     g.drawString(this.bajoPeso+" de "+this.total, 10, 490);
     //------------------------------------
     
     g.setColor(Color.blue);
     g.fillRect(90, 450, 40, (int)dno*-1*3);
     g.drawRect(90, 450, 40, (int)dno*-1*3);
     g.setColor(Color.white);
      g.drawString("personas", 90, 460);
     g.drawString("con imc", 90, 470);
     g.drawString("ideal", 90, 480);
     g.drawString(this.normal+" de "+this.total, 90, 490);
     //------------------------------------
      g.setColor(Color.yellow);
     g.fillRect(170, 450, 40, (int)dso*-1*3);
     g.drawRect(170, 450, 40, (int)dso*-1*3);
     g.setColor(Color.white);
     g.drawString("personas", 170, 460);
     g.drawString("con imc", 170, 470);
     g.drawString("sobre peso", 170, 480);
     g.drawString(this.sobrePeso+" de "+this.total, 170, 490);
 
     
     
     //------------------------------------
       g.setColor(Color.green);
     g.fillRect(250, 450, 40, (int)dob*-1*3);
     g.drawRect(250, 450, 40, (int)dob*-1*3); 
     g.setColor(Color.white);
      g.drawString("personas", 250, 460);
     g.drawString("con imc", 250, 470);
     g.drawString("obeso", 250, 480);
     g.drawString(this.obeso+" de "+this.total, 250, 490);
   
     
    
}

        
    
}
