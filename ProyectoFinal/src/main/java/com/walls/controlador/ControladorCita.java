package com.walls.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.walls.entidades.Cita;
import com.walls.entidades.Mascota;
import com.walls.repositorio.RepositorioCita;
import com.walls.repositorio.RepositorioCliente;
import com.walls.repositorio.RepositorioMascota;
import com.walls.servicio.ServicioCita;
import com.walls.servicio.ServicioMascota;

@Controller
public class ControladorCita {

	@Autowired
	ServicioCita servicioCita;
	
	@RequestMapping(value="/pedirCitaFormulario", method=RequestMethod.POST)
    public String pedirCita(Model model,
    		 @RequestParam("fecha") java.sql.Date fecha,
    		 @RequestParam("hora") String hora,
    		 @RequestParam("nombreMascota") String nombre,
    		 @RequestParam("tipoCita") String tipo,
    		 @RequestParam("observaciones") String observaciones) {
    	
		java.util.Date fechaActual = new java.util.Date();
	    java.sql.Date sqlDateActual = new java.sql.Date(fechaActual.getTime());
		
		if(sqlDateActual.before(fecha)) {
			
			if(!hora.equals("HH : MM")) {
				
				if(!tipo.equals("-TIPO CITA-")) {
				
					if(servicioCita.citaDisponible(fecha,hora)) {
						
						int codMascota = -1;
						for(Mascota m: RepositorioMascota.getTodasLasMascotas()) {
							if(nombre.equals(m.getNombre())) {
								codMascota = m.getCodMascota();
							}
								
						}
						
//						String[] observ = observaciones.split(",");	
						String todasObservaciones="";
//						for(String o:observ) {
//							todasObservaciones = todasObservaciones + o +"#";
//						}
						
//						for (int i=0 ; i < observaciones.length(); i++) {
//							todasObservaciones = todasObservaciones + observaciones.charAt(i);
//							if(observaciones.charAt(i) == ',' ){
//								if(observaciones.length() <= i) {
//									todasObservaciones = todasObservaciones + observaciones.charAt(i+5);
//									i+=4;
//								}
//							}
//						}
						
						
						servicioCita.crearCita(new Cita(
								RepositorioCliente.getCodCliente(),
								codMascota,
								fecha,
								hora,
								tipo,
								todasObservaciones.toUpperCase()));
						
					}else {
						model.addAttribute("mensaje","Ya hay una cita asignada a dicho dia y hora.");
						return "pedirCita";
					}
				}else {
					model.addAttribute("mensaje","Debe seleccionar un tipo de cita.");
					return "pedirCita";
				}
			}else {
				model.addAttribute("mensaje","Debe seleccionar una hora disponible.");
				return "pedirCita";
			}
		}else {
			model.addAttribute("mensaje","La fecha introducida no puede ser anterior a la actual.");
			return "pedirCita";
		}
		
    	
		return "administrarCitas";
      	
    }
    
    @RequestMapping(value="/borrarMascotaConCita", method=RequestMethod.GET)
    public String borrarMascotaConCita(Model model, @RequestParam("codMascota") int id) {
    	
    	
		servicioCita.tieneCita(id);
		List<Cita> citaDeMascota = RepositorioCita.getCitaDeMascota();
		servicioCita.eliminarCita(citaDeMascota.get(0));
		List<Mascota> mascota = ServicioMascota.obtenerUnaMascota(citaDeMascota.get(0).getCodMascota());
		RepositorioMascota.eliminarMascota(mascota.get(0));
		
		
		for(Mascota m : RepositorioMascota.getTodasLasMascotas()) {
			if(id == m.getCodMascota()) {
				ServicioMascota.borrarMascotaLista(m);
				break;
			}
		}
		
		for(Cita c : RepositorioCita.getCitasCliente() ) {
			if(citaDeMascota.get(0).getCodCita() == c.getCodCita()) {
				servicioCita.eliminarCitaLista(c);
				servicioCita.crearCita(c);
				return "listadoMascota";
			}
		}
    	
		return "listadoMascota";
      	
    }
	
	@RequestMapping(value="/borrarCita", method=RequestMethod.GET)
    public String borrarCita(Model model, @RequestParam("id") int id) {
    	
		
		List<Cita> cita = servicioCita.obtenerUnaCita(id);
		servicioCita.eliminarCita(cita.get(0));
		ServicioCita.obtenerCitasCliente();
		
		
		for(Cita c: servicioCita.getCitasCliente()) {
			if(id == c.getCodCita()) {
				servicioCita.eliminarCita(c);
				return "administrarCitas";
			}
		}
    	
		return "administrarCitas";
      	
    }
	
	@RequestMapping(value="/actualizarCitas", method=RequestMethod.GET)
    public String actualizarCitas(Model model) {
    	
		ServicioCita.obtenerCitasCliente();
		
		return "administrarCitas";
      	
    }
	
	@RequestMapping(value="/modificarCita", method=RequestMethod.GET)
    public String modificarCita(Model model, @RequestParam("id") int id) {
    	
		servicioCita.obtenerUnaCita(id);
		
		return "modificarCita";
      	
    }
	
	@RequestMapping(value="/modificarCitaFormulario", method=RequestMethod.POST)
    public String modificarCitaFormulario(Model model, 
    		@RequestParam("tipoCita") String tipoCita,
    		@RequestParam("observaciones") String observaciones) {
		

		String[] split = observaciones.split(",");
		String cadenaFormateada= "";
		for(String o : split) {
			o.toUpperCase();
			cadenaFormateada = cadenaFormateada + o + "#";
		}
		
		servicioCita.modificarCita(new Cita(tipoCita,cadenaFormateada)); 	

		return "administrarCitas";
      	
    }
	
	@RequestMapping(value="/modificarFechaHora", method=RequestMethod.POST)
    public String modificarFechaHora(Model model, 
    		@RequestParam("fecha") java.sql.Date fecha,
    		@RequestParam("hora") String hora) {
		
		java.util.Date fechaActual = new java.util.Date();
		java.sql.Date sqlDateActual = new java.sql.Date(fechaActual.getTime());
		
		if(sqlDateActual.before(fecha)) {
				
			if(servicioCita.citaDisponible(fecha,hora)) {

				servicioCita.modificarFechaHora(fecha, hora);
				model.addAttribute("mensajeExito","Fecha y hora actualizadas");
				return "modificarCita";
				
			}else {
				model.addAttribute("mensaje","Ya hay una cita asignada a dicho dia y hora.");
				return "modificarCita";
			}
		}
		else 
		{
			model.addAttribute("mensaje","La fecha introducida no puede ser anterior a la actual.");
			return "modificarCita";
		}
      	
    }
	
	
	
	
	@RequestMapping(value="/campoFiltrado", method=RequestMethod.POST)
    public String campoFiltrado(Model model, 
    		@RequestParam("filtroMascota") String filtroMascota,
    		@RequestParam("filtroTipo") String filtroTipo) {
		
    	
    	//Si se aplican ambos filtros
      	if(!filtroMascota.contentEquals("-MASCOTAS-") && !filtroTipo.contentEquals("-TIPO CITA-")) {
    		
      		servicioCita.obtenerCitasFiltradas(filtroMascota,filtroTipo, true);
      	}
    	else {
    		
    		if(!filtroMascota.equals("-MASCOTAS-")) {
    			servicioCita.obtenerCitasFiltradas(filtroMascota,null, false);
    		}
    		else if(!filtroTipo.contentEquals("-TIPO CITA-")) {
    			servicioCita.obtenerCitasFiltradas(null,filtroTipo, false);
    		}else {
    			ServicioCita.obtenerCitasCliente();
    		}
    		
    	}
    		
      	return "administrarCitas";
    }
	
}
