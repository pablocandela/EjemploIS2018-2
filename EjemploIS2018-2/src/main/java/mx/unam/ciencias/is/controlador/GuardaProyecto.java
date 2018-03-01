/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import mx.unam.ciencias.is.modelo.Proyecto;
import mx.unam.ciencias.is.modelo.ProyectoDAO;

/**
 *
 * @author jonathan
 */
//Etiqueta para decirle a jsf que esta clase es un controlador
@ManagedBean
public class GuardaProyecto {
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void guardaProyecto(){
        System.out.println(this.nombre);
        Proyecto p = new Proyecto();
        p.setNombre(nombre);
        ProyectoDAO pd = new ProyectoDAO();
        pd.guarda(p);
    }
     
}
