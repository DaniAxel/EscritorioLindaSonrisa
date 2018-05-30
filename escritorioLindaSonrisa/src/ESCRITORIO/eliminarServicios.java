/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESCRITORIO;

import DAO_IMP.ServicioDaoImp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Axel
 */
public class eliminarServicios extends javax.swing.JFrame {

    /**
     * Creates new form eliminarServicios
     */
    public eliminarServicios() {
        initComponents();
        this.setLocationRelativeTo(null);
        cmVar.removeAllItems();
        ServicioDaoImp dao = new ServicioDaoImp();
        ArrayList<String> lista = new ArrayList<String>();
        lista = dao.listarNombres();
        for (int i = 0; i < lista.size(); i++) {
            cmVar.addItem(lista.get(i));
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

        cmVar = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmVarActionPerformed(evt);
            }
        });
        getContentPane().add(cmVar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 180, -1));

        jLabel2.setText("Seleccione un servicio ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        jLabel3.setText("Eliminar Servicios");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, -1, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mfOAU8I.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmVarActionPerformed
    cmVar.transferFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_cmVarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        ServicioDaoImp dao = new ServicioDaoImp();
        String io = (String) cmVar.getSelectedItem();

        if (dao.eliminar(io)) {
            JOptionPane.showMessageDialog(null, "Exito al Eliminar");
        } else {
            JOptionPane.showMessageDialog(null, "Error al Eliminar");
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(eliminarServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(eliminarServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(eliminarServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(eliminarServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new eliminarServicios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmVar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
