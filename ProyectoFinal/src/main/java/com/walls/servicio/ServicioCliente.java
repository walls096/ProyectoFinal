package com.walls.servicio;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.walls.repositorio.RepositorioCliente;

@Service
public class ServicioCliente {
	
	
	public boolean compruebaLogin (String mail) {
		return RepositorioCliente.compruebaLogin(mail);
	}
	
	public boolean compruebaPass (String pass) {
		return RepositorioCliente.compruebaPass(pass);
	}
	
	public boolean registrarCliente (String dni,String mail, String nombre, Date fecha_nac,String pass) {
		return RepositorioCliente.registrarCliente(dni,mail,nombre,fecha_nac,pass);
	}
	
	public boolean modificarCliente (String nombre ,String mail, String direccion ,String localidad) {
		return RepositorioCliente.modificarCliente(nombre,mail,direccion,localidad);
	}
	
	public void modificarPassCliente(String pass) {
		RepositorioCliente.modificarPass(pass);
	}
}
