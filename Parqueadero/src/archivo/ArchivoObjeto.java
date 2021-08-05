/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import com.sun.security.ntlm.Client;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;

/**
 *
 * @author LENOVO
 */
public class ArchivoObjeto {
    private String ruta;
    
    public ArchivoObjeto(String ruta) {
        this.ruta = ruta;
    }
    
    public void escribir(List<Cliente> clientes){
        try {
            FileOutputStream archivo = new FileOutputStream(ruta);
            ObjectOutputStream escritura = new ObjectOutputStream(archivo);
            for (Cliente cliente : clientes) {
                escritura.writeObject(cliente);
            }
            escritura.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Cliente> leer(){
        List<Cliente> clientes = new ArrayList<>();
        try {
            FileInputStream archivo = new FileInputStream(this.ruta);
            ObjectInputStream lectura = new ObjectInputStream(archivo);
            Cliente cliente;
            while ((cliente = (Cliente) lectura.readObject()) != null){
                clientes.add(cliente);
            }
            lectura.close();
            archivo.close();
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
        }
        return clientes;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    
}
