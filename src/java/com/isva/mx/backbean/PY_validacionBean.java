/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isva.mx.backbean;

import com.isva.mx.service.PY_catalogosService;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

/**
 *
 * @author VC6AF18
 */
@ManagedBean(name = "py_validacionBean")
@SessionScoped
public class PY_validacionBean implements Serializable{
    private static final long serialVersionUID=1L;
    private static final Logger logger = Logger.getLogger(PY_validacionBean.class);
    
    private List<String> lista_mes;
    private List<Integer> lista_anio;
    private List<String> lista_totales;
    
    private String idSeleccionadoMes;
    private int idSeleccionadoAnio;
    private int idSeleccionadoQuincena;
        
    FacesMessage msg;
    
    @ManagedProperty(value = "#{py_catalogosService}")
    private PY_catalogosService py_catalogosService;
    
    public PY_validacionBean(){
        super();
    }
    
    @PostConstruct
    public void init(){
        logger.info("Obtiene información inicial");
        lista_mes = py_catalogosService.getPy_catalogos().lista_meses();
        lista_anio = py_catalogosService.getPy_catalogos().lista_anios();
        idSeleccionadoMes = lista_mes.get(0);
        idSeleccionadoAnio = Integer.parseInt(String.valueOf(lista_anio.get(0)));
        idSeleccionadoQuincena = py_catalogosService.getPy_catalogos().get_quincena(idSeleccionadoAnio, idSeleccionadoMes);
        lista_totales = py_catalogosService.getPy_catalogos().lista_validacion(idSeleccionadoAnio, idSeleccionadoMes, idSeleccionadoQuincena);
    }
    
    public boolean valida_filtros(){
        boolean bandera=true;
        if (idSeleccionadoAnio==0){
            bandera=false;
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: ","El año es obligatorio.");
        }else if (idSeleccionadoMes.equals("0")){
            bandera=false;
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: ","El mes es obligatorio.");
        }
        return bandera;
    }
    
    public void operacionFiltroMenu(){
        logger.info("Obtiene información con filtros menú");
        if (valida_filtros()){
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Consulta: ","Actualizando información");
            lista_totales = py_catalogosService.getPy_catalogos().lista_validacion(idSeleccionadoAnio, idSeleccionadoMes, idSeleccionadoQuincena);
        } 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }   

    public String getDecimalFormat(int number) {
        return new DecimalFormat("###,###.###").format(number);
    }
    
    public List<String> getLista_mes() {
        return lista_mes;
    }

    public void setLista_mes(List<String> lista_mes) {
        this.lista_mes = lista_mes;
    }

    public List<Integer> getLista_anio() {
        return lista_anio;
    }

    public void setLista_anio(List<Integer> lista_anio) {
        this.lista_anio = lista_anio;
    }

    public List<String> getLista_totales() {
        return lista_totales;
    }

    public void setLista_totales(List<String> lista_totales) {
        this.lista_totales = lista_totales;
    }

    public String getIdSeleccionadoMes() {
        return idSeleccionadoMes;
    }

    public void setIdSeleccionadoMes(String idSeleccionadoMes) {
        this.idSeleccionadoMes = idSeleccionadoMes;
    }

    public int getIdSeleccionadoAnio() {
        return idSeleccionadoAnio;
    }

    public void setIdSeleccionadoAnio(int idSeleccionadoAnio) {
        this.idSeleccionadoAnio = idSeleccionadoAnio;
    }

    public int getIdSeleccionadoQuincena() {
        return idSeleccionadoQuincena;
    }

    public void setIdSeleccionadoQuincena(int idSeleccionadoQuincena) {
        this.idSeleccionadoQuincena = idSeleccionadoQuincena;
    }

    public PY_catalogosService getPy_catalogosService() {
        return py_catalogosService;
    }

    public void setPy_catalogosService(PY_catalogosService py_catalogosService) {
        this.py_catalogosService = py_catalogosService;
    }
    
}
