package com.walls.controlador;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.walls.entidades.Mascota;
import com.walls.repositorio.RepositorioMascota;
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
	
	
	@RequestMapping(value="/borrarMascota", method=RequestMethod.GET)
    public String borrarMascota(
    		Model model,
    		@RequestParam("id") int id) {
    	
		//Eliminamos de la base de datos y de la lista
		List<Mascota> mascota = ServicioMascota.obtenerUnaMascota(id);
		ServicioMascota.eliminarMascota(mascota.get(0));
		
		for(Mascota m : RepositorioMascota.getTodasLasMascotas()) {
			if(id == m.getCodMascota()) {
				ServicioMascota.borrarMascotaLista(m);
				return "listadoMascota";
			}
		}
		
		
		return null;
		
		
    	
    }
	
	@RequestMapping(value="/modificarMascota", method=RequestMethod.GET)
    public String modoificarMascota(
    		Model model,
    		@RequestParam("id") int id) {
    	
		
		ServicioMascota.obtenerUnaMascota(id);
		
		
		return "modificarMascota";
			
    }
	
	@RequestMapping(value="/modificarMascotaFormulario", method=RequestMethod.POST)
    public String modificarMascotaFormulario(
    		Model model,
    		@RequestParam("nombre") String nombre,
    		@RequestParam("tipo") String tipo,
    		@RequestParam("raza") String raza) {
    	
		
		ServicioMascota.modificarUnaMascota(nombre,tipo,raza);
		
		
		return "listadoMascota";
			
    	
    }
	
	
}
