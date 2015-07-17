package com.policiencia.controlador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.policiencia.entities.libro;
import com.policiencia.utils.HibernateUtil;

@ManagedBean(name = "menuControlador")
@ViewScoped
public class MenuControlador implements Serializable {


	private libro instLibro = new libro() ;
	private Session session;
	private List<libro> listLibro;


	public static void direccionarCrearUsuario() {

		System.out.println("234235asdad4");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("../registroUsuario.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void direccionarInicio() {
		System.out.println(234234);
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("../index.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void direccionarLogin() {
		System.out.println(234234);
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("../login.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @return the instLibro
	 */
	public libro getInstLibro() {
		return instLibro;
	}




	/**
	 * @param instLibro the instLibro to set
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
	 * @param listLibro the listLibro to set
	 */
	public void setListLibro(List<libro> listLibro) {
		this.listLibro = listLibro;
	}







	public void listarLibroD() throws Exception{
		//instLibro.setId_libro(1);
		try{
			session = HibernateUtil.getSessionFactory().openSession();

			
/*			Query query = session.createSQLQuery("SELECT l.*, a.* from libro l, autor a where l.id_autor = a.id_autor)
					.addEntity(libro.class)
					.addEntity(autor.class);
			listLibro = query.list();*/
			
			
			/*Query query = sessioncreateQuery("from libro join autor on libro.id_autor = autor.id_autor");
			listLibro = query.list();*/
/*			Query query = session.createQuery("from libro where id_libro = :code ");
			query.setParameter("code", 1);*/
			
			Criteria criterio= session.createCriteria(libro.class);
			criterio.addOrder(Order.asc("stock_libro"));
			listLibro= criterio.list();
			System.out.println("\n llego a DAO EN MENU CONTROLADOR\n");
		}catch(Exception e){
			throw e; 
		}

		//return listLibro;
	}

/*	public void cLPD(libro instLibroDetalle) {
		
		LibroControlador instLibroControlador = new LibroControlador();
		instLibroControlador.setInstLibro(instLibroDetalle);
		System.out.println(" SE HA CAPTURADO EL LIBRO");
	}*/
	

}
