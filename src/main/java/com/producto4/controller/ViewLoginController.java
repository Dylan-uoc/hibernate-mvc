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
import org.hibernate.criterion.Restrictions;

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
        checklogin();
    }  
     

    private void checklogin(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q= session.createQuery("from Usuario");
        Usuario usuario_login = (Usuario) q.list().get(0);
        System.out.println(usuario_login.getPassword());
        usuario_login.getUsuario();
        session.getTransaction().commit();        
        
    if (username_login.getText().toString().equals(usuario_login.getUsuario()) && password_login.getText().toString().equals(usuario_login.getPassword())) {
    System.out.println("Correcto");
    } else {
    System.out.println("InCorrecto");
            }
    }
}
            
    
  
        
        
        
        
        
        
        
        
        
        
        
        
        
       
        
       
    