/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import controlador.ClienteControlador;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.Vehiculo;

/**
 *
 * @author LENOVO
 */
public class ArchivosBinarios {
    private File ruta;
    public ArchivosBinarios(){
    }
    public void escribir(List<Vehiculo> vehiculos){
        try {
            FileOutputStream archivo = new FileOutputStream(ruta);
            DataOutputStream escritura = new DataOutputStream(archivo);
            for (Vehiculo vehiculo : vehiculos) {
                escritura.writeLong(vehiculo.getId());
                escritura.writeUTF(vehiculo.getPlaca());
                escritura.writeUTF(vehiculo.getMarca());
                escritura.writeUTF(vehiculo.getModelo());
                escritura.writeUTF(vehiculo.getPropietario().getCedula());
            }
            escritura.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public List<Vehiculo> leer(ClienteControlador clienteControlador){
        List<Vehiculo> vehiculos = new ArrayList<>();
        try {
            FileInputStream archivo = new FileInputStream(ruta);
            DataInputStream lectura = new DataInputStream(archivo);
            while(true){
                Vehiculo vehiculo = new Vehiculo(lectura.readLong(), lectura.readUTF(), lectura.readUTF(), lectura.readUTF());
                Cliente cliente = clienteControlador.buscar(lectura.readUTF());
                vehiculo.setPropietario(cliente);
                vehiculos.add(vehiculo);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
        }
        return vehiculos;
    }

    public File getRuta() {
        return ruta;
    }

    public void setRuta(File ruta) {
        this.ruta = ruta;
    }
    
    
}
