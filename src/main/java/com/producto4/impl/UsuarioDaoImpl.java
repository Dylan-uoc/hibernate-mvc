/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.producto4.impl;

import com.producto4.dao.Dao;
import com.producto4.model.HibernateUtil;
import com.producto4.model.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author rojaw
 */
public class UsuarioDaoImpl implements Dao <Usuario>{

    @Override
    public boolean registrar(Usuario obj) throws Exception {
        boolean insertado=false;
        Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
 
    String usuario_insertado= obj.getUsuario().toString();
    
    session.save(obj); //<|--- Aqui guardamos el objeto en la base de datos.
 
    session.getTransaction().commit();
    Query q= session.createQuery("from Usuario u where u.usuario=:usuario_insertado");
    q.setParameter("usuario_insertado", usuario_insertado);
    session.close();        
        if (q.list().size()>0){
            insertado=true;
            
        } else {
            
        }
        return insertado;
    }

    @Override
    public void leer() {
     
     String nombre_usuario = "";   
        
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Query q= session.createQuery("from Usuario u where u.usuario=:user_login");
    q.setParameter("userlogin",nombre_usuario);
    session.close(); 
    List<Usuario> resultList = q.list();
    
        System.out.println("número de usuarios:" + resultList.size());
        for (Usuario next : resultList) {
            System.out.println("siguiente usuario: " + next);
        }
        
    }

    @Override
    public boolean actualizar(Usuario obj) {
        boolean insertado=false;
        String usuario_insertado= obj.getUsuario().toString();

    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.update(obj);
    Query q= session.createQuery("from Usuario u where u.usuario=:user_login");
    q.setParameter("userlogin",usuario_insertado);
    session.getTransaction().commit();
        
        
        return false;
        
    }

    @Override
    public boolean eliminar(Usuario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
