package com.walls.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.walls.dao.MascotaDAO;
import com.walls.entidades.Mascota;

@Service
public class ServicioMascota {

	
	public static List<Mascota> obtenerMascotasCliente() throws Exception{
		
		return MascotaDAO.obtenerMascotasCliente();
		
	}
	
}
