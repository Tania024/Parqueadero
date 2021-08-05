/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import controlador.VehiculoControlador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Servicio;

/**
 *
 * @author diego
 */
public class ArchivosBinariosAleatorio {
    private String ruta;
    public ArchivosBinariosAleatorio(String ruta){
        this.ruta = ruta;
    }
    public void escribir(List<Servicio> servicios){
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            for (Servicio servicio : servicios) {
                archivo.writeLong(servicio.getId());
                archivo.writeLong(servicio.getHoraEntrada().getTime());
                archivo.writeLong(servicio.getHoraSalida().getTime());
                archivo.writeDouble(servicio.getValorPagar());
                archivo.writeUTF(servicio.getVehiculo().getPlaca());
            }
            archivo.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
        }
    }
    public List<Servicio> leer(VehiculoControlador vehiculoControlador){
        List<Servicio> servicios = new ArrayList<>();
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            while (true) {                
                Servicio servicio = new Servicio(archivo.readLong(), new Date(archivo.readLong()), new Date(archivo.readLong()), archivo.readDouble());
                servicio.setVehiculo(vehiculoControlador.buscar(archivo.readUTF()));
                servicios.add(servicio);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
        }
        return servicios;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
}
