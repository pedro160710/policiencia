package com.policiencia.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



@Entity
public class categoria implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id_categoria;//int(11)
	private String nombre_categoria;//varchar(50)
	/**
	 * @return the id_categoria
	 */
	public int getId_categoria() {
		return id_categoria;
	}
	/**
	 * @param id_categoria the id_categoria to set
	 */
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	/**
	 * @return the nombre_categoria
	 */
	public String getNombre_categoria() {
		return nombre_categoria;
	}
	/**
	 * @param nombre_categoria the nombre_categoria to set
	 */
	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}