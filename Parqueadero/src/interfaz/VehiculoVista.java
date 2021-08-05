/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import archivo.ArchivosBinarios;
import controlador.ClienteControlador;
import controlador.VehiculoControlador;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Vehiculo;

/**
 *
 * @author LENOVO
 */
public class VehiculoVista extends javax.swing.JInternalFrame {

    public VehiculoControlador vehiculoControlador;
    public ClienteControlador clienteControlador;
    public DefaultTableModel tblModelVehiculo;
    public DefaultListModel lstModelCliente;
    public ArchivosBinarios archivosBinarios;
    public VehiculoVista(VehiculoControlador vehiculoControlador,  ClienteControlador clienteControlador, ArchivosBinarios archivosBinarios) {
        initComponents();
        this.vehiculoControlador = vehiculoControlador;
        this.clienteControlador = clienteControlador;
        this.tblModelVehiculo = (DefaultTableModel) tblVehiculo.getModel();
        this.lstModelCliente = new DefaultListModel();
        lstPropietario.setModel(lstModelCliente);
        this.archivosBinarios = archivosBinarios;
        tblVehiculo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if(tblVehiculo.getSelectedRow() >= 0){
                    vehiculoControlador.setSeleccionado(vehiculoControlador.getListaVehiculo().get(tblVehiculo.getSelectedRow()));
                    cargarValores();
                }else{
                    limpiarDatos();
                }
            }
        });
        cargarDatos();
        filtrarClientes();
    }
    public void cargarValores(){
        txtMarca.setText(vehiculoControlador.getSeleccionado().getMarca());
        txtModelo.setText(vehiculoControlador.getSeleccionado().getModelo());
        txtPlaca.setText(vehiculoControlador.getSeleccionado().getPlaca());
        txtPropietario.setText(vehiculoControlador.getSeleccionado().getPropietario().getCedula());
    }
    public void cargarDatos(){
        tblModelVehiculo.setRowCount(0);
        for (Vehiculo vehiculo : vehiculoControlador.getListaVehiculo()) {
            String datos[] = {String.valueOf(vehiculo.getId()), vehiculo.getPlaca(), vehiculo.getModelo(), 
                vehiculo.getMarca(), vehiculo.getPropietario().getCedula()};
            tblModelVehiculo.addRow(datos);
        }
    }
    public void filtrarClientes(){
        lstModelCliente.removeAllElements();
        for (Cliente cliente : clienteControlador.getDatos()) {
            if(cliente.getCedula().contains(txtPropietario.getText()))
                lstModelCliente.addElement(cliente.getCedula());
        }
    }
    public void limpiarDatos(){
        txtMarca.setText("");
        txtModelo.setText("");
        txtPlaca.setText("");
        txtPropietario.setText("");
        filtrarClientes();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPlaca = new javax.swing.JLabel();
        lblMadelo = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblPropietario = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtPropietario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPropietario = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVehiculo = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCargarDatos = new javax.swing.JButton();
        btnGuardarDatos = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("VEHICULOS");

        lblPlaca.setText("Placa:");

        lblMadelo.setText("Modelo:");

        lblMarca.setText("Marca:");

        lblPropietario.setText("Propietario:");

        txtPropietario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPropietarioKeyReleased(evt);
            }
        });

        lstPropietario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstPropietario);

        tblVehiculo.setAutoCreateRowSorter(true);
        tblVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Placa", "Modelo", "Marca", "Propietario"
            }
        ));
        tblVehiculo.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tblVehiculo);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCargarDatos.setText("Cargar Datos");
        btnCargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarDatosActionPerformed(evt);
            }
        });

        btnGuardarDatos.setText("Guardar Datos");
        btnGuardarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMadelo)
                            .addComponent(lblPlaca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(txtModelo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPropietario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPropietario))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMarca)
                                .addGap(44, 44, 44)
                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCargarDatos)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarDatos))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca)
                    .addComponent(lblMarca)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMadelo)
                            .addComponent(lblPropietario)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargarDatos)
                    .addComponent(btnGuardarDatos))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Cliente cliente;
        if (lstPropietario.getSelectedValue() != null)
            cliente = clienteControlador.buscar(lstPropietario.getSelectedValue());
        else
            cliente = clienteControlador.buscar(txtPropietario.getText());
        boolean resultado;
        if(vehiculoControlador.getSeleccionado() != null){
            resultado = vehiculoControlador.actualizar(txtPlaca.getText(), txtMarca.getText(), txtModelo.getText(), cliente);
        }else{
            resultado = vehiculoControlador.crear(txtPlaca.getText(),txtMarca.getText(), txtModelo.getText(), cliente);
        }
        System.out.println(resultado);
        cargarDatos();
        limpiarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        vehiculoControlador.eliminar(txtPlaca.getText());
        cargarDatos();
        limpiarDatos();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtPropietarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPropietarioKeyReleased
        filtrarClientes();
    }//GEN-LAST:event_txtPropietarioKeyReleased

    private void btnCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarDatosActionPerformed
        // TODO add your handling code here:
        JFileChooser directorio = new JFileChooser();
        int resultado = directorio.showOpenDialog(this);
        if(resultado == JFileChooser.APPROVE_OPTION){
            File seleccionado = directorio.getSelectedFile();
            archivosBinarios.setRuta(seleccionado);
            vehiculoControlador.setListaVehiculo(archivosBinarios.leer(clienteControlador));
            cargarDatos();
        }
    }//GEN-LAST:event_btnCargarDatosActionPerformed

    private void btnGuardarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDatosActionPerformed
        JFileChooser directorio = new JFileChooser();
        int resultado = directorio.showOpenDialog(this);
        if(resultado == JFileChooser.APPROVE_OPTION){
            File seleccionado = directorio.getSelectedFile();
            archivosBinarios.setRuta(seleccionado);
            archivosBinarios.escribir(vehiculoControlador.getListaVehiculo());
        }
    }//GEN-LAST:event_btnGuardarDatosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarDatos;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarDatos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMadelo;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblPropietario;
    private javax.swing.JList<String> lstPropietario;
    private javax.swing.JTable tblVehiculo;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPropietario;
    // End of variables declaration//GEN-END:variables
}
