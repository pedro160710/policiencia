package com.policiencia.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.policiencia.entities.libro;
import com.policiencia.utils.HibernateUtil;
//@Named

//@SessionScoped
//@RequestScoped
@ManagedBean(name = "libroControlador")
public class LibroControlador {

	private libro instLibro = new libro();
	// private LibroDAO instLibroDAO = new LibroDAO() ;
	// from DAO
	private Session session;
	private List<libro> listLibro = new ArrayList<libro>();

	public LibroControlador() {

	}

	/*
	 * public void listarLibroC() {
	 * System.out.println("\n llego a Controlador 1\n");
	 * //receptarLibroFromPrincipal();
	 * System.out.println("\n llego a Controlador 2\n"); try { this.listLibro =
	 * listarLibroD(); } catch (Exception e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } }
	 */

	/**
	 * @return the instLibro
	 */
	public libro getInstLibro() {
		return instLibro;
	}

	/**
	 * @param instLibro
	 *            the instLibro to set
	 */
	public void setInstLibro(libro instLibro) {
		this.instLibro = instLibro;
	}

	/**
	 * @return the listLibro
	 */
	public List<libro> getListLibro() {
		return listLibro;
	}

	/**
	 * @param listLibro
	 *            the listLibro to set
	 */
	public void setListLibro(List<libro> listLibro) {
		this.listLibro = listLibro;
	}

	/**
	 * Mètod para añadir al carrito un libro
	 */
	public void aniadirAlCarrito() {

	}

	/**
	 * Metodo para listar los atributos de un libro seleccionado de la BD
	 * 
	 * @return
	 * @throws Exception
	 */

	public void listarLibroD() throws Exception {

		/*	instLibro.setId_libro(1);
		instLibro.setId_categoria(22);
		instLibro.setId_autor(8);
		instLibro.setTitulo_libro("El ultimo borbon");
		instLibro.setPrecio_libro(25);
		// instLibro.sinopsis_libro;// text
		instLibro.setRuta_imagen_libro("/Imagenes/elUltimoBorbon.jpg");
		instLibro.setStock_libro(58);*/

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			 Criteria criterio=session.createCriteria(libro.class);
			// .add(Restrictions.eq( "id_libro", new Integer(1))).list();
			 criterio.addOrder(Order.asc("id_libro"));
			 listLibro= criterio.list();
			/*listLibro = session
					.createCriteria(libro.class)
					.add(Restrictions.like("titulo_libro", "El ultimo borbon%"))
					.setMaxResults(1).list();*/
			// .add(Restrictions.eq( "id_libro", new Integer(1))).list();
			System.out.println("\n llego a DAO EN LIBRO CONTROLADOR\n");
		} catch (Exception e) {
			throw e;
		}
		// return listLibro;
	}
	public String capturarLibroDetalle(libro instLibroFromMenu){
		this.instLibro= instLibroFromMenu;
		return "detallesLibro.xhtml";
	}
	

	
}
