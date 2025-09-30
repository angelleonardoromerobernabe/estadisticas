/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isva.mx.daoImplement;

import com.isva.mx.bean.PY_Adopcion_v2;
import com.isva.mx.bean.PY_detalleOperaciones_v2;
import com.isva.mx.bean.PY_detalleRS_v2;
import com.isva.mx.bean.PY_numOperaciones_v2;
import com.isva.mx.bean.PY_userUnicos_v2;
import com.isva.mx.dao.PY_catalogosDAO;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author VC6AF18
 */
@Repository("py_numOperacionesDAO")
public class HibernatePY_catalogosDAO implements PY_catalogosDAO, Serializable{
    private static final long serialVersionUID=1L;
    
    @Autowired
    @Qualifier(value="sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Integer> lista_anios() {
        HibernateTemplate ht = new HibernateTemplate(sessionFactory);
        Session session = ht.getSessionFactory().openSession();
        String consulta = "SELECT DISTINCT(DATE_FORMAT(mes, \"%Y\")) FROM py_numOperaciones_v2 ORDER BY 1 DESC";
        SQLQuery query = session.createSQLQuery(consulta);
        List<Integer> lista_anios = query.list();
        session.close();
        return lista_anios;
    }

    @Override
    public List<String> lista_meses() {
        HibernateTemplate ht = new HibernateTemplate(sessionFactory);
        Session session = ht.getSessionFactory().openSession();
        //SELECT distinct DATE_FORMAT(mes, '%b') fecha FROM py_numOperaciones GROUP BY mes (cuando se repitan)
        String consulta = "SELECT DATE_FORMAT(mes, '%b') fecha FROM py_numOperaciones_v2 GROUP BY mes ORDER BY mes DESC";
        SQLQuery query = session.createSQLQuery(consulta);
        List<String> lista_meses = query.list();
        session.close();
        return lista_meses;
    }

    @Override
    public List<PY_numOperaciones_v2> lista_numOperacionesFiltro(int anio, String mes, int quincena) {
        HibernateTemplate ht = new HibernateTemplate(sessionFactory);
        List<PY_numOperaciones_v2> lista_numOperaciones = ht.find("from py_numOperaciones_v2 WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' AND quincena = " + quincena);
        return lista_numOperaciones;
    }

    @Override
    public List<PY_detalleOperaciones_v2> lista_detOperacionesFiltro(int anio, String mes, int quincena, String region) {
        HibernateTemplate ht = new HibernateTemplate(sessionFactory);
        String sentencia="from py_detalleOperaciones_v2 WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' AND quincena = " + quincena;
        if (region.equals("r9")){
            sentencia="from py_detalleOperaciones_v2 WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' AND quincena = " + quincena + " AND (region_ejecutivo = 'R09' OR (region_ejecutivo = 'N/A' AND region_admin = 'R09'))";
        }else if (region.equals("deur")){
            sentencia="from py_detalleOperaciones_v2 WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' AND quincena = " + quincena + " AND (region_ejecutivo != 'R09' OR (region_ejecutivo = 'N/A' AND region_admin != 'R09'))";
        }        
        List<PY_detalleOperaciones_v2> lista_detOperaciones = ht.find(sentencia);
        return lista_detOperaciones;
    }

    @Override
    public List<PY_Adopcion_v2> lista_adopcionFiltro(int anio, String mes, int quincena, String region, String tipo_usuario) {
        HibernateTemplate ht = new HibernateTemplate(sessionFactory);
        String sentencia="from py_adopcion_v2 WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' AND quincena = " + quincena + " AND TIPO_USUARIO IN (" + tipo_usuario + ")";
        if (region.equals("r9")){
            sentencia="from py_adopcion_v2 WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' AND quincena = " + quincena + " AND (region_ejecutivo = 'R09' OR (region_ejecutivo = 'N/A' AND region_admin = 'R09')) AND TIPO_USUARIO IN (" + tipo_usuario + ")";
        }else if (region.equals("deur")){
            sentencia="from py_adopcion_v2 WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' AND quincena = " + quincena + " AND (region_ejecutivo != 'R09' OR (region_ejecutivo = 'N/A' AND region_admin != 'R09')) AND TIPO_USUARIO IN (" + tipo_usuario + ")";
        }        
        List<PY_Adopcion_v2> lista_adopcion = ht.find(sentencia);
        return lista_adopcion;
    }

    @Override
    public List<PY_detalleRS_v2> lista_detalleRSFiltro(int anio, String mes, int quincena, String region) {
        HibernateTemplate ht = new HibernateTemplate(sessionFactory);
        String sentencia="from py_detalleRS_v2 WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' AND quincena = " + quincena;
        if (region.equals("r9")){
            sentencia="from py_detalleRS_v2 WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' AND quincena = " + quincena + " AND (region_ejecutivo = 'R09' OR (region_ejecutivo = 'N/A' AND region_admin_gral = 'R09'))";
        }else if (region.equals("deur")){
            sentencia="from py_detalleRS_v2 WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' AND quincena = " + quincena + " AND (region_ejecutivo != 'R09' OR (region_ejecutivo = 'N/A' AND region_admin_gral != 'R09'))";
        }
        List<PY_detalleRS_v2> lista_detalleRS = ht.find(sentencia);
        return lista_detalleRS;
    }

    @Override
    public List<String> lista_resumenDetOperacionesAdopcion(int anio, String mes, int quincena) {
        HibernateTemplate ht = new HibernateTemplate(sessionFactory);
        Session session = ht.getSessionFactory().openSession();
        String consulta = "SELECT a.alias, SUM(a.operaciones), b.total_rfc "
                + "FROM py_detalleOperaciones_v2 a, py_adopcion_v2 b  "
                + "WHERE a.alias = b.alias  "
                + "AND DATE_FORMAT(a.mes, \'%b-%Y\') = '" + mes + "-" + anio + "' "
                + "AND a.quincena = " + quincena 
                + " AND a.quincena = b.quincena "
                + "AND DATE_FORMAT(a.mes, \'%b-%Y\') = DATE_FORMAT(b.mes, \'%b-%Y\') " 
                + "GROUP BY a.alias, b.total_rfc";
        SQLQuery query = session.createSQLQuery(consulta);
        List<String> lista_resumenDetOperAdopcion = query.list();
        session.close();
        return lista_resumenDetOperAdopcion;
    }

    @Override
    public List<String> lista_numOperacionesFiltroResumen(int anio, String mes, int quincena) {
        HibernateTemplate ht = new HibernateTemplate(sessionFactory);
        Session session = ht.getSessionFactory().openSession();
        String consulta = "SELECT funcionalidad, sum(r9), sum(deur), sum(alias_r9), sum(alias_deur) "
                + "FROM py_numOperaciones_v2 "
                + "WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' "
                + "AND quincena = " + quincena 
                + " GROUP BY funcionalidad";
        SQLQuery query = session.createSQLQuery(consulta);
        List<String> lista_numOperacionesResumen = query.list();
        session.close();
        return lista_numOperacionesResumen;
    }

    @Override
    public List<String> lista_validacion(int anio, String mes, int quincena) {
        HibernateTemplate ht = new HibernateTemplate(sessionFactory);
        Session session = ht.getSessionFactory().openSession();
        String consulta = "SELECT  'Número Operaciones', SUM(r9) + SUM(deur) total FROM py_numOperaciones_v2 "
                + "WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' "
                + "AND quincena = " + quincena + " "
                + "UNION ALL SELECT 'Detalle Operaciones', SUM(operaciones) total FROM py_detalleOperaciones_v2 "
                + "WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' "
                + "AND quincena = " + quincena + " "
                + "UNION ALL SELECT 'Adopción', SUM(total_rfc) total FROM py_adopcion_v2 "
                + "WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' "
                + "AND TIPO_USUARIO = 1 AND quincena = " + quincena + " "
                + "UNION ALL SELECT 'Detalle Razones Sociales', COUNT(DISTINCT(CONCAT_WS('_',REPLACE(alias,'ASESORIA','ASESORKA'),rfc_empresa))) total FROM py_detalleRS_v2 "
                + "WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' "
                + "AND quincena = " + quincena + " "
                + "UNION ALL SELECT 'Total líneas', SUM(total_lineas) total FROM py_adopcion_v2 "
                + "WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' "
                + "AND TIPO_USUARIO = 1 AND quincena = " + quincena;
        SQLQuery query = session.createSQLQuery(consulta);
        List<String> lista_validacion = query.list();
        session.close();
        return lista_validacion;
    }

    @Override
    public List<String> lista_historicoNumOperaciones(int anio, List<String> meses) {
        HibernateTemplate ht = new HibernateTemplate(sessionFactory);
        Session session = ht.getSessionFactory().openSession();
        String aux_sql="", aux_meses="", consulta="";
        //Solo se mostrar los ultimos 4 meses
        for (int i=3; i>=0; i--){
            aux_sql += "sum(CASE WHEN quincena=1 AND DATE_FORMAT(mes,'%b-%Y') = '" + meses.get(i) + "-" + anio + "' THEN r9 ELSE NULL END) +  sum(CASE WHEN quincena=1 AND DATE_FORMAT(mes,'%b-%Y') = '" + meses.get(i) + "-" + anio + "' THEN deur ELSE NULL END) 'QUINCENA_" + meses.get(i) + "-" + anio +"',";
            aux_sql += "sum(CASE WHEN quincena=2 AND DATE_FORMAT(mes,'%b-%Y') = '" + meses.get(i) + "-" + anio + "' THEN r9 ELSE NULL END) +  sum(CASE WHEN quincena=2 AND DATE_FORMAT(mes,'%b-%Y') = '" + meses.get(i) + "-" + anio + "' THEN deur ELSE NULL END) 'MES_" + meses.get(i) + "-" + anio +"',";
            aux_meses += "'" + meses.get(i) + "-" + anio + "',";
        }
        aux_sql=aux_sql.substring(0,aux_sql.length()-1);
        aux_meses=aux_meses.substring(0,aux_meses.length()-1);
        consulta = "SELECT  funcionalidad, " + aux_sql + " FROM py_numOperaciones_v2 "
                + "WHERE DATE_FORMAT(mes,'%b-%Y') IN (" + aux_meses + ") "
                + "GROUP BY funcionalidad";
        SQLQuery query = session.createSQLQuery(consulta);
        List<String> lista_historicoNumOperaciones = query.list();
        session.close();
        return lista_historicoNumOperaciones;
    }

    @Override
    public List<String> lista_analiticos(int anio, String mes, int quincena, String region) {
        HibernateTemplate ht = new HibernateTemplate(sessionFactory);
        Session session = ht.getSessionFactory().openSession();
        String aux_region=" AND a.region_ejecutivo LIKE 'R0%' ";
        if (region.equals("r9")){
            aux_region = " AND (a.region_ejecutivo = 'R09' OR (a.region_ejecutivo = 'N/A' AND a.region_admin = 'R09')) ";
        }else if (region.equals("deur")){
            aux_region = " AND (a.region_ejecutivo != 'R09' OR (a.region_ejecutivo = 'N/A' AND a.region_admin != 'R09')) ";
        }
            
        String consulta = "SELECT a.alias, a.id_alias, a.administrador, a.region_admin, a.ejecutivo, a.region_ejecutivo, a.ejecutivo_universal, SUM(b.visitas) "
                + "FROM py_detalleOperaciones_v2 a, py_analiticos b  "
                + "WHERE a.id_alias = b.id_alias  "
                + "AND DATE_FORMAT(a.mes, \'%b-%Y\') = '" + mes + "-" + anio + "' "
                + "AND a.quincena = " + quincena 
                + " AND a.quincena = b.quincena "
                + " AND a.quincena = b.quincena "
                + aux_region
                + "AND DATE_FORMAT(a.mes, \'%b-%Y\') = DATE_FORMAT(b.mes, \'%b-%Y\') " 
                + "GROUP BY a.alias, a.id_alias, a.administrador, a.region_admin, a.ejecutivo, a.region_ejecutivo, a.ejecutivo_universal";
        SQLQuery query = session.createSQLQuery(consulta);
        List<String> lista_analiticos = query.list();
        session.close();
        return lista_analiticos;
    }  

    @Override
    public List<PY_userUnicos_v2> lista_detOperacionesUserUnicos(int anio, String mes, int quincena) {
        HibernateTemplate ht = new HibernateTemplate(sessionFactory);
        String sentencia="from py_userUnicos_v2 WHERE DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "' AND quincena = " + quincena;
        List<PY_userUnicos_v2> lista_usuariosUnicos = ht.find(sentencia);
        return lista_usuariosUnicos;
    }

    @Override
    public Integer get_quincena(int anio, String mes) {
        HibernateTemplate ht = new HibernateTemplate(sessionFactory);
        Session session = ht.getSessionFactory().openSession();
        String consulta = "SELECT MAX(quincena) FROM py_numOperaciones_v2 WHERE DATE_FORMAT(mes, '%b-%Y') = '" + mes + "-" + anio + "' ORDER BY 1 DESC;";
        SQLQuery query = session.createSQLQuery(consulta);
        List<Integer> lista_meses = query.list();
        int resultado = lista_meses.get(0);
        session.close();
        return resultado;
    }

    @Override
    public List<String> lista_usuarioUnicosTotales(int anio, String mes, int quincena) {
        HibernateTemplate ht = new HibernateTemplate(sessionFactory);
        Session session = ht.getSessionFactory().openSession();
        String consulta = " SELECT " +
"  ( COUNT(DISTINCT CASE WHEN REGION_EJECUTIVO = 'R09' THEN ADMINISTRADOR END ) + " +
"  COUNT(DISTINCT CASE WHEN REGION_EJECUTIVO = 'N/A' AND REGION_ADMIN = 'R09' THEN ADMINISTRADOR END ) ) as Usuarios_R9," +
"  ( COUNT(DISTINCT CASE WHEN REGION_EJECUTIVO != 'R09' THEN ADMINISTRADOR END ) + " +
"  COUNT(DISTINCT CASE WHEN REGION_EJECUTIVO = 'N/A' AND REGION_ADMIN != 'R09' THEN ADMINISTRADOR END ) ) as Usuarios_DEUR" +
" FROM py_detalleOperaciones_v2 " +
" WHERE QUINCENA = " + quincena +
" AND DATE_FORMAT(mes, \'%b-%Y\') = '" + mes + "-" + anio + "'";
        SQLQuery query = session.createSQLQuery(consulta);
        List<String> lista_resultado = query.list();
        session.close();
        return lista_resultado;
    }
}
