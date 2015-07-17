package com.policiencia.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



@Entity
public class autor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id_autor;//int(11)
	private String nombre_autor;//varchar(80)
	private String apellido_autor;//varchar(80)
	/**
	 * @return the id_autor
	 */
	public int getId_autor() {
		return id_autor;
	}
	/**
	 * @param id_autor the id_autor to set
	 */
	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}
	/**
	 * @return the nombre_autor
	 */
	public String getNombre_autor() {
		return nombre_autor;
	}
	/**
	 * @param nombre_autor the nombre_autor to set
	 */
	public void setNombre_autor(String nombre_autor) {
		this.nombre_autor = nombre_autor;
	}
	/**
	 * @return the apellido_autor
	 */
	public String getApellido_autor() {
		return apellido_autor;
	}
	/**
	 * @param apellido_autor the apellido_autor to set
	 */
	public void setApellido_autor(String apellido_autor) {
		this.apellido_autor = apellido_autor;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}