/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isva.mx.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author VC6AF18
 */
@Entity(name="usuarios")
public class Usuarios implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    private String usuario;
    private String contrasena;
    private String nombre;  
    private String perfil;
    private String correo;
    private int estatus;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    public Usuarios (){
        super();
    }

    public Usuarios(String usuario, String contrasena, String nombre, String perfil, String correo, int estatus, Date fecha) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.perfil = perfil;
        this.correo = correo;
        this.estatus = estatus;
        this.fecha = fecha;
    }    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
        
}
