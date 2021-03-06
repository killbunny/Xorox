/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Alumno;
import static Clases.Alumno.macadress;
import Clases.Conexion;
import Clases.Validar_Campo_de_Texto;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp Pavilion g4
 */
public final class Login extends javax.swing.JFrame {

    //Variables de entorno
    String cicloEscolar;
    Connection conn;
    Conexion b1 = new Conexion();
    StringBuilder sb = new StringBuilder();
    InetAddress ip;
    String IP_remota;
    String MAC;
    String fecha_Actual = "";
    boolean fecha_es_correcta = false;
    boolean modoOffline=false;
    //Objeto de validación de campos de texto
    Validar_Campo_de_Texto validar = new Validar_Campo_de_Texto();

    public Login() {
        initComponents();
        //Validar que el usuario sea numérico
        validar.SNumeros(txtUsuario);

        //Obtener Fecha de la maquina
        //Fecha Actual del Equipo
        Calendar fecha = Calendar.getInstance();
        int dia = fecha.get(fecha.DAY_OF_MONTH);
        int año = fecha.get(fecha.YEAR);
        int mes = fecha.get(fecha.MONTH);
        //Asi se llama el proceso que recibe como parametro el numero del mes actual
        //Y en base a eso lo castea y devuelve el nombre del mes actual
        String mes1 = formato_mes(mes);
        fecha_Actual = dia + "/" + mes1 + "/" + año;

        try {
            //Se  obtiene la direccion ip de la computadora local   
            ip = InetAddress.getLocalHost();
            //Se crea una interfaz de red apartir de la direccion ip actual
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            //La direccion Mac se descompone en bytes
            byte[] mac = network.getHardwareAddress();
            //Se crea el objeto StringBuilder para traducir los bytes a caracteres
            IP_remota = ip.getHostAddress();
            //Comprueba que la MAC no sea nula
            if (mac != null) {
                //Si no es nula procede a agregar la MAC al stringbuilder
                for (int j = 0; j < mac.length; j++) {

                    //Se van agregando los bytes con el formato especificado en el objeto StringBuilder  
                    sb.append(String.format("%02X%s", mac[j], (j < mac.length - 1) ? "-" : ""));
                }
            } else {
                //Si es nula crea una Exception de tipo NoNetworkException
                throw new NoNetworkException("No hay direccion MAC en el dispositivo");
            }
            //Se convierte esa informacion a cadena para que finalmente se le pase esa informacion al JLabel
            //lblMAC_ADDRESS.setText(Dirmac);
        } catch (UnknownHostException | SocketException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (NoNetworkException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "Se usará la dirección mac 11-22-33-44-55-66");
            sb.append("112233445566");//Cambiar esto y poner guiones
        }
        Alumno.Fecha = fecha_Actual;
        MAC = sb.toString();
        Alumno.macadress = MAC;
        boolean existe = mostrar_mensaje(MAC);
        if (existe) {
            setVisible(true);
            Actualizar_IP(MAC, IP_remota);
        } else if(Alumno.modoOffline=true) {
            
            XoroxOffline xo=new XoroxOffline();
            xo.setVisible(true);
        } else{
            JOptionPane.showMessageDialog(null, "Direccion MAC sin Registrar: " + MAC);
            System.exit(0);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        pwdContraseña = new javax.swing.JPasswordField();
        btn_Iniciar_Sesion = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Usuario:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, -1, -1));

        jLabel3.setText("Contraseña:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, -1, -1));

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 300, -1));
        jPanel1.add(pwdContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 300, -1));

        btn_Iniciar_Sesion.setText("Iniciar Sesion");
        btn_Iniciar_Sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Iniciar_SesionActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Iniciar_Sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, -1, -1));

        jButton2.setText("Apagar Equipo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 530, -1, -1));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setText("Universidad Autonoma de Coahuila");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, 20));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel4.setText("Escuela de Sistemas U.T");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/escudo1.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario_login_1.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 210, 220));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String formato_mes(int mes) {
        //debido a que los enteros de los meses del jcalendar 
        //empiesan en 0 se le aumenta uno para poder regresar el entero correcto
        mes = mes + 1;

        String mes1 = "";
        //esto se hace debido al formato de las fechas
        if (mes <= 9) {
            mes1 = "0" + mes;
        } else {
            mes1 = "" + mes;
        }
        return mes1;
    }

    public boolean Comprobar_Fecha_del_Ciclo_E(String Fecha_Actual) {
        boolean fecha_correcta = false;
        int id_Ciclo_esc = 0;
        try {
            //comprueba si la fecha actual se encuentra dentro del rango de algun ciclo escolar siempre y cuando este activo     
            String consultar = "SELECT id_Ciclo_Escolar,Ciclo_Escolarcol FROM xorox.ciclo_escolar where str_to_date('" + Fecha_Actual + "', '%d/%m/%Y') between str_to_date(desde, '%d/%m/%Y') and  str_to_date(hasta, '%d/%m/%Y') and estado='activo'; ";
            Conexion miconexion = new Conexion();
            Connection conn = miconexion.getConnection();
            //Creamos el statement de la consulta y obtenemos su resultset
            Statement pst2 = conn.createStatement();
            ResultSet rs = pst2.executeQuery(consultar);
            while (rs.next()) {
                //Guarda el numero de ID del ciclo   
                id_Ciclo_esc = (rs.getInt("id_Ciclo_Escolar"));
                cicloEscolar = (rs.getString("Ciclo_Escolarcol"));
            }
            //si la fecha actual esta en el rango volvera la variable boolean verdadera
            if (id_Ciclo_esc != 0) {
                fecha_correcta = true;
            }
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //regresa un falso o un verdadero de acuerdo a la comprobacion de la fecha
        return fecha_correcta;
    }


    private void btn_Iniciar_SesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Iniciar_SesionActionPerformed
        // TODO add your handling code here:
        boolean a1 = false; //En caso de haber contraseña a1=true sino a1=false
        boolean b1 = false; //Comprueba que Valores[0] no sea nulo

        if (txtUsuario.getText().trim().equals("") || pwdContraseña.getPassword() == null) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios");
        } else {
            //Recupera la contraseña escrito en el campo de password
            String contraseña = "";
            char a[] = pwdContraseña.getPassword();
            for (int i = 0; i < a.length; i++) {
                contraseña = contraseña + a[i];
            }
            int No_Matricula = Integer.parseInt(txtUsuario.getText());
            Alumno.Alumno = txtUsuario.getText();

            //Comprueba que el No de Matricula sea correcto
            Object Valores[] = comprobar_NoMatricula(No_Matricula);

            if (Valores[0] != null) {
                b1 = true;
                String dat = comprobar_Contraseña(No_Matricula, contraseña);
                if (!dat.equals("")) {
                    a1 = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
                }

            } else {
                JOptionPane.showMessageDialog(null, "No. Matricula Incorrecta/ La Matricula no existe favor de registrarse con el administrador del Sistema");
            }

            if (a1 && b1) {
                Alumno.No_Matricula = Integer.parseInt(txtUsuario.getText());

                //comprueba si la fecha actual del equipo pertenece al ciclo escolar activo
                fecha_es_correcta = Comprobar_Fecha_del_Ciclo_E(fecha_Actual);
                if (fecha_es_correcta) {
                    //en caso que lo sea permite ingresar a la ventana de configuracion    
                    Alumno.cicloEscolar = this.cicloEscolar;
                    this.dispose();
                    Configuracion con1 = new Configuracion();
                    con1.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "La Fecha Actual del Equipo no corresponde al Ciclo Escolar Actual \n");
                    JOptionPane.showMessageDialog(null, "Posibles Soluciones:\n"
                            + "1.-Favor de solicitar al admininstrador del Sistema comprobar que la fecha Actual del equipo se encuentra dentro del rango de las\n"
                            + "fechas del Ciclo Escolar Actual\n"
                            + "2.Favor de solicitar al administrador del Sistema registrar el nuevo Ciclo Escolar si no esta registrado\n"
                            + "3.-Favor de solcitar al administrador del Sistema comprobar si de todos los ciclos escolares que se encuentran en la base de datos esta activado el ciclo Escolar Correcto\n"
                            + "de no ser asi solicitar que active el Ciclo Escolar correcto");
                }
            }

        }

    }//GEN-LAST:event_btn_Iniciar_SesionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    public String Comprobar_MaC(String MAC) {
        
        String info = "";
        try {
            String consultar = "SELECT MAC_ADDRESS FROM xorox.equipo where MAC_ADDRESS='" + MAC + "';";
            
            conn = b1.getConnection();
            
            Statement pst2 = conn.createStatement();
            ResultSet rs = pst2.executeQuery(consultar);
            
            while (rs.next()) {
                info = rs.getString("MAC_ADDRESS");
            }
            conn.close();

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Base de datos no disponible");
            Alumno.modoOffline=true;
            
        }

        return info;
    }

    public void Actualizar_IP(String MAC, String IP) {
        try {

            Conexion miconexion = new Conexion();
            Connection conn = miconexion.getConnection();
            //Segun la columna que haya seleccionado sera el valor que se modique

            String actualizar = "UPDATE `xorox`.`equipo` SET `Direccion_IP`=? WHERE `MAC_ADDRESS`=?;";
            PreparedStatement pst = conn.prepareStatement(actualizar);
            pst.setString(1, IP);
            pst.setString(2, MAC);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Direccion IP actualizada");
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public boolean mostrar_mensaje(String MAC) {
        boolean existe = false;
        String MAC1 = Comprobar_MaC(MAC);
        if (!MAC1.equals("")) {
            existe = true;
        } else if(Alumno.modoOffline==false) {
            JOptionPane.showMessageDialog(null, "La direccion MAC del equipo actual no esta dada de alta en el Sistema Xorox"
                    + " por favor registrela antes de hacer uso del sistema");
            existe = false;
        }else {
            JOptionPane.showMessageDialog(null,"Entrando al modo Offline");
        }
        return existe;
    }

    public Object[] comprobar_NoMatricula(int No_matriculas) {
        int no_matricula = 0;
        Object datos[] = new Object[2];
        try {
            conn = b1.getConnection();
            String consultar = "SELECT NO_MATRICULA,Alumno FROM xorox.alumnos where NO_MATRICULA=" + No_matriculas + ";";
            Conexion miconexion = new Conexion();
            Connection conn = miconexion.getConnection();
            Statement pst2 = conn.createStatement();
            ResultSet rs = pst2.executeQuery(consultar);

            while (rs.next()) {
                datos[0] = rs.getInt("NO_MATRICULA");
                datos[1] = rs.getString("Alumno");
            }
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return datos;
    }

    public String comprobar_Contraseña(int No_matriculas, String Contraseña) {
        String contraseña = "";

        try {
            conn = b1.getConnection();
            String consultar = "SELECT Contraseña FROM xorox.alumnos where NO_MATRICULA=" + No_matriculas + " and Contraseña='" + Contraseña + "';";
            Conexion miconexion = new Conexion();
            Connection conn = miconexion.getConnection();
            Statement pst2 = conn.createStatement();
            ResultSet rs = pst2.executeQuery(consultar);
            Object datos[] = new Object[2];
            while (rs.next()) {
                contraseña = rs.getString("Contraseña");
            }
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return contraseña;
    }

   

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Iniciar_Sesion;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField pwdContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public static class NoNetworkException extends Exception {

        String message;

        public NoNetworkException(String msg) {
            message = msg;
        }

        public String getMessage() {
            return message;
        }

    }
}
