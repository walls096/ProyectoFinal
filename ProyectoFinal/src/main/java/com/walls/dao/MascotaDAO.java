package com.walls.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;

import com.walls.controlador.HibernateUtils;
import com.walls.entidades.Cliente;
import com.walls.entidades.Mascota;

public class MascotaDAO {

	private static List<Mascota> todasLasMascotas;
	
	public static List<Mascota> obtenerMascotasCliente() {
		
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {

			session.beginTransaction();

			List<Mascota> mascotas = (List<Mascota>) session
					.createQuery("from com.walls.entidades.Mascota where codCliente = '" + ClienteDAO.getCodCliente() + "'", Mascota.class)
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
				
				
				int id = obtenerTodasLasMascotas().size();
				
				Mascota m = new Mascota();
				m.setCodMascota(id);
				m.setNombre(nombre);
				m.setTipo(tipo);
				m.setRaza(raza);
				m.setCodCliente(ClienteDAO.getCodCliente());
				
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
	public static List<Mascota> getTodasLasMascotas() {
		return todasLasMascotas;
	}

	
}
