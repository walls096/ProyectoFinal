package com.walls.repositorio;

import java.awt.Image;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.ImageIcon;

import org.hibernate.Session;

import com.walls.controlador.HibernateUtils;
import com.walls.entidades.Mascota;

public class RepositorioMascota {

	private static List<Mascota> todasLasMascotas;	//OBTIENE LAS MASCOTAS DEL CLIENTE
	private static List<Mascota> unaMascota;		//MASCOTA QUE PASA A SER MODIFICADA
	
	
	public static List<Mascota> obtenerMascotasCliente() {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			List<Mascota> mascotas = (List<Mascota>) session
					.createQuery("from com.walls.entidades.Mascota where codCliente = '" + RepositorioCliente.getCodCliente() + "'", Mascota.class)
					.getResultList();

			todasLasMascotas = mascotas;

			session.getTransaction().commit();

			session.close();
			
			return todasLasMascotas;
		}

		catch (Exception e) {

			System.out.println("Error al recuperar las mascotas del cliente (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
			return null;
		}
		
	}
	
	public static List<Mascota> buscarMascotaPorNombre(String nombre) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			List<Mascota> mascotas = (List<Mascota>) session
					.createQuery("from com.walls.entidades.Mascota where codCliente = '" + RepositorioCliente.getCodCliente() + "' and nombre = '"+nombre+"'", Mascota.class)
					.getResultList();
			
			if(!mascotas.isEmpty()) {
				todasLasMascotas = mascotas;	
			}

			session.getTransaction().commit();

			session.close();
			
			return todasLasMascotas;
		}

		catch (Exception e) {

			System.out.println("Error al recuperar las mascotas del cliente (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
			return null;
		}
		
	}
	
	public static List<Mascota> obtenerTodasLasMascotas() {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			List<Mascota> mascotas = (List<Mascota>) session
					.createQuery("from com.walls.entidades.Mascota ", Mascota.class)
					.getResultList();

			session.getTransaction().commit();

			session.close();
			
			return mascotas;
		}

		catch (Exception e) {

			System.out.println("Error al recuperar las mascotas (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
			return null;
		}
		
	}

	public static void agregarMascota(String nombre, String tipo, String raza) {
		

			Session session = HibernateUtils.getSessionFactory().openSession();
			
			try {

				session.beginTransaction();
				
				List<Mascota> todasMascotas = obtenerTodasLasMascotas();
				
				int id = 1;
				
				if(todasMascotas.size() != 0)
					id = todasMascotas.get(todasMascotas.size()-1).getCodMascota()+1;
				
				Mascota m = new Mascota();
				m.setCodMascota(id);
				m.setNombre(nombre.toUpperCase());
				m.setTipo(tipo.toUpperCase());
				m.setRaza(raza.toUpperCase());
				m.setCodCliente(RepositorioCliente.getCodCliente());
				m.setImagen("default.png");
				
				//Importante guardar en base de datos y en la lista.
				session.save(m);
				todasLasMascotas.add(m);
				

				session.getTransaction().commit();

				session.close();


			}

			catch (Exception e) {

				System.out.println("Error al crear una mascota (SessionFactory).");
				session.getTransaction().rollback();
				session.close();
			}
			
		
		
	}
	
	/**
	 * Método por el cual recupera una mascota del cliente y la almacena en una lista estática 
	 * List<Mascota> unaMascota;
	 * @param id Codigo de la mascota para filtrar por una sola
	 * @return retorna la mascota
	 */
	
	public static List<Mascota> obtenerUnaMascota(int id) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			List<Mascota> mascota = (List<Mascota>) session
					.createQuery("from com.walls.entidades.Mascota where codMascota = '" + id + "'", Mascota.class)
					.getResultList();
			
			unaMascota = mascota;

			session.getTransaction().commit();

			session.close();
			
			return unaMascota;
		}

		catch (Exception e) {

			System.out.println("Error al recuperar las mascotas del cliente (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
			return null;
		}
		
	}
	
	public static void modificarUnaMascota( String nombre, String tipo, String raza, String imagen) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();
			
			
			
			Mascota m = new Mascota();
			m.setCodMascota(unaMascota.get(0).getCodMascota());
			m.setCodCliente(unaMascota.get(0).getCodCliente());
			
			
			if(nombre.equals(""))
				m.setNombre(unaMascota.get(0).getNombre());
			else 
				m.setNombre(nombre.toUpperCase());
			if(tipo.equals(""))
				m.setTipo(unaMascota.get(0).getTipo());
			else 
				m.setTipo(tipo.toUpperCase());
			if(raza.equals(""))
				m.setRaza(unaMascota.get(0).getRaza());
			else 
				m.setRaza(raza.toUpperCase());
			if(imagen.equals(""))
				m.setImagen(unaMascota.get(0).getImagen());
			else {
				
				m.setImagen(imagen);
			}
			
			
			session.update(m);

			session.getTransaction().commit();

			session.close();
			
			todasLasMascotas.clear();
			unaMascota.clear();
			RepositorioMascota.obtenerMascotasCliente();
			
		}

		catch (Exception e) {

			System.out.println("Error al modificar las mascotas del cliente (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
		}
	}
	
	
	public static void eliminarMascota(Mascota m) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			session.delete(m);

			session.getTransaction().commit();

			session.close();
			
		}

		catch (Exception e) {

			System.out.println("Error al borrar las mascotas del cliente (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
		}
		
	}
	
	public static void crearImagen(String nombre) {
		
		String origen = "";
		String destino = "" + nombre;
		
		ImageIcon nueva = new ImageIcon(origen);
        nueva = adaptarImagen(nueva);
        
        try {
            Files.copy(Paths.get(origen),Paths.get(destino));
        } catch (IOException ex) {}
		
		
	}
	
	public static ImageIcon adaptarImagen(ImageIcon i){
        
        Image imagen = i.getImage();
        
        imagen = imagen.getScaledInstance(155, 158, Image.SCALE_SMOOTH);
        
        return new ImageIcon(imagen);
    }
	
	public static void borrarMascotaLista(Mascota o) {
		todasLasMascotas.remove(o);
	}
	
	public static void borrarListaMascota() {
		todasLasMascotas.clear();
	}
	
	public static List<Mascota> getTodasLasMascotas() {
		return todasLasMascotas;
	}
	
	public static List<Mascota> getUnaMascota() {
		return unaMascota;
	}

	
}
