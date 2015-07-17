package com.policiencia.controlador;
 
import java.util.List;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean; 
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;



import com.policiencia.entities.usuario;
import com.policiencia.utils.HibernateUtil;

@ManagedBean (name="loginUsu")
@RequestScoped 
@SessionScoped
public class LoginControlador {

	private usuario usuarios;
	private String username="";
	private String password2 = "";
	public boolean validarPassword =false;
	private Session sesion;
	private Transaction tx;
	private final HttpServletRequest httpServletRequest;
	private final FacesContext faceContext;
	
	
	public FacesContext getFaceContext() {
		return faceContext;
	}

	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}

	public LoginControlador(){
		usuarios  = new usuario();
		faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
		
	}
	
	private void iniciaOperacion() throws HibernateException
	{
	    sesion = HibernateUtil.getSessionFactory().openSession();
	    tx = sesion.beginTransaction();
	}
	
	@SuppressWarnings("unchecked")
	public String obtenListaUsuarios() throws HibernateException 
	{ 
		String nombreUsuario="";
		String passwordUsuario="";
		String ruta = "";
		List<usuario> listaContactos = null; 		    	    
	    try 
	    { 
	        iniciaOperacion(); 
	        listaContactos = sesion.createQuery("from usuario").list(); 
	        for(usuario usu: listaContactos){
	        	nombreUsuario= usu.getUsername_usuario();
	        	passwordUsuario=usu.getPassword_usuario();
	        	if(nombreUsuario.equals(username)){
	        		validarPassword=true;
	        		break;
	        	}else{
	        		
	        	}
	        }
	        if(validarPassword==true){
		        if(passwordUsuario.equals(password2)){
	    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@ a POLICIENCIA", nombreUsuario));
	    			httpServletRequest.getSession().setAttribute("sessionUsuario", nombreUsuario);
	    			MenuControlador menu = new MenuControlador();
	    			menu.direccionarInicio();
	    			System.out.println(234234);
	    			ruta="index.xhtml";
	    		}else{
	    			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña incorrecta", "Ingrese nuevamente"));
	    		}
	        }else{
	        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Este usuario", "No se encuentra registado en el sistema"));
	        }
	    }finally 
	    { 
	        sesion.close(); 
	    }  	    
	    return ruta; 
		
	}
	
	public void validarLogin(){
		if(username.equals("")||password2.equals("")){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Recuerde", "Los campos con * son obligatorios"));
		}else{	 
			obtenListaUsuarios();
		}
	}
	
	public usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(usuario usuarios) {
		this.usuarios = usuarios;
	}

	public Session getSesion() {
		return sesion;
	}

	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}

	public Transaction getTx() {
		return tx;
	}

	public void setTx(Transaction tx) {
		this.tx = tx;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword2() {
		return password2;
	}


	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public boolean isValidarPassword() {
		return validarPassword;
	}

	public void setValidarPassword(boolean validarPassword) {
		this.validarPassword = validarPassword;
	}

}
