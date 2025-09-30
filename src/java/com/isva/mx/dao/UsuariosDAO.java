package com.isva.mx.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.isva.mx.bean.Usuarios;
import java.util.List;

/**
 *
 * @author Alucard
 */
public interface UsuariosDAO {
    public String getLogin(String usuario,String contrasena);
}
