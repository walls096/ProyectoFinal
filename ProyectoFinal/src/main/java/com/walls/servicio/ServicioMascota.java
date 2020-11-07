package com.walls.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.walls.entidades.Mascota;
import com.walls.repositorio.RepositorioMascota;

@Service
public class ServicioMascota {

	
	public static List<Mascota> obtenerMascotasCliente(){
		
		return RepositorioMascota.obtenerMascotasCliente();
		
	}
	
	public static void agregarMascota(String nombre, String tipo, String raza) {
		RepositorioMascota.agregarMascota(nombre,tipo,raza);
		RepositorioMascota.getTodasLasMascotas();
	}
	
	public static void eliminarMascota(Mascota m) {
		RepositorioMascota.eliminarMascota(m);
	}
	
	public static List<Mascota> obtenerUnaMascota(int id) {
		return RepositorioMascota.obtenerUnaMascota(id);
	}
	
	public static void borrarMascotaLista(Mascota m) {
		RepositorioMascota.borrarMascotaLista(m);
	}
	
	public static void modificarUnaMascota( String nombre, String tipo, String raza) {
		RepositorioMascota.modificarUnaMascota(nombre,tipo,raza);
	}
	
}
