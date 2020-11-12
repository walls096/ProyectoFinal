package com.walls.repositorio;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.walls.controlador.HibernateUtils;
import com.walls.entidades.Cita;

public class RepositorioCita {

	private static List<Cita> citasCliente;
	private static List<Cita> unaCita;
	private static List<Cita> mascotaConCita;
	private static String[] horasDisponibles = {
			"08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00",
			"16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30"};
	
	//TODO: NO FUNCIONA
	public static int obtenerIdCita() {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			List<Cita> citaId = (List<Cita>) session
					.createQuery("SELECT MAX(codCita c) from com.walls.entidades.Cita c" , Cita.class)
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
	
	public static boolean citaDisponible(Date fecha, String hora) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			List<Cita> citaDisponible = (List<Cita>) session
					.createQuery("from com.walls.entidades.Cita where fecha = '"+fecha
							+ "' and hora = '" + hora + "'" , Cita.class)
					.getResultList();
			
			
			session.getTransaction().commit();

			session.close();
			
			if(citaDisponible.isEmpty()) {
				return true;
			}else {
				return false;
			}
			
		}

		catch (Exception e) {

			System.out.println("Error al recuperar las mascotas del cliente (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
			return false;
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

			unaCita = cita;
			
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
	
	public static List<Cita> getUnaCita(){
		return unaCita;
	}
	
	public static String[] getHorasDisponibles(){
		return horasDisponibles;
	}
	
	public static void eliminarCitasCliente() {
		citasCliente.clear();
		unaCita.clear();
		mascotaConCita.clear();
	}
	
	public static void eliminarCitaLista(Cita c) {
		citasCliente.remove(c);
	}
	
	
}
