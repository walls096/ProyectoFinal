package com.walls.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.walls.entidades.Mascota;
import com.walls.repositorio.RepositorioMascota;

@Service
public class ServicioMascota {

	
	public List<Mascota> obtenerMascotasCliente(){
		return RepositorioMascota.obtenerMascotasCliente();
	}
	
	public void agregarMascota(String nombre, String tipo, String raza) {
		RepositorioMascota.agregarMascota(nombre,tipo,raza);
		RepositorioMascota.getTodasLasMascotas();
	}
	
	public void eliminarMascota(Mascota m) {
		RepositorioMascota.eliminarMascota(m);
	}
	
	public List<Mascota> obtenerUnaMascota(int id) {
		return RepositorioMascota.obtenerUnaMascota(id);
	}
	
	public void borrarMascotaLista(Mascota m) {
		RepositorioMascota.borrarMascotaLista(m);
	}
	
	public void modificarUnaMascota( String nombre, String tipo, String raza) {
		RepositorioMascota.modificarUnaMascota(nombre,tipo,raza);
	}
	
	public void modificarImagen(Mascota m, String ruta) {
		RepositorioMascota.modificarImagen(m,ruta);
	}
	
	public void buscarMascotaPorNombre(String nombre) {
		RepositorioMascota.buscarMascotaPorNombre(nombre);
	}
	
}
