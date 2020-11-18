package com.walls.entidades;
// Generated 25-oct-2020 17:32:58 by Hibernate Tools 5.4.14.Final

/**
 * Mascota generated by hbm2java
 */
public class Mascota implements java.io.Serializable {

	private int codMascota;
	private String nombre;
	private String tipo;
	private String raza;
	private Integer codCliente;
	private String imagen;

	public Mascota() {
	}

	public Mascota(int codMascota) {
		this.codMascota = codMascota;
	}

	public Mascota(int codMascota, String nombre, String tipo, String raza, Integer codCliente,String imagen) {
		this.codMascota = codMascota;
		this.nombre = nombre;
		this.tipo = tipo;
		this.raza = raza;
		this.codCliente = codCliente;
		this.imagen = imagen;
	}

	
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getCodMascota() {
		return this.codMascota;
	}

	public void setCodMascota(int codMascota) {
		this.codMascota = codMascota;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRaza() {
		if(!this.raza.equals(""))
			return this.raza;
		else
			return "-- NO ESPECIFICADO --";
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Integer getCodCliente() {
		return this.codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

}
