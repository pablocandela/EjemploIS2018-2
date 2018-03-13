/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;

import java.security.Principal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mx.unam.ciencias.is.modelo.Empleado;
import mx.unam.ciencias.is.modelo.Proyecto;
import mx.unam.ciencias.is.modelo.ProyectoDAO;
import mx.unam.ciencias.is.modelo.Trabajar;
import mx.unam.ciencias.is.modelo.TrabajarDAO;

/**
 *
 * @author jonathan
 */
//Etiqueta para decirle a jsf que esta clase es un controlador
@ManagedBean
//Etiqueta para que viva este bean hasta que se cambie de pagina. util para jax
@ViewScoped
public class GuardaProyecto {
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * peticion que guarda un proyecto 
     */
    public String guardaProyecto(){
        Proyecto p = new Proyecto();
        p.setNombre(nombre);
        ProyectoDAO pd = new ProyectoDAO();
        pd.guarda(p);
        
        Trabajar t = new Trabajar();
        t.setProyecto(p);
        Empleado e=(Empleado)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
       
        t.setEmpleado(e);
        TrabajarDAO tbd = new TrabajarDAO();
        tbd.guarda(t);
        
        return "inicio";
    }
     
}
