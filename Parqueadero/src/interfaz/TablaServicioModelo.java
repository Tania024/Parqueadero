/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import controlador.ServicioControlador;
import controlador.VehiculoControlador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelo.Servicio;
import modelo.Vehiculo;

/**
 *
 * @author LENOVO
 */

public class TablaServicioModelo extends AbstractTableModel {
    private final SimpleDateFormat simpleDateFormat;
    private final ServicioControlador servicioControlador;
    private final VehiculoControlador vehiculoControlador;
    private final Class tipoColumnas[] = new Class[]{Integer.class, String.class, String.class, String.class, Double.class};
    private final String nombreColumnas[] = {"Id", "Vehiculo", "Hora Entrada", "Hora Salida", "Valor"};

    public TablaServicioModelo(ServicioControlador servicioControlador, VehiculoControlador vehiculoControlador) {
        this.servicioControlador = servicioControlador;
        this.vehiculoControlador = vehiculoControlador;   
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return tipoColumnas[columnIndex];
    }
    @Override
    public String getColumnName(int columnIndex)
    {
        return nombreColumnas[columnIndex];
    }
    @Override
    public int getRowCount() {
        return servicioControlador.getDatos().size();
    }
    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }
    @Override
    public Object getValueAt(int row, int column) {
        Servicio servicio = servicioControlador.getDatos().get(row);
        switch (column) {
            case 0:
                return servicio.getId();
            case 1:
                if(servicio.getVehiculo() != null)
                    return servicio.getVehiculo().getPlaca();
                return "";
            case 2:
                return simpleDateFormat.format(servicio.getHoraEntrada());
            case 3:
                if(servicio.getHoraSalida() != null)
                    return simpleDateFormat.format(servicio.getHoraSalida());
            case 4:
                return servicio.getValorPagar();
        }
        return null;
    }
    @Override
    public void setValueAt(Object value, int row, int column) {
        Servicio servicio = servicioControlador.getDatos().get(row);
        try {
            switch (column) {
                case 1:
                    Vehiculo vehiculo = vehiculoControlador.buscar((String)value);
                    if(vehiculo != null)
                        servicio.setVehiculo(vehiculo);
                    break;
                case 2:
                    Date date = simpleDateFormat.parse((String) value);
                    servicio.setHoraEntrada(date);
                    break;
                case 3:
                    Date dateSalida = simpleDateFormat.parse((String) value);
                    servicio.setHoraSalida(dateSalida);
                    servicioControlador.actualizar(servicio.getHoraEntrada(), servicio.getHoraSalida());
                    break;
                case 4:
//                    servicio.setValorPagar((Double) value);
                    break;
            }
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if(column != 0)
            return true;
        return false;
    }
    

}
