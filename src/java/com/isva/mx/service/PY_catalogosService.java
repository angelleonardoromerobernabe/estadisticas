/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isva.mx.service;

import com.isva.mx.dao.PY_catalogosDAO;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author VC6AF18
 */
@Service("py_catalogosService")
public class PY_catalogosService implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private PY_catalogosDAO py_catalogos;

    public PY_catalogosDAO getPy_catalogos() {
        return py_catalogos;
    }
}
