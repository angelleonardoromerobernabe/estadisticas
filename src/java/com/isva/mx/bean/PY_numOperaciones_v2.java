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
@Entity(name="py_numOperaciones_v2")
public class PY_numOperaciones_v2 implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    private int id_registro;
    private String funcionalidad;
    private String metodo;
    private int r9;
    private int alias_r9;
    private int deur;
    private int alias_deur;
    private int quincena;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mes;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date insercion;

    public PY_numOperaciones_v2() {
        super();
    }

    public PY_numOperaciones_v2(int id_registro, String funcionalidad, String metodo, int r9, int alias_r9, int deur, int alias_deur, int quincena, Date mes, Date insercion) {
        this.id_registro = id_registro;
        this.funcionalidad = funcionalidad;
        this.metodo = metodo;
        this.r9 = r9;
        this.alias_r9 = alias_r9;
        this.deur = deur;
        this.alias_deur = alias_deur;
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
    
    public String getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(String funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public int getR9() {
        return r9;
    }

    public void setR9(int r9) {
        this.r9 = r9;
    }

    public int getAlias_r9() {
        return alias_r9;
    }

    public void setAlias_r9(int alias_r9) {
        this.alias_r9 = alias_r9;
    }

    public int getAlias_deur() {
        return alias_deur;
    }

    public void setAlias_deur(int alias_deur) {
        this.alias_deur = alias_deur;
    }

    public int getDeur() {
        return deur;
    }

    public void setDeur(int deur) {
        this.deur = deur;
    }

    public Date getInsercion() {
        return insercion;
    }

    public void setInsercion(Date insercion) {
        this.insercion = insercion;
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
        
}
