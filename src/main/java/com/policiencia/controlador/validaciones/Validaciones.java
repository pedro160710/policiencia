package com.policiencia.controlador.validaciones;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



@ManagedBean(name = "validar")
@SessionScoped
public class Validaciones {
	/*
	 * */
	public static boolean validarLetras(String dato) {
		String expresionRegular = "[A-Za-z]*";
		String cadenaAEvaluar = dato;
		boolean validar = false;
		boolean b = Pattern.matches(expresionRegular, cadenaAEvaluar);
		if (b) {
			validar = true;
		} else {
			validar = false;
			FacesContext
			.getCurrentInstance()
			.addMessage(
					null,
					new FacesMessage(
							FacesMessage.SEVERITY_FATAL,
							"", "Ingrese caracteres invalidos (En un campo donde solo esta permitido ingresar letras)"));
		}
		return validar;
	}

	/*
	 * Metodo que valida que el Usuario tenga entre 18 a 100 anios de edad
	 * */	
	public static boolean validaFechaNacLector (Date fechaNacLector){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fechaCadena = sdf.format(fechaNacLector);
		String anoS = fechaCadena.substring(0, 4);
		int ano = Integer.parseInt(anoS);
		Calendar fechaDevolucion = Calendar.getInstance();
		boolean validacion = false;
		int anoActual = fechaDevolucion.get(Calendar.YEAR);
		if(ano>(anoActual-18)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Usted debe ser mayor de 18 años para poder registrarse"));
			validacion = false;
		}else if(ano<=(anoActual-18)&& ano >= (anoActual-100)){
			validacion = true;
		}else{
			validacion = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Fecha de nacimiento mal ingresada"));
		}			
		return validacion;
	}

	/*
	 * Metodo que valida si la direccion de correo es valida
	 * */
	public static boolean  validarMail(String dato) {
		String expresionRegular = "^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,4}$";
		String cadenaAEvaluar = dato;
		boolean validacion = false;
		boolean b = Pattern.matches(expresionRegular,cadenaAEvaluar);
		if(b){
			validacion = true;
		}else{
			validacion = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "", "Correo electronico incorrecto"));
		}
		return validacion ;
	}


}
