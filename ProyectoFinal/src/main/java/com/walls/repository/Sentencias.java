package com.walls.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.walls.entidades.Clinica;



public class Sentencias {
	
	private static List<Clinica> datosClinica;
		
	//Comprueba que los datos introducidos en el login aparecen en la base de datos.
	public static boolean CompruebaLogin(String mail){
		
		//abre la sesion con hibernate
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		//recupera la sesion actual
//		this.sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
					
			session.beginTransaction();
			
			List<Clinica> clinicas = (List<Clinica>)session.createQuery("from com.walls.entidades.Clinica where mail = '"+mail+"'",Clinica.class).getResultList();
			
			datosClinica = clinicas;
			
	        session.getTransaction().commit();
	        
	        session.close();
	        
	        if(!clinicas.isEmpty())
		        return true;
	        else
	        	return false;
	        
		}
		
		catch(Exception e) {
			
			System.out.println("Error en la session (sessionFactory)");
			session.getTransaction().rollback();
			session.close();
			return false;
		}
		
		
	}

	
	
	public static List<Clinica> getDatosClinica(){
		return datosClinica;
	}
	
	
	
	/*
	public static void main(String[] args) {
		
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		
		try {
			
			System.out.println("Preparado para realizar alta");
			
			Clinica c = new Clinica(new ClinicaId( 1, "Prueba", "c/ave", "aa@aa.com", 999999999));
			
			session.beginTransaction();
			
			session.save(c);
			
			session.getTransaction().commit();
			
			System.out.println("Alta realizada con exito");
			
			---------------------------
			
			session.beginTransaction();
			List<Clinica> clinicas = (List<Clinica>)session.createQuery("from Clinica ",Clinica.class).getResultList();
	        session.getTransaction().commit();
	        
	        for (Clinica c : clinicas) {
	        	System.out.println("***: "+ c.getId().getNombre());
	        }
			
		}
		catch(Exception e) {
			System.out.println("Error al hacer transca");
			session.getTransaction().rollback();
		}
		finally {
			
			HibernateUtils.closeSessionFactory();
			
		}
		

	}
	*/

}
