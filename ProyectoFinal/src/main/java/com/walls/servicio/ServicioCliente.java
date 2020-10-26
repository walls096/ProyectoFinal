package com.walls.servicio;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.walls.dao.ClienteDAO;

@Service
public class ServicioCliente {
	
	
	public boolean compruebaLogin (String mail) {
		return ClienteDAO.compruebaLogin(mail);
	}
	
	public boolean compruebaPass (String pass) {
		return ClienteDAO.compruebaPass(pass);
	}
	
	public boolean registrarCliente (String dni,String mail, String nombre, Date fecha_nac,String pass) {
		return ClienteDAO.registrarCliente(dni,mail,nombre,fecha_nac,pass);
	}
	
}
