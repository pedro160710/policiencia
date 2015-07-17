package com.policiencia.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.policiencia.entities.categoria;
import com.policiencia.entities.libro;
import com.policiencia.utils.HibernateUtil;

@ManagedBean(name = "categorias") 
@SessionScoped
public class CategoriaControlador {

	private List<categoria> listaCategorias = new ArrayList<categoria>();
	public CategoriaControlador() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the listaCategorias
	 */
	public List<categoria> getListaCategorias() {
		obtenerCategorias();
		return listaCategorias;
	}

	/**
	 * @param listaCategorias the listaCategorias to set
	 */
	public void setListaCategorias(List<categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public void obtenerCategorias() {
			
			//System.out.println("Texto a buscar: "+textoBusqueda);
			//System.out.println("Opcion: "+opcionBusqueda);
			
			
			
			listaCategorias = new ArrayList<categoria>();
			
			Session session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	    	
	    	try {
	    		
	    		//Query query = session.createQuery("SELECT l FROM libro l WHERE l.titulo_libro LIKE '%"+textoBusqueda+"%' ORDER by l.titulo_libro");
	    		Query query = session.createQuery("SELECT c FROM categoria c ORDER by c.nombre_categoria");
	       
	    		listaCategorias = query.list();
	    		session.getTransaction().commit();
	    		
	        } 
	        catch (HibernateException e) 
	        {
	        	e.printStackTrace();
	            System.out.println("Error Criteria:" + e.getMessage());
	        } 
	    	
	    	System.out.println("CATEGORIAS: "+listaCategorias.size());
		}	
	
	public void actualizarDetalleLibro(categoria categoria)
	{
		
	}
}
