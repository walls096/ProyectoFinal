package com.walls.repositorio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.walls.controlador.HibernateUtils;
import com.walls.entidades.Cliente;

public class RepositorioCliente {

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
			
			c.setCodCliente(datosCliente.get(0).getCodCliente());
			c.setDni(datosCliente.get(0).getDni());
			c.setFechaNac(datosCliente.get(0).getFechaNac());
			c.setPass(datosCliente.get(0).getPass());
			
			if(nombre.equals(""))
				c.setNombre(datosCliente.get(0).getNombre());
			else 
				c.setNombre(nombre);
			if(mail.equals(""))
				c.setMail(datosCliente.get(0).getMail());
			else 
				c.setMail(mail.toUpperCase());
			if(direccion.equals(""))
				c.setDireccion(datosCliente.get(0).getDireccion());
			else 
				c.setDireccion(direccion.toUpperCase());
			if(localidad.equals(""))
				c.setLocalidad(datosCliente.get(0).getLocalidad());
			else 
				c.setLocalidad(localidad.toUpperCase());
			
			datosCliente.remove(0);
			datosCliente.add(c);
			
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
	
	
	public static boolean modificarPass(String nuevaPass) {

		Session session = HibernateUtils.getSessionFactory().openSession();
		
		try {

			session.beginTransaction();

			String update = "update Cliente c set c.pass = :newPass where c.codCliente = :codCliente";
			int updatedEntities = session.createQuery( update )
			        .setString( "newPass", nuevaPass )
			        .setInteger( "codCliente", datosCliente.get(0).getCodCliente() )
			        .executeUpdate();
			
			session.getTransaction().commit();

			session.close();
			
			datosCliente.get(0).setPass(nuevaPass);

		}

		catch (Exception e) {

			System.out.println("Error al modificar la pass del cliente.");
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
		try {
		
			datosCliente.clear();
			todosLosClientes.clear();
			
		}catch(NullPointerException e) {
			
		}
		
	}

}
