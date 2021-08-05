/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Empresa;

/**
 *
 * @author LENOVO
 */
public class ArchivoTexto {

    private String ruta;

    public ArchivoTexto(String ruta) {
        this.ruta = ruta;
    }

    public void escribir(List<Empresa> empresas) {
        try {
            FileWriter archivo = new FileWriter(this.ruta);
            BufferedWriter escritura = new BufferedWriter(archivo);
            for (Empresa empresa : empresas) {
                escritura.append(empresa.getId() + "\n");
                escritura.append(empresa.getNombre() + "\n");
            }
            escritura.close();
            archivo.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<Empresa> leer() {
        List<Empresa> empresas = new ArrayList<>();
        try {
            FileReader archivo = new FileReader(this.ruta);
            BufferedReader lectura = new BufferedReader(archivo);
            String lineaId = "";
            String lineaNombre = "";
            while(lineaId != null && lineaNombre != null){
                lineaId = lectura.readLine();
                lineaNombre = lectura.readLine();
                if (lineaId != null && lineaNombre != null){
                    Empresa e = new Empresa(Integer.parseInt(lineaId), lineaNombre);
                    empresas.add(e);
                }
            }
            lectura.close();
            archivo.close();
            return empresas;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return empresas;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

}
