package com.producto4.impl;

import com.producto4.dao.Dao;
import com.producto4.model.HibernateUtil;
import com.producto4.model.Sede;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class SedeDaoImpl implements Dao <Sede> {

    @Override
    public boolean registrar(Sede obj) throws Exception {
        boolean insertado=false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String ubicacion_sede= obj.getUbicacion();

        Sede newSede = (Sede) session.save(obj); //<|--- Aqui guardamos el objeto en la base de datos.

        session.getTransaction().commit();
        // En el caso de que no funcione se deberá utilizar dos parámetros como la fecha de inicio y la ubicación para obtener el proyecto
        // que acabamos de crear
        Query q= session.createQuery("from Sede s where s.id=:id_sede");
        q.setParameter("id_sede", newSede.getId());
        session.close();
        if (q.list().size()>0){
            insertado=true;

        } else {

        }
        return insertado;
    }

    @Override
    public void leer() {

        Integer idSede = 0;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q= session.createQuery("from Sede");
        session.close();
        List<Sede> resultList = q.list();

        System.out.println("número de sedes:" + resultList.size());
        for (Sede next : resultList) {
            System.out.println("siguiente sede: " + next);
        }

    }

    @Override
    public boolean actualizar(Sede obj) {
        boolean insertado=false;
        Integer idSede= obj.getId();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(obj);
        Query q= session.createQuery("from Sede s where s.id=:idSede");
        q.setParameter("idSede",idSede);
        session.getTransaction().commit();


        return false;

    }

    @Override
    public boolean eliminar(Sede obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
