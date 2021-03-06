package com.walls.repositorio;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.walls.controlador.HibernateUtils;
import com.walls.entidades.Cita;
import com.walls.entidades.Mascota;

public class RepositorioCita {

	private static List<Cita> citasCliente;		//LISTA QUE CONTIENE TODAS LAS CITAS DE UN CLIENTE
	private static List<Cita> unaCita;			//LISTA UTILIZADA PARA MODIFICAR UNA CITA
	private static List<Cita> citasMascota;
	private static String[] horasDisponibles = {
			"08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00",
			"16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30"};
	
	
	/**
	 * Método encargado de administrar que tipo de filtro se quiere aplicar.
	 * Una vez elegido se dirige a ejecutar la consulta correspondiente.
	 * 
	 * @param filtroMascota
	 * @param filtroTipo	
	 * @param dosFiltros	bandera de control para filtrar por ambos campos
	 */
	public static void obtenerCitasFiltradas(String filtroMascota, String filtroTipo, boolean dosFiltros) {
		
		//En primer lugar se selecciona el codigo de la mascota para efectuar su filtro
		int codMascota = 0;
		
		if(null != filtroMascota) {
			for(Mascota m : RepositorioMascota.getTodasLasMascotas()) {
				if(filtroMascota.equals(m.getNombre())) {
					
					codMascota = m.getCodMascota();
					break;
				}
			}
		}
		
		if(dosFiltros) {
			
			filtrarAmbosCampos(filtroTipo, codMascota);
			
		}else {
			if(null != filtroTipo) {
				filtrarTipoCita(filtroTipo);
			}
			if(null != filtroMascota) {
				filtrarNombreMascota(codMascota);
			}
		}
			
		
	}
	
	public static void filtrarNombreMascota(int codMascota) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {
			
			session.beginTransaction();
			
			List<Cita> cita = (List<Cita>) session
					.createQuery("from com.walls.entidades.Cita where codMascota = '" + codMascota + 
							"'" + "and codCliente = '" +RepositorioCliente.getCodCliente() +"'", Cita.class)
					.getResultList();
			
			if(!cita.isEmpty())
				citasCliente = cita;
			
			session.getTransaction().commit();

			session.close();
			
			
			
		}catch (Exception e) {
	
			System.out.println("Error al filtrar (mascota) las citas. (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
		}
	}
	
	public static void filtrarTipoCita(String filtroTipo) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {
			
			session.beginTransaction();
			List<Cita> cita = (List<Cita>) session
					.createQuery("from com.walls.entidades.Cita where tipoCita = '" + filtroTipo + 
							"'" + "and codCliente = '" +RepositorioCliente.getCodCliente() +"'", Cita.class)
					.getResultList();
			
			if(!cita.isEmpty())
				citasCliente = cita;
			
			session.getTransaction().commit();

			session.close();
			
			
		}catch (Exception e) {
	
			System.out.println("Error al filtrar (tipo) las citas. (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
		}
		
	}

	public static void filtrarAmbosCampos(String filtroTipo, int codMascota) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {
			
			session.beginTransaction();
			
			List<Cita> cita = (List<Cita>) session
					.createQuery("from com.walls.entidades.Cita where codMascota = '" + codMascota + 
							"'" + "and tipoCita = '" +filtroTipo +"'", Cita.class)
					.getResultList();
			
			if(!cita.isEmpty())
				citasCliente = cita;
			
			session.getTransaction().commit();
	
			session.close();
			
			
		}catch (Exception e) {
	
			System.out.println("Error al filtrar (2) las citas. (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
		}
	}
	
	/**
	 * Se comprueba que hay una cita disponible, es decir, que no hay ninguna cita asignada a dicha fecha y hora.
	 * 
	 * @param fecha
	 * @param hora
	 * @return
	 */
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
	
	public static List<Cita> obtenerTodasLasCitas() {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {
			
			session.beginTransaction();
			
			List<Cita> cita = (List<Cita>) session
					.createQuery("from com.walls.entidades.Cita", Cita.class)
					.getResultList();
			
			session.getTransaction().commit();
	
			session.close();
			
			return cita;
			
		}catch (Exception e) {
	
			System.out.println("Error al filtrar (2) las citas. (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
			return null;
		}
	}
	
	
	/**
	 * Se modifica la cita que se recibe por param, se setean los valores guardados en unaCita
	 * sólo se modifican los valores tipo cita y observacion.
	 * 
	 * @unaCita		lista encargada de la modificacion de una cita, se almacenan sus valores
	 * @param c
	 */
	public static void modificarUnaCita(Cita c) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();
			
			c.setCodCita(unaCita.get(0).getCodCita());
			c.setCodMascota(unaCita.get(0).getCodMascota());
			c.setCodCliente(unaCita.get(0).getCodCliente());
			c.setFecha(unaCita.get(0).getFecha());
			c.setHora(unaCita.get(0).getHora());
			
			if(c.getTipoCita().equals(""))
				c.setTipoCita(unaCita.get(0).getTipoCita());
			
			if(c.getObservacion().equals(""))
				c.setObservacion("");
			
			
			session.update(c);

			session.getTransaction().commit();

			session.close();
			
			//Se elimina las citas del cliente y los datos almacenados en unaCita para su posterior recarga
			citasCliente.clear();
			unaCita.clear();
			RepositorioCita.obtenerCitasCliente();
			
		}

		catch (Exception e) {

			System.out.println("Error al modificar las citas del cliente (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
		}
		
	}
	
	public static void modificarFechaHora(Date fecha, String hora) {
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();
			
			Cita c = new Cita();
			c.setCodCita(unaCita.get(0).getCodCita());
			c.setCodMascota(unaCita.get(0).getCodMascota());
			c.setCodCliente(unaCita.get(0).getCodCliente());
			c.setTipoCita(unaCita.get(0).getTipoCita());
			c.setObservacion(unaCita.get(0).getObservacion());
			c.setFecha(fecha);
			c.setHora(hora);
			
			
			session.update(c);

			session.getTransaction().commit();

			session.close();
			
			citasCliente.clear();
			unaCita.clear();
			RepositorioCita.obtenerUnaCita(c.getCodCita());
			RepositorioCita.obtenerCitasCliente();
			
		}

		catch (Exception e) {

			System.out.println("Error al modificar las citas del cliente (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
		}
	}
	
	
	/**
	 *Método por el cual se seleccionan los valores de la cita que hay que modificar 
	 * 
	 * @param id   código de la cita
	 * @return
	 */
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
			
			int id = RepositorioCita.obtenerTodasLasCitas().size();
			
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
	
	/**
	 * Se utiliza para saber si una mascota tiene cita o no, pues no puede haber una cita de una mascota que no existe.
	 * 
	 * @param idMascota
	 * @return
	 */
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
			
			citasMascota = cita;
			
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
		return citasMascota;
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
		try {
			citasCliente.clear();
			unaCita.clear();
			citasMascota.clear();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void eliminarCitaLista(Cita c) {
		citasCliente.remove(c);
	}
	
	
}
