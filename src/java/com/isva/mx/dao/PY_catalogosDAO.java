/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isva.mx.dao;

import com.isva.mx.bean.PY_Adopcion_v2;
import com.isva.mx.bean.PY_detalleOperaciones_v2;
import com.isva.mx.bean.PY_detalleRS_v2;
import com.isva.mx.bean.PY_numOperaciones_v2;
import com.isva.mx.bean.PY_userUnicos_v2;
import java.util.List;

/**
 *
 * @author VC6AF18
 */
public interface PY_catalogosDAO {
    public List<Integer> lista_anios();
    public List<String> lista_meses();
    public Integer get_quincena(int anio, String mes);
    public List<PY_numOperaciones_v2> lista_numOperacionesFiltro(int anio, String mes, int quincena);
    public List<String> lista_numOperacionesFiltroResumen(int anio, String mes, int quincena);
    public List<PY_detalleOperaciones_v2> lista_detOperacionesFiltro(int anio, String mes, int quincena, String region);
    public List<PY_userUnicos_v2> lista_detOperacionesUserUnicos(int anio, String mes, int quincena);
    public List<PY_Adopcion_v2> lista_adopcionFiltro(int anio, String mes, int quincena, String region, String tipo_usuario);
    public List<PY_detalleRS_v2> lista_detalleRSFiltro(int anio, String mes, int quincena, String region);
    public List<String> lista_resumenDetOperacionesAdopcion(int anio, String mes, int quincena);
    public List<String> lista_validacion(int anio, String mes, int quincena);
    public List<String> lista_historicoNumOperaciones(int anio, List<String> meses);  
    public List<String> lista_analiticos(int anio, String mes, int quincena, String region);
    public List<String> lista_usuarioUnicosTotales(int anio, String mes, int quincena);
}
