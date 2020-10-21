package com.walls.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.walls.entidades.Clinica;
import com.walls.entidades.ClinicaId;

public class Sentencias {

	private static List<Clinica> datosClinica;
	private static List<Clinica> todasLasCLinicas;

	// Comprueba que los datos introducidos en el login aparecen en la base de
	// datos.
	public static boolean compruebaLogin(String mail) {

		// abre la sesion con hibernate
		Session session = HibernateUtils.getSessionFactory().openSession();

		// recupera la sesion actual
//		this.sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {

			session.beginTransaction();

			List<Clinica> clinica = (List<Clinica>) session
					.createQuery("from com.walls.entidades.Clinica where mail = '" + mail + "'", Clinica.class)
					.getResultList();

			datosClinica = clinica;

			session.getTransaction().commit();

			session.close();

			if (!clinica.isEmpty())
				return true;
			else
				return false;

		}

		catch (Exception e) {

			System.out.println("Error en la session (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
			return false;
		}

	}

	public static boolean compruebaPass(String pass) {

		if (datosClinica.get(0).getId().getNombre().equalsIgnoreCase(pass)) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean registrarClinica(String mail, String pass) {

		// abre la sesion con hibernate
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		
		try {

			session.beginTransaction();
			
			todasLasClinicas();
			int id = todasLasCLinicas.size();
			
			Clinica nueva = new Clinica();
			nueva.setId(new ClinicaId(id,pass,"",mail,0));
			
			session.save(nueva);

			session.getTransaction().commit();

			session.close();


		}

		catch (Exception e) {

			System.out.println("Error al crear nueva clinica.");
			session.getTransaction().rollback();
			session.close();
			return false;
		}
		
		return true;
	}

	public static void todasLasClinicas() {

		// abre la sesion con hibernate
		Session session = HibernateUtils.getSessionFactory().openSession();

		// recupera la sesion actual
//		this.sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {

			session.beginTransaction();

			List<Clinica> todasClinicas = (List<Clinica>) session
					.createQuery("from com.walls.entidades.Clinica", Clinica.class)
					.getResultList();

			todasLasCLinicas = todasClinicas;

			session.getTransaction().commit();

			session.close();
		}

		catch (Exception e) {

			System.out.println("Error al recuperar las clinicas (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
		}

	}
	
	public static List<Clinica> getDatosClinica() {
		return datosClinica;
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * Session session = HibernateUtils.getSessionFactory().getCurrentSession();
	 * 
	 * try {
	 * 
	 * System.out.println("Preparado para realizar alta");
	 * 
	 * Clinica c = new Clinica(new ClinicaId( 1, "Prueba", "c/ave", "aa@aa.com",
	 * 999999999));
	 * 
	 * session.beginTransaction();
	 * 
	 * session.save(c);
	 * 
	 * session.getTransaction().commit();
	 * 
	 * System.out.println("Alta realizada con exito");
	 * 
	 * ---------------------------
	 * 
	 * session.beginTransaction(); List<Clinica> clinicas =
	 * (List<Clinica>)session.createQuery("from Clinica ",Clinica.class).
	 * getResultList(); session.getTransaction().commit();
	 * 
	 * for (Clinica c : clinicas) { System.out.println("***: "+
	 * c.getId().getNombre()); }
	 * 
	 * } catch(Exception e) { System.out.println("Error al hacer transca");
	 * session.getTransaction().rollback(); } finally {
	 * 
	 * HibernateUtils.closeSessionFactory();
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

}
