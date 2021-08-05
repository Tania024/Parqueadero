/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import archivo.ArchivoObjeto;
import archivo.ArchivoTexto;
import archivo.ArchivosBinarios;
import archivo.ArchivosBinariosAleatorio;
import controlador.ClienteControlador;
import controlador.EmpresaControlador;
import controlador.ServicioControlador;
import controlador.VehiculoControlador;

/**
 *
 * @author LENOVO
 */
public class Principal extends javax.swing.JFrame {
    
    private EmpresaControlador empresaControlador;
    private ClienteControlador clienteControlador;
    private VehiculoControlador vehiculoControlador;
    private ServicioControlador servicioControlador;
    private ArchivoObjeto archivoObjeto;
    private ArchivosBinarios archivosBinarios;
    private ArchivosBinariosAleatorio archivosBinariosAleatorio;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        empresaControlador = new EmpresaControlador();
        clienteControlador = new ClienteControlador();
        vehiculoControlador = new VehiculoControlador();
        servicioControlador = new ServicioControlador();
        archivoObjeto = new ArchivoObjeto("/home/diego/UPS/56/ProgramacionAplicada/Parqueadero/src/archivo/ClienteArchivo.obj");// Ruta Absolojuta
        archivosBinarios = new ArchivosBinarios();
        archivosBinariosAleatorio = new ArchivosBinariosAleatorio("ServicioArchivo.dat");//Ruta relativa
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dtpPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuEmpresa = new javax.swing.JMenu();
        mnuEmpListar = new javax.swing.JMenuItem();
        mnuCliente = new javax.swing.JMenu();
        mniGestion = new javax.swing.JMenuItem();
        mnuVehiculo = new javax.swing.JMenu();
        mnuGestion = new javax.swing.JMenuItem();
        mnuServicio = new javax.swing.JMenu();
        mniParqueadero = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parqueadero UPS");

        javax.swing.GroupLayout dtpPrincipalLayout = new javax.swing.GroupLayout(dtpPrincipal);
        dtpPrincipal.setLayout(dtpPrincipalLayout);
        dtpPrincipalLayout.setHorizontalGroup(
            dtpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 917, Short.MAX_VALUE)
        );
        dtpPrincipalLayout.setVerticalGroup(
            dtpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );

        mnuEmpresa.setText("Empresa");

        mnuEmpListar.setText("Operaciones");
        mnuEmpListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEmpListarActionPerformed(evt);
            }
        });
        mnuEmpresa.add(mnuEmpListar);

        jMenuBar1.add(mnuEmpresa);

        mnuCliente.setText("Clientes");

        mniGestion.setText("Gestión");
        mniGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGestionActionPerformed(evt);
            }
        });
        mnuCliente.add(mniGestion);

        jMenuBar1.add(mnuCliente);

        mnuVehiculo.setText("Vehiculo");

        mnuGestion.setText("Gestion");
        mnuGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGestionActionPerformed(evt);
            }
        });
        mnuVehiculo.add(mnuGestion);

        jMenuBar1.add(mnuVehiculo);

        mnuServicio.setText("Servicio");

        mniParqueadero.setText("Parqueadero");
        mniParqueadero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniParqueaderoActionPerformed(evt);
            }
        });
        mnuServicio.add(mniParqueadero);

        jMenuBar1.add(mnuServicio);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dtpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dtpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuEmpListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEmpListarActionPerformed
        EmpresaVista empresa = new EmpresaVista(empresaControlador);
        dtpPrincipal.add(empresa);
        empresa.show();
    }//GEN-LAST:event_mnuEmpListarActionPerformed

    private void mniGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGestionActionPerformed
        ClienteVista clienteVista = new ClienteVista(clienteControlador, empresaControlador, archivoObjeto);
        dtpPrincipal.add(clienteVista);
        clienteVista.show();
    }//GEN-LAST:event_mniGestionActionPerformed

    private void mnuGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGestionActionPerformed
        VehiculoVista vehiculoVista = new VehiculoVista(vehiculoControlador, clienteControlador, archivosBinarios);
        dtpPrincipal.add(vehiculoVista);
        vehiculoVista.show();
    }//GEN-LAST:event_mnuGestionActionPerformed

    private void mniParqueaderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniParqueaderoActionPerformed
        ServicioVista servicioVista = new ServicioVista(vehiculoControlador, servicioControlador, archivosBinariosAleatorio);
        dtpPrincipal.add(servicioVista);
        servicioVista.show();
    }//GEN-LAST:event_mniParqueaderoActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dtpPrincipal;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mniGestion;
    private javax.swing.JMenuItem mniParqueadero;
    private javax.swing.JMenu mnuCliente;
    private javax.swing.JMenuItem mnuEmpListar;
    private javax.swing.JMenu mnuEmpresa;
    private javax.swing.JMenuItem mnuGestion;
    private javax.swing.JMenu mnuServicio;
    private javax.swing.JMenu mnuVehiculo;
    // End of variables declaration//GEN-END:variables
}
