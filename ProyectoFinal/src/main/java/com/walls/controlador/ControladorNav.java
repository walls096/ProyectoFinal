package com.walls.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorNav {

	//Requestmapping mapea la ruta para redireccionar a un archivo indicado en la vista.

    @RequestMapping(value="/")
    public String index() {
        return "index";
    }
    
    @RequestMapping(value="/bienvenido")
    public String login() {
        return "bienvenido";
    }
	
}
