/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoencuesta;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author gmsergiov
 */
public class JLabelLink extends JLabel{
    //la url del sitio
    String url;
    //el texto que muestra el label
    String texto;

    public JLabelLink(String url, String texto) {
        //las propiedades del label
        this.url = url;
        this.texto = texto;
        setText(texto);
        setSize(150, 40);
        makeLink();
    }
    
    
    //para agregar el componene a un jframe
    public static void main(String[] args) {
        JFrame frame =new JFrame("JLabelLink");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(new JLabelLink("www.aportaciones.net", "ir a aportaciones.net"));
        frame.setVisible(true);
    }
    // el mÃ©todo para implementar los eventos del mouse
    private void makeLink() {
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    //el el evento click se visita el sitio en el navegador
                    Desktop.getDesktop().browse(new URI(url));
                } catch (IOException ex) {
                    Logger.getLogger(JLabelLink.class.getName()).log(Level.SEVERE, null, ex);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(JLabelLink.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                //cuando el mouse entra en el area del compomente
                //se establece el cursor como link
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //cuando sale del area se reestablece a su estado normal
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }
    
}