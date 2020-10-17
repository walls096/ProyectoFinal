package com.walls.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.walls.repository.Sentencias;


//anotacion de spring indica que esta clase es un controlador 
@Controller
public class ControladorSpring {

	//Requestmapping mapea la ruta para redireccionar a un archivo indicado en la vista.

    @RequestMapping(value="/")
    public String index() {
        return "panelPrincipal";
    }
    
    
    @RequestMapping(value="/compruebaLogin", method=RequestMethod.POST)
    public String compruebaUsuario(Model model, @RequestParam("mail") String mail) {
    	
    	boolean encontrado = Sentencias.CompruebaLogin(mail);
    	
      	if(encontrado) {
      		model.addAttribute("nombre", Sentencias.getDatosClinica().get(0).getId().getNombre());
    		return "logeate";
      	}
    	else
    		return "registrate";
    }
    
    
    @RequestMapping(value="/compruebaPass", method=RequestMethod.POST)
    public String compruebaPassUsuario(Model model,@RequestParam("pass") String pass) {
    	    	
    	if(pass.equalsIgnoreCase((String)model.getAttribute("nombre")))
    		return "hola";
    	else
    		return "logeate";
    }
    
    
}