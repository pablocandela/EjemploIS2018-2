/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mx.unam.ciencias.is.modelo.Empleado;
import mx.unam.ciencias.is.modelo.EmpleadoDAO;

/**
 *
 * @author jonathan
 */
@ManagedBean
@ViewScoped
public class VerEmpleados {
    private List<Empleado> empleados;

    public List<Empleado> getEmpleados() {
        return empleados;
    }
    
    
    @PostConstruct
    public void ver() {
        EmpleadoDAO lib = new EmpleadoDAO();
        empleados= lib.empleados();
}
}
