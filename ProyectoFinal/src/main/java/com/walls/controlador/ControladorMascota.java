package com.walls.controlador;

import java.util.List;

import org.springframework.stereotype.Controller;
import com.walls.entidades.Mascota;
import com.walls.servicio.ServicioMascota;

@Controller
public class ControladorMascota {

	
	public List<Mascota> obtenerMascotasCliente() {
		
		try {
			//TODO: INTENTA OBTENER LAS MASCOTAS POR CLIENTE
			return ServicioMascota.obtenerMascotasCliente();
			
		} catch (Exception e) {
			// TODO: TRATAMIENTO DE EXCEPCIONES
			return null;
		}
		
    }
}
