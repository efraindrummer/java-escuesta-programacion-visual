/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoencuesta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author seba
 */
public class AdminWindows extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalWindows
     * @param usuario
     */
    public AdminWindows() {
        initComponents();
        //this.frame.setVisible(false);
        setTitle("ADMINSTRADOR");
        setSize(1110,600);
         
        this.setLocationRelativeTo(rootPane);
        
       cargarUsuario();
       mostrarDatosAdmin();
       
       cargarArray();
        
    }
        public void grafica(int anoInf,int anoSup){
             
        int bajoPeso=0;
        int normal=0;
        int sobrePeso=0;
        int obeso=0;
        int total=0;
        for(Encuesta e:list){
            
          if(e.getEdad()>=anoInf && e.getEdad()<=anoSup){  
            if(e.getImc()<=18.5){
                bajoPeso=bajoPeso+1;
                total=total+1;
            }
             if(e.getImc()>18.5 && e.getImc()<=24.99){
                normal=normal+1;
                total=total+1;
            }
             if(e.getImc()>24.99 && e.getImc()<=29.99){
                sobrePeso=sobrePeso+1;
                total=total+1;
            }
             if(e.getImc()>29.99){
                obeso=obeso+1;
                total=total+1;
            }
          }
        }
      
   new Ventana(total,bajoPeso,normal,sobrePeso,obeso);
      
        
    }
    public void cargarUsuario(){
         String datos[]=new String[5];
         System.out.println("carcar usuario funcionando");
         try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM admin WHERE estado='activo'");
            while(rs.next()){
                 datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                
                this.lblUser.setText(datos[1]);
                System.out.println("nombre :"+datos[1]);
                break;
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, "error al obtener datos del usuario");
        }
    }
        public void mostrarDatosAdmin(){
        //llenar la tabla con lo datos contenidos en la base de datos
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("rut");
        model.addColumn("nombre");
        model.addColumn("apellido");
        model.addColumn("edad");
        model.addColumn("peso");
        model.addColumn("estatura");
        model.addColumn("imc");
        model.addColumn("fecha");
        model.addColumn("estado");
        model.addColumn("Encuestador");
        
        this.tblDatos.setModel(model);
        DefaultComboBoxModel combo=new DefaultComboBoxModel();
            System.out.println("tabla cambiada");
        String datosEncuesta[]=new String[10];
       
        try {
            //obtener registros desde la base de datos
            Statement stt=con.createStatement();
            ResultSet resultado=stt.executeQuery("Select * from encuesta");
            while(resultado.next()){
                datosEncuesta[0]=resultado.getString(1);
                datosEncuesta[1]=resultado.getString(2);
                datosEncuesta[2]=resultado.getString(3);
                datosEncuesta[3]=resultado.getString(4);
                datosEncuesta[4]=resultado.getString(5);
                datosEncuesta[5]=resultado.getString(6);
                datosEncuesta[6]=resultado.getString(7);
                datosEncuesta[7]=resultado.getString(8);
                datosEncuesta[8]=resultado.getString(9);
               datosEncuesta[9]=resultado.getString(10);
               String nom=datosEncuesta[9];
               
              
               
               model.addRow(datosEncuesta);
    String rut=resultado.getString(1);
    String nombre=resultado.getString(2);;
    String apellido=resultado.getString(3);;
    int edad=Integer.parseInt(resultado.getString(4));
    int peso=Integer.parseInt(resultado.getString(5));
    double estatura=Double.parseDouble(resultado.getString(6));
    double imc=Double.parseDouble(resultado.getString(7));
    String fecha=resultado.getString(8);
    String estado=resultado.getString(10);
    Encuesta en=new Encuesta(rut,nombre,apellido,edad,peso,estatura,imc,fecha,estado);
    list.add(en);
                
            }
             try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT nombre from encuestador;");
            while(rs.next()){
                combo.addElement(rs.getString(1));
            
               
            }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane,"error al cargar el combobox");
        }
           
            this.tblDatos.setModel(model);
            this.cbxFiltrarxEncuestador.setModel(combo);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"error al cargar los registro "+ e);
                    
        }
    }


    
     public void prueba(){
         int fila=this.tblDatos.getRowCount();
         int bajoPeso=0;
        int normal=0;
        int sobrePeso=0;
        int obeso=0;
        int total=0;
       ArrayList ee=new ArrayList();
       for(int i=0;i<fila;i++){
            double imcc=Double.parseDouble(tblDatos.getValueAt(i,6).toString());
            ee.add(imcc);
       }
       
            
           for(int i=0;i<fila;i++){
               String aux=ee.get(i).toString();
               double e=Double.parseDouble(aux);
            if(e<=18.5){
                bajoPeso=bajoPeso+1;
                total=total+1;
            }
             if(e>18.5 && e<=24.99){
                normal=normal+1;
                total=total+1;
            }
             if(e>24.99 && e<=29.99){
                sobrePeso=sobrePeso+1;
                total=total+1;
            }
             if(e>29.99){
                obeso=obeso+1;
                total=total+1;
            }
         
           }
           new Ventana(total,bajoPeso,normal,sobrePeso,obeso);
        }
      
    
        
       /* String nom="";
        for(Admin a:list){
         if(a.getEstado().equals("activo")){
             nom=a.getNombre();
         }*/
     
   
    public void cargarArray(){
        String codigo;
        String nombre;
        String pass;
        String estado;
        ArrayList<String[]>lista=new ArrayList();
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM admin");
            while(rs.next()){
                 codigo=rs.getString(1);
                nombre=rs.getString(2);
                pass=rs.getString(3);
                estado=rs.getString(4);
                Admin ad=new Admin(codigo,nombre,pass,estado);
                
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, "error al obtener datos del usuario");
        
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

        frame = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        toolsMouse = new javax.swing.JPopupMenu();
        Eliminar = new javax.swing.JMenuItem();
        btnFiltrarxEdad = new javax.swing.JButton();
        btnGraficar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnAdministrarEnc = new javax.swing.JButton();
        txtEdadMin = new javax.swing.JTextField();
        txtEdadMax = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbxFiltrarxEncuestador = new javax.swing.JComboBox();
        btnFiltrarxEncuestado = new javax.swing.JButton();
        txtComandoSQL = new javax.swing.JTextField();
        btnComandoSQL = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        frame.setVisible(true);

        jButton5.setText("jButton5");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addComponent(jButton5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton5)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout frameLayout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(frameLayout);
        frameLayout.setHorizontalGroup(
            frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(467, Short.MAX_VALUE))
        );
        frameLayout.setVerticalGroup(
            frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(311, Short.MAX_VALUE))
        );

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        toolsMouse.add(Eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnFiltrarxEdad.setText("graficar por edad");
        btnFiltrarxEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarxEdadActionPerformed(evt);
            }
        });
        getContentPane().add(btnFiltrarxEdad);
        btnFiltrarxEdad.setBounds(260, 460, 140, 30);

        btnGraficar.setText("Graficar Datos");
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGraficar);
        btnGraficar.setBounds(70, 430, 140, 30);

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDatos.setComponentPopupMenu(toolsMouse);
        jScrollPane1.setViewportView(tblDatos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 140, 1060, 250);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tabla de Registros");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(100, 80, 210, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estas conectado como :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(890, 50, 200, 20);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(977, 540, 70, 23);

        btnAdministrarEnc.setText("Administrar Encuestadores");
        btnAdministrarEnc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarEncActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdministrarEnc);
        btnAdministrarEnc.setBounds(670, 70, 190, 40);

        txtEdadMin.setText("edad min");
        txtEdadMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEdadMinMouseClicked(evt);
            }
        });
        getContentPane().add(txtEdadMin);
        txtEdadMin.setBounds(260, 420, 70, 30);

        txtEdadMax.setText("edad max");
        txtEdadMax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEdadMaxMouseClicked(evt);
            }
        });
        getContentPane().add(txtEdadMax);
        txtEdadMax.setBounds(340, 420, 70, 30);

        lblUser.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblUser.setText("Usuario");
        getContentPane().add(lblUser);
        lblUser.setBounds(890, 70, 170, 60);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(890, 70, 170, 50);

        getContentPane().add(cbxFiltrarxEncuestador);
        cbxFiltrarxEncuestador.setBounds(460, 420, 100, 20);

        btnFiltrarxEncuestado.setText("graficar por encuestador");
        btnFiltrarxEncuestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarxEncuestadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnFiltrarxEncuestado);
        btnFiltrarxEncuestado.setBounds(430, 470, 170, 30);

        txtComandoSQL.setText("SELECT * FROM encuesta");
        txtComandoSQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComandoSQLActionPerformed(evt);
            }
        });
        getContentPane().add(txtComandoSQL);
        txtComandoSQL.setBounds(680, 410, 400, 30);

        btnComandoSQL.setText("ingresar comand SQL");
        btnComandoSQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComandoSQLActionPerformed(evt);
            }
        });
        getContentPane().add(btnComandoSQL);
        btnComandoSQL.setBounds(780, 460, 200, 23);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar);
        btnActualizar.setBounds(90, 110, 100, 23);

        fondo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fondo.setForeground(new java.awt.Color(255, 255, 255));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo pantalla.jpg"))); // NOI18N
        fondo.setText("jLabel1");
        getContentPane().add(fondo);
        fondo.setBounds(20, 20, 1250, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  try{
    
    PreparedStatement sttt=con.prepareStatement("UPDATE admin set estado='"+"inactivo'"+" WHERE codigo=1");          
     sttt.executeUpdate();
      PreparedStatement stttt=con.prepareStatement("UPDATE admin set estado='"+"inactivo'"+" WHERE codigo=2");          
     stttt.executeUpdate();       
         
       
  }catch(SQLException e){
      JOptionPane.showMessageDialog(rootPane, "se perdio la coneccion con el usuario "+e);
      
  }
  menu me=new menu();
  me.show();
  this.dispose();
  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnFiltrarxEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarxEdadActionPerformed
      String consulta="Select * from encuesta where edad>=";
      String edadMin=this.txtEdadMin.getText();
      String edadMax=this.txtEdadMax.getText();
      consulta=consulta+edadMin+" and edad<="+edadMax+";";
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("rut");
        model.addColumn("nombre");
        model.addColumn("apellido");
        model.addColumn("edad");
        model.addColumn("peso");
        model.addColumn("estatura");
        model.addColumn("imc");
        model.addColumn("fecha");
        model.addColumn("estado");
        model.addColumn("Encuestador");
        
        this.tblDatos.setModel(model);
         String datosEncuesta[]=new String[10];
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(consulta);
            while(rs.next()){
                
                 datosEncuesta[0]=rs.getString(1);
                datosEncuesta[1]=rs.getString(2);
                datosEncuesta[2]=rs.getString(3);
                datosEncuesta[3]=rs.getString(4);
                datosEncuesta[4]=rs.getString(5);
                datosEncuesta[5]=rs.getString(6);
                datosEncuesta[6]=rs.getString(7);
                datosEncuesta[7]=rs.getString(8);
                datosEncuesta[8]=rs.getString(9);
               datosEncuesta[9]=rs.getString(10);
               
               
              
               
               model.addRow(datosEncuesta);
            }
        }catch(Exception e){
               JOptionPane.showMessageDialog(rootPane,"LA CONSULTA TIENE ALGUN ERROR "+e);
               JOptionPane.showMessageDialog(rootPane,"Recuerde que la consulata tiene que empezar con select *  "+e);
                    }
        this.tblDatos.setModel(model);
            
    }//GEN-LAST:event_btnFiltrarxEdadActionPerformed

    private void btnAdministrarEncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarEncActionPerformed
AdministrarEncuestadores ad=new AdministrarEncuestadores();
ad.show();
    }//GEN-LAST:event_btnAdministrarEncActionPerformed

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
            prueba();   
    }//GEN-LAST:event_btnGraficarActionPerformed

    private void btnFiltrarxEncuestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarxEncuestadoActionPerformed
String consulta="Select * from encuesta where nombreEncuestador='";
      String encuestador=this.cbxFiltrarxEncuestador.getSelectedItem().toString();
      
      consulta=consulta+encuestador+"';";
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("rut");
        model.addColumn("nombre");
        model.addColumn("apellido");
        model.addColumn("edad");
        model.addColumn("peso");
        model.addColumn("estatura");
        model.addColumn("imc");
        model.addColumn("fecha");
        model.addColumn("estado");
        model.addColumn("Encuestador");
        
        this.tblDatos.setModel(model);
         String datosEncuesta[]=new String[10];
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(consulta);
            while(rs.next()){
                
                 datosEncuesta[0]=rs.getString(1);
                datosEncuesta[1]=rs.getString(2);
                datosEncuesta[2]=rs.getString(3);
                datosEncuesta[3]=rs.getString(4);
                datosEncuesta[4]=rs.getString(5);
                datosEncuesta[5]=rs.getString(6);
                datosEncuesta[6]=rs.getString(7);
                datosEncuesta[7]=rs.getString(8);
                datosEncuesta[8]=rs.getString(9);
               datosEncuesta[9]=rs.getString(10);
               
               
              
               
               model.addRow(datosEncuesta);
            }
        }catch(Exception e){
               JOptionPane.showMessageDialog(rootPane,"LA CONSULTA TIENE ALGUN ERROR "+e);
               JOptionPane.showMessageDialog(rootPane,"Recuerde que la consulata tiene que empezar con select *  "+e);
                    }
        this.tblDatos.setModel(model);   
               
                
                
                
                
                
      

    }//GEN-LAST:event_btnFiltrarxEncuestadoActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int fila=this.tblDatos.getSelectedRow();
           String codigo=tblDatos.getValueAt(fila, 0).toString();
            try{
            PreparedStatement st=con.prepareStatement("DELETE FROM Encuesta WHERE  rut='"+codigo+"'");
            st.executeUpdate();
            mostrarDatosAdmin();
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane,"error al eliminar los registros "+e);
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void btnComandoSQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComandoSQLActionPerformed
        String consulta=this.txtComandoSQL.getText();
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("rut");
        model.addColumn("nombre");
        model.addColumn("apellido");
        model.addColumn("edad");
        model.addColumn("peso");
        model.addColumn("estatura");
        model.addColumn("imc");
        model.addColumn("fecha");
        model.addColumn("estado");
        model.addColumn("Encuestador");
        
        this.tblDatos.setModel(model);
         String datosEncuesta[]=new String[10];
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(consulta);
            while(rs.next()){
                
                 datosEncuesta[0]=rs.getString(1);
                datosEncuesta[1]=rs.getString(2);
                datosEncuesta[2]=rs.getString(3);
                datosEncuesta[3]=rs.getString(4);
                datosEncuesta[4]=rs.getString(5);
                datosEncuesta[5]=rs.getString(6);
                datosEncuesta[6]=rs.getString(7);
                datosEncuesta[7]=rs.getString(8);
                datosEncuesta[8]=rs.getString(9);
               datosEncuesta[9]=rs.getString(10);
               
               
              
               
               model.addRow(datosEncuesta);
            }
        }catch(Exception e){
               JOptionPane.showMessageDialog(rootPane,"LA CONSULTA TIENE ALGUN ERROR "+e);
               JOptionPane.showMessageDialog(rootPane,"Recuerde que la consulata tiene que empezar con select *  "+e);
                    }
        this.tblDatos.setModel(model);
            
    }//GEN-LAST:event_btnComandoSQLActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        mostrarDatosAdmin();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtComandoSQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComandoSQLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComandoSQLActionPerformed

    private void txtEdadMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEdadMinMouseClicked
       this.txtEdadMin.setText("");
  
    }//GEN-LAST:event_txtEdadMinMouseClicked

    private void txtEdadMaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEdadMaxMouseClicked
       
       this.txtEdadMax.setText("");
    }//GEN-LAST:event_txtEdadMaxMouseClicked

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
            java.util.logging.Logger.getLogger(EncuastadorWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EncuastadorWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EncuastadorWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncuastadorWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminWindows().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAdministrarEnc;
    private javax.swing.JButton btnComandoSQL;
    private javax.swing.JButton btnFiltrarxEdad;
    private javax.swing.JButton btnFiltrarxEncuestado;
    private javax.swing.JButton btnGraficar;
    private javax.swing.JComboBox cbxFiltrarxEncuestador;
    private javax.swing.JLabel fondo;
    private javax.swing.JInternalFrame frame;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTable tblDatos;
    private javax.swing.JPopupMenu toolsMouse;
    private javax.swing.JTextField txtComandoSQL;
    private javax.swing.JTextField txtEdadMax;
    private javax.swing.JTextField txtEdadMin;
    // End of variables declaration//GEN-END:variables
Conectar cone=new Conectar();
Connection con=cone.conexion();
ArrayList<Encuesta>list=new ArrayList();
 ArrayList<Encuesta>listaFiltrada=new ArrayList();
}
