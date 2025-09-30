/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isva.mx.backbean;

import com.isva.mx.bean.PY_numOperaciones_v2;
import com.isva.mx.bean.PY_userUnicos_v2;
import com.isva.mx.service.PY_catalogosService;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 *
 * @author VC6AF18
 */
@ManagedBean(name = "py_numOperacionesBean")
@SessionScoped
public class PY_numOperacionBean implements Serializable{
    private static final long serialVersionUID=1L;
    private static final Logger logger = Logger.getLogger(PY_numOperacionBean.class);
    
    private PY_numOperaciones_v2 py_numOperaciones;
    private PY_userUnicos_v2 py_userUnicos;
    private List<String> lista_mes;
    private List<Integer> lista_anio;
    private String idSeleccionadoMes;
    private int idSeleccionadoAnio;
    private int idSeleccionadoQuincena;
    private List<PY_numOperaciones_v2> lista_numOperaciones;
    private List<String> lista_numOperacionesResumen;
    private List<String> lista_historicoOperaciones;
    private List<PY_userUnicos_v2> lista_userUnicos;
    private List<String> lista_userUnicosTotales;
    private List<String> lista_mesesOrder = new ArrayList();
    int total_r9;
    int total_usr_r9;
    int total_deur;
    int total_usr_deur;
    int total_gral;
    int total_usuarios;
    int total_opera;
    String getDecimalFormat;
    
    FacesMessage msg;
    
    @ManagedProperty(value = "#{py_catalogosService}")
    private PY_catalogosService py_catalogosService;

    public PY_numOperacionBean() {
        super();
        py_numOperaciones = new PY_numOperaciones_v2();
        py_userUnicos = new PY_userUnicos_v2();
    }
    
    @PostConstruct
    public void init(){
        logger.info("Obtiene información inicial");
        lista_mes = py_catalogosService.getPy_catalogos().lista_meses();
        lista_anio = py_catalogosService.getPy_catalogos().lista_anios();
        idSeleccionadoMes = lista_mes.get(0);
        idSeleccionadoAnio = Integer.parseInt(String.valueOf(lista_anio.get(0)));
        idSeleccionadoQuincena = py_catalogosService.getPy_catalogos().get_quincena(idSeleccionadoAnio, idSeleccionadoMes);
        System.out.println("::::::::::::::::::::::::::::SELECCION::::::::::::::");
        System.out.println(idSeleccionadoQuincena);
        
       
       
        lista_numOperaciones = py_catalogosService.getPy_catalogos().lista_numOperacionesFiltro(idSeleccionadoAnio, idSeleccionadoMes, idSeleccionadoQuincena);
        lista_numOperacionesResumen = py_catalogosService.getPy_catalogos().lista_numOperacionesFiltroResumen(idSeleccionadoAnio, idSeleccionadoMes, idSeleccionadoQuincena);
        lista_historicoOperaciones = py_catalogosService.getPy_catalogos().lista_historicoNumOperaciones(idSeleccionadoAnio, lista_mes);
        lista_userUnicos = py_catalogosService.getPy_catalogos().lista_detOperacionesUserUnicos(idSeleccionadoAnio, idSeleccionadoMes, idSeleccionadoQuincena);
        lista_userUnicosTotales = py_catalogosService.getPy_catalogos().lista_usuarioUnicosTotales(idSeleccionadoAnio, idSeleccionadoMes, idSeleccionadoQuincena);
        total_columnas_numOpercion();
        for (int i=3; i>=0; i--){
            lista_mesesOrder.add(lista_mes.get(i));
        }
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
    
    public void operacionFiltro(){
        logger.info("Obtiene información con filtros");
        if (valida_filtros()){
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Consulta: ","Actualizando información");
            lista_numOperaciones = py_catalogosService.getPy_catalogos().lista_numOperacionesFiltro(idSeleccionadoAnio, idSeleccionadoMes, idSeleccionadoQuincena);
            total_columnas_numOpercion();
        } 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void operacionFiltroUnicos(){
        logger.info("Obtiene información con filtros");
        if (valida_filtros()){
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Consulta: ","Actualizando información");
            lista_userUnicos = py_catalogosService.getPy_catalogos().lista_detOperacionesUserUnicos(idSeleccionadoAnio, idSeleccionadoMes, idSeleccionadoQuincena);
            lista_userUnicosTotales = py_catalogosService.getPy_catalogos().lista_usuarioUnicosTotales(idSeleccionadoAnio, idSeleccionadoMes, idSeleccionadoQuincena);
            total_columnas_unicos();
        } 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void total_columnas_numOpercion(){
        total_r9=0; total_usr_r9=0; total_deur=0; total_usr_deur=0; total_gral=0; total_usuarios=0;
        for(PY_numOperaciones_v2 total : lista_numOperaciones) {
            total_r9 += total.getR9();
            total_usr_r9 += total.getAlias_r9();
            total_deur += total.getDeur();
            total_usr_deur += total.getAlias_deur();
        }
        total_gral = total_r9 + total_deur;
        total_usuarios = total_usr_r9 + total_usr_deur;
    }
    
    public void total_columnas_unicos(){
        total_r9=0; total_deur=0; total_gral=0;
        for(PY_userUnicos_v2 total : lista_userUnicos) {
            total_r9 += total.getAlias_R09();
            total_deur += total.getAlias_DEUR();
        }
        total_gral = total_r9 + total_deur;
    }
    
    public void exporter_postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        wb.setSheetName(wb.getSheetIndex(sheet), "numOperaciones_"+idSeleccionadoMes+"_"+idSeleccionadoAnio);
        
        for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
            header.getCell(i).setCellStyle(cellStyle);
        }
        
        for (short i = sheet.getRow(0).getFirstCellNum(), end = sheet.getRow(0).getLastCellNum() ; i < end ; i++) {
            sheet.autoSizeColumn(i);
        }
    }
    
    public void operacionFiltroResumen(){
        logger.info("Obtiene información con filtros para el resumen");
        if (valida_filtros()){
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Consulta: ","Actualizando información");
            lista_numOperacionesResumen = py_catalogosService.getPy_catalogos().lista_numOperacionesFiltroResumen(idSeleccionadoAnio, idSeleccionadoMes, idSeleccionadoQuincena);
        } 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void exporter_postProcessXLS_v2(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        wb.setSheetName(wb.getSheetIndex(sheet), "usuarioUnicos_"+idSeleccionadoMes+"_"+idSeleccionadoAnio);
        
        for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
            header.getCell(i).setCellStyle(cellStyle);
        }
        
        for (short i = sheet.getRow(0).getFirstCellNum(), end = sheet.getRow(0).getLastCellNum() ; i < end ; i++) {
            sheet.autoSizeColumn(i);
        }
    }
    
    public String getDecimalFormat(int number) {
        return new DecimalFormat("###,###.###").format(number);
    }

    public PY_userUnicos_v2 getPy_userUnicos() {
        return py_userUnicos;
    }

    public void setPy_userUnicos(PY_userUnicos_v2 py_userUnicos) {
        this.py_userUnicos = py_userUnicos;
    }
    
    public PY_numOperaciones_v2 getPy_numOperaciones() {
        return py_numOperaciones;
    }

    public void setPy_numOperaciones(PY_numOperaciones_v2 py_numOperaciones) {
        this.py_numOperaciones = py_numOperaciones;
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

    public List<PY_numOperaciones_v2> getLista_numOperaciones() {
        return lista_numOperaciones;
    }

    public void setLista_numOperaciones(List<PY_numOperaciones_v2> lista_numOperaciones) {
        this.lista_numOperaciones = lista_numOperaciones;
    }

    public PY_catalogosService getPy_catalogosService() {
        return py_catalogosService;
    }

    public void setPy_catalogosService(PY_catalogosService py_catalogosService) {
        this.py_catalogosService = py_catalogosService;
    }

    public int getTotal_r9() {
        return total_r9;
    }

    public void setTotal_r9(int total_r9) {
        this.total_r9 = total_r9;
    }

    public int getTotal_usr_r9() {
        return total_usr_r9;
    }

    public void setTotal_usr_r9(int total_usr_r9) {
        this.total_usr_r9 = total_usr_r9;
    }

    public int getTotal_deur() {
        return total_deur;
    }

    public void setTotal_deur(int total_deur) {
        this.total_deur = total_deur;
    }

    public int getTotal_usr_deur() {
        return total_usr_deur;
    }

    public void setTotal_usr_deur(int total_usr_deur) {
        this.total_usr_deur = total_usr_deur;
    }

    public int getTotal_gral() {
        return total_gral;
    }

    public void setTotal_gral(int total_gral) {
        this.total_gral = total_gral;
    }

    public int getTotal_usuarios() {
        return total_usuarios;
    }

    public void setTotal_usuarios(int total_usuarios) {
        this.total_usuarios = total_usuarios;
    }

    public int getTotal_opera() {
        return total_opera;
    }

    public void setTotal_opera(int total_opera) {
        this.total_opera = total_opera;
    }

    public List<String> getLista_numOperacionesResumen() {
        return lista_numOperacionesResumen;
    }

    public void setLista_numOperacionesResumen(List<String> lista_numOperacionesResumen) {
        this.lista_numOperacionesResumen = lista_numOperacionesResumen;
    }

    public List<String> getLista_historicoOperaciones() {
        return lista_historicoOperaciones;
    }

    public void setLista_historicoOperaciones(List<String> lista_historicoOperaciones) {
        this.lista_historicoOperaciones = lista_historicoOperaciones;
    }

    public List<String> getLista_mesesOrder() {
        return lista_mesesOrder;
    }

    public void setLista_mesesOrder(List<String> lista_mesesOrder) {
        this.lista_mesesOrder = lista_mesesOrder;
    }

    public String getGetDecimalFormat(int number) {
        return new DecimalFormat("###,###.###").format(number);
    }

    public void setGetDecimalFormat(String getDecimalFormat) {
        this.getDecimalFormat = getDecimalFormat;
    }

    public List<PY_userUnicos_v2> getLista_userUnicos() {
        return lista_userUnicos;
    }

    public void setLista_userUnicos(List<PY_userUnicos_v2> lista_userUnicos) {
        this.lista_userUnicos = lista_userUnicos;
    }

    public List<String> getLista_userUnicosTotales() {
        return lista_userUnicosTotales;
    }

    public void setLista_userUnicosTotales(List<String> lista_userUnicosTotales) {
        this.lista_userUnicosTotales = lista_userUnicosTotales;
    }
}
