package com.walls.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    
    
    
    
    
    
}
