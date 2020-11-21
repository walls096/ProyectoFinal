package com.walls.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.walls.entidades.Cita;
import com.walls.repositorio.RepositorioCita;

@Service
public class ServicioCita {

	public List<Cita> obtenerCitasCliente() {
		return RepositorioCita.obtenerCitasCliente();
	}
	
	public List<Cita> obtenerUnaCita(int id) {
		return RepositorioCita.obtenerUnaCita(id);
	}
	
	public void eliminarCita(Cita c) {
		RepositorioCita.eliminarCita(c);
	}
	
	public void modificarCita(Cita c) {
		RepositorioCita.modificarUnaCita(c);
	}
	
	public void modificarFechaHora(Date fecha, String hora) {
		RepositorioCita.modificarFechaHora(fecha,hora);
	}
	
	public void eliminarCitaLista(Cita c) {
		RepositorioCita.eliminarCitaLista(c);
	}
	
	public List<Cita> getCitasCliente(){
		return RepositorioCita.getCitasCliente();
	}
	
	public void crearCita(Cita c) {
		RepositorioCita.crearCita(c);
	}
	
	public boolean citaDisponible(Date fecha, String hora) {
		return RepositorioCita.citaDisponible(fecha,hora);
	}
	
	public void tieneCita(int id) {
		RepositorioCita.tieneCita(id);
	}
	
	public void obtenerCitasFiltradas(String filtroMascota, String filtroTipo, boolean dosFiltros) {
		RepositorioCita.obtenerCitasFiltradas(filtroMascota,filtroTipo,dosFiltros);
	}
}
