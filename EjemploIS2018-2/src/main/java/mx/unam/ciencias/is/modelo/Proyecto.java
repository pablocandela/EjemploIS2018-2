package mx.unam.ciencias.is.modelo;
// Generated 06-mar-2018 0:19:22 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Proyecto generated by hbm2java
 */
public class Proyecto  implements java.io.Serializable {


     private int proyectoId;
     private String nombre;
     private Set trabajars = new HashSet(0);

    public Proyecto() {
    }

	
    public Proyecto(int proyectoId, String nombre) {
        this.proyectoId = proyectoId;
        this.nombre = nombre;
    }
    public Proyecto(int proyectoId, String nombre, Set trabajars) {
       this.proyectoId = proyectoId;
       this.nombre = nombre;
       this.trabajars = trabajars;
    }
   
    public int getProyectoId() {
        return this.proyectoId;
    }
    
    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getTrabajars() {
        return this.trabajars;
    }
    
    public void setTrabajars(Set trabajars) {
        this.trabajars = trabajars;
    }




}


