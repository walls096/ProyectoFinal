package com.walls.repositorio;

import java.util.List;

import org.hibernate.Session;

import com.walls.controlador.HibernateUtils;
import com.walls.entidades.Cita;

public class RepositorioCita {

private static List<Cita> citasCliente;
	
	
	public static List<Cita> obtenerCitasCliente() {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			List<Cita> citas = (List<Cita>) session
					.createQuery("from com.walls.entidades.Cita where codCliente = '" + RepositorioCliente.getCodCliente() + "'", Cita.class)
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
	public static void eliminarCita() {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			List<Cita> citas = (List<Cita>) session
					.createQuery("from com.walls.entidades.Cita where codCliente = '" + RepositorioCliente.getCodCliente() + "'", Cita.class)
					.getResultList();

			citasCliente = citas;

			session.getTransaction().commit();

			session.close();
			
		}

		catch (Exception e) {

			System.out.println("Error al recuperar las mascotas del cliente (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
		}
		
	}
	
	//TODO: COMPROBAR QUE DEVUELVE DATOSS
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
			
			if(null != cita)
				return true;
			else
				return false;
		}

		catch (Exception e) {

			System.out.println("Error no se puede comprobar que tiene cita (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
			return false;
		}
		
	}
	
	
}
