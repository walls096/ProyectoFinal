package com.walls.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.walls.repositorio.RepositorioCliente;
import com.walls.repositorio.RepositorioMascota;

@Controller
public class ControladorNav {

	//------------------------------------------------------------------------------
	//-----------------------MAPEO DE MENULOGIN-------------------------------------
	//------------------------------------------------------------------------------
	
    @RequestMapping(value="/") public String index() { return "index"; }
    
    @RequestMapping(value="/index") public String indexMenu() { return "index"; }
    
    @RequestMapping(value="/iniciaSesion") public String login() { return "iniciaSesion"; }
    
    @RequestMapping(value="/registrate") public String formRegistrate() { return "registrate"; }
	
    @RequestMapping(value="/contacta") public String formContact() { return "contacta"; }
    
    
    //------------------------------------------------------------------------------
  	//-----------------------MAPEO DE MENULOGEADO-------------------------------------
  	//------------------------------------------------------------------------------
        
    @RequestMapping(value="/modificarCliente") public String modificarCliente() { return "modificarCliente"; }
    
    @RequestMapping(value="/panelPrincipal") public String panelPrincipal() { return "panelPrincipal"; }
    
    @RequestMapping(value="/listadoMascotas") public String mascotasDeCliente() { return "listadoMascota"; }
    
    @RequestMapping(value="/crearMascota") public String crearMascota() { return "crearMascota"; }
    
    @RequestMapping(value="/administrarCitas") public String administrarCitas() { return "administrarCitas"; }
    
    @RequestMapping(value="/crearCita") public String crearCita() { return "crearCita"; }
    
//    @RequestMapping(value="/borrarMascotaConCita") public String borrarMascotaConCita() { return "listadoMascota"; }
    
    @RequestMapping(value="/cerrarSesion") 
	    public String cerrarSesion() { 
	    	RepositorioCliente.borrarListaCliente();
	    	RepositorioMascota.borrarListaMascota();
	    	
    	return "index"; 
    }
    
    
}
