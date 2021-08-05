/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import archivo.ArchivoObjeto;
import controlador.ClienteControlador;
import controlador.EmpresaControlador;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Empresa;

/**
 *
 * @author LENOVO
 */
public class ClienteVista extends javax.swing.JInternalFrame {
    
    public ClienteControlador clienteControlador;
    public EmpresaControlador empresaControlador;
    public ArchivoObjeto archivoObjeto;
    public DefaultTableModel tblModelCliente;
    public DefaultComboBoxModel cmbModelEmpresa;

    public ClienteVista(ClienteControlador clienteControlador, EmpresaControlador empresaControlador, ArchivoObjeto archivoObjeto) {
        initComponents();
        this.clienteControlador = clienteControlador;
        this.empresaControlador = empresaControlador;
        this.archivoObjeto = archivoObjeto;
        clienteControlador.setDatos(archivoObjeto.leer());
        tblModelCliente = (DefaultTableModel) tblClientes.getModel();
        cmbModelEmpresa = (DefaultComboBoxModel) cmbEmpresa.getModel();
        tblClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if(tblClientes.getSelectedRow() >= 0){
                    clienteControlador.setSeleccionado(clienteControlador.getDatos().get(tblClientes.getSelectedRow()));
                    cargarValores();
                }else {
                    limpiarDatos();
                }
            }
        });
        cargarDatosCombo();
        cargarDatosTabla();
    }
    public void limpiarDatos(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        cmbEmpresa.setSelectedIndex(-1);
        clienteControlador.setSeleccionado(null);
    }
    public void cargarValores(){
        txtNombre.setText(clienteControlador.getSeleccionado().getNombre());
        txtApellido.setText(clienteControlador.getSeleccionado().getApellido());
        txtCedula.setText(clienteControlador.getSeleccionado().getCedula());
        cmbEmpresa.setSelectedItem(clienteControlador.getSeleccionado().getEmpresa().getNombre());
    }
    public void cargarDatosTabla(){
        tblModelCliente.setRowCount(0);
        for (Cliente dato : clienteControlador.getDatos()) {
            String datos[] = {String.valueOf(dato.getId()), dato.getNombre(), dato.getApellido(), 
                dato.getCedula(), dato.getEmpresa().getNombre()};
            tblModelCliente.addRow(datos);
        }
    }
    public void cargarDatosCombo(){
        for (Empresa empresa : empresaControlador.getListaEmpresa()) 
            cmbModelEmpresa.addElement(empresa.getNombre());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        cmbEmpresa = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes");
        setAutoscrolls(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                guardarArchivoCerar(evt);
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

        lblNombre.setText("Nombre:");

        lblApellido.setText("Apellido:");

        lblCedula.setText("Cedula:");

        lblEmpresa.setText("Empresa:");

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

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Cedula", "Empresa"
            }
        ));
        jScrollPane1.setViewportView(tblClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCedula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCedula))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblApellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEmpresa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar)
                            .addComponent(btnEliminar))))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblApellido)
                    .addComponent(btnGuardar)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(lblEmpresa)
                    .addComponent(btnEliminar)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Empresa empresa = empresaControlador.getListaEmpresa().get(cmbEmpresa.getSelectedIndex());
        boolean resultado;
        if(clienteControlador.getSeleccionado() != null){
            resultado = clienteControlador.actualizar(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), empresa);
        }else{
            resultado = clienteControlador.crear(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), empresa);
        }
        System.out.println(resultado);
        cargarDatosTabla();
        limpiarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(clienteControlador.getSeleccionado() != null){
            boolean resultado = clienteControlador.eliminar(clienteControlador.getSeleccionado().getCedula());
            System.out.println(resultado);
            cargarDatosTabla();
            limpiarDatos();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void guardarArchivoCerar(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_guardarArchivoCerar
        this.archivoObjeto.escribir(this.clienteControlador.getDatos());
    }//GEN-LAST:event_guardarArchivoCerar

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbEmpresa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
