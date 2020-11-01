package com.walls.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.walls.entidades.Mascota;
import com.walls.repositorio.MascotaRepositorio;

@Service
public class ServicioMascota {

	
	public static List<Mascota> obtenerMascotasCliente(){
		
		return MascotaRepositorio.obtenerMascotasCliente();
		
	}
	
	public static void agregarMascota(String nombre, String tipo, String raza) {
		MascotaRepositorio.agregarMascota(nombre,tipo,raza);
		MascotaRepositorio.getTodasLasMascotas();
	}
	
	public static void eliminarMascota(Mascota m) {
		MascotaRepositorio.eliminarMascota(m);
	}
	
	public static List<Mascota> obtenerUnaMascota(int id) {
		return MascotaRepositorio.obtenerUnaMascota(id);
	}
	
	public static void borrarMascotaLista(Mascota m) {
		MascotaRepositorio.borrarMascotaLista(m);
	}
	
}
