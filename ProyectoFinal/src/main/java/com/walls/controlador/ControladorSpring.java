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

	
    
    @RequestMapping(value="/compruebaLogin", method=RequestMethod.POST)
    public String compruebaUsuario(Model model, @RequestParam("mail") String mail) {
    	
    	mail = mail.toUpperCase();
    	boolean encontrado = Sentencias.compruebaLogin(mail);
    	
      	if(encontrado) {
      		model.addAttribute("nombre", "Hola de nuevo! "+Sentencias.getDatosClinica().get(0).getId().getNombre());
    		return "logeate";
      	}
    	else
    		return "registrate";
    }
    
    
    @RequestMapping(value="/compruebaPass", method=RequestMethod.POST)
    public String compruebaPassUsuario(Model model,@RequestParam("pass") String pass) {
    	    	
    	if(Sentencias.compruebaPass(pass))
    		return "panelPrincipal";
    	else {
    		model.addAttribute("nombre","Contraseña incorrecta, porfavor inténtelo de nuevo");
    		return "logeate";
    	}
    }
    
    @RequestMapping(value="/registrarClinica", method=RequestMethod.POST)
    public String registrarClinica(Model model,@RequestParam("mail") String mail, @RequestParam("pass") String pass) {
    	    	
    	if(Sentencias.registrarClinica(mail,pass))
    		return "panelPrincipal";
		return null;
    	
    }
    
    
}