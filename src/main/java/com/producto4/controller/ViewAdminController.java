/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.producto4.controller;

import com.producto4.factory.ProyectoDaoFactory;
import com.producto4.factory.SedeDaoFactory;
import com.producto4.factory.UsuarioDaoFactory;
import com.producto4.impl.ProyectoDaoImpl;
import com.producto4.impl.SedeDaoImpl;
import com.producto4.impl.UsuarioDaoImpl;
import com.producto4.model.Proyecto;
import com.producto4.model.Sede;
import com.producto4.model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rojaw
 */
public class ViewAdminController implements Initializable {
    ObservableList<Map<String, Object>> items;

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
    private TableView UserTable;
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
    private TableView SedeTable;
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
    private TableView ProyectTable;
    @FXML
    private Label warning_ui;
    @FXML 
    private Label alert_ui;
    @FXML
    private TextField seleccion_id;
    @FXML
    private TableColumn<Map, String> id_usuario_column;

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
    private void seleccionar_button (ActionEvent event) { 
    
    items = FXCollections.<Map<String, Object>>observableArrayList();

    Map<String, Object> item1 = new HashMap<>();
    item1.put("ID_USUARIO", "Randall");
    //item1.put("lastName" , "Kovic");

    items.add(item1);

    /*Map<String, Object> item2 = new HashMap<>();
    item2.put("firstName", "Irmelin");
    item2.put("lastName" , "Satoshi");

    items.add(item2);*/

    UserTable.getItems().addAll(items);
        
    }
       
        

    @FXML
    private void modificar_usuario_button(ActionEvent event) throws Exception {
    }

       

    @FXML
    private void agregar_usuario_button(ActionEvent event) throws Exception {
             
        if (validateInputs("usuario")) {
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

    private boolean validateInputs(String target) {
        if(target.equals("usuario")) {

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

        } else if(target.equals("sede")) {

            if (sede_ubicacion_ui.getText().equals("")) {
                warning_ui.setText("Debes escribir una ubicación para la sede");
                return false;
            }

            return true;

        } else if(target.equals("proyecto")){

            if (proyecto_ubicacion_ui.getText().equals("")) {
                warning_ui.setText("Debes escribir una ubicación para el proyecto");
                return false;
            }

            return true;

        } else {
            return false;
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
        if (validateInputs("sede")) {
            Sede sede_agregada = createSedeFromInput();
            SedeDaoFactory sede = new SedeDaoFactory();
            SedeDaoImpl sededao = sede.crearSedeDao();
            boolean isSaved = false;
            try {
                isSaved = sededao.registrar(sede_agregada);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (isSaved) {
                alert_ui.setText("Sede añadida");
            }
        }
    }

    private Sede createSedeFromInput() {
        Sede sede = new Sede();

        sede.setTipo(sede_tipo_ui.getText());
        sede.setUbicacion(sede_ubicacion_ui.getText());

        return sede;

    }

    @FXML
    private void eliminar_proyecto_button(ActionEvent event) {
    }

    @FXML
    private void modificar_proyecto_button(ActionEvent event) {
    }

    @FXML
    private void agregar_proyecto_button(ActionEvent event) {
        if (validateInputs("proyecto")) {
            Proyecto proyecto_agregado = createProyectoFromInput();
            ProyectoDaoFactory proyecto = new ProyectoDaoFactory();
            ProyectoDaoImpl proyectodao = proyecto.crearProyectoDao();
            boolean isSaved = false;
            try {
                isSaved = proyectodao.registrar(proyecto_agregado);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (isSaved) {
                alert_ui.setText("Proyecto añadido");
            }
        }
    }

    private Proyecto createProyectoFromInput() {
        Proyecto proyecto = new Proyecto();

        LocalDate localDate = proyecto_inicio_ui.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        proyecto.setFechaInicio(date);

        LocalDate endLocalDate = proyecto_final_ui.getValue();
        Instant endInstant = Instant.from(endLocalDate.atStartOfDay(ZoneId.systemDefault()));
        Date endDate = Date.from(endInstant);
        proyecto.setFechaFinal(endDate);

        proyecto.setUbicacion(sede_ubicacion_ui.getText());

        return proyecto;
    }
    
    

}
