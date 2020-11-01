package com.walls.controlador;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.walls.repositorio.ClienteRepositorio;
import com.walls.servicio.ServicioCliente;
import com.walls.servicio.ServicioMascota;


//anotacion de spring indica que esta clase es un controlador 
@Controller
public class ControladorCliente {

	@Autowired
	ServicioCliente servicioCliente;
    
    @RequestMapping(value="/compruebaLogin", method=RequestMethod.POST)
    public String compruebaUsuario(Model model, @RequestParam("mail") String mail) {
    	
    	mail = mail.toUpperCase();
    	boolean encontrado = servicioCliente.compruebaLogin(mail);
    	
      	if(encontrado) {
      		model.addAttribute("nombre", "Hola de nuevo "+ClienteRepositorio.getDatosCliente().get(0).getNombre()+" !");
    		return "logeate";
      	}
    	else
    		return "registrate";
    }
    
    
    @RequestMapping(value="/compruebaPass", method=RequestMethod.POST)
    public String compruebaPassUsuario(Model model,@RequestParam("pass") String pass) {
    	    	
    	if(servicioCliente.compruebaPass(pass)) {
    		ServicioMascota.obtenerMascotasCliente();
    		return "panelPrincipal";
    	}
    	else {
    		model.addAttribute("nombre","Contraseña incorrecta, porfavor inténtelo de nuevo");
    		return "logeate";
    	}
    }
    
    
    @RequestMapping(value="/registrarCliente", method=RequestMethod.POST)
    public String registrarCliente(
    		Model model,
    		@RequestParam("dni") String dni,
    		@RequestParam("mail") String mail,
    		@RequestParam("nombre") String nombre,
    		@RequestParam("fecha_nac") Date fecha_nac,
    		@RequestParam("pass") String pass,
    		@RequestParam("pass2") String pass2) {
    	    	
    	
    	if(pass.equals(pass2)) {
    		
    		mail = mail.toUpperCase();
    		if(servicioCliente.registrarCliente(dni,mail,nombre,fecha_nac,pass)) {
    			ServicioMascota.obtenerMascotasCliente();
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
    
    @RequestMapping(value="/modificarCliente", method=RequestMethod.POST)
    public String modificarCliente(
    		Model model,
    		@RequestParam("mail") String mail,
    		@RequestParam("nombre") String nombre,
    		@RequestParam("direccion") String direccion,
    		@RequestParam("localidad") String localidad) {
    	    	
    	mail = mail.toUpperCase();
    	if(servicioCliente.modificarCliente(nombre,mail,direccion,localidad)) {
    		
    		return "panelPrincipal";
    		
		}else {
    		model.addAttribute("mensaje","El correo introducido ya existe");
    		return "modificarCliente";
    	}
    	
    	
    }
    
    
    
    
}