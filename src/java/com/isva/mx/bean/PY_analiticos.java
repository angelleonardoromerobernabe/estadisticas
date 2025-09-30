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
@Entity(name="py_analiticos")
public class PY_analiticos implements Serializable{
    private static final long serialVersionUID=1L;
 
    @Id
    private int id_registro;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private String id_alias;
    private int v_home;
    private int v_factura_serv;
    private int v_reportes;
    private int v_fpp;
    private int v_factura_epos;    
    private int v_complemento_pago;
    private int v_factura_electronica;
    private int v_mis_lineas;
    private int v_mis_grupos;
    private int v_servicios_adicionales;
    private int v_directorio;
    private int v_mis_movimientos;
    private int v_preguntas_frec;
    private int v_servicio_tecnico;
    private int v_citas;
    private int region;
    private int deur;
    private int visitas;
    private int page_view;
    private int quincena;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mes;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date insercion;

    public PY_analiticos() {
        super();
    }
    
    public PY_analiticos(int id_registro, Date fecha, String id_alias, int v_home, int v_factura_serv, int v_reportes, int v_fpp, int v_factura_epos, int v_complemento_pago, int v_factura_electronica, int v_mis_lineas, int v_mis_grupos, int v_servicios_adicionales, int v_directorio, int v_mis_movimientos, int v_preguntas_frec, int v_servicio_tecnico, int v_citas, int region, int deur, int visitas, int page_view, int quincena, Date mes, Date insercion) {
        this.id_registro = id_registro;
        this.fecha = fecha;
        this.id_alias = id_alias;
        this.v_home = v_home;
        this.v_factura_serv = v_factura_serv;
        this.v_reportes = v_reportes;
        this.v_fpp = v_fpp;
        this.v_factura_epos = v_factura_epos;
        this.v_complemento_pago = v_complemento_pago;
        this.v_factura_electronica = v_factura_electronica;
        this.v_mis_lineas = v_mis_lineas;
        this.v_mis_grupos = v_mis_grupos;
        this.v_servicios_adicionales = v_servicios_adicionales;
        this.v_directorio = v_directorio;
        this.v_mis_movimientos = v_mis_movimientos;
        this.v_preguntas_frec = v_preguntas_frec;
        this.v_servicio_tecnico = v_servicio_tecnico;
        this.v_citas = v_citas;
        this.region = region;
        this.deur = deur;
        this.visitas = visitas;
        this.page_view = page_view;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getId_alias() {
        return id_alias;
    }

    public void setId_alias(String id_alias) {
        this.id_alias = id_alias;
    }

    public int getV_home() {
        return v_home;
    }

    public void setV_home(int v_home) {
        this.v_home = v_home;
    }

    public int getV_factura_serv() {
        return v_factura_serv;
    }

    public void setV_factura_serv(int v_factura_serv) {
        this.v_factura_serv = v_factura_serv;
    }

    public int getV_reportes() {
        return v_reportes;
    }

    public void setV_reportes(int v_reportes) {
        this.v_reportes = v_reportes;
    }

    public int getV_fpp() {
        return v_fpp;
    }

    public void setV_fpp(int v_fpp) {
        this.v_fpp = v_fpp;
    }

    public int getV_factura_epos() {
        return v_factura_epos;
    }

    public void setV_factura_epos(int v_factura_epos) {
        this.v_factura_epos = v_factura_epos;
    }

    public int getV_complemento_pago() {
        return v_complemento_pago;
    }

    public void setV_complemento_pago(int v_complemento_pago) {
        this.v_complemento_pago = v_complemento_pago;
    }

    public int getV_factura_electronica() {
        return v_factura_electronica;
    }

    public void setV_factura_electronica(int v_factura_electronica) {
        this.v_factura_electronica = v_factura_electronica;
    }

    public int getV_mis_lineas() {
        return v_mis_lineas;
    }

    public void setV_mis_lineas(int v_mis_lineas) {
        this.v_mis_lineas = v_mis_lineas;
    }

    public int getV_mis_grupos() {
        return v_mis_grupos;
    }

    public void setV_mis_grupos(int v_mis_grupos) {
        this.v_mis_grupos = v_mis_grupos;
    }

    public int getV_servicios_adicionales() {
        return v_servicios_adicionales;
    }

    public void setV_servicios_adicionales(int v_servicios_adicionales) {
        this.v_servicios_adicionales = v_servicios_adicionales;
    }

    public int getV_directorio() {
        return v_directorio;
    }

    public void setV_directorio(int v_directorio) {
        this.v_directorio = v_directorio;
    }

    public int getV_mis_movimientos() {
        return v_mis_movimientos;
    }

    public void setV_mis_movimientos(int v_mis_movimientos) {
        this.v_mis_movimientos = v_mis_movimientos;
    }

    public int getV_preguntas_frec() {
        return v_preguntas_frec;
    }

    public void setV_preguntas_frec(int v_preguntas_frec) {
        this.v_preguntas_frec = v_preguntas_frec;
    }

    public int getV_servicio_tecnico() {
        return v_servicio_tecnico;
    }

    public void setV_servicio_tecnico(int v_servicio_tecnico) {
        this.v_servicio_tecnico = v_servicio_tecnico;
    }

    public int getV_citas() {
        return v_citas;
    }

    public void setV_citas(int v_citas) {
        this.v_citas = v_citas;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public int getDeur() {
        return deur;
    }

    public void setDeur(int deur) {
        this.deur = deur;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    public int getPage_view() {
        return page_view;
    }

    public void setPage_view(int page_view) {
        this.page_view = page_view;
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
