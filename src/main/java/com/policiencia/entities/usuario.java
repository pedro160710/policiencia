package com.policiencia.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



@Entity
public class usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id_usuario;
	private String nombres_usuario;
	private String apellidos_usuario;
	private Date fechaNacimiento_usuario;
	private String email_usuario;
	private String username_usuario;
	private String password_usuario;
	/**
	 * @return the id_usuario
	 */
	public int getId_usuario() {
		return id_usuario;
	}
	/**
	 * @param id_usuario the id_usuario to set
	 */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	/**
	 * @return the nombres_usuario
	 */
	public String getNombres_usuario() {
		return nombres_usuario;
	}
	/**
	 * @param nombres_usuario the nombres_usuario to set
	 */
	public void setNombres_usuario(String nombres_usuario) {
		this.nombres_usuario = nombres_usuario;
	}
	/**
	 * @return the apellidos_usuario
	 */
	public String getApellidos_usuario() {
		return apellidos_usuario;
	}
	/**
	 * @param apellidos_usuario the apellidos_usuario to set
	 */
	public void setApellidos_usuario(String apellidos_usuario) {
		this.apellidos_usuario = apellidos_usuario;
	}
	/**
	 * @return the fechaNacimiento_usuario
	 */
	public Date getFechaNacimiento_usuario() {
		return fechaNacimiento_usuario;
	}
	/**
	 * @param fechaNacimiento_usuario the fechaNacimiento_usuario to set
	 */
	public void setFechaNacimiento_usuario(Date fechaNacimiento_usuario) {
		this.fechaNacimiento_usuario = fechaNacimiento_usuario;
	}
	/**
	 * @return the email_usuario
	 */
	public String getEmail_usuario() {
		return email_usuario;
	}
	/**
	 * @param email_usuario the email_usuario to set
	 */
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	/**
	 * @return the username_usuario
	 */
	public String getUsername_usuario() {
		return username_usuario;
	}
	/**
	 * @param username_usuario the username_usuario to set
	 */
	public void setUsername_usuario(String username_usuario) {
		this.username_usuario = username_usuario;
	}
	/**
	 * @return the password_usuario
	 */
	public String getPassword_usuario() {
		return password_usuario;
	}
	/**
	 * @param password_usuario the password_usuario to set
	 */
	public void setPassword_usuario(String password_usuario) {
		this.password_usuario = password_usuario;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 
}