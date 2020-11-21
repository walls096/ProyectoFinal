package com.walls.controlador;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.walls.entidades.Mascota;
import com.walls.repositorio.RepositorioCliente;
import com.walls.repositorio.RepositorioMascota;
import com.walls.servicio.ServicioMascota;
import com.walls.servicio.SubirArchivo;

@Controller
public class ControladorMascota {

	@Autowired
	ServicioMascota servicioMascota;
	@Autowired
	SubirArchivo subirArchivo;
	
	
	@RequestMapping(value="/crearMascota", method=RequestMethod.POST)
    public String agregarMascota(
    		Model model,
    		@RequestParam("nombre") String nombre,
    		@RequestParam("tipo") String tipo,
    		@RequestParam("raza") String raza) {
    	    	
		
    	if(raza != null) 
    		servicioMascota.agregarMascota(nombre,tipo,raza);
    	else
    		servicioMascota.agregarMascota(nombre,tipo,"");
		
		return "listadoMascota";
    	
    }
	
	
	@RequestMapping(value="/borrarMascota", method=RequestMethod.GET)
    public String borrarMascota(
    		Model model,
    		@RequestParam("id") int id) {
    	
		//Eliminamos de la base de datos y de la lista
		List<Mascota> mascota = servicioMascota.obtenerUnaMascota(id);
		servicioMascota.eliminarMascota(mascota.get(0));
		
		for(Mascota m : RepositorioMascota.getTodasLasMascotas()) {
			if(id == m.getCodMascota()) {
				servicioMascota.borrarMascotaLista(m);
				return "listadoMascota";
			}
		}
		
		
		return null;
		
		
    	
    }
	
	@RequestMapping(value="/modificarMascota", method=RequestMethod.GET)
    public String modoificarMascota(
    		Model model,
    		@RequestParam("id") int id) {
    	
		
		servicioMascota.obtenerUnaMascota(id);
		
		
		return "modificarMascota";
			
    }
	
	/**
	 * Método encargado de la actualizacion de la mascota.
	 * Tambien se encarga de seleccionar una imagen y modificarla
	 * 
	 * @param model
	 * @param nombre
	 * @param tipo
	 * @param raza
	 * @param imagen
	 * @return
	 */
	@RequestMapping(value="/modificarMascotaFormulario",  method=RequestMethod.POST)
    public String modificarMascotaFormulario(
    		Model model,
    		@RequestParam("nombre") String nombre,
    		@RequestParam("tipo") String tipo,
    		@RequestParam("raza") String raza) {
    	
		
		servicioMascota.modificarUnaMascota(nombre,tipo,raza);
		
		
		return "listadoMascota";
  }		
	
	@PostMapping(value="/cambiarImagen")
    public String cambiarImagen(
    		Model model,
    		@RequestParam("imagen") MultipartFile imagen) {

		String rutaImagen = "";
		int codMascota = RepositorioMascota.getUnaMascota().get(0).getCodMascota();
		
		if(!imagen.isEmpty()) {
			
			try {
				
				subirArchivo.guardarArchivo(imagen, codMascota);
				rutaImagen = codMascota + ".jpg";
				model.addAttribute("mensajeExito", "Se ha sustituido la foto.");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}else {
			
			rutaImagen = RepositorioMascota.getUnaMascota().get(0).getImagen();
			model.addAttribute("mensajeExito", "Se mantiene la foto anterior.");
		}
		
		servicioMascota.modificarImagen(RepositorioMascota.getUnaMascota().get(0),rutaImagen);
		return "modificarMascota";
		
	}
//		if(null != imagen) {
//			
//			File fichero = new File("C:\\Users\\ASUS\\Desktop\\GitHub\\ProyectoFinal\\ProyectoFinal\\src\\main\\webapp\\static\\img\\"+codMascota+".jpg");
//			
//			try {
//				//Se crea una flujo binario de entrada, el cual se le dice que es la imagen que recibe
//				InputStream binEntrada = imagen.getInputStream();
//				FileOutputStream binSalida = new FileOutputStream(fichero);
//				
//				int bite = binEntrada.read();
//				while(bite != -1) {
//					binSalida.write(bite);
//					bite = binEntrada.read();
//				}
//				
//				binEntrada.close();
//				binSalida.close();
//				
//				rutaImagen = codMascota + ".jpg";
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		else {
//			rutaImagen = RepositorioMascota.getUnaMascota().get(0).getImagen();
//		}
	
  
	
	
	@RequestMapping(value="/buscarMascota", method=RequestMethod.POST)
    public String buscarMascota(
    		Model model,
    		@RequestParam("nombre") String nombre) {
    	    	
		
    	if("".equals(nombre)) 
    		servicioMascota.obtenerMascotasCliente();
    	else
    		servicioMascota.buscarMascotaPorNombre(nombre.toUpperCase());
		
		return "listadoMascota";
    	
    }
	
	
}
