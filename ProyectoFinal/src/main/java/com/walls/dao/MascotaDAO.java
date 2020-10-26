package com.walls.dao;

import java.util.List;

import org.hibernate.Session;

import com.walls.controlador.HibernateUtils;
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

			System.out.println("Error al recuperar las clinicas (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
			return null;
		}
		
	}

	public static List<Mascota> getTodasLasMascotas() {
		return todasLasMascotas;
	}

	
}
