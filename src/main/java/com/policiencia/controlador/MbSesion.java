package com.policiencia.controlador;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


@ManagedBean(name = "mbSesion")
@RequestScoped
@SessionScoped
public class MbSesion {
	private String usuario;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
    
    /*
     * Método para el manejo de Sesión
     * */
    
    public MbSesion(){
    	faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        if(httpServletRequest.getSession().getAttribute("sessionUsuario")!=null)
        {
            usuario=httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
        }
        else
        {
        	usuario = "";
        }
    }

	public String getUsuario() {
		if(usuario.equals(""))
			return "";
		else
			return "Bienvenido, "+ usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


}
