/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import archivo.ArchivosBinariosAleatorio;
import controlador.ServicioControlador;
import controlador.VehiculoControlador;
import java.util.Date;
import modelo.Servicio;
import modelo.Vehiculo;

/**
 *
 * @author LENOVO
 */
public class ServicioVista extends javax.swing.JInternalFrame {

    public VehiculoControlador vehiculoControlador;
    public ServicioControlador servicioControlador;
    public TablaServicioModelo tablaServicioModelo;
    public ArchivosBinariosAleatorio archivosBinariosAleatorio;
    public ServicioVista(VehiculoControlador vehiculoControlador, ServicioControlador servicioControlador, ArchivosBinariosAleatorio archivosBinariosAleatorio) {
        initComponents();
        this.vehiculoControlador = vehiculoControlador;
        this.servicioControlador = servicioControlador;
        this.archivosBinariosAleatorio = archivosBinariosAleatorio;
        servicioControlador.setDatos(archivosBinariosAleatorio.leer(vehiculoControlador));
        tablaServicioModelo = new TablaServicioModelo(servicioControlador, vehiculoControlador);
        tblServicio.setModel(tablaServicioModelo);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicio = new javax.swing.JTable();
        btNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("SERVICIO");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                guardarDatos(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        tblServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Vehiculo", "Hora Entrada", "Hora Salida", "Valor pagar"
            }
        ));
        tblServicio.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(tblServicio);

        btNuevo.setText("Nuevo");
        btNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoActionPerformed
        boolean resutlado = servicioControlador.crear(new Date(), new Date() ,0.0, null);
        System.out.println(resutlado);
        tablaServicioModelo.fireTableDataChanged(); // Actualizo la tabla
    }//GEN-LAST:event_btNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Servicio servicio = servicioControlador.getDatos().get(tblServicio.getSelectedRow());
        servicioControlador.eliminar(servicio.getHoraEntrada());
        tablaServicioModelo.fireTableDataChanged();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void guardarDatos(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_guardarDatos
        this.archivosBinariosAleatorio.escribir(servicioControlador.getDatos());
    }//GEN-LAST:event_guardarDatos


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btNuevo;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblServicio;
    // End of variables declaration//GEN-END:variables
}
