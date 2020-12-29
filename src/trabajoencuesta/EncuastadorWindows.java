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
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author seba
 */
public class EncuastadorWindows extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalWindows
     * @param Usuario
     */
    public EncuastadorWindows() {
        initComponents();
      
        this.setLocationRelativeTo(rootPane);
        setTitle("ENCUESTADOR");
       cargarUsuario();
       mostrarDatosEncuestador();
    }
    public void barrer(){
        this.txtRut.setText("");
        this.txtNombre.setText("");
        this.txtApellido.setText("");
        this.txtEdad.setText("");
        this.txtEstatura.setText("");
        this.txtPeso.setText("");
    }
    public void cargarUsuario(){
         String datos[]=new String[5];
         System.out.println("cargar usuario funcionando");
         try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM encuestador WHERE estado='activo'");
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
       /* String nom="";
        for(Admin a:list){
         if(a.getEstado().equals("activo")){
             nom=a.getNombre();
         }*/
     }
    public void mostrarDatosEncuestador(){
        //llenar la tabla con lo datos contenidos en la base de datos
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("rut");
        model.addColumn("nombre");
        model.addColumn("apellido");
        model.addColumn("edad");
        model.addColumn("estatura");
        model.addColumn("peso");
        model.addColumn("imc");
        model.addColumn("fecha");
        model.addColumn("estado");
        
        this.tblDatos.setModel(model);
        String datosEncuesta[]=new String[9];
        String userrr="";
        try {
            //obtener registros desde la base de datos
            Statement stt=con.createStatement();
            ResultSet resultado=stt.executeQuery("Select * from encuesta where nombreEncuestador='"+this.lblUser.getText()+"';");
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
                userrr=resultado.getNString(10);
                model.addRow(datosEncuesta);
                
            }
            this.tblDatos.setModel(model);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"error al cargar los registro "+ e);
                    
        }
    }
        
    
    public void mostrarDatos(){
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
        
        this.tblDatos.setModel(model);
        String datosEncuesta[]=new String[9];
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
                model.addRow(datosEncuesta);
                
            }
            this.tblDatos.setModel(model);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"error al cargar los registro "+ e);
                    
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

        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEstatura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        btnGrabar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, 20));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 190, -1));
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 190, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Apellido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 50, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Edad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 34, 14));
        getContentPane().add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 190, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estatura");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 60, -1));
        getContentPane().add(txtEstatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 190, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Peso");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 34, 14));
        getContentPane().add(txtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 190, -1));

        btnGrabar.setText("Grabar Encuesta");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 140, 30));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 150, 700, 270));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tabla de Ingresos");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 160, 15));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estas conectado como :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, 200, 20));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 540, -1, -1));

        lblUser.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblUser.setText("Usuario");
        getContentPane().add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 50, 170, 60));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("rut");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        getContentPane().add(txtRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 190, -1));

        fondo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fondo.setForeground(new java.awt.Color(255, 255, 255));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo pantalla.jpg"))); // NOI18N
        fondo.setText("jLabel1");
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 10, 1250, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
     
            try {
            //obtener registros desde la base de datos
            Statement stt=con.createStatement();
            ResultSet resultado=stt.executeQuery("Select rute from encuestador");
            while(resultado.next()){
                String rut=resultado.getString(1);
                
               try{
    
    PreparedStatement sttt=con.prepareStatement("UPDATE encuestador set estado='"+"inactivo'"+" WHERE rute=+"+rut+";");          
                   System.out.println(rut+" inactivo");
    sttt.executeUpdate();
      
       
  }catch(SQLException e){
      JOptionPane.showMessageDialog(rootPane, "se perdio la coneccion con el usuario "+e);
      
  }
              
               
              
                
            }
            
        } catch (Exception e) {
                System.out.println("no se pudo cerrar sesio");
        }
            
        
        
        
  menu me=new menu();
  me.show();
  this.dispose();
  
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
       Calendar calendario=Calendar.getInstance();
        String rut=this.txtRut.getText();
       String nombre=this.txtNombre.getText();
       String apellido=this.txtApellido.getText();
       String edad=this.txtEdad.getText();
       String estatura=this.txtEstatura.getText();
       String peso=this.txtPeso.getText();
       double pe=Double.parseDouble(peso);
       double es=Double.parseDouble(estatura);
       double imcc=pe/(es*es);
       String imc=imcc+"";
       String aux=imc.substring(0, 6);
       
       imc=aux+"";
        System.out.println(imc);
       int mes,dia,ano;
    
    mes=calendario.get(Calendar.MONTH)+1;
    dia=calendario.get(Calendar.DAY_OF_MONTH);
    ano=calendario.get(Calendar.YEAR);
    String fecha=ano+"/"+mes+"/"+dia;
    String estado="indefinido";
    String encuestador=this.lblUser.getText();
    if(imcc<=18.5){
                estado="BAJO PESO";
            }
             if(imcc>18.5 && imcc<=24.99){
                estado="PESO NORMAL";
            }
             if(imcc>24.99 && imcc<=29.99){
                estado="SOBRE PESO";;
            }
             if(imcc>29.99){
                estado="OBESO";;
            }
      Encuesta en=new Encuesta(rut,nombre,apellido,Integer.parseInt(edad),Integer.parseInt(peso),Double.parseDouble(estatura),imcc,fecha,estado);  
      //----------------------------------------------------------------------------------------------
     //grabando registro
       try {
            PreparedStatement stt=con.prepareStatement("insert into encuesta(rut,nombreEncu,apellido,edad,peso,estatura,imc,fecha,estado,nombreEncuestador) values("+rut+",'"+nombre+"','"+apellido+"',"+edad+","+peso+","+estatura+","+imc+",'"+fecha+"','"+estado+"','"+encuestador+"');");
          //  stt.setString(1, rut);
            //stt.setString(2, nombre);
            //stt.setString(3, estatura);
            //stt.setString(4, peso);
            System.out.println("insert into encuesta(rut,nombreEncu,apellido,edad,peso,estatura,imc,fecha,estado,nombreEncuestador) values("+rut+",'"+nombre+"','"+apellido+"',"+edad+","+peso+","+estatura+","+imc+",'"+fecha+"','"+estado+"','"+encuestador+"');");
            int x=stt.executeUpdate();
            if(x>0){
                JOptionPane.showMessageDialog(rootPane,"agregado correctamente a la base de datos");
                barrer();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane,"No se pudo registrar en la base de datos "+e);
        }
       mostrarDatosEncuestador();
    }//GEN-LAST:event_btnGrabarActionPerformed

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
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EncuastadorWindows().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEstatura;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
Conectar cone=new Conectar();
Connection con=cone.conexion();
}
