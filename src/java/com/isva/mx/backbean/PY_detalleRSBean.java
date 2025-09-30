/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isva.mx.backbean;

import com.isva.mx.bean.PY_detalleRS_v2;
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
@ManagedBean(name = "py_detalleRSBean")
@SessionScoped
public class PY_detalleRSBean implements Serializable{
    private static final long serialVersionUID=1L;
    private static final Logger logger = Logger.getLogger(PY_detalleRSBean.class);
    
    private final PY_detalleRS_v2 py_detalleRS;    
    private List<String> lista_mes;
    private List<Integer> lista_anio;
    private String idSeleccionadoMes;
    private String idSeleccionadoRegion;
    private int idSeleccionadoAnio;
    private int idSeleccionadoQuincena;    
    private List<PY_detalleRS_v2> lista_detalleRS;
    private int total_registros;
    
    @ManagedProperty(value = "#{py_catalogosService}")
    private PY_catalogosService py_catalogosService;
    
    FacesMessage msg;
    
    public PY_detalleRSBean() {   
        super();      
        py_detalleRS = new PY_detalleRS_v2();
    }
    
    @PostConstruct
    public void init(){
        logger.info("Obtiene información de filtros");
        lista_mes = py_catalogosService.getPy_catalogos().lista_meses();
        lista_anio = py_catalogosService.getPy_catalogos().lista_anios();
        idSeleccionadoMes = lista_mes.get(0);
        idSeleccionadoAnio = Integer.parseInt(String.valueOf(lista_anio.get(0)));
        idSeleccionadoQuincena = py_catalogosService.getPy_catalogos().get_quincena(idSeleccionadoAnio, idSeleccionadoMes);
        idSeleccionadoRegion = "todo";
        lista_detalleRS = py_catalogosService.getPy_catalogos().lista_detalleRSFiltro(idSeleccionadoAnio, idSeleccionadoMes, idSeleccionadoQuincena, idSeleccionadoRegion);
        total_registros();
    }
    
    public boolean valida_filtros(){
        boolean bandera=true;
        if (idSeleccionadoMes.equals("0") || idSeleccionadoAnio==0){
            bandera=false;
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: ","El año/mes es obligatorio.");
        }
        return bandera;
    }
    
    public void operacionFiltro(){
        logger.info("Obtiene información con filtros del usuario");
        if (valida_filtros()){
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Consulta: ","Actualizando información");
            lista_detalleRS = py_catalogosService.getPy_catalogos().lista_detalleRSFiltro(idSeleccionadoAnio, idSeleccionadoMes, idSeleccionadoQuincena, idSeleccionadoRegion);
            total_registros();
        }else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: ","Datos incompletos");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void exporter_postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        wb.setSheetName(wb.getSheetIndex(sheet), "detalleRazonesSociales_"+idSeleccionadoMes+"_"+idSeleccionadoAnio);
        
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
    
    public void total_registros(){
        total_registros=0;
        for(PY_detalleRS_v2 total : lista_detalleRS) {
            total_registros += 1;
        }
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

    public List<PY_detalleRS_v2> getLista_detalleRS() {
        return lista_detalleRS;
    }

    public void setLista_detalleRS(List<PY_detalleRS_v2> lista_detalleRS) {
        this.lista_detalleRS = lista_detalleRS;
    }

    public PY_catalogosService getPy_catalogosService() {
        return py_catalogosService;
    }

    public void setPy_catalogosService(PY_catalogosService py_catalogosService) {
        this.py_catalogosService = py_catalogosService;
    }

    public String getIdSeleccionadoRegion() {
        return idSeleccionadoRegion;
    }

    public void setIdSeleccionadoRegion(String idSeleccionadoRegion) {
        this.idSeleccionadoRegion = idSeleccionadoRegion;
    }

    public int getTotal_registros() {
        return total_registros;
    }

    public void setTotal_registros(int total_registros) {
        this.total_registros = total_registros;
    }
    
}
