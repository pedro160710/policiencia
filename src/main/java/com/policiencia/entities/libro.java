package com.policiencia.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



@Entity
public class libro implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id_libro;//int(11)
	private int	id_categoria;//int(11)
	private int id_autor;//int(11)
	private String titulo_libro;//varchar(50)
	private float precio_libro;	//decimal(5,2)
	private String sinopsis_libro;//	text
	private String ruta_imagen_libro;//	varchar(128)
	private int stock_libro;//int(11)
	/**
	 * @return the id_libro
	 */
	public int getId_libro() {
		return id_libro;
	}
	/**
	 * @param id_libro the id_libro to set
	 */
	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
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
	 * @return the titulo_libro
	 */
	public String getTitulo_libro() {
		return titulo_libro;
	}
	/**
	 * @param titulo_libro the titulo_libro to set
	 */
	public void setTitulo_libro(String titulo_libro) {
		this.titulo_libro = titulo_libro;
	}
	/**
	 * @return the precio_libro
	 */
	public float getPrecio_libro() {
		return precio_libro;
	}
	/**
	 * @param precio_libro the precio_libro to set
	 */
	public void setPrecio_libro(float precio_libro) {
		this.precio_libro = precio_libro;
	}
	/**
	 * @return the sinopsis_libro
	 */
	public String getSinopsis_libro() {
		return sinopsis_libro;
	}
	/**
	 * @param sinopsis_libro the sinopsis_libro to set
	 */
	public void setSinopsis_libro(String sinopsis_libro) {
		this.sinopsis_libro = sinopsis_libro;
	}
	/**
	 * @return the ruta_imagen_libro
	 */
	public String getRuta_imagen_libro() {
		return ruta_imagen_libro;
	}
	/**
	 * @param ruta_imagen_libro the ruta_imagen_libro to set
	 */
	public void setRuta_imagen_libro(String ruta_imagen_libro) {
		this.ruta_imagen_libro = ruta_imagen_libro;
	}
	/**
	 * @return the stock_libro
	 */
	public int getStock_libro() {
		return stock_libro;
	}
	/**
	 * @param stock_libro the stock_libro to set
	 */
	public void setStock_libro(int stock_libro) {
		this.stock_libro = stock_libro;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}