package com.producto4.model;
// Generated 9 ene. 2022 16:34:58 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "Usuario")
public class Usuario  implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
     private Long id;
    @Column(name = "password")
     private String password;
    @Column(name = "administrador")
     private short administrador;
    @Column(name = "dni")
     private String dni;
    @Column(name = "nombre")
     private String nombre;
    @Column(name = "apellido")
     private String apellido;
    @Column(name = "correo")
     private String correo;
    @Column(name = "fechaNacimiento")
     private Date fechaNacimiento;
    @Column(name = "usuario")
     private String usuario;
    @Column(name = "puesto")
     private String puesto;
    @Column(name = "idSede")
     private short idSede;
    @Column(name = "tipoEmpleado")
     private String tipoEmpleado;
    @Column(name = "salario")
     private Float salario;
    @Column(name = "territorio")
     private String territorio;

    public Usuario() {
    }

    public Usuario(Long id, String password, short administrador, String dni, String nombre, String apellido, String correo, Date fechaNacimiento, String usuario, String puesto, short idSede, String tipoEmpleado, Float salario, String territorio) {
        this.id = id;
        this.password = password;
        this.administrador = administrador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.puesto = puesto;
        this.idSede = idSede;
        this.tipoEmpleado = tipoEmpleado;
        this.salario = salario;
        this.territorio = territorio;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", password=" + password + ", administrador=" + administrador + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", usuario=" + usuario + ", puesto=" + puesto + ", idSede=" + idSede + ", tipoEmpleado=" + tipoEmpleado + ", salario=" + salario + ", territorio=" + territorio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.administrador != other.administrador) {
            return false;
        }
        if (this.idSede != other.idSede) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.puesto, other.puesto)) {
            return false;
        }
        if (!Objects.equals(this.tipoEmpleado, other.tipoEmpleado)) {
            return false;
        }
        if (!Objects.equals(this.territorio, other.territorio)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        if (!Objects.equals(this.salario, other.salario)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getAdministrador() {
        return administrador;
    }

    public void setAdministrador(short administrador) {
        this.administrador = administrador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public short getIdSede() {
        return idSede;
    }

    public void setIdSede(short idSede) {
        this.idSede = idSede;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public String getTerritorio() {
        return territorio;
    }

    public void setTerritorio(String territorio) {
        this.territorio = territorio;
    }

	
    
}


