package com.walls.entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utiles {

	private static Date fechaActual = new Date();
	
	
	public static String formatearFecha() {
		
		DateFormat hourFormat = new SimpleDateFormat("HH:mm");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		String hora = hourFormat.format(fechaActual);
		String fecha = dateFormat.format(fechaActual);
//		String horaFecha = hourdateFormat.format(fechaActual);
		
		return "["+hora+"]  "+fecha;
	}
	
	public static Date getFechaActual() {
		return fechaActual;
	}
	
}
