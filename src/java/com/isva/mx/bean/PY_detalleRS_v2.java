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
@Entity(name="py_detalleRS_v2")
public class PY_detalleRS_v2 implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    private int id_registro;
    private String alias;
    private String nombre_fiscal;
    private String rfc_empresa;
    private String region_admin_gral;
    private String region_ejecutivo;
    private String correo_admin_gral;    
    private int quincena;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mes;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date insercion;

    public PY_detalleRS_v2() {
        super();
    }

    public PY_detalleRS_v2(int id_registro, String alias, String nombre_fiscal, String rfc_empresa, String region_admin_gral, String region_ejecutivo, String correo_admin_gral, int quincena, Date mes, Date insercion) {
        this.id_registro = id_registro;
        this.alias = alias;
        this.nombre_fiscal = nombre_fiscal;
        this.rfc_empresa = rfc_empresa;
        this.region_admin_gral = region_admin_gral;
        this.region_ejecutivo = region_ejecutivo;
        this.correo_admin_gral = correo_admin_gral;
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

    public String getNombre_fiscal() {
        return nombre_fiscal;
    }

    public void setNombre_fiscal(String nombre_fiscal) {
        this.nombre_fiscal = nombre_fiscal;
    }

    public String getRfc_empresa() {
        return rfc_empresa;
    }

    public void setRfc_empresa(String rfc_empresa) {
        this.rfc_empresa = rfc_empresa;
    }

    public String getRegion_admin_gral() {
        return region_admin_gral;
    }

    public void setRegion_admin_gral(String region_admin_gral) {
        this.region_admin_gral = region_admin_gral;
    }

    public String getRegion_ejecutivo() {
        return region_ejecutivo;
    }

    public void setRegion_ejecutivo(String region_ejecutivo) {
        this.region_ejecutivo = region_ejecutivo;
    }

    public String getCorreo_admin_gral() {
        return correo_admin_gral;
    }

    public void setCorreo_admin_gral(String correo_admin_gral) {
        this.correo_admin_gral = correo_admin_gral;
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
