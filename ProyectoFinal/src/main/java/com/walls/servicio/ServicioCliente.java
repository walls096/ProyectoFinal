package com.walls.servicio;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.walls.repositorio.ClienteRepositorio;

@Service
public class ServicioCliente {
	
	
	public boolean compruebaLogin (String mail) {
		return ClienteRepositorio.compruebaLogin(mail);
	}
	
	public boolean compruebaPass (String pass) {
		return ClienteRepositorio.compruebaPass(pass);
	}
	
	public boolean registrarCliente (String dni,String mail, String nombre, Date fecha_nac,String pass) {
		return ClienteRepositorio.registrarCliente(dni,mail,nombre,fecha_nac,pass);
	}
	
	public boolean modificarCliente (String nombre ,String mail, String direccion ,String localidad) {
		return ClienteRepositorio.modificarCliente(nombre,mail,direccion,localidad);
	}
}
