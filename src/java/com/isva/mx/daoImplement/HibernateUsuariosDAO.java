/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isva.mx.daoImplement;

import com.isva.mx.bean.Usuarios;
import com.isva.mx.dao.UsuariosDAO;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author VC6AF18
 */
@Repository("usuariosDAO")
public class HibernateUsuariosDAO implements UsuariosDAO,Serializable{
    private static final long serialVersionUID=1L;
    
    @Autowired
    @Qualifier(value="sessionFactory")
    private SessionFactory sessionFactory;
    
    @Override
    public String getLogin(String usuario, String contrasena) {
        HibernateTemplate ht = new HibernateTemplate(sessionFactory);
        String user="empty";
        List<Usuarios> aux=ht.find("from usuarios where usuario='"+usuario+"' and contrasena='"+contrasena+"' and estatus = 1");
        if(!aux.isEmpty())
        {    
            for (Usuarios u: aux)
                user=u.getUsuario().toLowerCase() + "_" + u.getPerfil() + "_" + u.getNombre();   
        }
        return user;
    }
    
}
