
package com.policiencia.controlador;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.hibernate.Session;



import com.policiencia.entities.usuario;
import com.policiencia.utils.HibernateUtil;

@ManagedBean (name="crearUsu")
public class UsuarioControlador {

	private usuario usuario;
	private Calendar Cal= Calendar.getInstance();
	private String rango;
	private String password2 = "";
	public boolean validarPassword =false;
	private MenuControlador direcionar = new MenuControlador();
	
	public UsuarioControlador(){
		usuario  = new usuario();
	}
	
	public void validarPassword(){
		System.out.println(password2);
		System.out.println(usuario.getPassword_usuario());
		if(usuario.getPassword_usuario().equals(password2)){
			validarPassword=true;
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Las Contraseñas no coinciden", "Ingrese Nuevamente"));
			validarPassword=false;
		}
		
	}
	
	public void guardarNombre(){
		//System.out.println(usuario.getFechaNacimiento_Usuario());
		if(usuario.getNombres_usuario().equals("")||usuario.getApellidos_usuario().equals("")
				||usuario.getFechaNacimiento_usuario().equals("")
				||usuario.getPassword_usuario().equals("")
				||usuario.getEmail_usuario().equals("")
				||usuario.getUsername_usuario().equals("")){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Recuerde", "Los campos con * son obligatorios"));
		}else{
			validarPassword();
			if(validarPassword==true){
				Session session = HibernateUtil.getSessionFactory().openSession();//para abrir una nueva sesion
				
				session.beginTransaction();//abrir transaccion
				
				//usuario.setNombres_Usuario(nombre);
				
				//Usuario usuario = new Usuario(nombre);//creacion del objeto a almacenar
				
				session.save(usuario);// el objeto a almacenar
				session.getTransaction().commit();//guardar en la BD
				session.close();//para cerrar la sesio
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", "Felicidades, Usted se ha registrado Exitosamente a POLICIENCIA"));
				
				usuario = new usuario();
				direcionar.direccionarInicio();
				//direccionarInicio();
			}			
		
		}
	}
	
	public usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(usuario usuario) {
		this.usuario = usuario;
	}
	
	public Calendar getCal() {
		return Cal;
	}

	public void setCal(Calendar cal) {
		Cal = cal;
	}

	public String getRango() {
		Integer anioActual=0;
		anioActual= (Cal.get(Calendar.YEAR));
		int inicio,fin;
		inicio=anioActual-95;
		fin=anioActual-8;
		rango =String.valueOf(inicio+":"+fin);
		return rango; 
	}

	public void setRango(String rango) {
		this.rango = rango;
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
