/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import mx.unam.ciencias.is.modelo.Empleado;
import mx.unam.ciencias.is.modelo.EmpleadoDAO;

/**
 *
 * @author jonathan
 */
@ManagedBean
@RequestScoped
public class LoginController {
    
    
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    public String login() {
        EmpleadoDAO em = new EmpleadoDAO();
        Empleado user = em.encuentra(username);
        FacesContext context = FacesContext.getCurrentInstance();

        if (user == null) {
            context.addMessage(null, new FacesMessage("Unknown login, try again"));
            username = null;
            password = null;
            return null;
        } else if(user.getContrasenia().equals(this.password)){
            context.getExternalContext().getSessionMap().put("user", user);
            return "index?faces-redirect=true";
        } else {
            context.addMessage(null, new FacesMessage("Unknown login, try again"));
            username = null;
            password = null;
            return null; 
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
}
