/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.producto4.controller;

import com.producto4.factory.UsuarioDaoFactory;
import com.producto4.impl.UsuarioDaoImpl;
import com.producto4.model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rojaw
 */
public class ViewAdminController implements Initializable {

    @FXML
    private TextField name_ui;
    @FXML
    private Button eliminar_usuario_ui;
    @FXML
    private Button modificar_usuario_ui;
    @FXML
    private TextField apellido_ui;
    @FXML
    private TextField correo_ui;
    @FXML
    private DatePicker fechaNacimiento_ui;
    @FXML
    private TextField usuario_ui;
    @FXML
    private TextField puesto_ui;
    @FXML
    private TextField sede_ui;
    @FXML
    private TextField proyecto_ui;
    @FXML
    private TextField tipoEmpleado_ui;
    @FXML
    private TextField salario_ui;
    @FXML
    private TextField territorio_ui;
    @FXML
    private TextField pass_ui;
    @FXML
    private CheckBox admin_ui;
    @FXML
    private TextField DNI_ui;
    @FXML
    private Button agregar_usuario_ui;
    @FXML
    private TableView<?> UserTable;
    @FXML
    private TextField sede_ubicacion_ui;
    @FXML
    private Button eliminar_sede_ui;
    @FXML
    private Button modificar_sede_ui;
    @FXML
    private TextField sede_tipo_ui;
    @FXML
    private Button agregar_sede_ui;
    @FXML
    private TableView<?> SedeTable;
    @FXML
    private TextField proyecto_ubicacion_ui;
    @FXML
    private Button eliminar_proyecto_ui;
    @FXML
    private Button modificar_proyecto_ui;
    @FXML
    private Button agregar_proyecto_ui;
    @FXML
    private DatePicker proyecto_inicio_ui;
    @FXML
    private DatePicker proyecto_final_ui;
    @FXML
    private TableView<?> ProyectTable;
    @FXML
    private Label warning_ui;
    @FXML 
    private Label alert_ui;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void eliminar_usuario_button(ActionEvent event) {
        
       
        
        
    }

    @FXML
    private void modificar_usuario_button(ActionEvent event) {
    }

    @FXML
    private void agregar_usuario_button(ActionEvent event) throws Exception {
             
        if (validateInputs()) {
            Usuario usuario_agregado = createUserFromInput();
            UsuarioDaoFactory factory = new UsuarioDaoFactory();
	    UsuarioDaoImpl userdao = factory.crearUsuarioDao();
            boolean isSaved =  userdao.registrar(usuario_agregado);
            if (isSaved) {
                alert_ui.setText("Usuario añadido");
            }
        }
    }


    private Usuario createUserFromInput() {
        Usuario user = new Usuario();
        int admin_check= 0;
        if(admin_ui.isSelected()){
            admin_check= 1;
        } else {
        }
        user.setAdministrador((short) admin_check);
        user.setApellido(apellido_ui.getText());
        user.setCorreo(correo_ui.getText());
        user.setDni(DNI_ui.getText());
        LocalDate localDate = fechaNacimiento_ui.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        user.setFechaNacimiento(date);
        user.setNombre(name_ui.getText());
        user.setPassword(pass_ui.getText());
        user.setProyecto(proyecto_ui.getText());
        user.setSede(sede_ui.getText());
        user.setPuesto(puesto_ui.getText());
        float importe = Float.parseFloat(salario_ui.getText());
        user.setSalario(importe);
        user.setTerritorio(territorio_ui.getText());
        user.setTipoEmpleado(tipoEmpleado_ui.getText());
        user.setUsuario(usuario_ui.getText());
        
        return user;
    }

    private boolean validateInputs() {
        if (usuario_ui.getText().equals("")) {
            warning_ui.setText("Debes escribir un usuario");
            return false;
        }

        if (fechaNacimiento_ui.getValue() == null) {
            warning_ui.setText("*Debes de añadir una fecha de nacimiento");
            return false;
        }

        if (pass_ui.getText().equals("")) {
            warning_ui.setText("*Debes asignarle una password!");
            return false;
        }
        return true;
    }
        
    }

    @FXML
    private void eliminar_sede_button(ActionEvent event) {
    }

    @FXML
    private void modificar_sede_button(ActionEvent event) {
    }

    @FXML
    private void agregar_sede_button(ActionEvent event) {
    }

    @FXML
    private void eliminar_proyecto_button(ActionEvent event) {
    }

    @FXML
    private void modificar_proyecto_button(ActionEvent event) {
    }

    @FXML
    private void agregar_proyecto_button(ActionEvent event) {
    }
    
    

}
