package com.walls.repositorio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.walls.controlador.HibernateUtils;
import com.walls.entidades.Cliente;

public class ClienteRepositorio {

	private static List<Cliente> datosCliente;
	private static List<Cliente> todosLosClientes;

	
	public static boolean compruebaLogin(String mail) {

		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			List<Cliente> cliente = (List<Cliente>) session
					.createQuery("from com.walls.entidades.Cliente where mail = '" + mail + "'", Cliente.class)
					.getResultList();

			datosCliente = cliente;

			session.getTransaction().commit();

			session.close();

			if (!cliente.isEmpty())
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

		if (datosCliente.get(0).getPass().equals(pass)) {
			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * Primero recogemos todas las clinicas para verificar que el mail no existe, si existe abortamos,
	 * tambien se comprueba el ultimo elemento para establecerle un id
	 * @param mail
	 * @param nombre
	 * @param pass
	 * @return
	 */

	public static boolean registrarCliente(
			String dni, String mail, String nombre,Date fecha_nac, String pass) {

		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {

			session.beginTransaction();
			
			todosLosClientes();
			
			for(Cliente c : todosLosClientes) {
				if(c.getMail().equalsIgnoreCase(mail)) {
					return false;
				}
			}
			
			int id = todosLosClientes.size();
			
			Cliente c = new Cliente();
			c.setCodCliente(id);
			c.setDni(dni);
			c.setNombre(nombre);
			c.setPass(pass);
			c.setFechaNac(fecha_nac);
			c.setMail(mail);
			
			datosCliente = new ArrayList<Cliente>();
			datosCliente.add(c);
			session.save(c);

			session.getTransaction().commit();

			session.close();


		}

		catch (Exception e) {

			System.out.println("Error al crear el cliente.");
			session.getTransaction().rollback();
			session.close();
			return false;
		}
		
		return true;
	}
	
//	
//	public static boolean ModificarPass() {
//
//		Session session = HibernateUtils.getSessionFactory().openSession();
//		
//		try {
//
//			session.beginTransaction();
//			
//			todosLosClientes();
//			
//			for(Cliente c : todosLosClientes) {
//				if(c.getMail().equalsIgnoreCase(mail)) {
//					return false;
//				}
//			}
//			
//			
//			Cliente c = new Cliente();
//			c.setNombre(nombre);
//			c.setMail(mail);
//			c.setDireccion(direccion);
//			c.setLocalidad(localidad);
//			
//			
//			session.update(c);
//
//			session.getTransaction().commit();
//
//			session.close();
//
//
//		}
//
//		catch (Exception e) {
//
//			System.out.println("Error al modificar el cliente.");
//			session.getTransaction().rollback();
//			session.close();
//			return false;
//		}
//		
//		return true;
//	}
	
	

	public static boolean modificarCliente(
			String nombre, String mail, String direccion, String localidad) {

		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {

			session.beginTransaction();
			
			todosLosClientes();
			
			for(Cliente c : todosLosClientes) {
				if(c.getMail().equalsIgnoreCase(mail)) {
					return false;
				}
			}
			
			
			Cliente c = new Cliente();
			c.setNombre(nombre);
			c.setMail(mail);
			c.setDireccion(direccion);
			c.setLocalidad(localidad);
			
			
			session.update(c);

			session.getTransaction().commit();

			session.close();


		}

		catch (Exception e) {

			System.out.println("Error al modificar el cliente.");
			session.getTransaction().rollback();
			session.close();
			return false;
		}
		
		return true;
	}
	
	
	public static void todosLosClientes() {

		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			List<Cliente> Clientes = (List<Cliente>) session
					.createQuery("from com.walls.entidades.Cliente", Cliente.class)
					.getResultList();

			todosLosClientes = Clientes;

			session.getTransaction().commit();

			session.close();
		}

		catch (Exception e) {

			System.out.println("Error al recuperar las clinicas (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
		}

	}
	
	public static List<Cliente> getDatosCliente() {
		return datosCliente;
	}
	
	public static int getCodCliente() {
		return datosCliente.get(0).getCodCliente();
	}
	
	public static void borrarListaCliente() {
		datosCliente.clear();
		todosLosClientes.clear();
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
