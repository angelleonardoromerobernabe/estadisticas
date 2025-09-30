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
@Entity(name="py_detalleOperaciones_v2")
public class PY_detalleOperaciones_v2 implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    private int id_registro;
    private String modulo;
    private String metodo;
    private String region_admin;
    private String estatus;
    private String descripcion_estatus;
    private String administrador;
    private String id_alias;
    private String alias;
    private String ejecutivo;
    private String region_ejecutivo;
    private String ejecutivo_universal;
    private String ingreso;
    private int tipo_usuario;
    private int operaciones;
    private int quincena;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mes;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date insercion;

    public PY_detalleOperaciones_v2() {
        super();
    }
        
    public PY_detalleOperaciones_v2(int id_registro, String modulo, String metodo, String region_admin, String estatus, String descripcion_estatus, String administrador, String id_alias, String alias, String ejecutivo, String region_ejecutivo, String ejecutivo_universal, String ingreso, int tipo_usuario, int operaciones, int quincena, Date mes, Date insercion) {
        this.id_registro = id_registro;
        this.modulo = modulo;
        this.metodo = metodo;
        this.region_admin = region_admin;
        this.estatus = estatus;
        this.descripcion_estatus = descripcion_estatus;
        this.administrador = administrador;
        this.id_alias = id_alias;
        this.alias = alias;
        this.ejecutivo = ejecutivo;
        this.region_ejecutivo = region_ejecutivo;
        this.ingreso = ingreso;
        this.tipo_usuario = tipo_usuario;
        this.operaciones = operaciones;
        this.quincena = quincena;
        this.mes = mes;
        this.insercion = insercion;
        this.ejecutivo_universal = ejecutivo_universal;
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getRegion_admin() {
        return region_admin;
    }

    public void setRegion_admin(String region_admin) {
        this.region_admin = region_admin;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getDescripcion_estatus() {
        return descripcion_estatus;
    }

    public void setDescripcion_estatus(String descripcion_estatus) {
        this.descripcion_estatus = descripcion_estatus;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public String getId_alias() {
        return id_alias;
    }

    public void setId_alias(String id_alias) {
        this.id_alias = id_alias;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEjecutivo() {
        return ejecutivo;
    }

    public void setEjecutivo(String ejecutivo) {
        this.ejecutivo = ejecutivo;
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

    public int getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(int operaciones) {
        this.operaciones = operaciones;
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

    public String getEjecutivo_universal() {
        return ejecutivo_universal;
    }

    public void setEjecutivo_universal(String ejecutivo_universal) {
        this.ejecutivo_universal = ejecutivo_universal;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
        
}
