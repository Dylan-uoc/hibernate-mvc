/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.producto4.controller;


import com.producto4.model.HibernateUtil;
import com.producto4.model.Proyecto;
import com.producto4.model.Sede;
import com.producto4.model.Usuario;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author rojaw
 */
public class ViewLoginController implements Initializable  {

    @FXML
    private Button button_Login;

    public ViewLoginController(){  }

    @FXML
    private TextField username_login;
    
    @FXML
    private PasswordField password_login;
    
    
    @FXML
    private Label wrong_login;    
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
        
        String nombre = username_login.getText().toString();
        String pass = password_login.getText().toString();
        
       
        //listadoUsuarios();
        guardarsede();
        
    }
    
    public static List<Usuario> listadoUsuarios() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Usuario> result = (List<Usuario>)session.createQuery("from Usuario").list();
        session.getTransaction().commit();
        for (Usuario usuario : result) {
            System.out.println("Usuario: " + usuario.toString());
        }
        return result;
    }
    
    public static void guardarsede () {
            
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Proyecto proyecto = new Proyecto(1,"Madrid", new Date(2017,10,22), new Date(2019,10,22)); 
        session.save(proyecto);

        session.save(new Sede(1, "Madrid", "Central" ));
        session.save(new Sede(2,"Valencia", "Delegacion" ));

        session.getTransaction().commit();

        Query q = session.createQuery("From Sede ");

        List<Sede> resultList = q.list();
        System.out.println("num of sede:" + resultList.size());
        for (Sede next : resultList) {
            System.out.println("next sede: " + next);
        }
    }
    
}
