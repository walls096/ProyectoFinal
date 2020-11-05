package com.walls.servicio;

import java.util.List;

import com.walls.entidades.Cita;
import com.walls.repositorio.RepositorioCita;

public class ServicioCita {

	public static List<Cita> obtenerCitasCliente() {
		return RepositorioCita.obtenerCitasCliente();
	}
}
