package com.walls.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.walls.dao.MascotaDAO;
import com.walls.entidades.Mascota;

@Service
public class ServicioMascota {

	
	public static List<Mascota> obtenerMascotasCliente(){
		
		return MascotaDAO.obtenerMascotasCliente();
		
	}
	
	public static void agregarMascota(String nombre, String tipo, String raza) {
		MascotaDAO.agregarMascota(nombre,tipo,raza);
		MascotaDAO.getTodasLasMascotas();
	}
	
}
