package com.walls.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.walls.repositorio.RepositorioCliente;

@Controller
public class ControladorCita {

	
	@RequestMapping(value="/campoFiltrado", method=RequestMethod.POST)
    public String compruebaUsuario(Model model, 
    		@RequestParam("filtroMascota") String filtroMascota,
    		@RequestParam("filtroTipo") String filtroTipo) {
    	
    	
      	if(filtroMascota.contentEquals("-MASCOTAS-") && filtroTipo.contentEquals("-TIPO CITA-")) {
    		return "administrarCitas";
      	}
    	else
    		return "registrate";
    }
	
}
