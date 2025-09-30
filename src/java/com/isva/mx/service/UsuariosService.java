/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isva.mx.service;

import com.isva.mx.dao.UsuariosDAO;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author VC6AF18
 */
@Service("usuariosService")
public class UsuariosService implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private UsuariosDAO usuariosDAO;

    public UsuariosDAO getUsuariosDAO() {
        return usuariosDAO;
    }
       
}
