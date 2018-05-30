/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESCRITORIO;

import BBDD.Conexion;
import DAO_IMP.TrabajadorDaoImp;
import DTO.TrabajadorDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Axel
 */
public class DeshabilitarTrabajador extends javax.swing.JFrame {

    JTable tabla;
    ResultSet rs;

    /**
     * Creates new form DeshabilitarTrabajador
     */
    public DeshabilitarTrabajador() {

        initComponents();
        this.setLocationRelativeTo(null);
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
        txtRut = new javax.swing.JTextField();
        btnVerificar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnDeshabilitar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Rut");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel2.setText("Ingrese el rut del Trabajador a deshabilitar");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 326, -1));

        txtRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutActionPerformed(evt);
            }
        });
        jPanel1.add(txtRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 158, -1));

        btnVerificar.setText("Verificar");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 596, 22));

        btnDeshabilitar.setText("Deshabilitar");
        btnDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshabilitarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeshabilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mfOAU8I.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        verificar();


    }//GEN-LAST:event_btnVerificarActionPerformed

    private void txtRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutActionPerformed
        txtRut.transferFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshabilitarActionPerformed

        TrabajadorDto dto = new TrabajadorDto();
        TrabajadorDaoImp dao = new TrabajadorDaoImp();

        dto.setRut(txtRut.getText());

        if (dao.deshabilitar(dto)) {
            JOptionPane.showMessageDialog(null, "Exito al deshabilitar");
        } else {
            JOptionPane.showMessageDialog(null, "Error al deshabilitar");

        }
    }//GEN-LAST:event_btnDeshabilitarActionPerformed

    /**
     * @param args the command line arguments
     */
    public void verificar() {
      

        TrabajadorDto dto = new TrabajadorDto();
        TrabajadorDaoImp dao = new TrabajadorDaoImp();
        dto.setRut(txtRut.getText());

        if (dao.buscars(dto)) {
            JOptionPane.showMessageDialog(null, dto.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Error");

        }

    }

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
            java.util.logging.Logger.getLogger(DeshabilitarTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeshabilitarTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeshabilitarTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeshabilitarTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeshabilitarTrabajador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeshabilitar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}
