package com.walls.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.walls.repository.BrokerLogin;


//anotacion de spring indica que esta clase es un controlador 
@Controller
public class ControladorLogin {

	
    
    @RequestMapping(value="/compruebaLogin", method=RequestMethod.POST)
    public String compruebaUsuario(Model model, @RequestParam("mail") String mail) {
    	
    	mail = mail.toUpperCase();
    	boolean encontrado = BrokerLogin.compruebaLogin(mail);
    	
      	if(encontrado) {
      		model.addAttribute("nombre", "Hola de nuevo! "+BrokerLogin.getDatosClinica().get(0).getId().getNombre());
    		return "logeate";
      	}
    	else
    		return "registrate";
    }
    
    
    @RequestMapping(value="/compruebaPass", method=RequestMethod.POST)
    public String compruebaPassUsuario(Model model,@RequestParam("pass") String pass) {
    	    	
    	if(BrokerLogin.compruebaPass(pass))
    		return "panelPrincipal";
    	else {
    		model.addAttribute("nombre","Contraseña incorrecta, porfavor inténtelo de nuevo");
    		return "logeate";
    	}
    }
    
    
    @RequestMapping(value="/registrarClinica", method=RequestMethod.POST)
    public String registrarClinica(
    		Model model,
    		@RequestParam("mail") String mail,
    		@RequestParam("nombre") String nombre,
    		@RequestParam("pass") String pass,
    		@RequestParam("pass2") String pass2) {
    	    	
    	
    	if(pass.equals(pass2)) {
    		
    		mail = mail.toUpperCase();
    		if(BrokerLogin.registrarClinica(mail,nombre,pass)) {
    			return "panelPrincipal";
    		}else {
        		model.addAttribute("mensaje","El correo introducido ya existe");
        		return "registrate";
        	}
    	}else
		{
			model.addAttribute("mensaje","Las claves introducidas no coinciden");
    		return "registrate";
		}
    	
    	
    }
    
    
}