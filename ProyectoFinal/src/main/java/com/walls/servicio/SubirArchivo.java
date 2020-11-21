package com.walls.servicio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SubirArchivo {

	
	private String carpetaDestino = "C:\\Users\\ASUS\\Desktop\\GitHub\\ProyectoFinal\\ProyectoFinal\\src\\main\\webapp\\static\\img\\";

	public void guardarArchivo(MultipartFile archivo, int codMascota) throws IOException {
		
		if(!archivo.isEmpty()){
			byte[] bytes = archivo.getBytes();
			Path path = Paths.get(carpetaDestino + codMascota + ".jpg");
			Files.write(path,bytes);
		}

	}
}
