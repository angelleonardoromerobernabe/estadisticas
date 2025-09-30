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
@Entity(name="py_adopcion_v2")
public class PY_Adopcion_v2 implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    private int id_registro;
    private String alias;
    private int total_lineas;
    private String usuario_universal;
    private String correo_admin;
    private int tipo_usuario;
    private String region_admin;
    private String region_ejecutivo;
    private String ingreso;
    private String correo_ejecutivo;
    private int total_rfc;
    private int total_sub_admin;
    private int quincena;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mes;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date insercion;

    public PY_Adopcion_v2() {
        super();
    }

    public PY_Adopcion_v2(int id_registro, String alias, int total_lineas, String usuario_universal, String correo_admin, int tipo_usuario, String region_admin, String region_ejecutivo, String ingreso, String correo_ejecutivo, int total_rfc, int total_sub_admin, int quincena, Date mes, Date insercion) {
        this.id_registro = id_registro;
        this.alias = alias;
        this.total_lineas = total_lineas;
        this.usuario_universal = usuario_universal;
        this.correo_admin = correo_admin;
        this.tipo_usuario = tipo_usuario;
        this.region_admin = region_admin;
        this.region_ejecutivo = region_ejecutivo;
        this.ingreso = ingreso;
        this.correo_ejecutivo = correo_ejecutivo;
        this.total_rfc = total_rfc;
        this.total_sub_admin = total_sub_admin;
        this.quincena = quincena;
        this.mes = mes;
        this.insercion = insercion;
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getTotal_lineas() {
        return total_lineas;
    }

    public void setTotal_lineas(int total_lineas) {
        this.total_lineas = total_lineas;
    }

    public String getUsuario_universal() {
        return usuario_universal;
    }

    public void setUsuario_universal(String usuario_universal) {
        this.usuario_universal = usuario_universal;
    }

    public String getCorreo_admin() {
        return correo_admin;
    }

    public void setCorreo_admin(String correo_admin) {
        this.correo_admin = correo_admin;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getRegion_admin() {
        return region_admin;
    }

    public void setRegion_admin(String region_admin) {
        this.region_admin = region_admin;
    }

    public String getRegion_ejecutivo() {
        return region_ejecutivo;
    }

    public void setRegion_ejecutivo(String region_ejecutivo) {
        this.region_ejecutivo = region_ejecutivo;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getCorreo_ejecutivo() {
        return correo_ejecutivo;
    }

    public void setCorreo_ejecutivo(String correo_ejecutivo) {
        this.correo_ejecutivo = correo_ejecutivo;
    }

    public int getTotal_rfc() {
        return total_rfc;
    }

    public void setTotal_rfc(int total_rfc) {
        this.total_rfc = total_rfc;
    }

    public int getTotal_sub_admin() {
        return total_sub_admin;
    }

    public void setTotal_sub_admin(int total_sub_admin) {
        this.total_sub_admin = total_sub_admin;
    }

    public int getQuincena() {
        return quincena;
    }

    public void setQuincena(int quincena) {
        this.quincena = quincena;
    }

    public Date getMes() {
        return mes;
    }

    public void setMes(Date mes) {
        this.mes = mes;
    }

    public Date getInsercion() {
        return insercion;
    }

    public void setInsercion(Date insercion) {
        this.insercion = insercion;
    }
    
    
}
