package com.walls.repositorio;

import java.util.List;

import org.hibernate.Session;

import com.walls.controlador.HibernateUtils;
import com.walls.entidades.Cita;
import com.walls.entidades.Mascota;

public class RepositorioCita {

	private static List<Cita> citasCliente;
	private static List<Cita> citasFiltradas;
	private static List<Cita> mascotaConCita;
	
	//TODO: NO FUNCIONA
	public static int obtenerIdCita() {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			List<Cita> citaId = (List<Cita>) session
					.createQuery("from com.walls.entidades.Cita c where c.codCita = (select max(cc.codCita) from com.walls.entidades.Cita cc" , Cita.class)
					.getResultList();
			
			
			session.getTransaction().commit();

			session.close();
			
			return citaId.get(0).getCodCita();
		}

		catch (Exception e) {

			System.out.println("Error al recuperar las mascotas del cliente (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
			return 0;
		}
		
	}
	
	public static List<Cita> obtenerCitasCliente() {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			List<Cita> citas = (List<Cita>) session
					.createQuery("from com.walls.entidades.Cita where codCliente = '" + RepositorioCliente.getCodCliente() + "' order by fecha", Cita.class)
					.getResultList();

			citasCliente = citas;

			session.getTransaction().commit();

			session.close();
			
			return citasCliente;
		}

		catch (Exception e) {

			System.out.println("Error al recuperar las mascotas del cliente (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
			return null;
		}
		
	}
	
	//TODO: FALTA POR COMPLETAR EL METODO
	public static List<Cita> obtenerUnaCita(int id) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			List<Cita> cita = (List<Cita>) session
					.createQuery("from com.walls.entidades.Cita where codCita = '" + id + "'", Cita.class)
					.getResultList();


			session.getTransaction().commit();

			session.close();
			
			return cita;
			
		}

		catch (Exception e) {

			System.out.println("Error al recuperar las citas del cliente (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
			return null;
		}
		
	}
	
	public static void crearCita(Cita c) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {

			session.beginTransaction();
			
//			int id = 1;
//			
//			if(citasCliente.size() != 0)
//				id = citasCliente.get(citasCliente.size()-1).getCodCita()+1;
			int id = obtenerIdCita();
			
			c.setCodCita(id);
			session.save(c);
			citasCliente.add(c);
			

			session.getTransaction().commit();

			session.close();


		}

		catch (Exception e) {

			System.out.println("Error al crear una mascota (SessionFactory).");
			session.getTransaction().rollback();
			session.close();
		}
		
	}
	
	public static void eliminarCita(Cita c) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			session.delete(c);

			session.getTransaction().commit();

			session.close();
			
		}

		catch (Exception e) {

			System.out.println("Error al borrar las citas del cliente (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
		}
		
	}
	
	
	public static boolean tieneCita(int idMascota) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			List<Cita> cita = (List<Cita>) session
					.createQuery("from com.walls.entidades.Cita where codMascota = '" + idMascota + 
							"'" + "and codCliente = '" +RepositorioCliente.getCodCliente() +"'", Cita.class)
					.getResultList();

			session.getTransaction().commit();

			session.close();
			
			mascotaConCita = cita;
			
			if(!cita.isEmpty())
				return true;
			else
				return false;
		}

		catch (Exception e) {

			System.out.println("Error filtro and (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
			return false;
		}
		
	}
	
	public static List<Cita> getCitaDeMascota() {
		return mascotaConCita;
	}
	
	public static List<Cita> getCitasCliente() {
		return citasCliente;
	}
	
	public static void eliminarCitasCliente() {
		citasCliente.clear();
	}
	
	public static void eliminarCitaLista(Cita c) {
		citasCliente.remove(c);
	}
	
	
}
