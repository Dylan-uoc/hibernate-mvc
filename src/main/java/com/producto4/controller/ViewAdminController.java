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
import com.producto4.model.HibernateUtil;
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
import java.util.List;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.hibernate.Query;
import org.hibernate.Session;

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
    private TableColumn<Map, String> id_sede_column;
    @FXML
    private TableColumn<Map, String> id_proyecto_column;
    @FXML
    private TableColumn<Map, String> fecha_inicio_column;
    @FXML
    private TableColumn<Map, String> fecha_final_column;
    @FXML
    private TableColumn<Map, String> id_usuario_column;
    @FXML
    private TableColumn<Map, String> nombre_usuario_column;
    @FXML
    private TableColumn<Map, String> apellido_usuario_column;
    @FXML
    private TableColumn<Map, String> correo_usuario_column;
    @FXML
    private TableColumn<Map, String> _usuario_column;
    @FXML
    private TableColumn<Map, String> fecha_usuario_column;
    @FXML
    private TableColumn<Map, String> user_usuario_column;
    @FXML
    private TableColumn<Map, String> password_usuario_column;
    @FXML
    private TableColumn<Map, String> admin_usuario_column;
    @FXML
    private TableColumn<Map, String> dni_usuario_column;
    @FXML
    private TableColumn<Map, String> puesto_usuario_column;
    @FXML
    private TableColumn<Map, String> sede_usuario_column;
    @FXML
    private TableColumn<Map, String> proyecto_usuario_column;
    @FXML
    private TableColumn<Map, String> tipo_usuario_column;
    @FXML
    private TableColumn<Map, String> salario_usuario_column;
    @FXML
    private TableColumn<Map, String> territorio_usuario_column;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillTable();
        fillTableProyecto();
        fillTableUsuario();
    }    

    private void fillTable() {
        SedeTable.getItems().clear();    
        id_sede_column.setCellValueFactory(new MapValueFactory<>("ID_SEDE"));

	   	ObservableList<Map<String, Object>> items =
	   	    FXCollections.<Map<String, Object>>observableArrayList();

	   	Map<String, Object> item1;
                Session session = HibernateUtil.getSessionFactory().openSession();
                Query q = session.createQuery("From Sede");

        List<Sede> resultList = q.list();
        for (Sede next : resultList) {
            item1 = new HashMap<>();
	   	item1.put("ID_SEDE", next.getId());

	   	items.add(item1);
        }
        SedeTable.getItems().addAll(items);
        
    }

    private void fillTableUsuario() {
        UserTable.getItems().clear();
        id_usuario_column.setCellValueFactory(new MapValueFactory<>("ID_USUARIO"));
        nombre_usuario_column.setCellValueFactory(new MapValueFactory<>("NOMBRE_USUARIO"));
        apellido_usuario_column.setCellValueFactory(new MapValueFactory<>("APELLIDO_USUARIO"));
        correo_usuario_column.setCellValueFactory(new MapValueFactory<>("CORREO_USUARIO"));
        fecha_usuario_column.setCellValueFactory(new MapValueFactory<>("FECHA_USUARIO"));
        user_usuario_column.setCellValueFactory(new MapValueFactory<>("USER_USUARIO"));
        password_usuario_column.setCellValueFactory(new MapValueFactory<>("PASSWORD_USUARIO"));
        admin_usuario_column.setCellValueFactory(new MapValueFactory<>("ADMIN_USUARIO"));
        dni_usuario_column.setCellValueFactory(new MapValueFactory<>("DNI_USUARIO"));
        puesto_usuario_column.setCellValueFactory(new MapValueFactory<>("PUESTO_USUARIO"));
        sede_usuario_column.setCellValueFactory(new MapValueFactory<>("SEDE_USUARIO"));
        proyecto_usuario_column.setCellValueFactory(new MapValueFactory<>("PROYECTO_USUARIO"));
        tipo_usuario_column.setCellValueFactory(new MapValueFactory<>("TIPO_USUARIO"));
        salario_usuario_column.setCellValueFactory(new MapValueFactory<>("SALARIO_USUARIO"));
        territorio_usuario_column.setCellValueFactory(new MapValueFactory<>("TERRITORIO_USUARIO"));

        ObservableList<Map<String, Object>> items =
                FXCollections.<Map<String, Object>>observableArrayList();

        Map<String, Object> item1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From User");

        List<Usuario> resultList = q.list();
        for (Usuario next : resultList) {
            item1 = new HashMap<>();
            item1.put("ID_USUARIO", next.getId());
            item1.put("NOMBRE_USUARIO", next.getNombre());
            item1.put("APELLIDO_USUARIO", next.getApellido());
            item1.put("CORREO_USUARIO", next.getCorreo());
            item1.put("FECHA_USUARIO", next.getFechaNacimiento());
            item1.put("USER_USUARIO", next.getUsuario());
            item1.put("PASSWORD_USUARIO", next.getPassword());
            item1.put("ADMIN_USUARIO", next.getAdministrador());
            item1.put("DNI_USUARIO", next.getDni());
            item1.put("PUESTO_USUARIO", next.getPuesto());
            item1.put("SEDE_USUARIO", next.getSede());
            item1.put("PROYECTO_USUARIO", next.getProyecto());
            item1.put("TIPO_USUARIO", next.getTipoEmpleado());
            item1.put("SALARIO_USUARIO", next.getSalario());
            item1.put("TERRITORIO_USUARIO", next.getTerritorio());

            items.add(item1);
        }
        UserTable.getItems().addAll(items);

    }

    private void fillTableProyecto() {
        ProyectTable.getItems().clear();
        id_proyecto_column.setCellValueFactory(new MapValueFactory<>("ID_PROYECTO"));
        fecha_final_column.setCellValueFactory(new MapValueFactory<>("FECHA_FIN_PROYECTO"));
        fecha_inicio_column.setCellValueFactory(new MapValueFactory<>("FECHA_INICIO_PROYECTO"));

        ObservableList<Map<String, Object>> items =
                FXCollections.<Map<String, Object>>observableArrayList();

        Map<String, Object> item1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("From Proyecto");

        List<Proyecto> resultList = q.list();
        for (Proyecto next : resultList) {
            item1 = new HashMap<>();
            item1.put("ID_PROYECTO", next.getId());
            item1.put("FECHA_FIN_PROYECTO", next.getFechaFinal());
            item1.put("FECHA_INICIO_PROYECTO", next.getFechaInicio());
            items.add(item1);
        }
        SedeTable.getItems().addAll(items);

    }
        
    
    @FXML
    private void eliminar_usuario_button(ActionEvent event) {
         if (validateInputs("usuario")) {
            Usuario usuario_agregado = createUserFromInput();
            UsuarioDaoFactory factory = new UsuarioDaoFactory();
	    UsuarioDaoImpl userdao = factory.crearUsuarioDao();
            userdao.eliminar(usuario_agregado);
            //filltable_usuario();
        }
    }
    
    @FXML
    private void seleccionar_button (ActionEvent event) { 
    
    int id_seleccionado= Integer.parseInt(seleccion_id.getText());
    Session session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from Usuario u where u.id=:id_seleccionado ");
            q.setParameter("id_seleccionado",id_seleccionado );
            Usuario u = (Usuario) q.list().get(0);
            apellido_ui.setText(u.getApellido());
            name_ui.setText(u.getNombre());
            correo_ui.setText(u.getCorreo());
            usuario_ui.setText(u.getUsuario());
            pass_ui.setText(u.getPassword());
            DNI_ui.setText(u.getDni());
            puesto_ui.setText(u.getPuesto());
            sede_ui.setText(u.getSede());
            proyecto_ui.setText(u.getProyecto());
            tipoEmpleado_ui.setText(u.getTipoEmpleado());
            salario_ui.setText(u.getSalario().toString());
            territorio_ui.setText(u.getTerritorio());
            
            int admin_check= u.getAdministrador();
            if(admin_check==1){
            admin_ui.selectedProperty();
        } else {
        }
                  
            
    }
       
        

    @FXML
    private void modificar_usuario_button(ActionEvent event) throws Exception {
     if (validateInputs("usuario")) {
            Usuario usuario_agregado = createUserFromInput();
            UsuarioDaoFactory factory = new UsuarioDaoFactory();
	    UsuarioDaoImpl userdao = factory.crearUsuarioDao();
            userdao.actualizar(usuario_agregado);
            //filltable_usuario();
        }
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

        fillTableUsuario();
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
        //
        LocalDate localDate = fechaNacimiento_ui.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        user.setFechaNacimiento(date);
        //
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
    private void eliminar_sede_button(ActionEvent event) throws Exception {
       if (validateInputs("sede")) {
            Sede sede_agregada = createSedeFromInput();
            SedeDaoFactory sede = new SedeDaoFactory();
            SedeDaoImpl sededao = sede.crearSedeDao();
            sededao.registrar(sede_agregada);
           
        }
        fillTable();
    }

    @FXML
   private void modificar_sede_button(ActionEvent event) throws Exception {
       
       if (validateInputs("sede")) {
            Sede sede_agregada = createSedeFromInput();
            SedeDaoFactory sede = new SedeDaoFactory();
            SedeDaoImpl sededao = sede.crearSedeDao();
            sededao.eliminar(sede_agregada);
            }
       fillTable();
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
        fillTable();
    }
    
    private Sede createSedeFromInput() {
        Sede sede = new Sede();

        sede.setTipo(sede_tipo_ui.getText());
        sede.setUbicacion(sede_ubicacion_ui.getText());

        return sede;

    }

    @FXML
    private void eliminar_proyecto_button(ActionEvent event) {
         if (validateInputs("proyecto")) {
         Proyecto proyecto_agregado = createProyectoFromInput();
         ProyectoDaoFactory proyecto = new ProyectoDaoFactory();
         ProyectoDaoImpl proyectodao = proyecto.crearProyectoDao();
         proyectodao.eliminar(proyecto_agregado);
            
            }
        //fillTable_proyecto();
        
    }

    @FXML
    private void modificar_proyecto_button(ActionEvent event) {
        if (validateInputs("proyecto")) {
            Proyecto proyecto_agregado = createProyectoFromInput();
            ProyectoDaoFactory proyecto = new ProyectoDaoFactory();
            ProyectoDaoImpl proyectodao = proyecto.crearProyectoDao();
            proyectodao.actualizar(proyecto_agregado);
            
            }
        //fillTable_proyecto();
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
        fillTableProyecto();
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
