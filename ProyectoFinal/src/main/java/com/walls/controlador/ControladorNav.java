package com.walls.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.walls.repositorio.ClienteRepositorio;
import com.walls.repositorio.MascotaRepositorio;

@Controller
public class ControladorNav {

	//------------------------------------------------------------------------------
	//-----------------------MAPEO DE MENULOGIN-------------------------------------
	//------------------------------------------------------------------------------
	
    @RequestMapping(value="/") public String index() { return "index"; }
    
    //Comprueba la ruta si se encuentra en otra distanta a la raiz
    @RequestMapping(value="/index") public String indexMenu() { return "index"; }
    
    @RequestMapping(value="/iniciaSesion") public String login() { return "iniciaSesion"; }
    
    @RequestMapping(value="/registrate") public String formRegistrate() { return "registrate"; }
	
    @RequestMapping(value="/contacta") public String formContact() { return "contacta"; }
    
    
    //------------------------------------------------------------------------------
  	//-----------------------MAPEO DE MENULOGEADO-------------------------------------
  	//------------------------------------------------------------------------------
    
    @RequestMapping(value="/cerrarSesion") 
    public String cerrarSesion() { 
    	ClienteRepositorio.borrarListaCliente();
    	MascotaRepositorio.borrarListaMascota();
    	
    	return "index"; 
    }
    
    @RequestMapping(value="/modificarCliente") public String modificarCliente() { return "modificarCliente"; }
    
    @RequestMapping(value="/panelPrincipal") public String panelPrincipal() { return "panelPrincipal"; }
    
    @RequestMapping(value="/listadoMascotas") public String mascotasDeCliente() { return "listadoMascota"; }
    
    @RequestMapping(value="/crearMascota") public String crearMascota() { return "crearMascota"; }
    
    
    
    
}
