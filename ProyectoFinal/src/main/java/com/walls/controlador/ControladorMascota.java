package com.walls.controlador;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.walls.entidades.Mascota;
import com.walls.servicio.ServicioMascota;

@Controller
public class ControladorMascota {

	
	@RequestMapping(value="/crearMascota", method=RequestMethod.POST)
    public String agregarMascota(
    		Model model,
    		@RequestParam("nombre") String nombre,
    		@RequestParam("tipo") String tipo,
    		@RequestParam("raza") String raza) {
    	    	
		
    	if(raza != null) 
    		ServicioMascota.agregarMascota(nombre,tipo,raza);
    	else
    		ServicioMascota.agregarMascota(nombre,tipo,"");
		
		return "listadoMascota";
    	
    }
	
}
