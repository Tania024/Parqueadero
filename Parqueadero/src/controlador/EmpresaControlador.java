/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Empresa;

/**
 *
 * @author LENOVO
 */
public class EmpresaControlador {
    private List<Empresa> listaEmpresa;
    private Empresa seleccionado; // Guardar el Objeto que selecciona de la empresa
    
    public EmpresaControlador(){
        listaEmpresa = new ArrayList();
        seleccionado = null;
    }
    public long generarId(){
        if(listaEmpresa.size() > 0)
            return listaEmpresa.get(listaEmpresa.size() -1).getId() + 1;
        return 1;
    }
    public boolean crear(String nombre){
        Empresa empresa = new Empresa(generarId(), nombre);
        return listaEmpresa.add(empresa);
    }
    public Empresa buscar(String nombre){
        for (Empresa empresa : listaEmpresa) {
            if(empresa.getNombre().equals(nombre)){
                return empresa;
            }
        }
        return null;
    }
    public boolean actualizar(String nombreAnterior, String nombreNuevo){
        Empresa empresa = this.buscar(nombreAnterior);
        if(empresa != null) {
            int posicion = listaEmpresa.indexOf(empresa);
            empresa.setNombre(nombreNuevo);
            listaEmpresa.set(posicion, empresa);
            return true;
        }
        return false;
    }
    public boolean actualizar(int posicion, String nombre){
        Empresa empresa = listaEmpresa.get(posicion);
        empresa.setNombre(nombre);
        listaEmpresa.set(posicion, empresa);
        return true;
    }
    public boolean eliminar(String nombre){
        Empresa empresa = this.buscar(nombre);
        if(empresa != null) {
            return listaEmpresa.remove(empresa);
        }
        return false;
    }

    public List<Empresa> getListaEmpresa() {
        return listaEmpresa;
    }

    public void setListaEmpresa(List<Empresa> listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
    }

    public Empresa getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Empresa seleccionado) {
        this.seleccionado = seleccionado;
    }
    

}
