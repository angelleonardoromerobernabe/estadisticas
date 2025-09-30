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
@Entity(name="py_userUnicos_v2")
public class PY_userUnicos_v2 implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    private int id_registro;
    private String modulo;
    private int alias_R09;
    private int alias_DEUR;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mes;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date insercion;

    public PY_userUnicos_v2() {
        super();
    }

    public PY_userUnicos_v2(int id_registro, String modulo, int alias_R09, int alias_DEUR, Date mes, Date insercion) {
        this.id_registro = id_registro;
        this.modulo = modulo;
        this.alias_R09 = alias_R09;
        this.alias_DEUR = alias_DEUR;
        this.mes = mes;
        this.insercion = insercion;
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

    public int getAlias_R09() {
        return alias_R09;
    }

    public void setAlias_R09(int alias_R09) {
        this.alias_R09 = alias_R09;
    }

    public int getAlias_DEUR() {
        return alias_DEUR;
    }

    public void setAlias_DEUR(int alias_DEUR) {
        this.alias_DEUR = alias_DEUR;
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
