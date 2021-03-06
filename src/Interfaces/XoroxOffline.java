/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Alumno;
import Clases.Conexion;
import Clases.Cronometro;
import Clases.Estado_Windows;
import Clases.Servidor;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TitledPane;
import javax.swing.JOptionPane;

/**
 * /**
 *
 * @author ControlWifi
 */
public class XoroxOffline extends javax.swing.JFrame {

    //Atributos
    int x = 0;
    int y = 0;
    public String horaactual = "";
    String horaTermino;

    Conexion b1 = new Conexion();
//      String horaTermino="";
    //Hilos
    public static Cronometro cron;
    //Socket que recibe el mensaje del administrador para despues proyectarlo en la ventana
    Servidor ser;
    Estado_Windows estado;

    //Clase inet address
    InetAddress ip;
    String nombre = "";
    StringBuilder sb = new StringBuilder();
    boolean fecha_es_correcta = false;  //estado para saber si la fecha actual
    //esta dentro del rango del ciclo escolar actual.

    public XoroxOffline() {
        ConfiguracionOffline c = new ConfiguracionOffline(this, true);
        c.setVisible(true);

        initComponents();
        
        cron = new Cronometro(lblCronometro);
        cron.start();

        lblAlumno.setText(Alumno.Alumno);
        lblNo_Matricula.setText("" + Alumno.No_Matricula);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblMAC_ADDRESS = new javax.swing.JLabel();
        lblUbicacion = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblAula = new javax.swing.JLabel();
        lblNo_Matricula = new javax.swing.JLabel();
        lblAlumno = new javax.swing.JLabel();
        lblCarrera = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblCronometro = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Informacion del Equipo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        jLabel2.setText("MAC Address:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        jLabel3.setText("Ubicacion:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));
        jPanel1.add(lblMAC_ADDRESS, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 252, 14));
        jPanel1.add(lblUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 252, 14));

        jLabel7.setText("Fecha:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 252, 14));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/desktop-pc-vector.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 24, -1, 140));

        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/image4144.png"))); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, 200, 90));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Informacion del Alumno");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

        jLabel9.setText("Alumno:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, -1, -1));

        jLabel10.setText("No. Matricula:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, -1, -1));

        jLabel11.setText("Carrera:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        jLabel12.setText("Aula:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, -1, -1));
        jPanel1.add(lblAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 250, 20));
        jPanel1.add(lblNo_Matricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 250, 20));
        jPanel1.add(lblAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 250, 20));
        jPanel1.add(lblCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 250, 20));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Silueta.jpg"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 200, 360));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        lblCronometro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCronometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCronometro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCronometro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel5.setText("Uso del Equipo");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/timeclock_tiemp_3924.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel5)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lblCronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 450, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void deterner_Reloj() {
        this.cron.stop();
    }

   
    public void Registrar_Sesion(String cicloEscolar, int matricula, String MAC, String Maestro, String Materia, String Aula, String Fecha, String Duracion, String Comentarios) {

        File f = new File(System.getProperty("java.io.tmpdir") + "registrospendientes.dat");
        
        try {
            
            String stm = String.format("INSERT INTO `xorox`.`uso_del_equipo` "
                    + "(`Ciclo_Escolar`, `NO_MATRICULA`, `MAC_ADDRESS`, `Maestro`, `Materia`, `Aula`, `Fecha`, `Duracion`, `Comentarios`)"
                    + " VALUES ('%s', '%s', '%s','%s','%s','%s','%s','%s','%s');",
                    Alumno.cicloEscolar,
                    Alumno.No_Matricula,
                    Alumno.macadress,
                    Alumno.Maestro,
                    Alumno.Materia,
                    Alumno.Aula,
                    Alumno.Fecha,
                    Alumno.Duracion,
                    "OFFLINE"
            );

            if (!f.exists()) {
                f.createNewFile();
            }
            //TODO: HACER QUE LA WEA DE ARRIBA SE ESCRIBA EN UN TXT PARA LUEGO SER INSERTADA EN LA DB CUANDO ENCUENTRE UNA CONEXION DISPONIBLE
            BufferedWriter salida = new BufferedWriter(new FileWriter(f, true));
            salida.append(stm+System.lineSeparator());
            salida.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XoroxOffline.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XoroxOffline.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            //Apagar equipo
        }
    }


    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:
        deterner_Reloj();
        Alumno.Duracion = lblCronometro.getText();
        //Se registra la sesion
        Registrar_Sesion(Alumno.cicloEscolar, Alumno.No_Matricula, Alumno.macadress, Alumno.Maestro, Alumno.Materia, Alumno.Aula, Alumno.Fecha, Alumno.Duracion, Alumno.Comentarios);
        //Se apaga el Equipo
        //Apagar_Windows();
        //btnCerrarSesion.setEnabled(false);
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(XoroxOffline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XoroxOffline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XoroxOffline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XoroxOffline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XoroxOffline().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblAlumno;
    private javax.swing.JLabel lblAula;
    private javax.swing.JLabel lblCarrera;
    public static javax.swing.JLabel lblCronometro;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMAC_ADDRESS;
    private javax.swing.JLabel lblNo_Matricula;
    private javax.swing.JLabel lblUbicacion;
    // End of variables declaration//GEN-END:variables
}
