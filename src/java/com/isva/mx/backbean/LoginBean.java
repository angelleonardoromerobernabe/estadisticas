/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isva.mx.backbean;

import com.isva.mx.service.UsuariosService;
import java.io.Serializable;
import java.util.ArrayList;
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
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{
    private static final long serialVersionUID=1L;
    private static final Logger logger = Logger.getLogger(LoginBean.class);
    
    private String usuario;
    private String contrasena;
    private String nombre;
    private String perfil;
    private FacesMessage msg;
    private List<String> images;
       
        
    @ManagedProperty(value = "#{usuariosService}")
    private UsuariosService usuariosService;
    
    public LoginBean() {   
        super();      
    }
    
    @PostConstruct
    public void init(){        
        images = new ArrayList<String>(); 
        for(int i=1;i<=5;i++) {            
            images.add(i + ".jpg");
        }
    }
    
    //Método que valida que los datos no esten vacios
    public boolean valida_datos_login(){
        boolean bandera=true;
        if (usuario.isEmpty()){
            bandera=false;
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: ","El campo 'Usuario' es obligatorio");
        }else if (contrasena.isEmpty()){
            bandera=false;
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: ","El campo 'Contraseña' es obligatorio");
        }
        return bandera;
    }
    
    public String validateUser(){
        logger.info("Inicia login usuario");
        String redirecciona="empty";
        try{
            if(valida_datos_login()){
                String respuesta=usuariosService.getUsuariosDAO().getLogin(usuario, contrasena);
                
                if(!respuesta.equals("empty")){
                    setSessionObj("login", respuesta);
                    datos_usuario();                        
                        if (perfil.equals("USR") || perfil.equals("JEFE")){
                            redirecciona="/faces/users/menu?faces-redirect=true";
                        }else if (perfil.equals("ADM")){
                            redirecciona="/faces/admin/admin_users?faces-redirect=true";
                        }
                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Ok: ","Usuario válidado");
                }else{
                    msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: ","Usuario no válido.");
                }
            }else{
                usuario="";
                contrasena="";
            }            
        }catch(Exception e){
            logger.info("Error: " + e );
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: ","Favor de contactar al administrador.");             
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        return redirecciona;
    }
    
    public void datos_usuario(){
        String[] datos_session=getSessionObj("login").toString().split("_");
        usuario=datos_session[0];
        perfil=datos_session[1];
        nombre=datos_session[2];        
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/faces/bienvenida?faces-redirect=true";
    }
    
    public static Object getSessionObj(String id) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(id);
     }

    public static void setSessionObj(String id,Object obj){
       FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(id, obj);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public UsuariosService getUsuariosService() {
        return usuariosService;
    }

    public void setUsuariosService(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    public List<String> getImages() {
        return images;
    }
}
