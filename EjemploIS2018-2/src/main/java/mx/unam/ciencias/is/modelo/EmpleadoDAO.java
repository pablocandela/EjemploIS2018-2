/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.modelo;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author jonathan
 */
public class EmpleadoDAO {
    private SessionFactory sessionFactory;
    
    
    /**
     * Constructor de la clase.
     * inicializa la variable sessionFactory para que podamos abrir una session
    */
    public EmpleadoDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
     /**
     * Regresa una lista con todos los empleados que estan activos en la base de datos.
     * @return 
     */
    public List<Empleado> empleados() {
        List<Empleado> result = null;
        // arbrimos la sesion son sessionFactory 
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            //iniciamos la transaccion, la consulta a realizar
            tx = session.beginTransaction();
            //Escribimos la consulta en HQL
            String hql = "from Empleado";
            Query query = session.createQuery(hql);
            result = (List<Empleado>)query.list();
            tx.commit();
        }
        catch (Exception e) {
            //si hay un problema regresamos la base aun estado antes de la consulta
            if (tx!=null){
                tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
            //cerramos la session
            session.close();
        }
        return result;
    }

    /**
     * Regresa una lista con todos los empleados que estan activos en la base de datos.
     * @return 
     */
    public Empleado encuentra(String correo,String pass) {
        Empleado result = null;
        // arbrimos la sesion son sessionFactory 
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            //iniciamos la transaccion, la consulta a realizar
            tx = session.beginTransaction();
            //Escribimos la consulta en HQL
            String hql = " select e from Empleado e join fetch e.trabajars where correo like '%"+correo+"%' and contrasenia = :pass" ;
            Query query = session.createQuery(hql);
            query.setParameter("pass", pass);
            //query.setParameter("correo", correo);
            result = (Empleado)query.uniqueResult();
            tx.commit();
        }
        catch (Exception e) {
            //si hay un problema regresamos la base aun estado antes de la consulta
            if (tx!=null){
                tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
            //cerramos la session
            session.close();
        }
        return result;
    }
}
