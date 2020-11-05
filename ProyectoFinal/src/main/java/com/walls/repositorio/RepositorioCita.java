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
	
	
}
