/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.producto4.model;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure((new File("E:\\Cursillos\\DAW\\3º cuatrimestre\\ICB0_P5 _ PROGRAMACIÓN ORIENTADA A OBJETOS CON ACCESO A BASE DE DATOS\\FASE 3\\PRODUCTO 4\\JavaProject2\\hibernate-mvc\\src\\main\\resources\\hibernate.cfg.xml"))).buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}