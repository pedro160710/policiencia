package com.policiencia.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.policiencia.entities.autor;
import com.policiencia.entities.categoria;
import com.policiencia.entities.libro;
import com.policiencia.utils.HibernateUtil;

@ManagedBean(name = "busquedaLibro") 
@SessionScoped
public class BusquedaLibro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -735236043411017297L;


	public BusquedaLibro()
	{
		
	}

	private String textoBusqueda;
	private String opcionBusqueda;
	private List<libro> librosEncontrados = new ArrayList<libro>();
	
	
	/**
	 * @return the opcionBusqueda
	 */
	public String getOpcionBusqueda() {
		return opcionBusqueda;
	}


	/**
	 * @param opcionBusqueda the opcionBusqueda to set
	 */
	public void setOpcionBusqueda(String opcionBusqueda) {
		this.opcionBusqueda = opcionBusqueda;
	}


	/**
	 * @return the textoBusqueda
	 */
	public String getTextoBusqueda() {
		return textoBusqueda;
	}


	/**
	 * @param textoBusqueda the textoBusqueda to set
	 */
	public void setTextoBusqueda(String textoBusqueda) {
		this.textoBusqueda = textoBusqueda;
	}


	/**
	 * @return the librosEncontrados
	 */
	public List<libro> getLibrosEncontrados() {
		return librosEncontrados;
	}


	/**
	 * @param librosEncontrados the librosEncontrados to set
	 */
	public void setLibrosEncontrados(List<libro> librosEncontrados) {
		this.librosEncontrados = librosEncontrados;
	}


	public void buscarCoincidenciaLibros() {
		
		System.out.println("Texto a buscar: "+textoBusqueda);
		System.out.println("Opcion: "+opcionBusqueda);
		
		
		
		librosEncontrados = new ArrayList<libro>();
		
		if(!textoBusqueda.equals(null) && !textoBusqueda.equals(""))
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
        	session.beginTransaction();
        	
        	if(opcionBusqueda.equals("tituloLibro"))
        	{
        		try {
        			List<libro> librosVenta = new ArrayList<libro>();
    	    		//Query query = session.createQuery("SELECT l FROM libro l WHERE l.titulo_libro LIKE '%"+textoBusqueda+"%' ORDER by l.titulo_libro");
    	    		Query query = session.createQuery("SELECT l FROM libro l ORDER by l.titulo_libro");
    	       
    	    		librosVenta = query.list();
    	    		session.getTransaction().commit();
    	    		
    	    		librosEncontrados = librosEncontradosBusquedaBD(librosVenta);
    	        } 
    	        catch (HibernateException e) 
    	        {
    	        	e.printStackTrace();
    	            System.out.println("Error Criteria:" + e.getMessage());
    	        }    
        		
        		
        	}
        	else if(opcionBusqueda.equals("autor"))
        	{
        		try {
        			List<autor> autores = new ArrayList<autor>();
    	    		Query consulta = session.createQuery("SELECT a FROM autor a  ORDER by a.apellido_autor");
    	    		//query.setParameter("texto", textoBusqueda);
    	    		
    	    		
    	    		autores = consulta.list();
    	    		session.getTransaction().commit();
    	    		
    	    		autores = autoresEncontradosBusquedaBD(autores);
    	    		
    	    		librosEncontrados = librosEncontradosAutor(autores);
    	    		
    	        } 
    	        catch (HibernateException e) 
    	        {
    	        	e.printStackTrace();
    	            System.out.println("Error Criteria:" + e.getMessage());
    	        }
        	}
        	else if(opcionBusqueda.equals("categoria"))
        	{
        		try {
        			List<categoria> categorias = new ArrayList<categoria>();
    	    		Query query = session.createQuery("SELECT c FROM categoria c ORDER by c.nombre_categoria");
    	    		//query.setParameter("texto", textoBusqueda);
    	       
    	    		categorias = query.list();
    	    		session.getTransaction().commit();
    	    		
    	    		categorias = categoriasEncontradasBusquedaBD(categorias);
    	    		
    	    		librosEncontrados = librosEncontradosCategoria(categorias); 
    	        } 
    	        catch (HibernateException e) 
    	        {
    	        	e.printStackTrace();
    	            System.out.println("Error Criteria:" + e.getMessage());
    	        }
        	}
        
        	
			
		}
		System.out.println("Libros encontrados: "+librosEncontrados.size());
		direccionarPaginaBusqueda();
             
	}
	
	

	public void direccionarPaginaBusqueda() {
		System.out.println("Redireccionando a pagina de busqueda");
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("../busquedaLibro.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void limpiarBusqueda()
	{
		textoBusqueda = "";
	}
	
	private List<libro> librosEncontradosBusquedaBD(List<libro> listaLibros)
	{
		List<libro> librosEncontrados = new ArrayList<libro>();
		String textoFormateadoBusqueda = textoBusqueda.toLowerCase();
		int tamanoListaLibros = listaLibros.size();
		Pattern p;
		Matcher m;
		p= Pattern.compile("("+textoFormateadoBusqueda+").*");

		for(int i = 0; i < tamanoListaLibros; i++)
		{
			m= p.matcher(listaLibros.get(i).getTitulo_libro().toLowerCase());
			
			if(m.find())
			{
				librosEncontrados.add(listaLibros.get(i));
			}
		}
		
		return librosEncontrados;
	}
	
	private List<autor> autoresEncontradosBusquedaBD(List<autor> listaAutores)
	{
		List<autor> autoresEncontrados = new ArrayList<autor>();
		String textoFormateadoBusqueda = textoBusqueda.toLowerCase();
		int tamanoListaLibros = listaAutores.size();
		Pattern p;
		Matcher nombre;
		Matcher apellido;
		p= Pattern.compile("("+textoFormateadoBusqueda+").*");

		for(int i = 0; i < tamanoListaLibros; i++)
		{
			nombre= p.matcher(listaAutores.get(i).getNombre_autor().toLowerCase());
			apellido= p.matcher(listaAutores.get(i).getApellido_autor().toLowerCase());
			
			if(nombre.find() || apellido.find())
			{
				autoresEncontrados.add(listaAutores.get(i));
			}
		}
		
		return autoresEncontrados;
	}
	
	private List<libro> librosEncontradosAutor(List<autor> listaAutores)
	{
		List<libro> librosEncontrados = new ArrayList<libro>();
		int tamanoListaAutores = listaAutores.size();

		

		for(int i = 0; i < tamanoListaAutores; i++)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	    	
			Query query = session.createQuery("SELECT l FROM libro l WHERE l.id_autor="+listaAutores.get(i).getId_autor()+" ORDER by l.titulo_libro");
			List<libro> libros = query.list();
    		session.getTransaction().commit();
    		
    		librosEncontrados.addAll(libros);
    					
		}
		
		return librosEncontrados;
	}
	
	private List<libro> librosEncontradosCategoria(List<categoria> categorias) {
		List<libro> librosEncontrados = new ArrayList<libro>();
		int tamanoListaCategorias = categorias.size();


		for(int i = 0; i < tamanoListaCategorias; i++)
		{

			Session session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
	    	
			Query query = session.createQuery("SELECT l FROM libro l WHERE l.id_categoria="+categorias.get(i).getId_categoria()+" ORDER by l.titulo_libro");
			List<libro> libros = query.list();
    		session.getTransaction().commit();
    		
    		librosEncontrados.addAll(libros);
    					
		}
		
		return librosEncontrados;
	}


	private List<categoria> categoriasEncontradasBusquedaBD(List<categoria> listaCategorias) {
		List<categoria> categoriasEncontradas = new ArrayList<categoria>();
		String textoFormateadoBusqueda = textoBusqueda.toLowerCase();
		int tamanoListaLibros = listaCategorias.size();
		Pattern p;
		Matcher m;

		p= Pattern.compile("("+textoFormateadoBusqueda+").*");

		for(int i = 0; i < tamanoListaLibros; i++)
		{
			m= p.matcher(listaCategorias.get(i).getNombre_categoria().toLowerCase());
			
			
			if(m.find() )
			{
				categoriasEncontradas.add(listaCategorias.get(i));
			}
		}
		
		return categoriasEncontradas;
	}

}
