package com.producto4.impl;

import com.producto4.dao.Dao;
import com.producto4.model.HibernateUtil;
import com.producto4.model.Proyecto;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 *
 * @author rojaw
 */
public class ProyectoDaoImpl implements Dao <Proyecto> {

    @Override
    public boolean registrar(Proyecto obj) throws Exception {
        boolean insertado=false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String ubicacion_proyecto= obj.getUbicacion();

        Proyecto newProject = (Proyecto) session.save(obj); //<|--- Aqui guardamos el objeto en la base de datos.

        session.getTransaction().commit();
        // En el caso de que no funcione se deberá utilizar dos parámetros como la fecha de inicio y la ubicación para obtener el proyecto
        // que acabamos de crear
        Query q= session.createQuery("from Proyecto p where p.id=:id_proyecto");
        q.setParameter("id_proyecto", newProject.getId());
        session.close();
        if (q.list().size()>0){
            insertado=true;

        } else {

        }
        return insertado;
    }

    @Override
    public void leer() {

        Integer idProyecto = 0;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q= session.createQuery("from Proyecto");
        session.close();
        List<Proyecto> resultList = q.list();

        System.out.println("número de proyectos:" + resultList.size());
        for (Proyecto next : resultList) {
            System.out.println("siguiente proyecto: " + next);
        }

    }

    @Override
    public boolean actualizar(Proyecto obj) {
        boolean insertado=false;
        Integer idProyecto= obj.getId();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(obj);
        Query q= session.createQuery("from Proyecto p where p.id=:idProyecto");
        q.setParameter("idProyecto",idProyecto);
        session.getTransaction().commit();


        return false;

    }

    @Override
    public boolean eliminar(Proyecto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
